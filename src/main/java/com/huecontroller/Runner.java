package com.huecontroller;

import com.huecontroller.UI.LightsMainController;
import com.huecontroller.entities.LightPanel;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Runner {

    // JFrame
    static JFrame frame;
    LightsMainController lightsMainController;

    public static void main(String[] args) throws Exception {

        try {
            hueBridge hue = new hueBridge();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        frame.setLayout(gbl);

        // Panel 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        LightPanel panel = createPanel();
        frame.add(panel, gbc);




//        gbc.gridx = 1;
//        frame.add(createPanel(), gbc);

        frame.pack();
        frame.setVisible(true);
    }

    private static LightPanel createPanel() {

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        LightPanel panel = new LightPanel(1);
        panel.setLayout(gbl);

        gbc.insets = new Insets(5, 5, 5, 5);


        LightPanel lightPanel = new LightPanel(1);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lightPanel.getSwitchButton(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lightPanel.getHueSlider(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lightPanel.getSatSlider(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lightPanel.getBriSlider(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(lightPanel.getHueText(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(lightPanel.getSatText(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(lightPanel.getBriText(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(lightPanel.getIconName(), gbc);

    return panel;
    }

}
