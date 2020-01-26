package com.huecontroller.entities;

import com.huecontroller.URLReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.huecontroller.hueBridge.base_url;
import static com.huecontroller.hueBridge.hue_bridge_ip;

public class oldLight {

    private final String name;
    private final Integer lightID;
    private final String productName;
    private boolean needsUpdate;

    public oldLight(String name, Integer lightID, String productName) throws Exception {

        this.name = name;
        this.lightID = lightID;
        this.productName = productName;

    }

    public oldLight(Integer lightID) throws Exception {

        this.name = getName(lightID).toString();
        this.lightID = lightID;
        this.productName = getProductName(lightID).toString();

    }

    public String getName() {
        return this.name;
    }

    public Integer getID() {
        return this.lightID;
    }

    public String getProductName() {
        return this.productName;
    }

    public static Object getName(Integer lightID) throws Exception {

        try {
            String r = URLReader.address("http://" + hue_bridge_ip + base_url + "lights/" + lightID + "/");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(r);
            JSONObject j = (JSONObject) obj;
            return j.get("name");

        } catch (ClassCastException e) {
            System.out.println("Bulb number " + lightID + " not registered... Bad request!");
            System.exit(1);
            return false;
        }
    }

    public static Object getProductName(Integer lightID) throws Exception {

        try {
            String r = URLReader.address("http://" + hue_bridge_ip + base_url + "lights/" + lightID + "/");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(r);
            JSONObject j = (JSONObject) obj;
            System.out.println(j);
            return j.get("productname");

        } catch (ClassCastException e) {
            System.out.println("Bulb number " + lightID + " not registered... Bad request!");
            System.exit(1);
            return false;
        }
    }


    public static Object getLightProperty(String property_name, Integer lightID) throws Exception {

        try {
            String r = URLReader.address("http://" + hue_bridge_ip + base_url + "lights/" + lightID + "/");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(r);
            JSONObject j = (JSONObject) obj;
            JSONObject on = (JSONObject) j.get("state");

            return on.get(property_name);
        } catch (ClassCastException e) {
            System.out.println("Bulb number " + lightID + " not registered... Bad request!");
            System.exit(1); // Terminate the application.
            return false;
        }

    }

    public static int setLightProperty(Integer lightID, String prop, Object x) throws Exception {
        URL url;

        if (lightID == 0) {
            url = new URL("http://" + hue_bridge_ip + base_url + "groups/0/action/");
        } else {
            url = new URL("http://" + hue_bridge_ip + base_url + "lights/" + lightID + "/state/");
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT"); //Because Hue Bridge RESTful API need PUT request to process a cmd.
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());

            JSONObject payload = new JSONObject();

            payload.put(prop, x);

            osw.write(payload.toString());

            osw.flush();
            osw.close();

            return connection.getResponseCode(); // 200 - OK (Good response)

        } catch (java.net.UnknownHostException e) {
            System.out.println("Impossible to connecte To the HUE bridge!");
            return -1;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return -1;
        }

    }

    public boolean getLightState() throws Exception {
        return ((Boolean) getLightProperty("on", this.lightID));
    }

    public Long getLightHue() throws Exception {
        return (Long) getLightProperty("hue", this.lightID);
    }

    public Long getLightBrightness() throws Exception {
        return (Long) getLightProperty("bri", this.lightID);
    }

    public Long getLightSaturation() throws Exception {
        return (Long) getLightProperty("sat", this.lightID);
    }


    public void lightOn() throws Exception {
        setLightProperty(this.lightID, "on", true);
    }

    public void lightOff() throws Exception {
        setLightProperty(this.lightID, "on", false);
    }

    public void lightSwitch() throws Exception {
        setLightProperty(this.lightID, "on", !getLightState());
    }

    public void setBrightness(Integer value) throws Exception {
        setLightProperty(this.lightID, "bri", value);
    }

    public void setColor(Integer value) throws Exception {
        setLightProperty(this.lightID, "hue", value);
    }

    public void setSaturation(Integer value) throws Exception {
        setLightProperty(this.lightID, "sat", value);
    }

    public void setLightEffectOn() throws Exception {
        setLightProperty(this.lightID, "effect", "colorloop");
    }

    public void setLightEffectOff() throws Exception {
        setLightProperty(this.lightID, "effect", "none");
    }

}
