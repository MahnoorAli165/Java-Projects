package Railway_Management;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class addingTrain extends JFrame {

    JFrame addingTrain = new JFrame();
    JLabel label1 = new JLabel("Enter id of train: ");
    JTextField tf1 = new JTextField();
    JLabel label2 = new JLabel("Enter nameof train: ");
    JTextField tf2 = new JTextField();
    JLabel label3 = new JLabel("Enter number of business seats: ");
    JTextField tf3 = new JTextField();
    JLabel label4 = new JLabel("Enter fair for one business seat: ");
    JTextField tf4 = new JTextField();
    JLabel label5 = new JLabel("Enter number of economy seats: ");
    JTextField tf5 = new JTextField();
    JLabel label6 = new JLabel("Enter fair for one economy seat: ");
    JTextField tf6 = new JTextField();
    JLabel label7 = new JLabel("Enter destination: ");
    JTextField tf7 = new JTextField();
    JButton add = new JButton("   Add   ");
    String hour[] = {"hour", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    JComboBox hourCombo = new JComboBox(hour);
    String minutes[] = {"minutes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"};
    JComboBox minuteCombo = new JComboBox(minutes);
    JButton addDetail = new JButton("Add Train detail");

    JPanel j = new JPanel();
    JPanel j2 = new JPanel();
    boolean check = false;

    public addingTrain(int action) {
        super("Railway Ticket Management");
        setLayout(new GridLayout(2, 1));
        setSize(900, 700);
        
        j.setLayout(new GridLayout(10, 2));
        j2.setLayout(new GridLayout(4, 3));
        
        j.add(new JPanel());
        j.add(new JPanel());
        j.add(label1);
        j.add(tf1);
        j.add(label2);
        j.add(tf2);
        j.add(label3);
        j.add(tf3);
        j.add(label4);
        j.add(tf4);
        j.add(label5);
        j.add(tf5);
        j.add(label6);
        j.add(tf6);
        j.add(label7);
        j.add(tf7);
        j.add(new JPanel());
        j.add(new JPanel());
        j.add(new JPanel());
        j.add(add);

        for (int i = 0; i < 6; i++) {
            j2.add(new JPanel());
        }
        j2.add(hourCombo);
        j2.add(minuteCombo);
        j2.add(addDetail);
        j2.add(new JPanel());
        j2.add(new JPanel());
        j2.add(new JPanel());
        add(j);
        add(j2);

        ActionListener adding = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                try {
                    id = Integer.parseInt(tf1.getText());
                } catch (Exception e1) {
                    tf1.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    id = Integer.parseInt(tf1.getText());
                }

                String name = tf2.getText();

                check = true;
                int Bseats = 0;
                do {
                    try {
                        Bseats = Integer.parseInt(tf3.getText());
                        check = false;
                    } catch (Exception e1) {
                        tf3.setText(JOptionPane.showInputDialog("Seats must be an integer value\nEnter seats:"));
                    }
                } while (check);

                int Bfair = 0;
                do {
                    try {
                        Bfair = Integer.parseInt(tf4.getText());
                    } catch (Exception e1) {
                        tf4.setText(JOptionPane.showInputDialog("Seats must be an integer value\nEnter seats:"));
                        Bseats = Integer.parseInt(tf4.getText());
                    }
                } while (check);

                check = true;
                int Eseats = 0;
                do {
                    try {
                        Eseats = Integer.parseInt(tf5.getText());
                        check = false;
                    } catch (Exception e1) {
                        tf3.setText(JOptionPane.showInputDialog("Seats must be an integer value\nEnter seats:"));
                    }
                } while (check);

                check=true;
                int Efair = 0;
                do {
                    try {
                        Efair = Integer.parseInt(tf6.getText());
                        check=false;
                    } catch (Exception e1) {
                        tf3.setText(JOptionPane.showInputDialog("Seats must be an integer value\nEnter seats:"));
                    }
                } while (check);

                String destination = tf7.getText();

                if (action == 1) {
                    Local l = new Local(id, name, Bfair, Bseats, Efair, Eseats, destination);
                    if (!(l.equals(id))) {
                        l.addTrain();
                        check = true;
                        JOptionPane.showMessageDialog(null, "Record added successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID Already exists\nEnter different ID");
                    }

                } else if (action == 2) {
                    International c = new International(id, name, Bfair, Bseats, Efair, Eseats, destination);
                    if (!(c.equals(id))) {
                        c.addTrain();
                        check = true;
                        JOptionPane.showMessageDialog(null, "Record added successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID Already exists\nEnter different ID");
                    }

                }
            }
        };
        add.addActionListener(adding);
        addDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = new File("TrainDetails.txt");
                try {
                    FileWriter fw = new FileWriter(f, true);
                    PrintWriter pw = new PrintWriter(f);
                    boolean check = true;
                    int id = 0;
                    while (check) {
                        try {
                            id = Integer.parseInt(tf1.getText());
                            check = false;
                        } catch (Exception e2) {
                            tf1.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                        }
                    }
                    pw.println(id + " " + String.valueOf(hourCombo.getSelectedItem()) + ":" + String.valueOf(minuteCombo.getSelectedItem()));
                    pw.close();
                    JOptionPane.showMessageDialog(null, "Train details added successfully");
                } catch (IOException e1) {
                    System.out.println(e);
                }

            }
        });

    }
}
