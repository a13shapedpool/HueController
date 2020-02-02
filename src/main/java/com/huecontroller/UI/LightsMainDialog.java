package com.huecontroller.UI;

import javax.swing.*;
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

    private JButton globalPartyButton;



    private JButton getLightsButton;
    /*
    Boutons, textes, etc...
     */

    private LightsMainController lightsMainController;

    private boolean isConnected;


    public LightsMainDialog() {
        setSize(1820, 980);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(closeButton);
        pack();
        isConnected = false;



//        connectButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onConnectButton();
//            }
//        });

//        closeButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onClose();
//            }
//        });

//        globalPartyButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onGlobalPartyButton();
//            }
//        });

//        l1_switch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    onSwitchButton(0);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

//        l2_switch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    onSwitchButton(1);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

//        l3_switch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    onSwitchButton(2);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

//        l4_switch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    onSwitchButton(3);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

//        l5_switch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    onSwitchButton(4);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

//        l6_switch.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    onSwitchButton(5);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });
    }

//    private void onConnectButton() {
//        if (!isConnected) {
//            this.lightsMainController.start();
//            this.connectButton.setText("Connected to HUE Bridge");
//            this.connectButton.setEnabled(false);
//            isConnected = true;
//        }
//    }

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