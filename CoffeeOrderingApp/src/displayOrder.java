import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class displayOrder {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayOrder window = new displayOrder();
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
	public displayOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 292, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Order Summary");
		frame.getContentPane().setLayout(null);
		
		JLabel lblFinalOrderSummary = new JLabel("Order Summary");
		lblFinalOrderSummary.setBackground(new Color(95, 158, 160));
		lblFinalOrderSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalOrderSummary.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFinalOrderSummary.setBounds(0, 0, 276, 48);
		frame.getContentPane().add(lblFinalOrderSummary);
		
		JTextArea textAreaOrderSummary = new JTextArea();
		textAreaOrderSummary.setBackground(new Color(95, 158, 160));
		textAreaOrderSummary.setFont(new Font("Arial Black", Font.BOLD, 16));
		textAreaOrderSummary.setBounds(0, 51, 276, 211);
		textAreaOrderSummary.setText("hello world");
		textAreaOrderSummary.setEditable(false);
		frame.getContentPane().add(textAreaOrderSummary);
	}
}
