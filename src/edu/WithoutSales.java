package edu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *Project: Point of Sale
 * This class is in charge of handling products which have no discount.
 * 
 * @author: Sergio Penavades Suarez
 * @version: 1
 */

public class WithoutSales extends Sales {
/**
 * The constructor will call the parent class Sales to obtain all the following attributes:
 * @param SKU
 * @param description
 * @param unitCost
 * @param salesType
 * @param units
 * @param order
 */
	public WithoutSales (String SKU, String description, int unitCost, SalesType salesType, int units,int order){
		super(SKU, description, unitCost, salesType, units, order);
	}
	
	@Override
	public float operation() {
		
		String auxiliar =""; 
		int total = getUnits()*getUnitCost();
		float totalDecimal = (float)total/100f;
		//We use the class Number Format to unify the format that will be given to the
		//prices so that it will only have two decimals.
		NumberFormat formatter = new DecimalFormat("#0.00");
		
		PointOfSaleView.setTextTape(auxiliar + getSKU() + " " 
		+ getDescription() + " " + getUnits() + "@" 
		+ formatter.format((float)getUnitCost()/100) + " = " + formatter.format(totalDecimal) +"\n");
		return totalDecimal;
	}

}
