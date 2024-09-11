package Railway_Management;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainMenu extends JFrame implements WindowListener {

    Customer c;
    File f;

    JFrame menu1 = new JFrame();
    JLabel heading = new JLabel("Customer");
    JButton button1 = new JButton("Add Customer");
    JButton button2 = new JButton("View Customer");
    JButton button3 = new JButton("Search Customer(Name based)");
    JButton button4 = new JButton("Search Customer(ID based)");
    JButton button5 = new JButton("Update Customer");
    JButton button6 = new JButton("Delete Customer");

    public mainMenu() {
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        add(new JPanel().add(heading), BorderLayout.NORTH);
        ImageIcon image = new ImageIcon("customer.jpg");
        JLabel label = new JLabel();
        label.setIcon(image);
        add(label, BorderLayout.CENTER);
        add(button3, BorderLayout.SOUTH);
        addWindowListener(this);
        JPanel p1 = new JPanel(new GridLayout(6, 1));

        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        add(heading, BorderLayout.NORTH);
        add(p1, BorderLayout.EAST);

        c = new Customer();
        try {
            f = new File("customers.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        button1.addActionListener(new add());
        button2.addActionListener(new view());
        button3.addActionListener(new searchName());
        button4.addActionListener(new searchID());
        button5.addActionListener(new update());
        button6.addActionListener(new delete());
    }

    public class add implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            addCustomer add = new addCustomer();
            add.setVisible(true);
        }
    }

    public class view implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            viewCustomer view = new viewCustomer();
            view.setVisible(true);
        }
    }

    public class searchID implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            searchCustomer_ID search_ID = new searchCustomer_ID();
            search_ID.setVisible(true);
        }
    }

    public class searchName implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            searchCustomer_Name search_Name = new searchCustomer_Name();
            search_Name.setVisible(true);
        }
    }

    public class update implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            updateCustomer update = new updateCustomer();
            update.setVisible(true);
        }
    }

    public class delete implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            deleteCustomer d = new deleteCustomer();
            d.setVisible(true);

        }
    }

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
