package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.RouteViewForm;

public class RouteViewListener implements ActionListener
{
   RouteViewForm obj;
   
   public RouteViewListener(RouteViewForm in)
   {
	   obj=in;
   }
	
   @Override
	public void actionPerformed(ActionEvent arg0) 
    {
      if(arg0.getSource()==obj.btnView)
       {
	    	 if(obj.txtRouteId.getText().isEmpty())
	    	 {
	    		 String message="Field Can't Be Empty";
				 JOptionPane.showMessageDialog(obj.frame, message);
	    	 }
	    	 else 
	    	 {
	    		 Administrator adminService=new Administrator();
	    		 RouteBean routeBean2=new RouteBean();
	    		 routeBean2=adminService.viewRoute(obj.txtRouteId.getText());
	    		 if(routeBean2 != null)
	    		 {  
	    			   obj.txtSource.setText(routeBean2.getSource().toUpperCase());
	    			   obj.txtDestination.setText(routeBean2.getDestination().toUpperCase());
	    			   obj.txtDistance.setText(String.valueOf(routeBean2.getDistance()));
	    			   obj.txtTravelDuration.setText(String.valueOf(routeBean2.getTravelDuration()));
	    			   
	    			   
	    			  
	    		 }
	    		 else
	    		 {
	    			 String message="INVALID ENTRY";
					 JOptionPane.showMessageDialog(obj.frame, message);
	    		 }
	    	 }
       }
     
     else if(arg0.getSource()==obj.btnCancel)
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
