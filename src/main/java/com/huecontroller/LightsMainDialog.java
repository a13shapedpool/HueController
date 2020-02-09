package com.huecontroller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class LightsMainDialog extends JDialog {

    private JPanel contentPane;
    private JButton closeButton;
    private JButton connectButton;
    private JList<Light> lightJList;

    private JPanel l1_panel;
    private JTextField l1_name;
    private JTextField l1_room;
    private JTextField l1_hue;
    private JTextField l1_sat;
    private JTextField l1_bri;
    private JButton l1_switch;
    private JSlider l1_sat_slider;
    private JSlider l1_bri_slider;
    private JSlider l1_hue_slider;

    private JPanel l2_panel;
    private JTextField l2_name;
    private JTextField l2_room;
    private JTextField l2_hue;
    private JTextField l2_sat;
    private JTextField l2_bri;
    private JButton l2_switch;
    private JSlider l2_sat_slider;
    private JSlider l2_bri_slider;
    private JSlider l2_hue_slider;

    private JPanel l3_panel;
    private JTextField l3_name;
    private JTextField l3_room;
    private JTextField l3_hue;
    private JTextField l3_sat;
    private JTextField l3_bri;
    private JButton l3_switch;
    private JSlider l3_hue_slider;
    private JSlider l3_sat_slider;
    private JSlider l3_bri_slider;

    private JPanel l4_panel;
    private JTextField l4_name;
    private JTextField l4_room;
    private JTextField l4_hue;
    private JTextField l4_sat;
    private JTextField l4_bri;
    private JButton l4_switch;
    private JSlider l4_hue_slider;
    private JSlider l4_sat_slider;
    private JSlider l4_bri_slider;

    private JPanel l5_panel;
    private JTextField l5_name;
    private JTextField l5_room;
    private JTextField l5_hue;
    private JTextField l5_sat;
    private JTextField l5_bri;
    private JButton l5_switch;
    private JSlider l5_hue_slider;
    private JSlider l5_sat_slider;
    private JSlider l5_bri_slider;

    private JPanel l6_panel;
    private JTextField l6_name;
    private JTextField l6_room;
    private JTextField l6_hue;
    private JTextField l6_bri;
    private JTextField l6_sat;
    private JButton l6_switch;
    private JSlider l6_hue_slider;
    private JSlider l6_sat_slider;
    private JSlider l6_bri_slider;

    private JPanel l7_panel;
    private JTextField l7_name;
    private JTextField l7_room;
    private JTextField l7_hue;
    private JTextField l7_bri;
    private JTextField l7_sat;
    private JButton l7_switch;
    private JSlider l7_hue_slider;
    private JSlider l7_sat_slider;
    private JSlider l7_bri_slider;


    private JButton globalPartyButton;





    private List<JTextField> briTextFields;
    private JButton getLightsButton;

    private LightsMainController lightsMainController;

    private boolean isConnected;
    public int panelUpdated = -1;

    public static void main(String[] args) throws Exception {
        LightsMainDialog dialog = new LightsMainDialog();
        dialog.setLightsMainController(new LightsMainController(dialog));
        dialog.setVisible(true);
    }

    public LightsMainDialog() {
//        setSize(1820, 980);
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
                    onSwitchButton(0);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l2_switch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onSwitchButton(1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l3_switch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onSwitchButton(2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l4_switch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onSwitchButton(3);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l5_switch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onSwitchButton(4);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l6_switch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onSwitchButton(5);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l7_switch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onSwitchButton(6);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        l1_hue_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int hue = l1_hue_slider.getValue();
                    setL1_hue((long) hue);
                    setPanelUpdated(1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l1_sat_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int sat = l1_sat_slider.getValue();
                    setL1_sat((long) sat);
                    setPanelUpdated(1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l1_bri_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int bri = l1_bri_slider.getValue();
                    setL1_bri((long) bri);
                    setPanelUpdated(1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l2_hue_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int hue = l2_hue_slider.getValue();
                    setL2_hue((long) hue);
                    setPanelUpdated(2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l2_sat_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int sat = l2_sat_slider.getValue();
                    setL2_sat((long) sat);
                    setPanelUpdated(2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l2_bri_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int bri = l2_bri_slider.getValue();
                    setL2_bri((long) bri);
                    setPanelUpdated(2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l3_hue_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int hue = l3_hue_slider.getValue();
                    setL3_hue((long) hue);
                    setPanelUpdated(3);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l3_sat_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int sat = l3_sat_slider.getValue();
                    setL3_sat((long) sat);
                    setPanelUpdated(3);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l3_bri_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int bri = l3_bri_slider.getValue();
                    setL3_bri((long) bri);
                    setPanelUpdated(3);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l4_hue_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int hue = l4_hue_slider.getValue();
                    setL4_hue((long) hue);
                    setPanelUpdated(4);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l4_sat_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int sat = l4_sat_slider.getValue();
                    setL4_sat((long) sat);
                    setPanelUpdated(4);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l4_bri_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int bri = l4_bri_slider.getValue();
                    setL4_bri((long) bri);
                    setPanelUpdated(4);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l5_hue_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int hue = l5_hue_slider.getValue();
                    setL5_hue((long) hue);
                    setPanelUpdated(5);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l5_sat_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int sat = l5_sat_slider.getValue();
                    setL5_sat((long) sat);
                    setPanelUpdated(5);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l5_bri_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int bri = l5_bri_slider.getValue();
                    setL5_bri((long) bri);
                    setPanelUpdated(5);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l6_hue_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int hue = l6_hue_slider.getValue();
                    setL6_hue((long) hue);
                    setPanelUpdated(6);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l6_sat_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int sat = l6_sat_slider.getValue();
                    setL6_sat((long) sat);
                    setPanelUpdated(6);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l6_bri_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int bri = l6_bri_slider.getValue();
                    setL6_bri((long) bri);
                    setPanelUpdated(6);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l7_hue_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int hue = l7_hue_slider.getValue();
                    setL7_hue((long) hue);
                    setPanelUpdated(7);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l7_sat_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int sat = l7_sat_slider.getValue();
                    setL7_sat((long) sat);
                    setPanelUpdated(7);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        l7_bri_slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                try {
                    int bri = l7_bri_slider.getValue();
                    setL7_bri((long) bri);
                    setPanelUpdated(7);
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

    public int getPanelUpdated() {
        return this.panelUpdated;
    }

    public void setPanelUpdated(int i) {
        this.panelUpdated = i;
    }

    public void panelInit() {
        for (Light L : lightsMainController.lightList) {
            if (!L.isColor) {
                switch (L.getID()) {
                    case 1:
                        l1_hue_slider.setEnabled(false);
                        l1_sat_slider.setEnabled(false);
                        l1_hue_slider.setValue(0);
                        l1_sat_slider.setValue(0);
                        l1_hue.setEnabled(false);
                        l1_sat.setEnabled(false);
                        break;
                    case 2:
                        l2_hue_slider.setEnabled(false);
                        l2_sat_slider.setEnabled(false);
                        l2_hue_slider.setValue(0);
                        l2_sat_slider.setValue(0);
                        l2_hue.setEnabled(false);
                        l2_sat.setEnabled(false);
                        break;
                    case 3:
                        l3_hue_slider.setEnabled(false);
                        l3_sat_slider.setEnabled(false);
                        l3_hue_slider.setValue(0);
                        l3_sat_slider.setValue(0);
                        l3_hue.setEnabled(false);
                        l3_sat.setEnabled(false);
                        break;
                    case 4:
                        l4_hue_slider.setEnabled(false);
                        l4_sat_slider.setEnabled(false);
                        l4_hue_slider.setValue(0);
                        l4_sat_slider.setValue(0);
                        l4_hue.setEnabled(false);
                        l4_sat.setEnabled(false);
                        break;
                    case 5:
                        l5_hue_slider.setEnabled(false);
                        l5_sat_slider.setEnabled(false);
                        l5_hue_slider.setValue(0);
                        l5_sat_slider.setValue(0);
                        l5_hue.setEnabled(false);
                        l5_sat.setEnabled(false);
                        break;
                    case 6:
                        l6_hue_slider.setEnabled(false);
                        l6_sat_slider.setEnabled(false);
                        l6_hue_slider.setValue(0);
                        l6_sat_slider.setValue(0);
                        l6_hue.setEnabled(false);
                        l6_sat.setEnabled(false);
                        break;
                    case 7:
                        l7_hue_slider.setEnabled(false);
                        l7_sat_slider.setEnabled(false);
                        l7_hue_slider.setValue(0);
                        l7_sat_slider.setValue(0);
                        l7_hue.setEnabled(false);
                        l7_sat.setEnabled(false);
                        break;
                }
            }
        }
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

    public void setLightsMainController(LightsMainController lightsMainController) {
        this.lightsMainController = lightsMainController;
    }

    private void onGlobalPartyButton() {
        System.out.println("PARTY PARTY PARTY");
    }

    private void onSwitchButton(int id) throws Exception {
        lightsMainController.lightON(id);
        lightsMainController.lightList.get(id).displayLightInfo();
    }

    public String[] getPanelInfo(int panelID) {
        String name = "";
        String hue = "";
        String sat = "";
        String bri = "";
        switch (panelID) {
            case 1:
                name = l1_name.getText();
                hue = l1_hue.getText();
                sat = l1_sat.getText();
                bri = l1_bri.getText();
                break;
            case 2:
                name = l2_name.getText();
                hue = l2_hue.getText();
                sat = l2_sat.getText();
                bri = l2_bri.getText();
                break;
            case 3:
                name = l3_name.getText();
                hue = l3_hue.getText();
                sat = l3_sat.getText();
                bri = l3_bri.getText();
                break;
            case 4:
                name = l4_name.getText();
                hue = l4_hue.getText();
                sat = l4_sat.getText();
                bri = l4_bri.getText();
                break;
            case 5:
                name = l5_name.getText();
                hue = l5_hue.getText();
                sat = l5_sat.getText();
                bri = l5_bri.getText();
                break;
            case 6:
                name = l6_name.getText();
                hue = l6_hue.getText();
                sat = l6_sat.getText();
                bri = l6_bri.getText();
                break;
            case 7:
                name = l7_name.getText();
                hue = l7_hue.getText();
                sat = l7_sat.getText();
                bri = l7_bri.getText();
                break;
        }
        return new String[]{name, hue, sat, bri};
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

    public void setL3_name(String l3_name) {
        this.l3_name.setText(l3_name);
    }

    public void setL3_hue(Long l3_hue) {
        this.l3_hue.setText(l3_hue.toString());
    }

    public void setL3_sat(Long l3_sat) {
        this.l3_sat.setText(l3_sat.toString());
    }

    public void setL3_bri(Long l3_bri) {
        this.l3_bri.setText(l3_bri.toString());
    }

    public void setL4_name(String l4_name) {
        this.l4_name.setText(l4_name);
    }

    public void setL4_hue(Long l4_hue) {
        this.l4_hue.setText(l4_hue.toString());
    }

    public void setL4_sat(Long l4_sat) {
        this.l4_sat.setText(l4_sat.toString());
    }

    public void setL4_bri(Long l4_bri) {
        this.l4_bri.setText(l4_bri.toString());
    }

    public void setL5_name(String l5_name) {
        this.l5_name.setText(l5_name);
    }

    public void setL5_hue(Long l5_hue) {
        this.l5_hue.setText(l5_hue.toString());
    }

    public void setL5_sat(Long l5_sat) {
        this.l5_sat.setText(l5_sat.toString());
    }

    public void setL5_bri(Long l5_bri) {
        this.l5_bri.setText(l5_bri.toString());
    }

    public void setL6_name(String l6_name) {
        this.l6_name.setText(l6_name);
    }

    public void setL7_name(String l7_name) {
        this.l7_name.setText(l7_name);
    }

    public void setL6_hue(Long l6_hue) {
        this.l6_hue.setText(l6_hue.toString());
    }

    public void setL6_sat(Long l6_sat) {
        this.l6_sat.setText(l6_sat.toString());
    }

    public void setL6_bri(Long l6_bri) {
        this.l6_bri.setText(l6_bri.toString());
    }

    public void setL7_hue(Long l7_hue) {
        this.l7_hue.setText(l7_hue.toString());
    }

    public void setL7_sat(Long l7_sat) {
        this.l7_sat.setText(l7_sat.toString());
    }

    public void setL7_bri(Long l7_bri) {
        this.l7_bri.setText(l7_bri.toString());
    }

}