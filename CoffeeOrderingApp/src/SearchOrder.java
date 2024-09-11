import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchOrder {

	JFrame frame;
	JTextField txtCustomerName;
	JLabel lblEnterName;
	String customerName = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchOrder window = new SearchOrder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 408, 136);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtCustomerName = new JTextField();
		txtCustomerName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerName = txtCustomerName.getText();
			}
		});
		txtCustomerName.setHorizontalAlignment(SwingConstants.LEFT);
		txtCustomerName.setToolTipText("Enter name of customer here");
		txtCustomerName.setBounds(10, 38, 276, 23);
		frame.getContentPane().add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				for(int j=0;j<alName.size();j++)
//					{
//						if(customerName==alName.get(j))
//						{
//							displayOrder();
//						}
//					}
			}
		});
		btnSearch.setBounds(293, 38, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		lblEnterName = new JLabel("Enter Customer's Name");
		lblEnterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterName.setBounds(10, 10, 151, 17);
		frame.getContentPane().add(lblEnterName);
	}
}
