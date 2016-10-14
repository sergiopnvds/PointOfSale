package edu;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *Project: Point of Sale
 * This is the main class of the project which will be in charge of executing the view
 * @author: Sergio Penavades Suarez
 * @version: 1
 */

public class PointOfSale {
	
	private static ArrayList<Sales> ProductsDataBase;
	private boolean flagProductAdded=false;

	/**
	 * The constructor PointOfSale is in charge of reading the costs and sales file and initialize.
	 * @param pathcosts Will read the costs txt file
	 * @param pathsales Will read the sales txt file
	 * @throws IOException
	 */
	public PointOfSale(String pathcosts,String pathsales) throws IOException{
	    Sales.readCosts(pathcosts);
		Sales.readSales(pathsales);		
		initialize();	
	}
	
	/**
	 * This will separate the sales into the 3 different categories which are the discount, buyxget1free and buyxforthecostofy
	 */
	void initialize(){	
		 ProductsDataBase = new ArrayList<Sales>();
		for(String cost: Sales.getCosts()){
			flagProductAdded=false;
			//The cost fields will only have 3 arguments
			String [] costFields = cost.split("\\|",3);
			for(String sale: Sales.getSales()){
				//The sale fields can have either 3 or 4 arguments
				String [] salesFields = sale.split("\\|");
				
				//If the SKU from the cost fields is the same as the one in the sales list we will give it either the category of buyxget1free,
				//buyxforthecostofy,discount or not give it any discount at all.
				if (costFields[0].equals(salesFields[0])){
					switch (salesFields[1]){
					case "DISCOUNT":
						flagProductAdded=true;
						ProductsDataBase.add(new DiscountSales(costFields[0],costFields[1],Integer.parseInt(costFields[2]), SalesType.DISCOUNT, Integer.parseInt(salesFields[2]), 0, 0)); 
						break;
					case "BUYXGET1FREE":
						flagProductAdded=true;
						ProductsDataBase.add(new BuyXGet1Free(costFields[0],costFields[1],Integer.parseInt(costFields[2]), SalesType.BUY_X_GET_ONE_FREE, Integer.parseInt(salesFields[2]), 0, 0)); 
						break;	
					case "BUYXFORY":
						flagProductAdded=true;
						ProductsDataBase.add(new BuyXForTheCostOfY(costFields[0],costFields[1],Integer.parseInt(costFields[2]), SalesType.BUY_X_FOR_THE_COST_OF_Y, Integer.parseInt(salesFields[2]), Integer.parseInt(salesFields[3]), 0, 0)); 
						break;	
					}
				}
			}
			if (!flagProductAdded) {
				ProductsDataBase.add(new WithoutSales(costFields[0],costFields[1],Integer.parseInt(costFields[2]), SalesType.NO_SALES, 0, 0));
			}
		}
	}
	/**
	 * This method will give the whole database fo both products and sales.
	 * @return
	 */
	public static ArrayList<Sales> getProductsDataBase() {
		return ProductsDataBase;
	}	
	
	
	/**
	 * The main method will launch the application.
	 */
	public static void main(String[] args) {
	
		if(args == null || args.length == 0 ||args.length == 1||args.length == 2){
			System.out.println("One of the three files is missing which can be either the cost, sales or registertape file");
			return;
		}
		final String pathcosts=args[0];
		final String pathsales=args[1];
		final String pathregistertape=args[2];
		PointOfSaleModel.setPathregister(pathregistertape);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					PointOfSale window = new PointOfSale(pathcosts,pathsales);
					PointOfSaleModel model = new PointOfSaleModel();
	                PointOfSaleView view = new PointOfSaleView(); 
	                PointOfSaleController controller = new PointOfSaleController(model,view);
	                controller.control();
					view.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
