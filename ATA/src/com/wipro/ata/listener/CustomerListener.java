package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.ata.ui.BookVehicleUI;
import com.wipro.ata.ui.CancelBookingUi;
import com.wipro.ata.ui.CustomerUI;
import com.wipro.ata.ui.CustomerViewRouteForm;
import com.wipro.ata.ui.CustomerViewVehicleBySeatsForm;
import com.wipro.ata.ui.CustomerViewVehicleBytypeForm;
import com.wipro.ata.ui.LoginUI;
import com.wipro.ata.ui.ReservationViewBookingDetailsForm;
import com.wipro.ata.util.User;

public class CustomerListener implements ActionListener
{
	CustomerUI cui;
	public CustomerListener(CustomerUI cui)
	{
		this.cui=cui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource()==cui.customerlogout)
		{
			User user=new User();
			try
			{
				boolean b=user.logout(LoginListener.userId);
				if(b)
				{
					cui.dispose();
					new LoginUI().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(cui.frame,"Problem in Logout...");
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		if(arg0.getSource()==cui.viewBookingButton)
		{
			new ReservationViewBookingDetailsForm();
			cui.dispose();
		}
		if(arg0.getSource()==cui.viewVehicleOrRouteDetailsButton)
		{
			new CustomerViewVehicleBytypeForm();
			cui.dispose();
		}
		if(arg0.getSource()==cui.viewVehicleBySeats)
		{
			new CustomerViewVehicleBySeatsForm();
			cui.dispose();
		}
		if(arg0.getSource()==cui.viewRoute)
		{
			new CustomerViewRouteForm();
			//cui.dispose();
		}
		if(arg0.getSource()==cui.bookVehicleOnlineButton)
		{
			new BookVehicleUI().setVisible(true);
			cui.dispose();
		}
		if(arg0.getSource()==cui.cancelBooking)
		{
			new CancelBookingUi();
			cui.dispose();
		}
		
	}

}
