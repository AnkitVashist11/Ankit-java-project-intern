package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.BookingDetailsViewForm;
import com.wipro.ata.ui.DriverAddForm;
import com.wipro.ata.ui.DriverDeleteForm;
import com.wipro.ata.ui.DriverModifyForm;
import com.wipro.ata.ui.DriverViewAllForm;
import com.wipro.ata.ui.LoginUI;
import com.wipro.ata.ui.RouteAddForm;
import com.wipro.ata.ui.RouteDeleteForm;
import com.wipro.ata.ui.RouteModifyForm;
import com.wipro.ata.ui.RouteViewAllForm;
import com.wipro.ata.ui.RouteViewForm;
import com.wipro.ata.ui.VehicleDeleteUi;
import com.wipro.ata.ui.VehicleUi;
import com.wipro.ata.ui.VehicleUpdateUi;
import com.wipro.ata.ui.VehicleViewAll;
import com.wipro.ata.ui.VehicleViewUi;
import com.wipro.ata.util.User;

public class AdminListener implements ActionListener,ItemListener,MenuListener
{
	AdminUI adui;
	public AdminListener(AdminUI adui) 
	{
		this.adui=adui;
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource()==adui.logoutButton)
		{
			User user=new User();
			try
			{
				boolean b=user.logout(LoginListener.userId);
				if(b)
				{
					adui.dispose();
					new LoginUI().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(adui.frame,"Problem in Logout...");
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
		if(arg0.getSource()==adui.addDriver)
		{
			new DriverAddForm();
			adui.dispose();
		}
		if(arg0.getSource()==adui.deleteDriver)
		{
			new DriverDeleteForm();
			adui.dispose();
		}
		if(arg0.getSource()==adui.modifyDriver)
		{
			new DriverModifyForm();
			adui.dispose();
		}
		if(arg0.getSource()==adui.addVehicle)
		{
			new VehicleUi();
			adui.dispose();
		}
		if(arg0.getSource()==adui.deleteVehicle)
		{
			new VehicleDeleteUi();
			adui.dispose();
		}
		if(arg0.getSource()==adui.viewAllVehicle)
		{
			new VehicleViewAll();
			adui.dispose();
		}
		if(arg0.getSource()==adui.viewVehicleById)
		{
			new VehicleViewUi();
			adui.dispose();
		}
		if(arg0.getSource()==adui.modifyVehicle)
		{
			new VehicleUpdateUi();
			adui.dispose();
		}
		if(arg0.getSource()==adui.addRoute)
		{
			new RouteAddForm();
			adui.dispose();
		}
		if(arg0.getSource()==adui.deleteRoute)
		{
			new RouteDeleteForm();
			adui.dispose();
		}
		if(arg0.getSource()==adui.viewAllRoutes)
		{
			new RouteViewAllForm();
			adui.dispose();
		}
		if(arg0.getSource()==adui.viewRouteById)
		{
			new RouteViewForm();
			adui.dispose();
		}
		if(arg0.getSource()==adui.modifyRoute)
		{
			new RouteModifyForm();
			adui.dispose();
		}
	}
	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuSelected(MenuEvent arg0) 
	{
		if(arg0.getSource()==adui.allotDriver)
		{
			new DriverViewAllForm();
			adui.dispose();
		}
		if(arg0.getSource()==adui.viewDetails)
		{
			new BookingDetailsViewForm();
			adui.dispose();
		}
	}

}
