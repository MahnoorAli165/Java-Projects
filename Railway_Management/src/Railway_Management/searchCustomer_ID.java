package Railway_Management;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class searchCustomer_ID extends JFrame{
    JFrame search_id = new JFrame();
    JPanel p1 = new JPanel();
    JLabel heading = new JLabel("Search Customer");
    JLabel idLabel = new JLabel("Enter ID: ");
    JTextField idField = new JTextField("");
    JButton searchButton = new JButton(" Search ");
    
    public searchCustomer_ID(){
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
        add(searchButton, BorderLayout.SOUTH);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=0;
                
                    try {
                        id = Integer.parseInt(idField.getText());
                    } catch (NumberFormatException e1) {
                        idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                        id = Integer.parseInt(idField.getText());
                    }
                Customer.searchCustomer_id(new File("customers.txt"), id);
            }
        });
    }
}
