package Railway_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updateTrain extends JFrame {
    JFrame update = new JFrame();
    JPanel p1 = new JPanel();
    JLabel heading = new JLabel("Update Train");
    JLabel idLabel = new JLabel("          Enter ID: ");
    JTextField idField = new JTextField();
    JButton updateBSeats = new JButton(" Update number of Business seats ");
    JButton updateBFair = new JButton(" Update fair for Business one seat ");
    JButton updateESeats = new JButton(" Update number of Economy seats ");
    JButton updateEFair = new JButton(" Update fair for Economy one seat ");
    
    
    public updateTrain(int action){
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(6,2));
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(idLabel);
        p1.add(idField);
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(updateBSeats);
        p1.add(updateBFair);
        p1.add(updateESeats);
        p1.add(updateEFair);
        p1.add(new JPanel());
        p1.add(new JPanel());
        add(heading,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);
        
        updateBSeats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=0;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (Exception e1) {
                    idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    id = Integer.parseInt(idField.getText());
                }
                if(action==1){
                    Local c= new Local();
                    boolean update=c.updateTrain(id,1);
                    if(update)
                        JOptionPane.showMessageDialog(null, "Record updated successfully");
                    else
                        JOptionPane.showMessageDialog(null, "Error updating record");
                }
                else{
                    International c = new International();
                    boolean update= c.updateTrain(id,1);
                    if(update)
                        JOptionPane.showMessageDialog(null, "Record updated successfully");
                    else
                        JOptionPane.showMessageDialog(null, "Error updating record");
                }
            }
        });
        updateBFair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=0;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (Exception e1) {
                    idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    id = Integer.parseInt(idField.getText());
                }
                if(action==1){
                    Local c= new Local();
                    boolean update=c.updateTrain(id,2);
                    if(update)
                        JOptionPane.showMessageDialog(null, "Record updated successfully");
                    else
                        JOptionPane.showMessageDialog(null, "Error updating record");
                }
                else{
                    International c = new International();
                    boolean update= c.updateTrain(id,2);
                    if(update)
                        JOptionPane.showMessageDialog(null, "Record updated successfully");
                    else
                        JOptionPane.showMessageDialog(null, "Error updating record");
                }
            }
        });
        
    }
}
