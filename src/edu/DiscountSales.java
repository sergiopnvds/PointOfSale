package edu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *Project: Point of Sale
 * This class will be in charge of taking care of the produts that have a discount.
 * @author: Sergio Penavades Suarez
 * @version: 1
 */

public class DiscountSales extends Sales {
	
	private int percent;
	/**
	 * The constructor will be in charge of obtaining fields of the prodecuts from the parent field.
	 * @param SKU
	 * @param description
	 * @param unitCost
	 * @param salesType
	 * @param percent
	 * @param units
	 * @param order
	 */
	public DiscountSales (String SKU, String description, int unitCost, SalesType salesType, int percent, int units, int order){
		super(SKU, description, unitCost, salesType, units, order);
		this.percent = percent;
	}

	/**
	 * This method will be in charge of sending to the register tape the total price of the product. 
	 */
	@Override
	public float operation() {
		String auxiliar =""; 
		NumberFormat formatter = new DecimalFormat("#0.00");
		float discountUnitCost = (int)(getUnitCost() * (float)(100-getPercent())/100);
		discountUnitCost = ((float)((int)(discountUnitCost * 100)))/100f;
		float total = getUnits()*discountUnitCost;
		float totalDecimal = (float)total/100f;
		
		
		PointOfSaleView.setTextTape(auxiliar + getSKU() + " "
		+ getDescription() + " " + getPercent() + "% Off " + getUnits() 
		+ "@" + formatter.format((float)discountUnitCost/100) + " = " + formatter.format(totalDecimal) +"\n");
		return totalDecimal;
	}

	/**
	 * Getter and setter of the percentage applied to the product.
	 * @return
	 */
	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
}
