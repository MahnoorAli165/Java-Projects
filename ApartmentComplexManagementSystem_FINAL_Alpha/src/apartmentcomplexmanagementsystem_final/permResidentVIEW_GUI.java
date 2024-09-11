package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class permResidentVIEW_GUI extends JFrame implements ActionListener
{
    public permResidentVIEW_GUI()
    {
        setVisible(true);
        setSize(900, 500);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setIconImage(systemIcon.getImage());
        table.setEnabled(false);
        Dimension td = new Dimension(700, 500);
        table.setPreferredScrollableViewportSize(td);
        table.setFillsViewportHeight(true);
        for(int i = 0; i < a.size(); i++)
        {
            dtm.addRow((a.get(i).split(";")));
        }
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    String[] columns = {"ID", "Name", "Gender", "Phone No.", "E-Mail", "Room No."};
    DefaultTableModel dtm = new DefaultTableModel(columns, 0);
    JTable table = new JTable(dtm);
    ArrayList<String> a = permResident.viewRecords();
    
    public void actionPerformed(ActionEvent e) 
    {
        
    }
}
