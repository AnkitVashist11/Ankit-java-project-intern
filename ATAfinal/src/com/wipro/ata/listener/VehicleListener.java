package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.VehicleDeleteUi;
import com.wipro.ata.ui.VehicleUi;

public class VehicleListener implements ActionListener , ItemListener , WindowListener
{
	VehicleUi uiObj;
	public VehicleListener(VehicleUi uiObj) 
	{
		this.uiObj= uiObj;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==VehicleUi.btnAdd)
		{
			Administrator adminObj = new Administrator();
			String add;
			
			if(uiObj.txtName.getText().equals("") || uiObj.txtRegistrationNo.getText().equals("") || /*uiObj.txtSeatingCapacity.getText().equals("") ||*/ uiObj.txtFarePerKm.getText().equals(""))   
			{
				add="Don't leave blank fields";
			}
						
			else if(!(uiObj.txtName.getText().trim().matches("[a-zA-Z0-9 ]+")))
			{
				add = "Name can contain only characters and numbers. ";
			}	
			
			else if(!(uiObj.txtRegistrationNo.getText().trim().matches("[a-zA-Z0-9]+")))
			{
				add = "Registration Number can contain only characters and numbers. ";
			}
		
			else if(uiObj.txtFarePerKm.getText().trim().length()>6 || uiObj.txtFarePerKm.getText().trim().length()<=0)
			{
				add = "Fare per km should be between 1 to 999. ";
			}

			else
			{
				double fare = 0;
			 
				try
				{
					fare = Double.parseDouble(uiObj.txtFarePerKm.getText().trim());
					
					VehicleBean vehicleBean = new VehicleBean();
					vehicleBean.setName(uiObj.txtName.getText().trim());
					vehicleBean.setType(uiObj.cType.getSelectedItem());
					vehicleBean.setRegistrationNumber(uiObj.txtRegistrationNo.getText().trim());		
					vehicleBean.setSeatingCapacity(Integer.parseInt(uiObj.cSeats.getSelectedItem()));
					vehicleBean.setFarePerKM(fare);
					
					add = adminObj.addVehicle(vehicleBean);
				
					uiObj.txtId.setText(vehicleBean.getVehicleID());
				}	
				catch(NumberFormatException e)
				{
					add="Fare per km can contain numbers.";
				}
			}
			uiObj.option.showMessageDialog(uiObj.frame , add);
		}
		
		if(ae.getSource()==VehicleUi.btnCancel)
		{
			VehicleUi.txtId.setText("");
			VehicleUi.txtName.setText("");
			VehicleUi.cType.select(0);
			VehicleUi.txtRegistrationNo.setText("");
			VehicleUi.cSeats.removeAll();
			VehicleUi.txtFarePerKm.setText("");
		}
		
		if(ae.getSource()==VehicleUi.btnBack)
		{
			new AdminUI().setVisible(true);
			uiObj.dispose();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==VehicleUi.cType)
		{
			if(VehicleUi.cType.getSelectedItem().equals("SMALL"))
			{
				VehicleUi.cSeats.removeAll();
				VehicleUi.cSeats.add("4");
			}
			
			if(VehicleUi.cType.getSelectedItem().equals("MEDIUM"))
			{
				VehicleUi.cSeats.removeAll();
				VehicleUi.cSeats.add("6");
				VehicleUi.cSeats.add("8");
			}
			
			if(VehicleUi.cType.getSelectedItem().equals("LARGE"))
			{
				VehicleUi.cSeats.removeAll();
				VehicleUi.cSeats.add("10");
				VehicleUi.cSeats.add("17");
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
