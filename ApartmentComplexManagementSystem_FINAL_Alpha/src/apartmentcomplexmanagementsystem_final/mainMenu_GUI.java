package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainMenu_GUI extends JFrame implements ActionListener, WindowListener
{
    public mainMenu_GUI()
    {
        setSize(1100, 700);
        setVisible(true);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setIconImage(systemIcon.getImage());
        setLayout(new BorderLayout());
        mainMenuHeadingText.setFont(new Font("Broadway", Font.BOLD, 37));
        mainMenuHeadingText.setForeground(Color.GRAY);
        add(mainMenuHeadingText, BorderLayout.NORTH);
        add(mainMenu_Pic, BorderLayout.CENTER);
        mainMenuButtons.setBackground(Color.DARK_GRAY);
        login.setBackground(Color.LIGHT_GRAY);
        exit.setBackground(Color.LIGHT_GRAY);
        login.setFont(new Font("Calibri", Font.BOLD, 15));
        exit.setFont(new Font("Calibri", Font.BOLD, 15));
        mainMenuButtons.add(login);
        mainMenuButtons.add(exit);
        add(mainMenuButtons, BorderLayout.SOUTH);
        login.addActionListener(this);
        exit.addActionListener(this);
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    ImageIcon mainMenuPic = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemMainMenuPic.png");
    JLabel mainMenuHeadingText = new JLabel("Mayfeather Apartments Management System", JLabel.CENTER);
    JLabel mainMenu_Pic = new JLabel("", mainMenuPic, JLabel.CENTER);
    JButton login = new JButton("LOGIN");
    JButton exit = new JButton("EXIT");
    JPanel mainMenuButtons = new JPanel();
    
    public void actionPerformed(ActionEvent e) 
    {
        switch(e.getActionCommand())
        {
            case "EXIT":
                System.exit(0);
            
            case "LOGIN":
                new selectionMenu_GUI();
                break;
        }
    }
    
    public void windowOpened(WindowEvent e) 
    {
        
        
    }
    
    public void windowClosing(WindowEvent e) 
    {
        int OP = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit", "Warning", JOptionPane.NO_OPTION);
        if(OP == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    
    public void windowClosed(WindowEvent e) 
    {
        
    }
    
    public void windowIconified(WindowEvent e) 
    {
        
    }
    
    public void windowDeiconified(WindowEvent e) 
    {
        
    }
    
    public void windowActivated(WindowEvent e) 
    {
        
    }
    
    public void windowDeactivated(WindowEvent e) 
    {
        
    }
}
