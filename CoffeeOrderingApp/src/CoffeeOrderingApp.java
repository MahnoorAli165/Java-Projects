import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import static java.awt.SystemColor.window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CoffeeOrderingApp {

	static JTextField txtUsername;
	static JTextField txtCustomerName;
	static JTextArea textAreaOrderSummary;
	static JTextArea txtOrderSummary;
	static JLabel lblQuantity;
	static JLabel lblOrderSummary;
	static JButton btnSaveOrder;
	static String userName = "";
	static String customerName = "";
	static String priceMessage = "";
	static String priceMessage1 = "";
	static boolean hasWhippedCream;
	static boolean hasChocolate;
	static int finalPrice;
	static JLabel lblFinalPrice;
	static JLabel lblEnterName;
	static int quantity = 2;
//	static int i = 0;	
	static JFrame frameAddOrder;
	static JFrame frameDisplayOrder;
	static JFrame frame;
	static JFrame frameSearchOrder;
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
				//try {
					//CoffeeOrderingApp window = new CoffeeOrderingApp();
                                        initialize();
                                        LoadData();
//					window.frame.setVisible(true);
//					window.frame.setResizable(false);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			}
		});
	}

	/**
	 * Create the application.
	 */
//	public CoffeeOrderingApp() {
//		//initialize();
////		LoadData();
////		for(String str : alName){
////			System.out.println(str);
////		}
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				saveData();
			}
		});
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 450, 295);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Just Java");
		
		addOrder();
		
		JButton btnAddOrder = new JButton("Add Order");
		btnAddOrder.setBackground(new Color(248, 248, 255));
		btnAddOrder.setBounds(163, 80, 120, 30);
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!frameAddOrder.isVisible()){
					txtUsername.setText("Customer's Name");
					lblOrderSummary.setVisible(false);
					txtOrderSummary.setText(null);
					frameAddOrder.setVisible(true);
				}
			}
		});
		frame.getContentPane().setLayout(null);
		btnAddOrder.setPreferredSize(new Dimension(150, 100));
		frame.getContentPane().add(btnAddOrder);
		
		displayOrder();
		searchOrder();
		
		JButton btnSearchOrder = new JButton("Search Order");
		btnSearchOrder.setBackground(new Color(248, 248, 255));
		btnSearchOrder.setBounds(163, 127, 120, 30);
		btnSearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!frameSearchOrder.isVisible()){
					txtCustomerName.setText("Enter customer's name");
//					searchOrder();
					frameSearchOrder.setVisible(true);
				}
			}
		});
		btnSearchOrder.setPreferredSize(new Dimension(150, 100));
		frame.getContentPane().add(btnSearchOrder);
		
                CoffeeOrderingApp window = new CoffeeOrderingApp();
                window.frame.setVisible(true);
                window.frame.setResizable(false);
