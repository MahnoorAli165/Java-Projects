package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class permResidentSEARCH_GUI extends JFrame implements ActionListener
{
    public permResidentSEARCH_GUI()
    {
        setVisible(true);
        setSize(400, 200);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setIconImage(systemIcon.getImage());
        setLayout(new BorderLayout());
        heading.setFont(new Font("Broadway", Font.BOLD, 37));
        heading.setForeground(Color.GRAY);
        add(heading, BorderLayout.NORTH);
        TFpanel.setLayout(new GridLayout(2,0));
        IDTFlabel.setForeground(Color.WHITE);
        NAMElabel.setForeground(Color.WHITE);
        TFpanel.setBackground(Color.DARK_GRAY);
        TFpanel.add(IDTFlabel);
        TFpanel.add(IDTF);
        TFpanel.add(NAMElabel);
        TFpanel.add(NAMETF);
        action.setBackground(Color.LIGHT_GRAY);
        action.setFont(new Font("Calibri", Font.BOLD, 15));
        action1.setBackground(Color.LIGHT_GRAY);
        action1.setFont(new Font("Calibri", Font.BOLD, 15));
        action.addActionListener(this);
        action1.addActionListener(this);
        add(TFpanel, BorderLayout.CENTER);
        buttons.setBackground(Color.DARK_GRAY);
        buttons.add(action);
        buttons.add(action1);
        add(buttons, BorderLayout.SOUTH);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel heading = new JLabel("Search Record", JLabel.CENTER);
    JPanel TFpanel = new JPanel();
    JLabel IDTFlabel = new JLabel("Enter ID:");
    JLabel NAMElabel = new JLabel("Enter Name:");
    JTextField IDTF = new JTextField();
    JTextField NAMETF = new JTextField();
    JButton action = new JButton("SEARCH BY ID");
    JButton action1 = new JButton("SEARCH BY NAME");
    JPanel buttons = new JPanel();
    
    public void actionPerformed(ActionEvent e) 
    {
        switch(e.getActionCommand())
        {
            case "SEARCH BY ID":
                int ID;
                permResident r = null;
                try
                {
                    ID = Integer.parseInt(IDTF.getText());
                    r = new permResident(ID, null, null, 0, null, 0);
                    r.searchRecordID();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.WARNING_MESSAGE);
                }
                break;
                
            case "SEARCH BY NAME":
                String name;
                permResident r1 = null;
                try
                {
                    name = NAMETF.getText();
                    r1 = new permResident(0, name, null, 0, null, 0);
                    r1.searchRecordName();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.WARNING_MESSAGE);
                }
                break;
        }
    }
}
