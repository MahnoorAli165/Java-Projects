import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.View;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AddOrder {

	JFrame frame;
    static JTextField txtUsername;
	JLabel lblQuantity;
	JLabel lblOrderSummary;
	static String userName;
	static boolean hasWhippedCream;
	static boolean hasChocolate;
	static int finalPrice;
	JLabel lblFinalPrice;
	static int quantity = 2;
//	static int i = 0;
	static ArrayList<String> alName = new ArrayList<String>();
	static ArrayList<Boolean> alWhippedCreamTopping = new ArrayList<Boolean>();
	static ArrayList<Boolean> alChocolateTopping = new ArrayList<Boolean>();
	static ArrayList<Integer> alQuantity = new ArrayList<Integer>();
	static ArrayList<Integer> alPrice = new ArrayList<Integer>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					AddOrder window = new AddOrder();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the application.
	 */
	public AddOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param View 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 410, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Add Order");
		frame.getContentPane().setLayout(null);
		
		JLabel lblJustJava = new JLabel("Just Java");
		lblJustJava.setForeground(Color.BLACK);
		lblJustJava.setBackground(new Color(255, 255, 255));
		lblJustJava.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJustJava.setHorizontalAlignment(SwingConstants.LEFT);
		lblJustJava.setBounds(10, 0, 290, 47);
		frame.getContentPane().add(lblJustJava);
		
//		Component horizontalStrut = Box.createHorizontalStrut(20);
//		horizontalStrut.setBounds(10, 49, 41, -9);
//		frame.getContentPane().add(horizontalStrut);
		
		txtUsername = new JTextField();
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtUsername.setText(null);
			}
		});
		txtUsername.setToolTipText("Enter customer's name in this field");
		txtUsername.setText("Customer's Name");
		txtUsername.setBounds(10, 48, 290, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblToppings = new JLabel("Toppings");
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(10, 85, 80, 25);
		frame.getContentPane().add(lblToppings);
		
		JCheckBox cbxWhippedCream = new JCheckBox("Whipped Cream");
		cbxWhippedCream.setHorizontalAlignment(SwingConstants.LEFT);
		cbxWhippedCream.setBackground(new Color(255, 255, 255));
		cbxWhippedCream.setBounds(10, 111, 142, 23);
		cbxWhippedCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hasWhippedCream = cbxWhippedCream.isSelected();
				calculatePrice(hasWhippedCream,hasChocolate);
				lblFinalPrice.setText("$" + finalPrice);
			}
		});
		frame.getContentPane().add(cbxWhippedCream);
		
		JCheckBox cbxChocolate = new JCheckBox("Chocolate");
		cbxChocolate.setHorizontalAlignment(SwingConstants.LEFT);
		cbxChocolate.setBackground(new Color(255, 255, 255));
		cbxChocolate.setBounds(10, 143, 142, 23);
		cbxChocolate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hasChocolate = cbxChocolate.isSelected();
				calculatePrice(hasWhippedCream,hasChocolate);
				lblFinalPrice.setText("$" + finalPrice);
			}
		});
		frame.getContentPane().add(cbxChocolate);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantity_1.setBounds(10, 183, 80, 25);
		frame.getContentPane().add(lblQuantity_1);
		
		lblQuantity = new JLabel("2");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(60, 209, 20, 28);
		frame.getContentPane().add(lblQuantity);
		
		JButton decrementButton = new JButton("-");
		decrementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(quantity==1)
				{
					JOptionPane.showMessageDialog(null,"You cannot order less than 1 cup of coffee");
					return;
				}
				quantity-= 1;
				lblQuantity.setText("" + quantity);
				calculatePrice(hasWhippedCream,hasChocolate);
				lblFinalPrice.setText("$" + finalPrice);
			}
		});
		
		decrementButton.setIcon(null);
		decrementButton.setBackground(new Color(230, 230, 250));
		decrementButton.setBounds(10, 209, 41, 28);
		frame.getContentPane().add(decrementButton);
		
		JButton incrementButton = new JButton("+");
		incrementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(quantity==50)
				{
					JOptionPane.showMessageDialog(null,"You cannot order more than 50 cups of coffee.");
					return;
				}
				quantity+= 1;
				lblQuantity.setText("" + quantity);
				calculatePrice(hasWhippedCream,hasChocolate);
				lblFinalPrice.setText("$" + finalPrice);
			}
		});
		incrementButton.setBackground(new Color(230, 230, 250));
		incrementButton.setBounds(89, 209, 41, 28);
		frame.getContentPane().add(incrementButton);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalPrice.setBounds(10, 254, 128, 14);
		frame.getContentPane().add(lblTotalPrice);
		
		JTextArea txtOrderSummary = new JTextArea();
		txtOrderSummary.setBackground(new Color(95, 158, 160));
		txtOrderSummary.setBounds(193, 211, 162, 126);
		frame.getContentPane().add(txtOrderSummary);
		
		JButton btnSaveOrder = new JButton("Save Order");
		btnSaveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName = txtUsername.getText();
				calculatePrice(hasWhippedCream,hasChocolate);
				String priceMessage  = createOrderSummary(userName,finalPrice,hasWhippedCream,hasChocolate);
				txtOrderSummary.setText(priceMessage);
				lblOrderSummary.setVisible(true);
				saveOrder();
//				loopPractice();
				JOptionPane.showMessageDialog(null,"Order saved");
			}
		});
		btnSaveOrder.setBackground(new Color(230, 230, 250));
		btnSaveOrder.setBounds(10, 306, 108, 30);
		frame.getContentPane().add(btnSaveOrder);
			
		lblFinalPrice = new JLabel("$10");
		lblFinalPrice.setBounds(10, 269, 108, 20);
		frame.getContentPane().add(lblFinalPrice);
		
		lblOrderSummary = new JLabel("Order Summary");
		lblOrderSummary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrderSummary.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderSummary.setBounds(193, 188, 162, 14);
		lblOrderSummary.setVisible(false);
		frame.getContentPane().add(lblOrderSummary);
		
		JButton btnNewButton = new JButton("Check Saved Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				strNameCheck();
			}
		});
		btnNewButton.setBounds(10, 361, 162, 23);
		frame.getContentPane().add(btnNewButton);
		
	}

	static int calculatePrice(boolean addWhippedCream,boolean addChocolate)
	{
		int basePrice = 5;
		if(addWhippedCream)
		{
			basePrice+= 1;
		}
		if(addChocolate)
		{
			basePrice+= 2;
		}
		finalPrice = basePrice * quantity;
		return finalPrice;
	}	
	
	static String createOrderSummary(String txtUser,int price,boolean hasWhippedCream,boolean hasChocolate)
	{
		StringBuilder orderSummary = new StringBuilder(txtUser  + "\n" + "Add whipped cream?" + hasWhippedCream + "\n" + "Add chocolate?" + hasChocolate + "\n" + "Quantity:" + quantity + "\nTotal: $" + price + "\nThank you");
		return orderSummary.toString();
	}

	static  void saveOrder()
	{
		alName.add(userName);
		alWhippedCreamTopping.add(hasWhippedCream);
		alChocolateTopping.add(hasChocolate);
		alQuantity.add(quantity);
		alPrice.add(finalPrice);
	}
	static void strNameCheck(){
		for(String strName:alName)
		{
			System.out.println(strName);
		}
	}
}
