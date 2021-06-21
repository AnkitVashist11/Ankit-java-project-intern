package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.RouteModifyForm;

public class RouteModifyListener implements ActionListener
{
	RouteModifyForm obj;
	
	public RouteModifyListener(RouteModifyForm in)
	{
		 obj=in;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		RouteBean routeBean2=new RouteBean();
	  if(e.getSource()==obj.btnEnter)
	  {
		  if(obj.txtRouteId.getText().isEmpty())
	    	 {
	    		 String message="Field Can't Be Empty";
				 JOptionPane.showMessageDialog(obj.frame, message);
	    	 }
	    	 else 
	    	 {
	    		 Administrator adminService=new Administrator();
	    		 
	    		 routeBean2=adminService.viewRoute(obj.txtRouteId.getText());
	    		 if(routeBean2 != null)
	    		 {  
	    			   obj.txtSource.setText(routeBean2.getSource().toUpperCase());
	    			   obj.txtDestination.setText(routeBean2.getDestination().toUpperCase());
	    			   obj.txtDistance.setText(String.valueOf(routeBean2.getDistance()));
	    			   obj.txtTravelDuration.setText(String.valueOf(routeBean2.getTravelDuration()));
	    			   
	    			   obj.lblSource.setVisible(true);
	    			   obj.lblDestination.setVisible(true);
	    			   obj.lblDistance.setVisible(true);
	    			   obj.lblTravelDuration.setVisible(true);
	    			   obj.txtSource.setVisible(true);
	    			   obj.txtDestination.setVisible(true);
	    			   obj.txtDistance.setVisible(true);
	    			   obj.txtTravelDuration.setVisible(true);
	    			   obj.btnModify.setVisible(true);
	    			   obj.btnEnter.setVisible(false);
	    			   obj.txtRouteId.setEditable(false);
	    			  
	    		 }
	    		 else
	    		 {
	    			 String message="INVALID ENTRY";
					 JOptionPane.showMessageDialog(obj.frame, message);
	    		 }
	    	 }
	  }
	  
      if(e.getSource()==obj.btnModify)
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
				
				if(obj.txtSource.getText()==null || obj.txtDestination.getText() ==null ||obj.txtDestination.getText()==null|| obj.txtTravelDuration.getText()==null)
				 {
					JOptionPane.showMessageDialog(obj.frame,"Fill All Details");
				 }
				else if(obj.txtSource.getText().trim().length() <2 || obj.txtDestination.getText().trim().length()<2) 
				 {
					 JOptionPane.showMessageDialog(obj.frame,"ATLEAST 2 CHARACTER VALUES MUST BE ENTER FOR SOURCE & DESTINATION");
				 }
				else if(obj.txtSource.getText().trim().equalsIgnoreCase(obj.txtDestination.getText().trim()))
				 {
					JOptionPane.showMessageDialog(obj.frame,"SOURCE AND DESTINATION CAN'T BE SAME");

				 }
				else if (!(obj.txtSource.getText().trim().matches("[a-zA-Z ]+")) && !(obj.txtDestination.getText().trim().matches("[a-zA-Z ]+")))
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
					
					   Administrator adminService=new Administrator();
	                   
						int distance = Integer.parseInt(obj.txtDistance.getText().trim());
						
						RouteBean routeBean=new RouteBean();
						routeBean.setRouteID(obj.txtRouteId.getText());
						routeBean.setSource(obj.txtSource.getText().toUpperCase().trim());
						routeBean.setDestination(obj.txtDestination.getText().toUpperCase().trim());
						routeBean.setDistance(distance);
						routeBean.setTravelDuration(Double.parseDouble(obj.txtTravelDuration.getText().trim()));
						
						
					    boolean value = adminService.modifyRoute(routeBean);
							
							//obj.txtRouteId.setText(routeBean.getRouteID());
						if(value==true)
						  {
							 JOptionPane.showMessageDialog(obj.frame,"DETAILS MODIFIED");
							 
							    obj.txtRouteId.setText("");
								obj.txtSource.setText("");
								obj.txtDestination.setText("");
								obj.txtDistance.setText("");
								obj.txtTravelDuration.setText("");
						  }
						else
						  {
							 JOptionPane.showMessageDialog(obj.frame, "UNABLE TO MODIFY: RETRY");
						  }   
							
				    }		
									
			      }
				catch(NumberFormatException e1)
				  {
					result = "Enter Numeric Values Of Distance in KiloMeter and Duration in hours ";
					//obj.optionPane.showMessageDialog(obj.frame, result);
					JOptionPane.showMessageDialog(obj.frame, result);
				  }
			  }
							
	  }
		 	
		
		  
     
      if(e.getSource()==obj.btnCancel)
      {
    	    obj.txtRouteId.setText("");
			obj.txtSource.setText("");
			obj.txtDestination.setText("");
			obj.txtDistance.setText("");
			obj.txtTravelDuration.setText("");
      }
      if(e.getSource()==obj.btnBack)
      {
    	  new AdminUI().setVisible(true);
    	  obj.frame.setVisible(false); 
      }

		
	}
}
