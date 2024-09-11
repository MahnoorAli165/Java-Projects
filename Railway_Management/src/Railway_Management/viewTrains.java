package Railway_Management;

import java.awt.BorderLayout;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class viewTrains extends JFrame {

    JFrame view = new JFrame();
    JPanel p1 = new JPanel();
    JLabel label1 = new JLabel("       Trains record:");
    String[] s = {"id", "Name", "Business Fair", "Business Seats", "Economy Fair", "Economy Seats", "Destination"};

    ArrayList<Local> record = new ArrayList();
    Customer c = new Customer();
    DefaultTableModel tabModel = new DefaultTableModel(s, 0);
    JTable table = new JTable(tabModel);
    Object[] o = new Object[s.length];

    public viewTrains(int action) {
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        if (action == 1) {
            record = Local.viewTrains(new File("Local.txt"));
            for (int i = 0; i < record.size(); i++) {
                o[0] = record.get(i).getTrainId();
                o[1] = record.get(i).getTrainName();
                o[2] = record.get(i).getBFair();
                o[3] = record.get(i).getBSeats();
                o[4] = record.get(i).getEFair();
                o[5] = record.get(i).getESeats();
                o[6] = record.get(i).getDestination();
                tabModel.addRow(o);
            }
            for (int i = tabModel.getRowCount() - 1; i >= 0; i--) {
                record.remove(i);
            }
            add(table);
            add(new JScrollPane(table));
        }
        if (action == 2) {
            record = International.viewTrains(new File("international.txt"));
            for (int i = tabModel.getRowCount() - 1; i >= 0; i--) {
                record.remove(i);
            }
            for (int i = 0; i < record.size(); i++) {
                o[0] = record.get(i).getTrainId();
                o[1] = record.get(i).getTrainName();
                o[2] = record.get(i).getBFair();
                o[3] = record.get(i).getBSeats();
                o[4] = record.get(i).getEFair();
                o[5] = record.get(i).getESeats();
                o[6] = record.get(i).getDestination();
                tabModel.addRow(o);
            }
            for (int i = tabModel.getRowCount() - 1; i >= 0; i--) {
                record.remove(i);
            }
            add(table);
            add(new JScrollPane(table));
        }
    }

}