//		frmAddOrder = new AddOrder();
		}
	
	static void addOrder(){
		frameAddOrder = new JFrame();
		frameAddOrder.setResizable(false);
		frameAddOrder.getContentPane().setBackground(new Color(95, 158, 160));
		frameAddOrder.setBounds(100, 100, 410, 444);
//		frameAddOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAddOrder.setTitle("Add Order");
		frameAddOrder.getContentPane().setLayout(null);
		
		JLabel lblJustJava = new JLabel("Just Java");
		lblJustJava.setForeground(Color.BLACK);
		lblJustJava.setBackground(new Color(255, 255, 255));
		lblJustJava.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJustJava.setHorizontalAlignment(SwingConstants.LEFT);
		lblJustJava.setBounds(10, 0, 290, 47);
		frameAddOrder.getContentPane().add(lblJustJava);
				
//		if(txtUsername!=null)txtUsername.setBounds(10, 58, 290, 20);
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
		frameAddOrder.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblToppings = new JLabel("Toppings");
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(10, 85, 80, 25);
		frameAddOrder.getContentPane().add(lblToppings);
		
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
		frameAddOrder.getContentPane().add(cbxWhippedCream);
		
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
		frameAddOrder.getContentPane().add(cbxChocolate);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantity_1.setBounds(10, 183, 80, 25);
		frameAddOrder.getContentPane().add(lblQuantity_1);
		
		lblQuantity = new JLabel("2");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(60, 209, 20, 28);
		frameAddOrder.getContentPane().add(lblQuantity);
		
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
		frameAddOrder.getContentPane().add(decrementButton);
		
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
		frameAddOrder.getContentPane().add(incrementButton);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalPrice.setBounds(10, 254, 128, 14);
		frameAddOrder.getContentPane().add(lblTotalPrice);
		
		lblOrderSummary = new JLabel("Order Summary");
		lblOrderSummary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrderSummary.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderSummary.setBounds(193, 188, 162, 14);
		lblOrderSummary.setVisible(false);
		frameAddOrder.getContentPane().add(lblOrderSummary);
		
		txtOrderSummary = new JTextArea();
		txtOrderSummary.setBackground(new Color(95, 158, 160));
		txtOrderSummary.setBounds(193, 211, 162, 126);
		frameAddOrder.getContentPane().add(txtOrderSummary);
		
		btnSaveOrder = new JButton("Save Order");
		btnSaveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName = txtUsername.getText();
				if(userName.equals("Customer's Name")||userName.equals(""))
					JOptionPane.showMessageDialog(null,"Invalid name");
				else{
				calculatePrice(hasWhippedCream,hasChocolate);
				priceMessage  = createOrderSummary(userName,finalPrice,hasWhippedCream,hasChocolate);
				saveOrder();
				lblOrderSummary.setVisible(true);
				txtOrderSummary.setText(priceMessage);
				JOptionPane.showMessageDialog(null,"Order saved");
				}
				
			}
		});
		btnSaveOrder.setBackground(new Color(230, 230, 250));
		btnSaveOrder.setBounds(10, 306, 108, 30);
		frameAddOrder.getContentPane().add(btnSaveOrder);
			
		lblFinalPrice = new JLabel("$10");
		lblFinalPrice.setBounds(10, 269, 108, 20);
		frameAddOrder.getContentPane().add(lblFinalPrice);
		
//		JButton btnNewButton = new JButton("Check Saved Name");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				strNameCheck();
//			}
//		});
//		btnNewButton.setBounds(10, 361, 162, 23);
//		frameAddOrder.getContentPane().add(btnNewButton);
	}
	
	static void searchOrder()
	{
		frameSearchOrder = new JFrame();
		frameSearchOrder.setResizable(false);
		frameSearchOrder.setBounds(100, 100, 408, 136);
		frameSearchOrder.getContentPane().setBackground(new Color(95, 158, 160));
//		frameSearchOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSearchOrder.setTitle("Search order");
		frameSearchOrder.getContentPane().setLayout(null);
		
		txtCustomerName = new JTextField();
		txtCustomerName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCustomerName.setText(null);
			}
		});
		txtCustomerName.setHorizontalAlignment(SwingConstants.LEFT);
		txtCustomerName.setToolTipText("Enter customer's name here");
		txtCustomerName.setBounds(10, 38, 276, 23);
		frameSearchOrder.getContentPane().add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
