package apartmentcomplexmanagementsystem_final;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class yApartmentDELETE_GUI extends JFrame implements ActionListener
{
    public yApartmentDELETE_GUI()
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
        APARTMENTTFlabel.setForeground(Color.WHITE);
        TFpanel.setBackground(Color.DARK_GRAY);
        TFpanel.add(APARTMENTTFlabel);
        TFpanel.add(APARTMENTTF);
        action.setBackground(Color.LIGHT_GRAY);
        action.setFont(new Font("Calibri", Font.BOLD, 15));
        action.addActionListener(this);
        add(TFpanel, BorderLayout.CENTER);
        add(action, BorderLayout.SOUTH);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel heading = new JLabel("Delete Record", JLabel.CENTER);
    JPanel TFpanel = new JPanel();
    JLabel APARTMENTTFlabel = new JLabel("Enter Apartment Number:");
    JTextField APARTMENTTF = new JTextField();
    JButton action = new JButton("DELETE");
    
    public void actionPerformed(ActionEvent e) 
    {
        int apartNo;
        yApart r = null;
        switch(e.getActionCommand())
        {
            case "DELETE":
                try
                {
                    apartNo = Integer.parseInt(APARTMENTTF.getText());
                    r = new yApart(apartNo, 0, 0, 0);
                    r.deleteRecord();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.WARNING_MESSAGE);
                }
                break;
        }
    }
}
