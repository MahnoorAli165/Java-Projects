package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tempResidentUPDATE_GUI extends JFrame 
{
    public tempResidentUPDATE_GUI()
    {
        setVisible(true);
        setSize(900, 500);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setIconImage(systemIcon.getImage());
        setLayout(new BorderLayout());
        heading.setFont(new Font("Broadway", Font.BOLD, 37));
        heading.setForeground(Color.GRAY);
        add(heading, BorderLayout.NORTH);
        TFpanel.setLayout(new GridLayout(6,0));
        IDTFlabel.setForeground(Color.WHITE);
        NAMETFlabel.setForeground(Color.WHITE);
        GENDERTFlabel.setForeground(Color.WHITE);
        PHONETFlabel.setForeground(Color.WHITE);
        ROOMTFlabel.setForeground(Color.WHITE);
        EMAILTFlabel.setForeground(Color.WHITE);
        TFpanel.setBackground(Color.DARK_GRAY);
        TFpanel.add(IDTFlabel);
        TFpanel.add(IDTF);
        TFpanel.add(NAMETFlabel);
        TFpanel.add(NAMETF);
        TFpanel.add(GENDERTFlabel);
        TFpanel.add(GENDERTF);
        TFpanel.add(PHONETFlabel);
        TFpanel.add(PHONETF);
        TFpanel.add(ROOMTFlabel);
        TFpanel.add(ROOMTF);
        TFpanel.add(EMAILTFlabel);
        TFpanel.add(EMAILTF);
        action.setBackground(Color.LIGHT_GRAY);
        action.setFont(new Font("Calibri", Font.BOLD, 15));
        action.addActionListener(new MyActionListener());
        add(TFpanel, BorderLayout.CENTER);
        add(action, BorderLayout.SOUTH);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel heading = new JLabel("Add New Record with Existing ID", JLabel.CENTER);
    JPanel TFpanel = new JPanel();
    JLabel IDTFlabel = new JLabel("Enter ID:");
    JLabel NAMETFlabel = new JLabel("Enter Name:");
    JLabel GENDERTFlabel = new JLabel("Enter Gender:");
    JLabel PHONETFlabel = new JLabel("Enter Phone Number:");
    JLabel ROOMTFlabel = new JLabel("Enter Room Number:");
    JLabel EMAILTFlabel = new JLabel("Enter E-Mail Address:");
    JTextField IDTF = new JTextField();
    JTextField NAMETF = new JTextField();
    JTextField GENDERTF = new JTextField();
    JTextField PHONETF = new JTextField();
    JTextField ROOMTF = new JTextField();
    JTextField EMAILTF = new JTextField();
    JButton action = new JButton("UPDATE");
    
    public class MyActionListener implements ActionListener //Anonymous class
    {
        public void actionPerformed(ActionEvent e) 
        {
            int ID, roomNo;
            String name, gender, email;
            long phoneNo;
            tempResident r = null;
            switch(e.getActionCommand())
            {
                case "UPDATE":
                    try
                    {
                        ID = Integer.parseInt(IDTF.getText());
                        name = NAMETF.getText();
                        gender = GENDERTF.getText();
                        phoneNo = Long.parseLong(PHONETF.getText());
                        roomNo = Integer.parseInt(ROOMTF.getText());
                        email = EMAILTF.getText();
                        r = new tempResident(ID, name, gender, phoneNo, email, roomNo);
                        r.updateRecord();
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
            }
        }
    }
}
