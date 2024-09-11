package Railway_Management;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class searchCustomer_Name extends JFrame{
    JFrame search_id = new JFrame();
    JPanel p1 = new JPanel();
    JLabel heading = new JLabel("Search Customer");
    JLabel nameLabel = new JLabel("Enter Name: ");
    JTextField nameField = new JTextField("");
    JButton searchButton = new JButton(" Search ");
    
    public searchCustomer_Name(){
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(6, 1));
        p1.add(new JPanel());
        p1.add(nameLabel);
        p1.add(nameField);
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(new JPanel());
        add(heading, BorderLayout.NORTH);
        add(p1);
        add(searchButton, BorderLayout.SOUTH);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= nameField.getText();
                Customer.searchCustomer_name(new File("customers.txt"), name);
            }
        });
    }
}