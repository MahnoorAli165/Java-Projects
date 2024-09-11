package Railway_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class searchTrain_name extends JFrame{
    JFrame search_id = new JFrame();
    JPanel p1 = new JPanel();
    JLabel heading = new JLabel("Search Train");
    JLabel nameLabel = new JLabel("Enter Name: ");
    JTextField nameField = new JTextField("");
    JButton search = new JButton(" Search ");
    
    public searchTrain_name(int action){
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(6,1));
        p1.add(new JPanel());
        p1.add(nameLabel);
        p1.add(nameField);
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(new JPanel());
        add(heading,BorderLayout.NORTH);
        add(p1);
        add(search,BorderLayout.SOUTH);
        ActionListener searchTrain = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(action==1){
                Local c=new Local();
                Object obj=c.searchTrain_name(nameField.getText());
                String s=obj.toString();
                String[] s1 =s.split(" ");
                if(obj==null)
                    JOptionPane.showMessageDialog(null, "No such record found");
                else
                    JOptionPane.showMessageDialog(null,"ID: "+s1[0]+"  Name: "+s1[1]+"  Seats: "+s1[2]+"  Fair: "+s1[3] );
                
            }
            else{
                International c=new International();
                Object obj= c.searchTrain_name(nameField.getText());
                String s=obj.toString();
                String[] s1 = s.split(" ");
                if(obj==null)
                    JOptionPane.showMessageDialog(null, "No such record found");
                else
                    JOptionPane.showMessageDialog(null,"ID: "+s1[0]+"  Name: "+s1[1]+"  Seats: "+s1[2]+"  Fair: "+s1[3] );
            }
            }
    };
        search.addActionListener(searchTrain);
    }
    
}
