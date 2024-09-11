package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class apartmentMenu_GUI extends JFrame implements ActionListener
{
    public apartmentMenu_GUI()
    {
        setVisible(true);
        setSize(1100, 700);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setIconImage(systemIcon.getImage());
        setLayout(new BorderLayout());
        residentMenuHeading.setFont(new Font("Broadway", Font.BOLD, 37));
        residentMenuHeading.setForeground(Color.GRAY);
        add(residentMenuHeading, BorderLayout.NORTH);
        residentMenuButtons.setBackground(Color.DARK_GRAY);
        residentMenuButtons.setLayout(null);
        residentMenuTempRes.setSize(500, 50);
        residentMenuPermRes.setSize(500, 50);
        residentMenuTempRes.setLocation(300, 150);
        residentMenuPermRes.setLocation(300, 205);
        residentMenuTempRes.setBackground(Color.LIGHT_GRAY);
        residentMenuTempRes.setFont(new Font("Calibri", Font.BOLD, 15));
        residentMenuPermRes.setBackground(Color.LIGHT_GRAY);
        residentMenuPermRes.setFont(new Font("Calibri", Font.BOLD, 15));
        residentMenuExit.setBackground(Color.LIGHT_GRAY);
        residentMenuExit.setFont(new Font("Calibri", Font.BOLD, 15));
        residentMenuExitButton.setBackground(Color.DARK_GRAY);
        residentMenuExitButton.add(residentMenuExit);
        residentMenuButtons.add(residentMenuTempRes);
        residentMenuButtons.add(residentMenuPermRes);
        residentMenuTempRes.addActionListener(this);
        residentMenuPermRes.addActionListener(this);
        residentMenuExit.addActionListener(this);
        add(residentMenuButtons);
        add(residentMenuExitButton, BorderLayout.SOUTH);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel residentMenuHeading = new JLabel("Apartment Menu", JLabel.CENTER);
    JButton residentMenuTempRes = new JButton("MONTHLY APARTMENTS");
    JButton residentMenuPermRes = new JButton("YEARLY APARTMENTS");
    JButton residentMenuExit = new JButton("BACK");
    JPanel residentMenuButtons = new JPanel();
    JPanel residentMenuExitButton = new JPanel();
    
    public void actionPerformed(ActionEvent e) 
    {
        switch(e.getActionCommand())
        {
            case "MONTHLY APARTMENTS":
                new monthlyApartment_GUI();
                break;
                
            case "YEARLY APARTMENTS":
                new yearlyApartment_GUI();
                break;
                
            case "BACK":
                setVisible(false);
                break;
        }
    }
}
