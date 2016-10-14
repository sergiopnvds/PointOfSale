package edu;
import java.awt.*;

import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *Project: Point of Sale
 * 
 * @author: Sergio Penavades Suarez
 * @version: 1
 */

public class PointOfSaleController {
   	
	private PointOfSaleModel model = null;
    private PointOfSaleView view = null;
    private ActionListener actionListener;
    
    /**
     * Constructor that obtains the model and view classes.
     * @param model
     * @param view
     */
    public PointOfSaleController(PointOfSaleModel model, PointOfSaleView view){
        this.model = model;
        this.view = view;
        
    }
    
    /**
     * In charge of giving functions to each button calling the model class.
     */
    public void control(){   
    	
    view.getMenuAbout().addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e) {                  
                  PointOfSaleModel.linkAbout();
              }
        });                
    view.getMenuAbout().addActionListener(actionListener);  
        
    view.getMenuExit().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {                  
                System.exit(0);
            }
      });                
    view.getMenuExit().addActionListener(actionListener); 
      
    view.getButtonItem().addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {                  
        	  PointOfSaleModel.validSKU();
        	  PointOfSaleModel.refresh();
        	  
          }
    });                
    view.getButtonItem().addActionListener(actionListener);  
    
    view.getButtonVoid().addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {                  
      	  PointOfSaleModel.ClickVoidButton();     	  
       }
    });                
    view.getButtonVoid().addActionListener(actionListener);  

    view.getButtonPay().addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {                  
        	PointOfSaleModel.ClickPayButton()  ;	  
       }
    });                
    view.getButtonPay().addActionListener(actionListener);  
    
    }
	
       	
}
