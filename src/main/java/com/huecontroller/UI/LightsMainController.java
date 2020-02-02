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
    public List<Light> lightList;

    public LightsMainController(LightsMainDialog mainDialog) throws Exception {
        this.mainDialog = mainDialog;
        this.lightList = new ArrayList<>();
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
                lightList.add(new Light(i));
            }
            lightList.get(0).getLightType();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Light L : lightList) {
            initLight(L);
            try {
                readLightInfo(L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mainDialog.lightPanel3.setLightPanel(lightList.get(3));

        while (!exit) {
            try {
                Thread.sleep(300);
                checkForUpdates();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void stopRun() {
        exit = true;
    }

    private void initLight(Light L) {
        int id = L.getLightID();
        switch (id) {
            case 1:
                this.mainDialog.setL1_name(L.getName());
                break;
            case 2:
                this.mainDialog.setL2_name(L.getName());
                break;
            case 3:
                this.mainDialog.setL3_name(L.getName());
                break;
            case 4:
                this.mainDialog.setL4_name(L.getName());
                break;
            case 5:
                this.mainDialog.setL5_name(L.getName());
                break;
            case 6:
                this.mainDialog.setL6_name(L.getName());
                break;
        }
    }

    private void checkForUpdates() throws Exception {
        int panel = this.mainDialog.getPanelUpdated();
        if (panel > -1) {
            String[] panelInfo = this.mainDialog.getPanelInfo(panel);
            updateLight(lightList.get(panel - 1), panelInfo);
        }
    }

    private void updateLight(Light L, String[] panelInfo) throws Exception {
        Thread.sleep(20);
        int hue, sat, bri;
        switch (L.getLightType()) {
            case "Hue go":
            case "Hue play":
            case "Hue color lamp":
                hue = Integer.parseInt(panelInfo[1]);
                sat = Integer.parseInt(panelInfo[2]);
                bri = Integer.parseInt(panelInfo[3]);
                updateColorLight(L, hue, sat, bri);
                break;
            case "Hue filament bulb":
                bri = Integer.parseInt(panelInfo[3]);
                L.setBrightness(bri);
                break;
        }
        this.mainDialog.setPanelUpdated(-1);
    }

    private void updateColorLight(Light L, int hue, int sat, int bri) throws Exception {
        L.setHue(hue);
        L.setSaturation(sat);
        L.setBrightness(bri);
    }


    private void updateWhiteLightDisplay(Light L, Long bri) {
        int id = L.getLightID();
        switch (id) {
            case 1:
                this.mainDialog.setL1_bri(bri);
                break;
            case 2:
                this.mainDialog.setL2_bri(bri);
                break;
            case 3:
                this.mainDialog.setL3_bri(bri);
                break;
            case 4:
                this.mainDialog.setL4_bri(bri);
                break;
            case 5:
                this.mainDialog.setL5_bri(bri);
                break;
            case 6:
                this.mainDialog.setL6_bri(bri);
                break;
        }
    }

    private void updateColorLightDisplay(Light L, Long hue, Long sat, Long bri) {
        int id = L.getLightID();
        switch (id) {
            case 1:
                this.mainDialog.setL1_hue(hue);
                this.mainDialog.setL1_sat(sat);
                this.mainDialog.setL1_bri(bri);
                break;
            case 2:
                this.mainDialog.setL2_hue(hue);
                this.mainDialog.setL2_sat(sat);
                this.mainDialog.setL2_bri(bri);
                break;
            case 3:
                this.mainDialog.setL3_hue(hue);
                this.mainDialog.setL3_sat(sat);
                this.mainDialog.setL3_bri(bri);
                break;
            case 4:
                this.mainDialog.setL4_hue(hue);
                this.mainDialog.setL4_sat(sat);
                this.mainDialog.setL4_bri(bri);
                break;
            case 5:
                this.mainDialog.setL5_hue(hue);
                this.mainDialog.setL5_sat(sat);
                this.mainDialog.setL5_bri(bri);
                break;
            case 6:
                this.mainDialog.setL6_hue(hue);
                this.mainDialog.setL6_sat(sat);
                this.mainDialog.setL6_bri(bri);
                break;
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
