package Railway_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class deleteTrain extends JFrame{
    JFrame addingTrain = new JFrame();
    JLabel heading = new JLabel("             Delete Train");
    JLabel idLabel = new JLabel("Enter id: ");
    JTextField idField = new JTextField("");
    JButton delete =new JButton(" Delete ");
    JPanel p1 = new JPanel();
    public deleteTrain(int action){
        super("Railay Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(6,1));
        p1.add(new JPanel());
        p1.add(idLabel);
        p1.add(idField);
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(new JPanel());
        add(heading,BorderLayout.NORTH);
        add(p1);
        add(delete,BorderLayout.SOUTH);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(action==1){
                    Local c= new Local();
                    int id=0;
                    boolean check=true;
                    while(check){
                    try {
                        id = Integer.parseInt(idField.getText());
                        check=false;
                    } catch (Exception e1) {
                        idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    }}
                    check=c.deleteTrain(id);
                    if(check)
                        JOptionPane.showMessageDialog(null, "Record deleted successfully");
                    else
                        JOptionPane.showMessageDialog(null, "Error deleting record.\nID may not exist");
                }
                else{
                    International c= new International();
                    int id=0;
                    boolean check=true;
                    while(check){
                    try {
                        id = Integer.parseInt(idField.getText());
                        check=false;
                    } catch (Exception e1) {
                        idField.setText(JOptionPane.showInputDialog("ID must be an integer value\nEnter ID:"));
                    }
                    }
                    check=c.deleteTrain(id);
                    if(check)
                        JOptionPane.showMessageDialog(null, "Record deleted successfully");
                    else
                        JOptionPane.showMessageDialog(null, "Error deleting record.\nID may not exist");
                }
            }
        });
    }
}
