package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class monApartmentADD_GUI extends JFrame implements ActionListener
{
    public monApartmentADD_GUI()
    {
        setVisible(true);
        setSize(400, 300);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setIconImage(systemIcon.getImage());
        setLayout(new BorderLayout());
        heading.setFont(new Font("Broadway", Font.BOLD, 37));
        heading.setForeground(Color.GRAY);
        add(heading, BorderLayout.NORTH);
        TFpanel.setLayout(new GridLayout(4,0));
        APARTMENTTFlabel.setForeground(Color.WHITE);
        FLOORTFlabel.setForeground(Color.WHITE);
        RENTTFlabel.setForeground(Color.WHITE);
        SIZETFlabel.setForeground(Color.WHITE);
        TFpanel.setBackground(Color.DARK_GRAY);
        TFpanel.add(APARTMENTTFlabel);
        TFpanel.add(APARTMENTTF);
        TFpanel.add(FLOORTFlabel);
        TFpanel.add(FLOORTF);
        TFpanel.add(SIZETFlabel);
        TFpanel.add(SIZETF);
        TFpanel.add(RENTTFlabel);
        TFpanel.add(RENTTF);
        action.setBackground(Color.LIGHT_GRAY);
        action.setFont(new Font("Calibri", Font.BOLD, 15));
        action.addActionListener(this);
        add(TFpanel, BorderLayout.CENTER);
        add(action, BorderLayout.SOUTH);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel heading = new JLabel("Add Record", JLabel.CENTER);
    JPanel TFpanel = new JPanel();
    JLabel APARTMENTTFlabel = new JLabel("Enter Apartment Number:");
    JLabel FLOORTFlabel = new JLabel("Enter Floor Number:");
    JLabel SIZETFlabel = new JLabel("Enter Size:");
    JLabel RENTTFlabel = new JLabel("Enter Monthly Rent:");
    JTextField APARTMENTTF = new JTextField();
    JTextField FLOORTF = new JTextField();
    JTextField SIZETF = new JTextField();
    JTextField RENTTF = new JTextField();
    JButton action = new JButton("ADD");
    
    public void actionPerformed(ActionEvent e) 
    {
        int apartNo, floor, size, monthlyRent;
        monApart r = null;
        switch(e.getActionCommand())
        {
            case "ADD":
                try
                {
                    apartNo = Integer.parseInt(APARTMENTTF.getText());
                    floor = Integer.parseInt(FLOORTF.getText());
                    size = Integer.parseInt(SIZETF.getText());
                    monthlyRent = Integer.parseInt(RENTTF.getText());
                    r = new monApart(apartNo, floor, size, monthlyRent);
                    r.addRecord();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.WARNING_MESSAGE);
                }
                break;
        }
    }
}
