package edu;
import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *Project: Point of Sale
 * This class is the layout of the application
 * @author: Sergio Penavades Suarez
 * @version: 1
 */

public class PointOfSaleView extends JFrame{

	public static JFrame frame;
	static JTextField itemsfield = null;
	static JTextField costfield = null;
	static JTextField skufield = null;	
	private JButton voidbutton = null;
	private JButton additem = null;
	private static JButton pay = null;
	JMenuItem mntmAbout, mntmExit;
	private JMenu mnRegister, mnHelp;
	static JScrollPane scroll;
	public static JTextArea textTape;
		
	public PointOfSaleView(){
		initialize();
	}
			
	/**
	 * The method initialize is in charge of the contents of the frame in order.
	 */
	public void initialize() {
		// This will be used to create the layout of the main frame.
		
		frame = new JFrame("Point Of Sale Register");
		frame.setBounds(100, 100, 1024, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel itemstext = new JLabel("Total Items:");
		itemstext.setBounds(330, 250, 100, 20);
		frame.getContentPane().add(itemstext);
		
		JLabel costext = new JLabel("Total Cost:");
		costext.setBounds(470, 250, 70, 20);
		frame.getContentPane().add(costext);
		
		JLabel skutext = new JLabel("SKU:");
		skutext.setBounds(370, 285, 50, 20);
		frame.getContentPane().add(skutext);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1100, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textTape= new JTextArea();
		textTape.setEditable(false);
		 
		JScrollPane scroll = new JScrollPane (textTape);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(15, 30, 980, 200);
		panel.add(scroll);	
		
		itemsfield = new JTextField();
		itemsfield.setBounds(400, 250, 60, 20);
		itemsfield.setEditable(false);
		frame.getContentPane().add(itemsfield);
		itemsfield.setColumns(10);
		itemsfield.setEditable(false);
		
		costfield = new JTextField();
		costfield.setColumns(10);
		costfield.setEditable(false);
		costfield.setBounds(540, 250, 60, 20);
		costfield.setEditable(false);
		frame.getContentPane().add(costfield);
		
		skufield = new JTextField();
		//skufield.setText("Vacant");
		skufield.setColumns(10);
		skufield.setBounds(400, 285, 100, 20);
		frame.getContentPane().add(skufield);
		
		additem = new JButton("Add Item");
		additem.setBounds(510, 285, 90, 20);
		frame.getContentPane().add(additem);
		
		pay = new JButton("Pay");
		pay.setBounds(400, 320, 70, 30);
		frame.getContentPane().add(pay);
		
		voidbutton = new JButton("Void");
		voidbutton.setBounds(480, 320, 70, 30);
		frame.getContentPane().add(voidbutton);		
		
		/**
		 * The menu inside the main frame will contain the action of registration and help.
		 */
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1009, 19);
		panel.add(menuBar);
		
		mnRegister = new JMenu("Register");
		mnRegister.setForeground(new Color(0, 0, 0));
		mnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnRegister);
		
		mntmExit = new JMenuItem("Exit");
		mnRegister.add(mntmExit);
		
		/**
		 * By clicking Help we will display my name and student number.
		 */	
		mnHelp = new JMenu("Help");
		mnHelp.setForeground(new Color(0, 0, 0));
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
	}
		
	// Getters and setters to get all the buttons from the controller class.
	 public JMenu getMenuRegister(){
	        return mnRegister;
	   }
	 
	 public JMenu getMenuHelp(){
	        return mnHelp;
	   }
	 
	 public JMenuItem getMenuAbout(){
	        return mntmAbout;
	   }
	 
	 public JMenuItem getMenuExit(){
	        return mntmExit;
	   }
	 
	 public JButton getButtonItem(){
	        return additem;
	   }
	 
	 public JButton getButtonVoid(){
	        return voidbutton;
	   }
	 
	 public JButton getButtonPay(){
	        return pay;
	   }
	 
	 public static void setTextitems(String text){
		 itemsfield.setText(text);
	    }
	 
	 public static void setTextcost(String text){
		 costfield.setText(text);
	    }
	 
	 public void setTextsku(String text){
		 
		 skufield.setText(text);
	    }
	 public static void setTextTape(String text){		
		 textTape.append(text);
	    }
	 	 
	 public static String getTextTape(){
		
		 return textTape.getText();
	    }
	 
}