//		displayOrder();
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerName = txtCustomerName.getText();
				if(customerName.equals("Enter customer's name")||customerName.equals("")){
					JOptionPane.showMessageDialog(null,"Invalid search criteria");
				}
				else{
					int j=0;
					for(;j<alName.size();j++)
					{
						if(customerName.equals(alName.get(j)))
						{
							makeOrderSummary(j);
							if(!frameDisplayOrder.isVisible())
							{
								frameDisplayOrder.setVisible(true);
								break;
							}
						}
					}
					if(j==alName.size())
					{
						JOptionPane.showMessageDialog(null,"Match not found.");
					}
				}
			}
		});
		btnSearch.setBounds(293, 38, 89, 23);
		frameSearchOrder.getContentPane().add(btnSearch);
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
		StringBuilder orderSummary = new StringBuilder(txtUser  + "\nAdd whipped cream?" + hasWhippedCream + "\nAdd chocolate?" + hasChocolate + "\nQuantity:" + quantity + "\nTotal: $" + price + "\nThank you");
		return orderSummary.toString();
	}
	
	static void displayOrder()
	{
		frameDisplayOrder = new JFrame();
		frameDisplayOrder.setResizable(false);
		frameDisplayOrder.getContentPane().setBackground(new Color(95, 158, 160));
		frameDisplayOrder.setBounds(100, 100, 292, 300);
//		frameDisplayOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDisplayOrder.setTitle("Order Summary");
		frameDisplayOrder.getContentPane().setLayout(null);
		
		JLabel lblFinalOrderSummary = new JLabel("Order Summary");
		lblFinalOrderSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalOrderSummary.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFinalOrderSummary.setBounds(0, 0, 276, 48);
		frameDisplayOrder.getContentPane().add(lblFinalOrderSummary);
		
		textAreaOrderSummary = new JTextArea();
		textAreaOrderSummary.setBackground(new Color(95, 158, 160));
		textAreaOrderSummary.setFont(new Font("Arial Black", Font.BOLD, 16));
		textAreaOrderSummary.setBounds(0, 51, 276, 211);
//		priceMessage1  = createOrderSummary(alName.get(j),alPrice.get(j),alWhippedCreamTopping.get(j),alChocolateTopping.get(j));
//		textAreaOrderSummary.setText(priceMessage1);
		textAreaOrderSummary.setEditable(false);
		frameDisplayOrder.getContentPane().add(textAreaOrderSummary);
	}
	
	static  void saveOrder()
	{
		alName.add(userName);
		alWhippedCreamTopping.add(hasWhippedCream);
		alChocolateTopping.add(hasChocolate);
		alQuantity.add(quantity);
		alPrice.add(finalPrice);
//		loopPractice();
	}
	
	static void makeOrderSummary(int j){
		priceMessage1  = createOrderSummary(alName.get(j),alPrice.get(j),alWhippedCreamTopping.get(j),alChocolateTopping.get(j));
		textAreaOrderSummary.setText(priceMessage1);
	}
	
