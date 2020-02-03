package com.huecontroller.UI;

import com.huecontroller.entities.LightPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LightsMainDialog extends JDialog {

    private JPanel contentPane;
    private JButton closeButton;
    private JButton connectButton;

    private JTextField l1_name;
    private JTextField l1_room;
    private JTextField l1_hue;
    private JTextField l1_sat;
    private JTextField l1_bri;
    private JButton l1_switch;

    private JTextField l2_name;
    private JTextField l2_room;
    private JTextField l2_hue;
    private JTextField l2_sat;
    private JTextField l2_bri;
    private JButton l2_switch;

    private JTextField l3_name;
    private JTextField l3_room;
    private JTextField l3_hue;
    private JTextField l3_sat;
    private JTextField l3_bri;
    private JButton l3_switch;

    private JTextField l4_name;
    private JTextField l4_room;
    private JTextField l4_hue;
    private JTextField l4_sat;
    private JTextField l4_bri;
    private JButton l4_switch;

    private JTextField l5_name;
    private JTextField l5_room;
    private JTextField l5_hue;
    private JTextField l5_sat;
    private JTextField l5_bri;
    private JButton l5_switch;

    private JTextField l6_name;
    private JTextField l6_room;
    private JTextField l6_hue;
    private JTextField l6_bri;
    private JTextField l6_sat;
    private JButton l6_switch;


    private LightsMainController lightsMainController;
    private JFrame mainFrame;

    private boolean isConnected;


    public LightsMainDialog() throws Exception {
        this.lightsMainController = new LightsMainController(this);

        JFrame frame = new JFrame();
        this.mainFrame = frame;

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        frame.setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton connectButton = new JButton("Connect");
        this.connectButton = connectButton;
        frame.add(this.connectButton);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JButton closeButton = new JButton("Close");
        this.closeButton = closeButton;
        frame.add(this.closeButton);

        // Panel 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        LightPanel panel = createPanel(1);
        frame.add(panel, gbc);
        frame.pack();
        frame.setVisible(true);

        this.connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onConnectButton();
            }
        });

        this.closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });
    }

    public void updateDisplay() {
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }

    private void onConnectButton() {
        if (!isConnected) {
            this.lightsMainController.start();
            this.connectButton.setText("Connected to HUE Bridge");
            this.connectButton.setEnabled(false);
            isConnected = true;
        }
    }

    public LightPanel createPanel(int id) {
        System.out.println("PANEL NUMERO " + id + " créé");

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        LightPanel panel = new LightPanel(id);
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

    private void onClose() {
        try {
            this.lightsMainController.stopRun();
            this.lightsMainController.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dispose();
        System.exit(0);
    }

    public void setLightsMainController(LightsMainController lightsMainController) {
        this.lightsMainController = lightsMainController;
    }

//    private void onGlobalPartyButton() {
//        System.out.println("PARTY PARTY PARTY");
//    }
//
//    private void onSwitchButton(int id) throws Exception {
//        lightsMainController.LightList.get(id).lightSwitch();
//    }
//
//    public void setL1_name(String l1_name) {
//        this.l1_name.setText(l1_name);
//    }
//
//    public void setL1_hue(Long l1_hue) {
//        this.l1_hue.setText(l1_hue.toString());
//    }
//
//    public void setL1_sat(Long l1_sat) {
//        this.l1_sat.setText(l1_sat.toString());
//    }
//
//    public void setL1_bri(Long l1_bri) {
//        this.l1_bri.setText(l1_bri.toString());
//    }
//
//    public void setL2_name(String l2_name) {
//        this.l2_name.setText(l2_name);
//    }
//
//    public void setL2_hue(Long l2_hue) {
//        this.l2_hue.setText(l2_hue.toString());
//    }
//
//    public void setL2_sat(Long l2_sat) {
//        this.l2_sat.setText(l2_sat.toString());
//    }
//
//    public void setL2_bri(Long l2_bri) {
//        this.l2_bri.setText(l2_bri.toString());
//    }
//
//    public void setL3_name(String l3_name) {
//        this.l3_name.setText(l3_name);
//    }
//
//    public void setL3_hue(Long l3_hue) {
//        this.l3_hue.setText(l3_hue.toString());
//    }
//
//    public void setL3_sat(Long l3_sat) {
//        this.l3_sat.setText(l3_sat.toString());
//    }
//
//    public void setL3_bri(Long l3_bri) {
//        this.l3_bri.setText(l3_bri.toString());
//    }
//
//    public void setL4_name(String l4_name) {
//        this.l4_name.setText(l4_name);
//    }
//
//    public void setL4_hue(Long l4_hue) {
//        this.l4_hue.setText(l4_hue.toString());
//    }
//
//    public void setL4_sat(Long l4_sat) {
//        this.l4_sat.setText(l4_sat.toString());
//    }
//
//    public void setL4_bri(Long l4_bri) {
//        this.l4_bri.setText(l4_bri.toString());
//    }
//
//    public void setL5_name(String l5_name) {
//        this.l5_name.setText(l5_name);
//    }
//
//    public void setL5_hue(Long l5_hue) {
//        this.l5_hue.setText(l5_hue.toString());
//    }
//
//    public void setL5_sat(Long l5_sat) {
//        this.l5_sat.setText(l5_sat.toString());
//    }
//
//    public void setL5_bri(Long l5_bri) {
//        this.l5_bri.setText(l5_bri.toString());
//    }
//
//    public void setL6_name(String l6_name) {
//        this.l6_name.setText(l6_name);
//    }
//
//    public void setL6_hue(Long l6_hue) {
//        this.l6_hue.setText(l6_hue.toString());
//    }
//
//    public void setL6_sat(Long l6_sat) {
//        this.l6_sat.setText(l6_sat.toString());
//    }
//
//    public void setL6_bri(Long l6_bri) {
//        this.l6_bri.setText(l6_bri.toString());
//    }

}