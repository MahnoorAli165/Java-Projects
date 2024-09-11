package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class condoMenu_GUI extends JFrame implements ActionListener
{
    public condoMenu_GUI()
    {
        setVisible(true);
        setSize(1100, 700);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setIconImage(systemIcon.getImage());
        setLayout(new BorderLayout());
        tempResidentGUIheading.setFont(new Font("Broadway", Font.BOLD, 37));
        tempResidentGUIheading.setForeground(Color.GRAY);
        add(tempResidentGUIheading, BorderLayout.NORTH);
        tempResidentGUIaddRecord.setBackground(Color.LIGHT_GRAY);
        tempResidentGUIaddRecord.setFont(new Font("Calibri", Font.BOLD, 15));
        tempResidentGUIviewRecords.setBackground(Color.LIGHT_GRAY);
        tempResidentGUIviewRecords.setFont(new Font("Calibri", Font.BOLD, 15));
        tempResidentGUIsearchRecord.setBackground(Color.LIGHT_GRAY);
        tempResidentGUIsearchRecord.setFont(new Font("Calibri", Font.BOLD, 15));
        tempResidentGUIupdateRecord.setBackground(Color.LIGHT_GRAY);
        tempResidentGUIupdateRecord.setFont(new Font("Calibri", Font.BOLD, 15));
        tempResidentGUIdeleteRecord.setBackground(Color.LIGHT_GRAY);
        tempResidentGUIdeleteRecord.setFont(new Font("Calibri", Font.BOLD, 15));
        tempResidentGUIexit.setBackground(Color.LIGHT_GRAY);
        tempResidentGUIexit.setFont(new Font("Calibri", Font.BOLD, 15));
        tempResidentGUIbuttons.setLayout(null);
        tempResidentGUIbuttons.add(tempResidentGUIaddRecord);
        tempResidentGUIbuttons.add(tempResidentGUIviewRecords);
        tempResidentGUIbuttons.add(tempResidentGUIsearchRecord);
        tempResidentGUIbuttons.add(tempResidentGUIupdateRecord);
        tempResidentGUIbuttons.add(tempResidentGUIdeleteRecord);
        tempResidentGUIaddRecord.setSize(500, 50);
        tempResidentGUIviewRecords.setSize(500, 50);
        tempResidentGUIsearchRecord.setSize(500, 50);
        tempResidentGUIupdateRecord.setSize(500, 50);
        tempResidentGUIdeleteRecord.setSize(500, 50);
        tempResidentGUIaddRecord.setLocation(300, 150);
        tempResidentGUIviewRecords.setLocation(300, 205);
        tempResidentGUIsearchRecord.setLocation(300, 260);
        tempResidentGUIupdateRecord.setLocation(300, 315);
        tempResidentGUIdeleteRecord.setLocation(300, 370);
        tempResidentGUIbuttons.setBackground(Color.DARK_GRAY);
        tempResidentGUIexitButton.setBackground(Color.DARK_GRAY);
        tempResidentGUIexitButton.add(tempResidentGUIexit);
        add(tempResidentGUIbuttons);
        add(tempResidentGUIexitButton, BorderLayout.SOUTH);
        tempResidentGUIaddRecord.addActionListener(this);
        tempResidentGUIviewRecords.addActionListener(this);
        tempResidentGUIsearchRecord.addActionListener(this);
        tempResidentGUIupdateRecord.addActionListener(this);
        tempResidentGUIdeleteRecord.addActionListener(this);
        tempResidentGUIexit.addActionListener(this);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel tempResidentGUIheading = new JLabel("Condos Menu", JLabel.CENTER);
    JButton tempResidentGUIaddRecord = new JButton("ADD RECORD");
    JButton tempResidentGUIviewRecords = new JButton("VIEW RECORDS");
    JButton tempResidentGUIsearchRecord = new JButton("SEARCH RECORD");
    JButton tempResidentGUIupdateRecord = new JButton("UPDATE RECORD");
    JButton tempResidentGUIdeleteRecord = new JButton("DELETE RECORD");
    JButton tempResidentGUIexit = new JButton("BACK");
    JPanel tempResidentGUIbuttons = new JPanel();
    JPanel tempResidentGUIexitButton = new JPanel();

    public void actionPerformed(ActionEvent e) 
    {
        switch(e.getActionCommand())
        {
            case "BACK":
                setVisible(false);
                break;
                
            case "ADD RECORD":
                new condoADD_GUI();
                break;
                
            case "VIEW RECORDS":
                new condoVIEW_GUI();
                break;
                
            case "SEARCH RECORD":
                new condoSEARCH_GUI();
                break;
                
            case "UPDATE RECORD":
                new condoUPDATE_GUI();
                break;
                
            case "DELETE RECORD":
                new condoDELETE_GUI();
                break;
        }
    }
}
