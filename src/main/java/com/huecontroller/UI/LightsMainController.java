package com.huecontroller.UI;

import com.huecontroller.entities.Light;
import com.huecontroller.hueBridge;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LightsMainController extends Thread {

    private LightsMainDialog mainDialog;
    private boolean exit;
    public List<Light> LightList;

    public LightsMainController(LightsMainDialog mainDialog) throws Exception {
        this.mainDialog = mainDialog;
        this.LightList = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            hueBridge hue = new hueBridge();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 1; i <= 6; i++) {
                LightList.add(new Light(i));
                System.out.println(LightList.get(i - 1).getLightType());
                mainDialog.createPanel(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Light L : LightList) {
            initLight(L);
        }

        while (!exit) {
            try {
                for (Light L : LightList) {
                    readLightInfo(L);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            mainDialog.updateDisplay();
        }

    }

    public void stopRun() {
        exit = true;
    }

    private void initLight(Light L) {
        int id = L.getLightID();
        switch (id) {
            case 1:

        }
    }

    public void lightON(int id) throws Exception {
        LightList.get(id).lightOn();
    }

    private void updateWhiteLightDisplay(Light L, Long bri) {
        int id = L.getLightID();
        switch (id) {
            case 1:

        }
    }

    private void updateColorLightDisplay(Light L, Long hue, Long sat, Long bri) {
        int id = L.getLightID();
        switch (id) {
            case 1:

        }
    }

    private void readLightInfo(Light L) throws Exception {

        switch (L.getLightType()) {
            case "Hue go":
            case "Hue play":
            case "Hue color lamp":
                Long hue = L.getLightHue();
                Long sat = L.getLightSat();
                Long bri = L.getLightBri();

                updateColorLightDisplay(L, hue, sat, bri);
                break;

            case "Hue filament bulb":
                bri = L.getLightBri();
                updateWhiteLightDisplay(L, bri);

                break;
        }


    }


}
