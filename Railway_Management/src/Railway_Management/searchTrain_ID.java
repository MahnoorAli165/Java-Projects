package Railway_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class searchTrain_ID extends JFrame {

    JFrame search_id = new JFrame();
    JPanel p1 = new JPanel();
    JLabel heading = new JLabel("Search Train");
    JLabel idLabel = new JLabel("Enter ID: ");
    JTextField idField = new JTextField("");
    JButton search = new JButton(" Search ");

    public searchTrain_ID(int action) {
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(6, 1));
        p1.add(new JPanel());
        p1.add(idLabel);
        p1.add(idField);
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(new JPanel());
        add(heading, BorderLayout.NORTH);
        add(p1);
        add(search, BorderLayout.SOUTH);
        ActionListener searchTrain = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (action == 1) {
                    Local c = new Local();
                    boolean check = true;
                    int id = 0;
                    while (check) {
                        try {
                            id = Integer.parseInt(idField.getText());
                            check = false;
                        } catch (Exception e1) {
                            idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                        }
                    }
                    Object obj = c.searchTrain_id(id);
                    String s = obj.toString();
                    String[] s1 = s.split(" ");
                    if (obj == null) {
                        JOptionPane.showMessageDialog(null, "No such record found");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID: " + s1[0] + "  Name: " + s1[1] + "  Seats: " + s1[2] + "  Fair: " + s1[3]);
                    }

                } else {
                    International c = new International();
                    int id = 0;
                    boolean check = true;
                    while (check) {
                        try {
                            id = Integer.parseInt(idField.getText());
                            check = false;
                        } catch (Exception e1) {
                            idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                        }
                    }
                    Object obj = c.searchTrain_id(id);
                    String s = obj.toString();
                    String[] s1 = s.split(" ");
                    if (obj == null) {
                        JOptionPane.showMessageDialog(null, "No such record found");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID: " + s1[0] + "  Name: " + s1[1] + "  Seats: " + s1[2] + "  Fair: " + s1[3]);
                    }
                }
            }
        };
        search.addActionListener(searchTrain);
    }

}
