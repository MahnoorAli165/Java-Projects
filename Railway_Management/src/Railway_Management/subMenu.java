package Railway_Management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class subMenu extends JFrame implements WindowListener {

    JFrame subMenu = new JFrame();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Status");
    JMenuItem local = new JMenuItem("Local");
    JMenuItem international = new JMenuItem("International");
    JButton addTrain = new JButton("Add Train");
    JButton viewTrain = new JButton("View Train");
    JButton updateTrain = new JButton("Update Train");
    JButton deleteTrain = new JButton("Delete Train");
    JButton searchID = new JButton("Search Train by ID");
    JButton searchName = new JButton("Search Train by Name");
    JLabel view = new JLabel();
    private int action;

    public subMenu() {
        super("Railway Ticket Management");
        setSize(900, 700);
        setLayout(new BorderLayout());
        addWindowListener(this);
        menu.add(local);
        menu.add(international);
        menuBar.add(menu);

        JPanel p1 = new JPanel(new GridLayout(6, 1));
        p1.add(addTrain);
        p1.add(viewTrain);
        p1.add(updateTrain);
        p1.add(deleteTrain);
        p1.add(searchID);
        p1.add(searchName);
        setJMenuBar(menuBar);

//        add(new JPanel(),BorderLayout.CENTER);
        add(p1, BorderLayout.EAST);

        ImageIcon image = new ImageIcon("trains.jpg");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Local")) {
                    action = 1;
                } else {
                    action = 2;
                }
            }
        };
        local.addActionListener(al);
        international.addActionListener(al);

        addTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent addingTrain) {
                if (action == 1 || action == 2) {
                    addingTrain addTrain = new addingTrain(action);
                    addTrain.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Select Status from Menu Bar");
                }
            }
        });
        viewTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (action == 1 || action == 2) {
                    viewTrains view = new viewTrains(action);
                    view.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Select Status from Menu Bar");
                }
            }
        });
        updateTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (action == 1 || action == 2) {

                    updateTrain update = new updateTrain(action);
                    update.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Select Status from Menu Bar");
                }
            }
        });
        searchID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (action == 1 || action == 2) {
                    searchTrain_ID searchID = new searchTrain_ID(action);
                    searchID.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Select Status from Menu Bar");
                }
            }
        });
        searchName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (action == 1 || action == 2) {
                    searchTrain_name searchName = new searchTrain_name(action);
                    searchName.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Select Status from Menu Bar");
                }
            }
        });
        deleteTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (action == 1 || action == 2) {
                    deleteTrain delete = new deleteTrain(action);
                    delete.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Select Status from Menu Bar");
                }
            }
        });
    }

    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        new Runner().setVisible(true);

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