//	static void strNameCheck(){
//		for(String strName:alName)
//		{
//			System.out.println(strName);
//		}
//	}
//	static void loopPractice()
//	{
//		for(;i<alName.size();i++)
//		{
//			System.out.println(alName.get(i));
//			System.out.println(alWhippedCreamTopping.get(i));
//			System.out.println(alChocolateTopping.get(i));
//			System.out.println(alQuantity.get(i));
//			System.out.println(alPrice.get(i));
//		}
//		System.out.print("\n");
//	}

        static File fName = new File("e:\\dataCOA\\alName.dat");
        static File fWhippedCreamTopping = new File("e:\\dataCOA\\alWhippedCreamTopping.dat");
	static File fChocolateTopping = new File("e:\\dataCOA\\alChocolateTopping.dat");
        static File fQuantity = new File("e:\\dataCOA\\alQuantity.dat");
        static File fPrice = new File("e:\\dataCOA\\alPrice.dat");
	static void saveData()
	{
		try {
			 //String pathToExecutable = CoffeeOrderingApp.class.getProtectionDomain().getCodeSource().getLocation().getPath() ;
		//	 File fName = new File("e:\\dataCOA\\alName.dat");
		//	 File fWhippedCreamTopping = new File("e:\\dataCOA\\alWhippedCreamTopping.dat");
		//	 File fChocolateTopping = new File("e:\\dataCOA\\alChocolateTopping.dat");
		//	 File fQuantity = new File("e:\\dataCOA\\alQuantity.dat");
		//	 File fPrice = new File("e:\\dataCOA\\alPrice.dat");
			 //JOptionPane.showMessageDialog(null, fName.getAbsolutePath());
			 //System.out.println(fName.getAbsolutePath());
			 if(!fName.exists()){
				 fName.createNewFile();
			 }
			 if(!fWhippedCreamTopping.exists()){
				 fWhippedCreamTopping.createNewFile();
			 }
			 if(!fChocolateTopping.exists()){
				 fChocolateTopping.createNewFile();
			 }
			 if(!fQuantity.exists()){
				 fQuantity.createNewFile();
			 }
			 if(!fPrice.exists()){
				 fPrice.createNewFile();
			 }
			 
	         FileOutputStream fileOut = new FileOutputStream(fName);
	         FileOutputStream fileOut1 = new FileOutputStream(fWhippedCreamTopping);
	         FileOutputStream fileOut2 = new FileOutputStream(fChocolateTopping);
	         FileOutputStream fileOut3 = new FileOutputStream(fQuantity);
	         FileOutputStream fileOut4 = new FileOutputStream(fPrice);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
	         ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
	         ObjectOutputStream out3 = new ObjectOutputStream(fileOut3);
	         ObjectOutputStream out4 = new ObjectOutputStream(fileOut4);
	         out.writeObject(alName);
	         out.close();
	         fileOut.close();
	         out1.writeObject(alWhippedCreamTopping);
	         out1.close();
	         fileOut1.close();
	         out2.writeObject(alChocolateTopping);
	         out2.close();
	         fileOut2.close();
	         out3.writeObject(alQuantity);
	         out3.close();
	         fileOut3.close();
	         out4.writeObject(alPrice);
	         out4.close();
	         fileOut4.close();
	         //System.out.printf("Serialized data is saved in /tmp/employee.ser");
	      }catch(Exception i) {
	         i.printStackTrace();
	      }
	}
	
	public static void LoadData(){
		try{
		//	File fName = new File("d:\\dataCOA\\alName.dat");
		//	File fWhippedCreamTopping = new File("d:\\dataCOA\\alWhippedCreamTopping.dat");
		//	File fChocolateTopping = new File("d:\\dataCOA\\alChocolateTopping.dat");
		//	File fQuantity = new File("d:\\dataCOA\\alQuantity.dat");
		//	File fPrice = new File("d:\\dataCOA\\alPrice.dat");
			
			if(fName.exists() && fWhippedCreamTopping.exists() && fChocolateTopping.exists() && fQuantity.exists() && fPrice.exists()){
				FileInputStream fInput = new FileInputStream(fName);
				ObjectInputStream oInput = new ObjectInputStream(fInput);
				alName = (ArrayList<String>) oInput.readObject();
				oInput.close();
				fInput.close();
				
				fInput = new FileInputStream(fWhippedCreamTopping);
				oInput = new ObjectInputStream(fInput);
				alWhippedCreamTopping = (ArrayList<Boolean>) oInput.readObject();
				oInput.close();
				fInput.close();
				
				fInput = new FileInputStream(fChocolateTopping);
				oInput = new ObjectInputStream(fInput);
				alChocolateTopping = (ArrayList<Boolean>) oInput.readObject();
				oInput.close();
				fInput.close();
				
				fInput = new FileInputStream(fQuantity);
				oInput = new ObjectInputStream(fInput);
				alQuantity = (ArrayList<Integer>) oInput.readObject();
				oInput.close();
				fInput.close();
		
				fInput = new FileInputStream(fPrice);
				oInput = new ObjectInputStream(fInput);
				alPrice = (ArrayList<Integer>) oInput.readObject();
				oInput.close();
				fInput.close();
			} 
		}catch(Exception i) {
	         i.printStackTrace();
	      }
	
	}

}