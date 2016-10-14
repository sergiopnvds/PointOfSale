package edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *Project: Point of Sale
 * 
 * @author: Jessica Ginesta Legasto
 * @version: 12/08/2015/A
 */

/**
 *
 *This class is an abstract class which is the parent to the classes buyxget1free,buyxforthecostofy,
 *discountsales and without sales.
 */

public abstract class Sales {
	//All the objects from this class will have this attributes. 
	protected String SKU;
	protected String description;
	protected int unitCost;
	protected SalesType salesType;
	protected int units;
	protected int order;
	
	
	
/**
 * Obtains all the fields from the product or sale.
 * @param SKU
 * @param description
 * @param unitCost
 * @param salesType
 * @param units
 * @param order
 */
	public Sales(String SKU, String description, int unitCost, SalesType salesType, int units, int order) {
		this.SKU = SKU;
		this.description = description;
		this.unitCost = unitCost;
		this.salesType = salesType;
		this.units = units;
		this.order = order;
	}

	/**
	 * This is an abstract class will be implemented differently depending on the child class 
	 * where it is called.
	 * @return It will return a float that will be the total cost of each product depending on the type of sale.
	 */
	public abstract float operation();
	
	// Defining the variables:
	// costslist which is in charge of gathering the total object from the costs txt file.
	// saleslist which is in charge of gathering the total object from the sales txt file.
	// buffer is the reading buffer to read the txt files.
	private static ArrayList<String> CostsList = new ArrayList<>() ;
	private static ArrayList<String> SalesList = new ArrayList<>() ;
	private static BufferedReader buffer;
	
	/**
	 * The method read costs will read all the products and its characteristics from the costs txt file.
	 * @param path 
	 * @throws IOException
	 */
	public static void readCosts(String path) throws IOException{
		buffer = new BufferedReader(new FileReader(path));
		String strLine;
			while ((strLine =buffer.readLine()) != null ){ 
				CostsList.add (strLine); 
			}
	}
	
	/**
	 * The method read sales will read all the sales and its characteristics from the sales txt file.
	 * @param path 
	 * @throws IOException
	 */
	public static void readSales(String path) throws IOException{
		buffer = new BufferedReader(new FileReader(path));
		String strLine;
			while ((strLine =buffer.readLine()) != null ){ 
				SalesList.add (strLine); 
			}
	}
	/**
	 * In charge of reading the array sales and costs.
	 * @return
	 */
	public static ArrayList<String> getCosts() {
		return CostsList;
	}	
	
	public static ArrayList<String> getSales() {
		return SalesList;
	}	
	
	/**
	 * Getters and setters of the attributes of the constructor method
	 * @return
	 */
	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public SalesType getSalesType() {
		return salesType;
	}

	public void setSalesType(SalesType salesType) {
		this.salesType = salesType;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
