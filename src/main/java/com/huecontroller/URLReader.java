package com.huecontroller;

import java.net.*;
import java.io.*;

public class URLReader {

    public static String address(String str) throws IOException {

        URL url = new URL(str);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        if ((inputLine = in.readLine()) != null)
            return inputLine;
        in.close();

        return null;
    }
}