package Railway_Management;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class deleteCustomer extends JFrame {
    JFrame search_id = new JFrame();
    JPanel p1 = new JPanel();
    JLabel heading = new JLabel("Delete Customer");
    JLabel idLabel = new JLabel("Enter ID: ");
    JTextField idField = new JTextField("");
    JButton deleteButton = new JButton(" Delete ");
    
    public deleteCustomer(){
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
        add(deleteButton, BorderLayout.SOUTH);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f= new File("customers.txt");
                int id=0;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (Exception e1) {
                    idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    id = Integer.parseInt(idField.getText());
                }
                Customer.deleteCustomer(f, id);
            }
        });
        
    }
}
