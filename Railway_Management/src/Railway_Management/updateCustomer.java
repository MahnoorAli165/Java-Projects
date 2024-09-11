package Railway_Management;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class updateCustomer extends JFrame{
    JFrame update = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel heading = new JLabel("Update Customer");
    JLabel idLabel = new JLabel("          Enter ID: ");
    JTextField idField = new JTextField();
    JButton updateName = new JButton("Update Name");
    JButton updateCNIC = new JButton("Update CNIC");
    JButton updatePhone = new JButton("Update Phone no");
    
    public updateCustomer(){
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(5,3));
        for(int i=0;i<3;i++){
            p1.add(new JPanel());
        }
        p1.add(idLabel);
        p1.add(idField);
        p1.add(new JPanel());
        for(int i=0;i<3;i++){
            p1.add(new JPanel());
        }
        p1.add(updateName);
        p1.add(updateCNIC);
        p1.add(updatePhone);
        for(int i=0;i<3;i++){
            p1.add(new JPanel());
        }
        add(heading,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);
        
        updateName.addActionListener(new ActionListener() {
            int id=0;
            public void actionPerformed(ActionEvent e) {
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException e1) {
                    idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    id = Integer.parseInt(idField.getText());
                }
                Customer.updateCustomer(new File("customers.txt"), id,1);
            }
        });
        updateCNIC.addActionListener(new ActionListener() {
            int id=0;
            public void actionPerformed(ActionEvent e) {
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException e1) {
                    idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    id = Integer.parseInt(idField.getText());
                }
                Customer.updateCustomer(new File("customers.txt"), id,2);
            }
        });
        updatePhone.addActionListener(new ActionListener() {
            int id=0;
            public void actionPerformed(ActionEvent e) {
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException e1) {
                    idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    id = Integer.parseInt(idField.getText());
                }
                Customer.updateCustomer(new File("customers.txt"), id,3);
            }
        });
    }
}