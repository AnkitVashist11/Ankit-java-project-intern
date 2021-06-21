package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JOptionPane;

import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.RouteAddForm;

public class RouteAddListener implements ActionListener
{   
	RouteAddForm obj;

	public RouteAddListener(RouteAddForm in)
	{
		obj=in;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{ 
		Administrator adminService=new Administrator();
		if(arg0.getSource()==obj.btnAdd)
		{
			String result="";
			if(obj.txtSource.getText().isEmpty() || obj.txtDestination.getText().isEmpty()||obj.txtDistance.getText().isEmpty()||obj.txtTravelDuration.getText().isEmpty())
			{	
				result="Mandatory to fill all Fields";
				JOptionPane.showMessageDialog(obj.frame, result);
			}
			else
			{
				try
				{  
				
	
			    if (!(obj.txtSource.getText().trim().matches("[a-zA-Z ]+")) && !(obj.txtSource.getText().trim().matches("[a-zA-Z ]+")))
	            {
	              JOptionPane.showMessageDialog(null, "Please enter a valid character For SOURCE and DESTINATION", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	            else if(!(obj.txtSource.getText().trim().matches("[a-zA-Z ]+")))
	            {
	         	   JOptionPane.showMessageDialog(null, "Please Enter Valid Character For Source");
	            }
	            else if(!(obj.txtDestination.getText().trim().matches("[a-zA-Z ]+")))
	            {
	         	   JOptionPane.showMessageDialog(null, "Please Enter Valid Character For Destination");
	            }
	            else if(Integer.parseInt(obj.txtDistance.getText().trim()) < 1 || Double.parseDouble(obj.txtTravelDuration.getText().trim()) <=0 )
	            {
	            	JOptionPane.showMessageDialog(null, "Please Enter Valid Positive Numeric Value Greater Than ZERO");
	            }
	            else if(!(obj.txtDistance.getText().trim().matches("[0-9]+")))
	            {
	         	   JOptionPane.showMessageDialog(null, "Please Enter Valid Numeric Value For Distance");
	            }
	            else if(!(obj.txtTravelDuration.getText().trim().matches("[0-9.]+")))
	            {
	         	   JOptionPane.showMessageDialog(null, "Please Enter Valid Numeric Value For Travel Duration");
	            }
	           
	            else if(obj.txtDistance.getText().trim().length()>4) 
	            {
	            	JOptionPane.showMessageDialog(null, "Maximum 4 Digits Are Allowed For Field Distance");
	            }
	            else if(obj.txtTravelDuration.getText().trim().length()>5)
	            {
	            	JOptionPane.showMessageDialog(null, "Maximum 5 Digits Are Allowed For Field Travel Duration");
	            }
	            else if(obj.txtSource.getText().trim().length()>20)             
	            {
		          JOptionPane.showMessageDialog(null, "FAILED: YOU EXCEED THE ENTRY LIMIT OF 20 CHARACTER Of SOURCE");

	            } 
	            else if(obj.txtDestination.getText().trim().length()>20)             
	            {
		          JOptionPane.showMessageDialog(null, "FAILED: YOU EXCEED THE ENTRY LIMIT OF 20 CHARACTER Of DESTINATION");

	            }
					
				else
				  {	
					
					
	                   
						int distance = Integer.parseInt(obj.txtDistance.getText().trim());
						
						RouteBean routeBean=new RouteBean();
						routeBean.setSource(obj.txtSource.getText().trim().toUpperCase());
						routeBean.setDestination(obj.txtDestination.getText().trim().toUpperCase());
						routeBean.setDistance(distance);
						routeBean.setTravelDuration(Double.parseDouble(obj.txtTravelDuration.getText().trim()));
						result = adminService.addRoute(routeBean);
						
						obj.txtRouteId.setText(routeBean.getRouteID());
						JOptionPane.showMessageDialog(obj.frame, result);
						obj.txtRouteId.setText("");
						obj.txtSource.setText("");
						obj.txtDestination.setText("");
						obj.txtDistance.setText("");
						obj.txtTravelDuration.setText("");
					
					
				   }	
				 }
				catch(NumberFormatException e)
				  {
					//e.printStackTrace();
					result = "Enter Numeric Values Of Distance in KiloMeter and Duration in hours ";
					//obj.optionPane.showMessageDialog(obj.frame, result);
					JOptionPane.showMessageDialog(obj.frame, result);
					
					obj.txtRouteId.setText("");
					obj.txtSource.setText("");
					obj.txtDestination.setText("");
					obj.txtDistance.setText("");
					obj.txtTravelDuration.setText("");
				  }
			}
		 	
		
		 }
		
		 if(arg0.getSource()==obj.btnCancel)
		 {  
			obj.txtRouteId.setText("");
			obj.txtSource.setText("");
			obj.txtDestination.setText("");
			obj.txtDistance.setText("");
			obj.txtTravelDuration.setText("");
		 }
		 else if(arg0.getSource()==obj.btnBack)
		 {
			 new AdminUI().setVisible(true);
			obj.frame.setVisible(false);
		 }
		
  }
}
