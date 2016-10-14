package edu;

/**
 *Project: Point of Sale
 * This class is in charge of obtaining the products from the sales text file which have the 
 * offer of buying one and getting one free.
 * @author: Jessica Ginesta Legasto
 * @version: 12/08/2015/A
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class BuyXGet1Free extends Sales {

	private int getOneFreeX;
	
	/**
	 * Constructor which is in charge of obtaining all the parameters from its parent class sales
	 * @param SKU
	 * @param description
	 * @param unitCost
	 * @param salesType
	 * @param getOneFreeX
	 * @param units
	 * @param order
	 */
	public BuyXGet1Free (String SKU, String description, int unitCost, SalesType salesType, int getOneFreeX, int units, int order){
		super(SKU, description, unitCost, salesType, units, order);
		this.getOneFreeX = getOneFreeX;
	}
	
	/**
	 * The operation method returns a float that returns the total cost of that product to write it in the register tape.
	 */
	@Override
	public float operation() {
		float totalCost = 0;
		NumberFormat formatter = new DecimalFormat("#0.00");
		int totalUnitsFree = getUnits()/(getGetOneFreeX()+1);
		int totalPrinted = 0;
		for(int i = 0; i < totalUnitsFree; i++){
			float totalCostTemp = getGetOneFreeX()*getUnitCost();
			PointOfSaleView.setTextTape(getSKU() + " " + getDescription() + " " + getGetOneFreeX() + "@" + formatter.format(getUnitCost()/100f) + " = " +formatter.format(totalCostTemp/100f)+ "\n");
			PointOfSaleView.setTextTape(getSKU() + " " + getDescription() + " " + "1@0,00 = 0,00\n");
			totalPrinted += getGetOneFreeX() + 1;
			totalCost += totalCostTemp/100f;
		}
		int unitsLeft = getUnits()-totalPrinted;
		if(unitsLeft > 0){
			float totalCostTemp = unitsLeft*getUnitCost();
			PointOfSaleView.setTextTape(getSKU() + " " + getDescription() + " " + unitsLeft + "@" + formatter.format(getUnitCost()/100f) + " = " +formatter.format(totalCostTemp/100f)+ "\n");
			totalCost += totalCostTemp/100f;
		}
		return totalCost;
	}
/**
 * Getter and setter to obtain or modify the value of get one free.
 * @return
 */
	public int getGetOneFreeX() {
		return getOneFreeX;
	}

	public void setGetOneFreeX(int getOneFreeX) {
		this.getOneFreeX = getOneFreeX;
	}

}
