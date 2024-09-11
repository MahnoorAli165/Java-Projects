package apartmentcomplexmanagementsystem_final;

import java.awt.*;
import javax.swing.*;

public class unexpectedError_GUI extends JFrame
{
    public unexpectedError_GUI()
    {
        setVisible(true);
        setSize(150, 200);
        setResizable(false);
        setTitle("Mayfeather Apartments Management System");
        setLocationRelativeTo(null);
        setIconImage(systemIcon.getImage());
        setLayout(new BorderLayout());
        error.setForeground(Color.YELLOW);
        add(error, BorderLayout.CENTER);
        
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    ImageIcon systemIcon = new ImageIcon("C:\\Users\\abdul\\Downloads\\SystemIcon.png");
    JLabel error = new JLabel("Error: An unexpected error occurred.", JLabel.CENTER);
}
