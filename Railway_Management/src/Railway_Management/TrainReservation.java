package Railway_Management;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TrainReservation extends JFrame implements WindowListener {

    public boolean localButton, internationalButton, businessButton, economyButton = false;
    
    Reservation r = new Reservation();
    int r_cID;
    String r_cName;
    int r_tID;
    String r_status;
    String r_Class;
    String r_destination;
    Date r_d;
    int r_price;
    int hours;
    int minutes;

    JPanel j = new JPanel();
    JPanel head_p = new JPanel();
    JLabel heading = new JLabel("      Ticket Reservation    ");
    JPanel idPanel = new JPanel();
    JLabel idLabel = new JLabel("Enter Customer ID: ");
    JTextField idField = new JTextField();
    JPanel statusPanel = new JPanel();
    ButtonGroup status = new ButtonGroup();
    JRadioButton local = new JRadioButton("Local");
    JRadioButton international = new JRadioButton("International");
    JPanel destinationPanel = new JPanel();
    JLabel destinationLabel = new JLabel("Choose Destination: ");
    JComboBox destinationCombo = new JComboBox();
    JPanel datePanel1 = new JPanel();
    JPanel datePanel2 = new JPanel();
    JLabel dateLabel = new JLabel("Select Date: ");
    String[] year = {"year", "2016", "2017", "2018", "2019", "2020"};
    JComboBox yearCombo = new JComboBox(year);
    String[] month = {"month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    JComboBox monthCombo = new JComboBox(month);
    String[] day = {"day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    JComboBox dayCombo = new JComboBox(day);
    JPanel ClassPanel = new JPanel();
    ButtonGroup Class = new ButtonGroup();
    JRadioButton economy = new JRadioButton("Economy");
    JRadioButton business = new JRadioButton("Business");
    JPanel printPanel = new JPanel();
    JButton print = new JButton("Print");

    TrainReservation() {
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new GridLayout(8, 1));
        getContentPane().setBackground(Color.LIGHT_GRAY);
        heading.setFont(new Font("Calibri", Font.BOLD, 50));
        idPanel.setLayout(new GridLayout(1, 2));
        idPanel.add(idLabel);
        idPanel.add(idField);
        status.add(local);
        status.add(international);
        statusPanel.setLayout(new GridLayout(1, 2));
        statusPanel.add(local);
        statusPanel.add(international);
        destinationPanel.setLayout(new GridLayout(1, 2));
        destinationPanel.add(destinationLabel);
        destinationPanel.add(destinationCombo);
        datePanel1.setLayout(new GridLayout(1, 2));
        datePanel2.setLayout(new GridLayout(1, 3));
        datePanel1.add(dateLabel);
        datePanel2.add(yearCombo);
        datePanel2.add(monthCombo);
        datePanel2.add(dayCombo);
        datePanel1.add(datePanel2);
        Class.add(economy);
        Class.add(business);
        ClassPanel.setLayout(new GridLayout(1, 2));
        ClassPanel.add(economy);
        ClassPanel.add(business);
        printPanel.setLayout(new GridLayout(1, 4));
        printPanel.add(new JPanel());
        printPanel.add(new JPanel());
        printPanel.add(new JPanel());
        printPanel.add(print);

        head_p.add(heading);
        head_p.setBackground(Color.LIGHT_GRAY);
        add(head_p);
        add(idPanel);
        add(statusPanel);
        add(destinationPanel);
        add(datePanel1);
        add(ClassPanel);
        add(new JPanel());
        add(printPanel);

        addWindowListener(this);

        local.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                localButton = !localButton;
                internationalButton = false;

                international.setSelected(internationalButton);
                local.setSelected(localButton);

                if (localButton) {
                    r_status = "Local";

                    File f = new File("Local.txt");
                    ArrayList<String> localList = new ArrayList<String>();

                    try {
                        Scanner s = new Scanner(f);
                        while (s.hasNext()) {
                            String s1 = s.nextLine();
                            String[] s2 = s1.split(" ");
                            localList.add(s2[6]);  //list of local destinations

                        }
                        s.close();
                        destinationCombo.setModel(new DefaultComboBoxModel(localList.toArray()));

                    } catch (IOException e1) {
                        System.out.println(e);
                    }
                }
            }
        });

        international.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internationalButton = !internationalButton;
                localButton = false;

                international.setSelected(internationalButton);
                local.setSelected(localButton);

                if (internationalButton) {

                    r_status = "International";
                    File f = new File("International.txt");
                    ArrayList<String> internationalList = new ArrayList<String>();

                    try {
                        Scanner s = new Scanner(f);
                        while (s.hasNext()) {
                            String s1 = s.nextLine();
                            String[] s2 = s1.split(" ");
                            internationalList.add(s2[6]);  //list of local destinations

                        }
                        s.close();
                        destinationCombo.setModel(new DefaultComboBoxModel(internationalList.toArray()));

                    } catch (IOException e1) {
                        System.out.println(e);
                    }
                }
            }
        });

        destinationCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File f = null;
                if (internationalButton) {
                    f = new File("International.txt");
                } else if (localButton) {
                    f = new File("Local.txt");
                }
                try {
                    r_destination = String.valueOf(destinationCombo.getSelectedItem());
                    Scanner s = new Scanner(f);
                    while (s.hasNext()) {
                        String s1 = s.nextLine();
                        String[] s2 = s1.split(" ");
                        if (r_destination.equals(s2[6]));
                        {
                            r_tID = Integer.parseInt(s2[0]);
                        }
                    }
                    s.close();

                } catch (IOException e1) {
                    System.out.println(e1);
                }
            }
        });

        business.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r_Class = "Business";
                businessButton = !businessButton;
                economyButton = false;

                economy.setSelected(economyButton);
                business.setSelected(businessButton);

                if (localButton) {
                    File f = new File("Local.txt");
                    ArrayList<String> internationalList = new ArrayList<String>();

                    try {
                        Scanner s = new Scanner(f);
                        while (s.hasNext()) {
                            String s1 = s.nextLine();
                            String[] s2 = s1.split(" ");
                            if (Integer.parseInt(idField.getText()) == Integer.parseInt(s2[0])) {
                                r_price = Integer.parseInt(s2[2]);
                            }
                        }
                        s.close();
                    } catch (IOException e1) {
                        System.out.println(e);
                    }
                }
                if (internationalButton) {
                    File f = new File("International.txt");
                    ArrayList<String> internationalList = new ArrayList<String>();

                    try {
                        Scanner s = new Scanner(f);
                        while (s.hasNext()) {
                            String s1 = s.nextLine();
                            String[] s2 = s1.split(" ");
                            if (Integer.parseInt(idField.getText()) == Integer.parseInt(s2[0])) {
                                r_price = Integer.parseInt(s2[2]);
                            }
                        }
                        s.close();
                    } catch (IOException e1) {
                        System.out.println(e);
                    }
                }
            }
        });
        economy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r_Class = "Economy";
                economyButton = !economyButton;
                economyButton = false;

                economy.setSelected(economyButton);
                business.setSelected(businessButton);

                if (localButton) {
                    File f = new File("Local.txt");
                    ArrayList<String> internationalList = new ArrayList<String>();

                    try {
                        Scanner s = new Scanner(f);
                        boolean check = true;
                        while (s.hasNext()) {
                            String s1 = s.nextLine();
                            String[] s2 = s1.split(" ");
                            if (Integer.parseInt(idField.getText()) == Integer.parseInt(s2[0])) {
                                r_price = Integer.parseInt(s2[4]);
                            }
                        }
                        s.close();
                    } catch (IOException e1) {
                        System.out.println(e);
                    }
                }
                if (internationalButton) {
                    File f = new File("International.txt");
                    ArrayList<String> internationalList = new ArrayList<String>();

                    try {
                        Scanner s = new Scanner(f);
                        while (s.hasNext()) {
                            String s1 = s.nextLine();
                            String[] s2 = s1.split(" ");
                            if (Integer.parseInt(idField.getText()) == Integer.parseInt(s2[0])) {
                                r_price = Integer.parseInt(s2[4]);
                            }
                        }
                        s.close();
                    } catch (IOException e1) {
                        System.out.println(e);
                    }
                }
            }
        });

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    r_cID = Integer.parseInt(idField.getText());
                    File f = new File("customers.txt");
                    Scanner s = new Scanner(f);
                    while (s.hasNext()) {
                        String s1 = s.nextLine();
                        String[] s2 = s1.split(" ");
                        if (r_cID == Integer.parseInt(s2[0])) {
                            r_cName = s2[1];
                        }
                    }
                    s.close();
                    File f2 = new File("TrainDetails.txt");
                    Scanner s_2 = new Scanner(f2);
                    while (s_2.hasNext()) {
                        String s1 = s_2.nextLine();
                        String[] s2 = s1.split(" ");
                        if (r_tID == Integer.parseInt(s2[0])) {
                            String s3 = s2[1];
                            String[] s4 = s3.split(":");
                            hours = Integer.parseInt(s4[0]);
                            minutes = Integer.parseInt(s4[1]);
                        }
                    }
                    s_2.close();
                    Date d = new Date(Integer.parseInt(String.valueOf(yearCombo.getSelectedItem())), Integer.parseInt(String.valueOf(monthCombo.getSelectedItem())), Integer.parseInt(String.valueOf(dayCombo.getSelectedItem())), hours, minutes);
                    s.close();
                    Reservation r = new Reservation(r_cID, r_cName, r_cID, r_status, r_Class, r_destination, d, r_price);
                    r.print();
                } catch (Exception e1) {
                    boolean check = true;
                    while (check) {
                        try {
                            r_cID = Integer.parseInt(JOptionPane.showInputDialog(null, "ID must be integer value\nEnter ID:"));
                            check = false;
                        } catch (Exception e2) {
                            System.out.println(e);
                        }
                    }
                }
            }

        });

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        new Runner().setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
