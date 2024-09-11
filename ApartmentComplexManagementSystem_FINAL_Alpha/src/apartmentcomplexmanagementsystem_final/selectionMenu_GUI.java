package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class selectionMenu_GUI extends JFrame implements ActionListener
{
    public selectionMenu_GUI()
    {
        setVisible(true);
        setSize(1100, 700);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setIconImage(systemIcon.getImage());
        setLayout(new BorderLayout());
        selectionMenuHeading.setFont(new Font("Broadway", Font.BOLD, 37));
        selectionMenuHeading.setForeground(Color.GRAY);
        add(selectionMenuHeading, BorderLayout.NORTH);
        selectionMenuResidents.setBackground(Color.LIGHT_GRAY);
        selectionMenuApartments.setBackground(Color.LIGHT_GRAY);
        selectionMenuCondos.setBackground(Color.LIGHT_GRAY);
        selectionMenuExit.setBackground(Color.LIGHT_GRAY);
        selectionMenuResidents.setFont(new Font("Calibri", Font.BOLD, 15));
        selectionMenuApartments.setFont(new Font("Calibri", Font.BOLD, 15));
        selectionMenuCondos.setFont(new Font("Calibri", Font.BOLD, 15));
        selectionMenuExit.setFont(new Font("Calibri", Font.BOLD, 15));
        selectionMenuResidents.setSize(500, 50);
        selectionMenuResidents.setLocation(300, 150);
        selectionMenuApartments.setSize(500, 50);
        selectionMenuApartments.setLocation(300, 205);
        selectionMenuCondos.setSize(500, 50);
        selectionMenuCondos.setLocation(300, 260);
        selectionMenuResidents.addActionListener(this);
        selectionMenuApartments.addActionListener(this);
        selectionMenuCondos.addActionListener(this);
        selectionMenuExit.addActionListener(this);
        selectionMenuButtons.setLayout(null);
        selectionMenuButtons.setBackground(Color.DARK_GRAY);
        selectionMenuButtons.add(selectionMenuResidents);
        selectionMenuButtons.add(selectionMenuApartments);
        selectionMenuButtons.add(selectionMenuCondos);
        add(selectionMenuButtons, BorderLayout.CENTER);
        selectionMenuExitButton.setBackground(Color.DARK_GRAY);
        selectionMenuExitButton.add(selectionMenuExit);
        add(selectionMenuExitButton, BorderLayout.SOUTH);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel selectionMenuHeading = new JLabel("Please Select a Category", JLabel.CENTER);
    JButton selectionMenuResidents = new JButton("RESIDENTS");
    JButton selectionMenuApartments = new JButton("APARTMENTS");
    JButton selectionMenuCondos = new JButton("CONDOS");
    JButton selectionMenuExit = new JButton("BACK");
    JPanel selectionMenuExitButton = new JPanel();
    JPanel selectionMenuButtons = new JPanel();
    
    public void actionPerformed(ActionEvent e) 
    {
        switch(e.getActionCommand())
        {
            case "RESIDENTS":
                new residentMenu_GUI();
                break;
            
            case "APARTMENTS":
                new apartmentMenu_GUI();
                break;
            
            case "CONDOS":
                new condoMenu_GUI();
                break;
                
            case "BACK":
                setVisible(false);
                break;
        }
    }
    
    
}
