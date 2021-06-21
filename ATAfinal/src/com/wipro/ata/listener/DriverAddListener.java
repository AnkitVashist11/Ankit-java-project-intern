package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.DriverAddForm;


public class DriverAddListener implements ActionListener
{
	DriverAddForm objAdd;
	public DriverAddListener(DriverAddForm objAdd)
	{
		this.objAdd=objAdd;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Administrator objadmin=new Administrator();
		DriverBean driverBean=new DriverBean();
		if(e.getSource()==objAdd.btnBack)
		 {
			 objAdd.dispose();
			 new AdminUI().setVisible(true);
			 
		 }
		if(e.getSource()==objAdd.btnCancel)
		 {
			objAdd.txtId.setText("");
			objAdd.txtName.setText("");
			objAdd.txtStreet.setText("");
			objAdd.txtLoc.setText("");
			objAdd.txtCity.setText("");
			objAdd.txtState.setText("");
			objAdd.txtPin.setText("");
			objAdd.txtMob.setText("");
			objAdd.txtLicense.setText("");
		 }
		if(e.getSource()==objAdd.btnAdd)
		{
			String result;
			if(objAdd.txtName.getText().equals("")||objAdd.txtStreet.getText().equals("")||objAdd.txtLoc.getText().equals("")||objAdd.txtCity.getText().equals("")||objAdd.txtState.getText().equals("")||objAdd.txtPin.getText().equals("")||objAdd.txtMob.getText().equals("")||objAdd.txtLicense.getText().equals(""))
			{
				result="Mandatory to fill all fields";
				JOptionPane.showMessageDialog(objAdd.frame,result);
			}
			else if(!(objAdd.txtName.getText().trim().matches("[a-zA-Z ]+")))
			{
				result="Fill Correct Initials for field Name";
				JOptionPane.showMessageDialog(objAdd.frame,result);
			}
			else if(!(objAdd.txtLoc.getText().trim().matches("[a-zA-Z0-9 ]+")))
			{
				result="Location field takes only characters";
				JOptionPane.showMessageDialog(objAdd.frame,result);
			}
			else if(!(objAdd.txtCity.getText().trim().matches("[a-zA-Z ]+")))
			{
				result="City field takes only characters";
				JOptionPane.showMessageDialog(objAdd.frame,result);
			}
			else if(!(objAdd.txtState.getText().trim().matches("[a-zA-Z ]+")))
			{
				result="State field takes only characters";
				JOptionPane.showMessageDialog(objAdd.frame,result);
			}
			else if(!(objAdd.txtLicense.getText().trim().matches("[0-9]+")))
			{
				result="License Number takes only numeric values";
				JOptionPane.showMessageDialog(objAdd.frame,result);
			}
			else if(!(objAdd.txtMob.getText().trim().matches("[0-9]+")))
			{
				result="Mobile Number take only numeric values";
				JOptionPane.showMessageDialog(objAdd.frame,result);
			}
			else if(!(objAdd.txtPin.getText().trim().matches("[0-9]+")))
			{
				result="Pincode take only numeric values";
				JOptionPane.showMessageDialog(objAdd.frame,result);
			}
			else
			{
				driverBean.setName(objAdd.txtName.getText().trim().toUpperCase());
				driverBean.setStreet(objAdd.txtStreet.getText().trim().toUpperCase());
				driverBean.setLocation(objAdd.txtLoc.getText().trim().toUpperCase());
				driverBean.setCity(objAdd.txtCity.getText().trim().toUpperCase());
				driverBean.setState(objAdd.txtState.getText().trim().toUpperCase());
				driverBean.setPincode(objAdd.txtPin.getText().trim());
				driverBean.setMobileNo(objAdd.txtMob.getText().trim());
				driverBean.setLicenseNumber(objAdd.txtLicense.getText().trim());
				result=objadmin.addDriver(driverBean);
				if(result.equalsIgnoreCase("New Driver Added Successfully"))
				{
					objAdd.txtId.setText(driverBean.getDriverID());
					JOptionPane.showMessageDialog(objAdd.frame,result);
					
					new AdminUI().setVisible(true);
					 objAdd.dispose();
				}
				
			}

			
		}
	
			 
			 
	}
}
