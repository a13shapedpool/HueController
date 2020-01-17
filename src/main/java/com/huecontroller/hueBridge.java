package com.huecontroller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class hueBridge {

    public static String hueSite = "https://discovery.meethue.com/";
    public static String hue_bridge_ip = null;
    public static String base_url = "/api/D2LIXA98g7xjCpMOidbNRMLP4V22WcfrNDPhFB9j/";

    public hueBridge() throws ParseException, IOException {

        if (hue_bridge_ip == null) {
            String r = URLReader.address(hueSite);
            JSONParser parser = new JSONParser();
            Object object = parser.parse(r);
            JSONArray array = (JSONArray) object;
            JSONObject object2 = (JSONObject) array.get(0);
            hue_bridge_ip = (object2.get("internalipaddress")).toString();
        }
    }
}