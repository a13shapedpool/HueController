package com.huecontroller.entities;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightPanel extends JPanel {

    public JButton switchButton;
    private Light light;
    private JSlider hueSlider;
    private JSlider satSlider;
    private JSlider briSlider;
    private JTextField hue;
    private JTextField sat;
    private JTextField bri;
    private JTextField name;
    private int panelID;
    private boolean colorType;


    public LightPanel(int id) {
        this.panelID = id;
        createComponents();
    }

    private void createComponents() {
        createSwitchButton();
        createSliders();
        createTexts();
        createIcon();
    }

    public void setLightPanel(Light light) {
        this.light = light;
//        this.colorType = this.light.isColor();                                                                                                                                                                                                                                                                   e = light.isColor();
        hideUnused();
    }

    public void hideUnused() {
        if (!this.colorType) {
            this.hueSlider.setVisible(false);
            this.satSlider.setVisible(false);
            this.hue.setVisible(false);
            this.sat.setVisible(false);
        }
    }

    public JButton getSwitchButton() {
        return switchButton;
    }

    public JSlider getHueSlider() {
        return hueSlider;
    }

    public JSlider getSatSlider() {
        return satSlider;
    }

    public JSlider getBriSlider() {
        return briSlider;
    }

    public JTextField getHueText() {
        return hue;
    }

    public JTextField getSatText() {
        return sat;
    }

    public JTextField getBriText() {
        return bri;
    }

    public JTextField getIconName() {
        return name;
    }

    public Light getLight() {
        return light;
    }

    private void createSwitchButton() {
        JButton switchButton = new JButton();
        switchButton.addActionListener(switchButtonListener());
        switchButton.setText("Switch");
        this.switchButton = switchButton;
    }

    private void createSliders() {
        JSlider hueSlider = new JSlider();
        hueSlider.addChangeListener(sliderChangeListener());
        this.hueSlider = hueSlider;

        JSlider satSlider = new JSlider();
        satSlider.addChangeListener(sliderChangeListener());
        this.satSlider = satSlider;

        JSlider briSlider = new JSlider();
        briSlider.addChangeListener(sliderChangeListener());
        this.briSlider = briSlider;
    }

    private void createIcon() {
        JTextField text = new JTextField("Nom Lumière");
        this.name = text;
    }

    private void createTexts() {
        JTextField hue = new JTextField();
        hue.setEditable(false);
        this.hue = hue;

        JTextField sat = new JTextField();
        sat.setEditable(false);
        this.sat = sat;

        JTextField bri = new JTextField();
        bri.setEditable(false);
        this.bri = bri;
    }


    private ActionListener switchButtonListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    getLight().lightSwitch();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

    private ChangeListener sliderChangeListener() {
        return new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int val = hueSlider.getValue();
                System.out.println(val);
            }
        };
    }

}
