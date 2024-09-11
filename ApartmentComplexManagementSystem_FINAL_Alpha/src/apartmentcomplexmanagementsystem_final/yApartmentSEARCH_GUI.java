package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class yApartmentSEARCH_GUI extends JFrame implements ActionListener
{
    public yApartmentSEARCH_GUI()
    {
        setVisible(true);
        setSize(400, 150);
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
        TFpanel.setBackground(Color.DARK_GRAY);
        TFpanel.add(IDTFlabel);
        TFpanel.add(IDTF);
        action.setBackground(Color.LIGHT_GRAY);
        action.setFont(new Font("Calibri", Font.BOLD, 15));
        action.addActionListener(this);
        add(TFpanel, BorderLayout.CENTER);
        add(action, BorderLayout.SOUTH);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel heading = new JLabel("Search Record", JLabel.CENTER);
    JPanel TFpanel = new JPanel();
    JLabel IDTFlabel = new JLabel("Enter ID:");
    JTextField IDTF = new JTextField();
    JButton action = new JButton("SEARCH");
    
    public void actionPerformed(ActionEvent e) 
    {
        int ID;
        yApart r = null;
        switch(e.getActionCommand())
        {
            case "SEARCH":
                try
                {
                    ID = Integer.parseInt(IDTF.getText());
                    r = new yApart(ID, 0, 0 ,0);
                    r.searchRecordID();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.WARNING_MESSAGE);
                }
                break;
            
        }
    }
}
