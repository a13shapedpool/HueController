package com.huecontroller.entities;

import com.huecontroller.URLReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.huecontroller.hueBridge.base_url;
import static com.huecontroller.hueBridge.hue_bridge_ip;

public class Light {

    private final String name;
    private final Integer id;
    private final String type;
    private boolean isOn;
    private boolean isColor;

    public Light(Integer lightID) throws Exception {
        this.id = lightID;
        this.name = this.checkLightName();
        this.type = this.checkLightType();
        this.isOn = this.getLightState();
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isColor() {
        switch (this.getLightType()) {
            case "Hue go":
            case "Hue play":
            case "Hue color lamp":
                this.isColor = true;
                break;
            case "Hue filament bulb":
                this.isColor = false;
                break;
        }
        return isColor;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public Integer getLightID() {
        return this.id;
    }

    public String getLightType() {
        return type;
    }

    private Object accessJson() throws Exception {
        try {
            String r = URLReader.address("http://" + hue_bridge_ip + base_url + "lights/" + this.getLightID() + "/");
            JSONParser parser = new JSONParser();
            return parser.parse(r);
        } catch (ClassCastException e) {
            System.out.println("Bulb number " + this.getLightID() + " not registered... Bad request!");
            System.exit(1);
            return false;
        }
    }


    private String checkLightName() throws Exception {
        JSONObject j = (JSONObject) this.accessJson();
        return String.valueOf(j.get("name"));
    }

    private String checkLightType() throws Exception {
        JSONObject j = (JSONObject) this.accessJson();
        return String.valueOf(j.get("productname"));
    }

    public Object getLightProperty(String property) throws Exception {
        JSONObject j = (JSONObject) this.accessJson();
        JSONObject state = (JSONObject) j.get("state");
        return state.get(property);
    }

    public boolean getLightState() throws Exception {
        return (Boolean) this.getLightProperty("on");
    }

    public Long getLightHue() throws Exception {
        return (Long) this.getLightProperty("hue");
    }

    public Long getLightSat() throws Exception {
        return (Long) this.getLightProperty("sat");
    }

    public Long getLightBri() throws Exception {
        return (Long) this.getLightProperty("bri");
    }

    private static void setLightProperty(Integer lightID, String property, Object x) throws Exception {

        URL url = new URL("http://" + hue_bridge_ip + base_url + "lights/" + lightID + "/state/");

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());

            JSONObject payload = new JSONObject();
            payload.put(property, x);
            osw.write(payload.toString());

            osw.flush();
            osw.close();

            connection.getResponseCode();

        } catch (java.net.UnknownHostException e) {
            System.out.println("Connection not allowed");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public void setHue(Integer value) throws Exception {
        setLightProperty(this.id, "hue", value);
    }

    public void setSaturation(Integer value) throws Exception {
        setLightProperty(this.id, "sat", value);
    }

    public void setBrightness(Integer value) throws Exception {
        setLightProperty(this.id, "bri", value);
    }

    public void lightOn() throws Exception {
        setLightProperty(this.id, "on", true);
        this.setOn(true);
    }

    public void lightOff() throws Exception {
        setLightProperty(this.id, "on", false);
        this.setOn(false);
    }

    public void lightSwitch() throws Exception {
        setLightProperty(this.id, "on", !this.isOn);
        this.setOn(!this.isOn);
    }

}
