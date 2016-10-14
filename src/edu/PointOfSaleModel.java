package edu;
import java.awt.*;

import javax.swing.*;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
 *Project: Point of Sale
 * This is the model of the project.
 * 
 * @author: Sergio Penavades Suarez
 * @version: 1
 */

public class PointOfSaleModel {
	private static String pathregister="";
	private static int order = 0;
	private static float lastTotalCost = 0;
	private static int lastTotalUnits = 0;
	
/**
 * This will show the user the student number and ID when they click menu in the application.
 */
	public static void linkAbout() {
		JOptionPane.showMessageDialog(PointOfSaleView.frame,
			    "S.Penavades \n ID: A20387929",
			    "About",
			    JOptionPane.PLAIN_MESSAGE);		
	} 
	
	/**
	 * Compares if the SKU is valid.
	 * 
	 */
	public static void validSKU(){
		boolean valid=false;
		for(Sales product:PointOfSale.getProductsDataBase()){
			if (product.getSKU().equals(PointOfSaleView.skufield.getText())){
				if (PointOfSaleView.skufield.getText().length()==6){
				 product.setUnits(product.getUnits()+1);
					if(product.getUnits() == 1) {
						product.setOrder(++order);
						
					}
			}
				valid = true;
			}
		}
		if(!valid){
			JOptionPane.showMessageDialog(PointOfSaleView.frame,
				    "Invalid SKU",
				    "Invalid SKU",
				    JOptionPane.PLAIN_MESSAGE);
		}			
	}

	/**
	 * This is in charge of eliminating the things inside the fields, in order to make a new order.
	 */
	public static void refresh (){
		lastTotalCost = 0;
		lastTotalUnits = 0;
		//SKU is know set to null
		PointOfSaleView.skufield.setText("");
		PointOfSaleView.textTape.setText("");
		//The new distribution is redrawn
		for(int i = 0; i < PointOfSale.getProductsDataBase().size(); i++){
			boolean found = false;
			for(Sales product : PointOfSale.getProductsDataBase()){
				if(product.getOrder() == i+1){
					lastTotalCost += product.operation();
					lastTotalUnits += product.getUnits();
					found = true;
				}	
			}
			if(!found) 
				break;
		}
		//Refresh the cost and units from the last order each time there is a modification.
		NumberFormat formatter = new DecimalFormat("#0.00");
		PointOfSaleView.setTextcost(formatter.format(lastTotalCost));
		PointOfSaleView.setTextitems(Integer.toString(lastTotalUnits));
			
	}
	
	/**
	 * This method will show the total number of units bought and displayed it in the register tape.
	 */
	public static void ClickPayButton(){		
		lastTotalCost *= 100;
		lastTotalCost = (int)lastTotalCost;
		lastTotalCost /= 100f;
		PointOfSaleView.setTextTape("\nTotal Items: " + lastTotalUnits + "\nTotal Cost: $" + lastTotalCost +"\n");
		PointOfSaleView.setTextTape("+-------------------------------------------------------+\n\n");
		printToFile(PointOfSaleView.getTextTape(), pathregister);
	}
	
	/**
	 * This method will save to file the complete order of the customer.
	 * @param text
	 * @param path
	 */
	private static void printToFile(String text, String path){
		try {
			StandardOpenOption option = StandardOpenOption.CREATE;
			File f = new File(path);
			if(f.exists() && !f.isDirectory()) { 
				option = StandardOpenOption.APPEND;
			}
			Files.write(Paths.get(path), text.getBytes(), option);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will cleanup all the variables to start over.
	 */
	public static void ClickVoidButton(){
		PointOfSaleView.textTape.setText("");
		PointOfSaleView.skufield.setText("");
		PointOfSaleView.itemsfield.setText("");
		PointOfSaleView.costfield.setText("");
		order=0;
		for(Sales product:PointOfSale.getProductsDataBase()){
				product.setUnits(0);
				product.setOrder(0);
		}
	}
	
	/**
	 * Getter and setter to obtain the path for the registry tape file.
	 * @return
	 */
	public static String getPathregister() {
		return pathregister;
	}
	public static void setPathregister(String pathregister) {
		PointOfSaleModel.pathregister = pathregister;
	}
	
}
