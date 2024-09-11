package Railway_Management;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class viewCustomer extends JFrame {

    JFrame view = new JFrame();
    JPanel p1 = new JPanel();
    JLabel label1 = new JLabel("       Customer record:");
    String[] s = {"id", "Name", "CNIC", "Contact Number"};
    ArrayList<Customer> record = new ArrayList();
    Customer c = new Customer();
    DefaultTableModel tabModel = new DefaultTableModel(s, 0);
    JTable table = new JTable(tabModel);
    Object[] o = new Object[4];

    public viewCustomer() {
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        Customer c = new Customer();
        p1.setLayout(new BorderLayout());
        p1.add(label1, BorderLayout.NORTH);
        add(p1);
        record = Customer.viewCustomer(new File("customers.txt"));
        for (int i = 0; i < record.size(); i++) {
            o[0] = record.get(i).getC_id();
            o[1] = record.get(i).getName();
            o[2] = record.get(i).getCnic();
            o[3] = record.get(i).getPhoneNo();
            tabModel.addRow(o);
        }
        for (int i = tabModel.getRowCount() - 1; i >= 0; i--) {
            record.remove(i);
        }
        add(table);
        add(new JScrollPane(table));
    }

}
