package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.RouteDeleteForm;

public class RouteDeleteListener implements ActionListener
{ 
   RouteDeleteForm obj;
   
   public RouteDeleteListener(RouteDeleteForm in)
   {
	 obj=in; 
   }

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==obj.btnDelete)
		{
			if(obj.txtRouteId.getText().isEmpty())
			{   String message="Field Can't Be Empty";
				JOptionPane.showMessageDialog(obj.frame, message);
			}
			else
			{   
			     
			    Administrator adminService=new Administrator();
				int Rid=adminService.deleteRoute(obj.txtRouteId.getText());
				if(Rid>0)
				 { 
				    int btnPress=JOptionPane.showConfirmDialog(obj.frame, "Do U Really Want To Delete");
				    if(btnPress==JOptionPane.YES_OPTION)
				     {
				    	JOptionPane.showMessageDialog(obj.frame, "DELETION DONE");
						obj.txtRouteId.setText("");	
				     }
					
					else if(btnPress==JOptionPane.NO_OPTION)
				     {
					    obj.txtRouteId.setText("");
					 }
				    else if(btnPress==JOptionPane.CANCEL_OPTION)
					 {
					    	 obj.txtRouteId.setText("");
					 }			
				  }
				else if(Rid==-1)
				{
					JOptionPane.showMessageDialog(obj.frame, "This RouteID is booked");
				}
				else
					
				{
					JOptionPane.showMessageDialog(obj.frame, "INVALID ID");
				} 			
			     
			}
		}
		else if(arg0.getSource()==obj.btnCancel)
		{
			obj.txtRouteId.setText("");
		}
		else if(arg0.getSource()==obj.btnBack)
		{
			new AdminUI().setVisible(true);
			obj.frame.setVisible(false);
		}
		
	}
	
}	
