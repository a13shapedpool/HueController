package com.huecontroller;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LightsMainController extends Thread{

    private LightsMainDialog mainDialog;

    private boolean exit;
    public Light light1;
    public Light light2;
    public Light light3;
    public Light light4;
    public Light light5;
    public Light light6;

    public LightsMainController(LightsMainDialog mainDialog) throws Exception {
        this.mainDialog = mainDialog;
    }

    @Override
    public void run() {
        try {
            hueBridge hue = new hueBridge();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        try {
            this.light1 = new Light(1);
            this.light2 = new Light(4);
//            this.light3 = new Light(4);
//            this.light4 = new Light(4);
//            this.light5 = new Light(5);
//            this.light6 = new Light(6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        initLight1(light1);
        initLight2(light2);

        while(!exit) {
            try {
                readLight1Info(light1);
                readLight2Info(light2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void stopRun() {
        exit = true;
    }

    private void initLight1(Light L) {
        this.mainDialog.setL1_name(L.getName());
    }

    private void updateLight1Display(Long l1_hue, Long l1_sat, Long l1_bri) {
        this.mainDialog.setL1_hue(l1_hue);
        this.mainDialog.setL1_sat(l1_sat);
        this.mainDialog.setL1_bri(l1_bri);
    }

    private void readLight1Info(Light L) throws Exception {
        Long hue = L.getLightHue();
        Long sat = L.getLightSaturation();
        Long bri = L.getLightBrightness();

        updateLight1Display(hue, sat, bri);
    }

    private void initLight2(Light lColor) {
        this.mainDialog.setL2_name(lColor.getName());
    }

    private void updateLight2Display(Long l2_hue, Long l2_sat, Long l2_bri) {
        this.mainDialog.setL2_hue(l2_hue);
        this.mainDialog.setL2_sat(l2_sat);
        this.mainDialog.setL2_bri(l2_bri);
    }

    private void readLight2Info(Light L) throws Exception {
        Long hue = L.getLightHue();
        Long sat = L.getLightSaturation();
        Long bri = L.getLightBrightness();

        updateLight2Display(hue, sat, bri);
    }



}
