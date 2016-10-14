package edu;

/**
 *Project: Point of Sale
 * This class is in charge of handling the prodcuts which have the offer of buy one for the cost of y
 * @author: Jessica Ginesta Legasto
 * @version: 12/08/2015/A
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BuyXForTheCostOfY extends Sales{
	
	private int forTheCostX;
	private int forTheCostY;

	/**
	 * The constructor is in charge of obtaining all the attributes of the parent class.
	 * @param SKU
	 * @param description
	 * @param unitCost
	 * @param salesType
	 * @param forTheCostX
	 * @param forTheCostY
	 * @param units
	 * @param order
	 */
	public BuyXForTheCostOfY (String SKU, String description, int unitCost, SalesType salesType, int forTheCostX, int forTheCostY, int units, int order){
		super(SKU, description, unitCost, salesType, units, order);
		this.forTheCostX = forTheCostX;
		this.forTheCostY = forTheCostY;
	}
	
	@Override
	//Calls the abstract method from the parent table to calculate the final price of the products with the offer.
	public float operation(){
		float totalCost = 0;
		NumberFormat formatter = new DecimalFormat("#0.00");
		int totalUnitsFree = getUnits()/forTheCostX;
		int totalPrinted = 0;
		for(int i = 0; i < totalUnitsFree; i++){
			int totalCostTemp = forTheCostY*getUnitCost();
			PointOfSaleView.setTextTape(getSKU() + " " + getDescription() +" " + forTheCostX + " for " + forTheCostY + "@" + formatter.format(getUnitCost()/100f) + " = " +formatter.format(totalCostTemp/100f)+ "\n");
			totalCost += totalCostTemp/100f;
			totalPrinted += forTheCostX;
		}
		int unitsLeft = getUnits()-totalPrinted;
		if(unitsLeft > 0){
			float totalCostTemp = unitsLeft*getUnitCost();
			PointOfSaleView.setTextTape(getSKU() + " " + getDescription() + " " + unitsLeft + "@" + formatter.format(getUnitCost()/100f) + " = " +formatter.format(totalCostTemp/100f)+ "\n");
			totalCost += totalCostTemp/100f;
		}
		return totalCost;
	}

}
