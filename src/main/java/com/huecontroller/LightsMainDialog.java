package com.huecontroller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LightsMainDialog extends JDialog {

    private JPanel contentPane;
    private JButton closeButton;
    private JButton connectButton;
    private JList<Light> lightJList;

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
    private JTextField l6_sat;
    private JTextField l6_bri;
    private JButton l6_switch;

    private JButton globalPartyButton;


    private JButton getLightsButton;
    /*
    Boutons, textes, etc...
     */

    private LightsMainController lightsMainController;

    private boolean isConnected;

    public static void main(String[] args) throws Exception {
        LightsMainDialog dialog = new LightsMainDialog();
        dialog.setLightsMainController(new LightsMainController(dialog));
        dialog.setVisible(true);
    }

    public LightsMainDialog() {
        setSize(1820, 980);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(closeButton);
        pack();
        isConnected = false;

        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onConnectButton();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        });

        globalPartyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onGlobalPartyButton();
            }
        });

        l1_switch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onSwitch1Button();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l2_switch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onSwitch2Button();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });
    }

    private void onConnectButton() {
        if (!isConnected) {
            this.lightsMainController.start();
            this.connectButton.setText("Connected to HUE Bridge");
            this.connectButton.setEnabled(false);
            isConnected = true;
        }
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

    private void onGlobalPartyButton() {
        System.out.println("PARTY PARTY PARTY");
        }

    public void setLightsMainController(LightsMainController lightsMainController) {
        this.lightsMainController = lightsMainController;
    }

    public void setL1_name(String l1_name) {
        this.l1_name.setText(l1_name);
    }

    public void setL1_hue(Long l1_hue) {
        this.l1_hue.setText(l1_hue.toString());
    }

    public void setL1_sat(Long l1_sat) {
        this.l1_sat.setText(l1_sat.toString());
    }

    public void setL1_bri(Long l1_bri) {
        this.l1_bri.setText(l1_bri.toString());
    }

    private void onSwitch1Button() throws Exception {
        lightsMainController.light1.lightSwitch();
    }

    public void setL2_name(String l2_name) {
        this.l2_name.setText(l2_name);
    }

    public void setL2_hue(Long l2_hue) {
        this.l2_hue.setText(l2_hue.toString());
    }

    public void setL2_sat(Long l2_sat) {
        this.l2_sat.setText(l2_sat.toString());
    }

    public void setL2_bri(Long l2_bri) {
        this.l2_bri.setText(l2_bri.toString());
    }

    private void onSwitch2Button() throws Exception {
        lightsMainController.light2.lightSwitch();
    }

}