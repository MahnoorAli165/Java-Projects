package Railway_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Runner extends JFrame implements WindowListener{

    JButton trains = new JButton("");
    JButton customers = new JButton("");
    JButton reservation = new JButton("");
    
    JLabel railwayImage =new JLabel(new ImageIcon("main.png"));
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
   
    
    public Runner(){
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);
        p1.setLayout(new GridLayout(3, 1));
        p1.add(trains);
        p1.add(customers);
        p1.add(reservation);
        p2.setLayout(new FlowLayout());
        trains.setIcon(new ImageIcon("train.png"));
        customers.setIcon(new ImageIcon("customer.png"));
        reservation.setIcon(new ImageIcon("reserve.png"));
        p2.add(railwayImage);
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.NORTH);
        addWindowListener(this);
        
        trains.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subMenu sm = new subMenu();
                sm.setVisible(true);
                dispose();
            }
        });
        customers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu m = new mainMenu();
                m.setVisible(true);
                dispose();
            }
        });
        
        reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainReservation tr = new TrainReservation();
                tr.setVisible(true);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        Runner a4 = new Runner();
        a4.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to close","Exit",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
        else{
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
