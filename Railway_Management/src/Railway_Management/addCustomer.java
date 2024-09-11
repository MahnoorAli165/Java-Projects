package Railway_Management;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class addCustomer extends JFrame{
    JFrame menu1 = new JFrame();
    JLabel heading = new JLabel("Customer");
    JLabel label1= new JLabel("Enter ID: ");
    JLabel label2= new JLabel("Enter Name: ");
    JLabel label3= new JLabel("Enter CNIC: ");
    JLabel label4= new JLabel("Enter Phone no: ");
    JTextField f1 = new JTextField();
    JTextField f2 = new JTextField();
    JTextField f3 = new JTextField();
    JTextField f4 = new JTextField();
    JButton addButton = new JButton("Add");
    
    JPanel p1 = new JPanel();
    public addCustomer(){
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        add(new JPanel().add(heading),BorderLayout.NORTH);
        p1.setLayout(new GridLayout(4,2));
        p1.add(label1);
        p1.add(f1);
        p1.add(label2);
        p1.add(f2);
        p1.add(label3);
        p1.add(f3);
        p1.add(label4);
        p1.add(f4);
        add(p1);
        add(addButton,BorderLayout.SOUTH);
        
        ActionListener adding = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int id=0;
                
                    try {
                        id = Integer.parseInt(f1.getText());
                    } catch (NumberFormatException e1) {
                        f1.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                        id = Integer.parseInt(f1.getText());
                    }

                String name=f2.getText();
                
                long cnic=0;
                try {
                        cnic = Long.parseLong(f3.getText());
                    } catch (NumberFormatException e1) {
                        f3.setText(JOptionPane.showInputDialog("CNIC must be an integer value\nEnter CNIC:"));
                        cnic = Long.parseLong(f3.getText());
                    }
                
                long phoneNo=0;
                try {
                        phoneNo = Long.parseLong(f4.getText());
                    } catch (NumberFormatException e1) {
                        f4.setText(JOptionPane.showInputDialog("Phone number must be an integer value\nEnter Phone no:"));
                        phoneNo = Long.parseLong(f4.getText());
                    }
                
                Customer c = new Customer(id,name,cnic,phoneNo);
                Customer.addCustomer(new File("customers.txt"), c);
            }
        };
        addButton.addActionListener(adding);
    }
}