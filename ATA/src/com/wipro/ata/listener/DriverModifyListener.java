package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.DriverModifyForm;

public class DriverModifyListener implements ActionListener
{
	DriverModifyForm objmodify;
	public DriverModifyListener(DriverModifyForm objmodify)
	{
		this.objmodify=objmodify;
	}

	public void actionPerformed(ActionEvent e) 
	{
		String valid;
		Administrator objadmin=new Administrator();
		DriverBean driverBean =new DriverBean();
		if(e.getSource()==objmodify.btnEnter)
		{
			if(objmodify.txtId.getText().equals(""))
			{
				valid="Please enter DriverId";
				JOptionPane.showMessageDialog(null,valid);
			}
			else
			{
			
			try
			{
				driverBean = objadmin.findById(objmodify.txtId.getText());
				objmodify.txtName.setText(driverBean.getName());
				objmodify.txtStreet.setText(driverBean.getStreet());
				objmodify.txtLoc.setText(driverBean.getLocation());
				objmodify.txtCity.setText(driverBean.getCity());
				objmodify.txtState.setText(driverBean.getState());
				objmodify.txtPin.setText(driverBean.getPincode());
				objmodify.txtMob.setText(driverBean.getMobileNo());
				objmodify.txtLicense.setText(driverBean.getLicenseNumber());
				objmodify.lblName.setVisible(true);
				objmodify.txtName.setVisible(true);
				objmodify.lblStreet.setVisible(true);
				objmodify.txtStreet.setVisible(true);
				objmodify.lblLoc.setVisible(true);
				objmodify.txtLoc.setVisible(true);
				objmodify.lblCity.setVisible(true);
				objmodify.txtCity.setVisible(true);
				objmodify.lblState.setVisible(true);
				objmodify.txtState.setVisible(true);
				objmodify.lblPin.setVisible(true);
				objmodify.txtPin.setVisible(true);
				objmodify.lblMob.setVisible(true);
				objmodify.txtMob.setVisible(true);
				objmodify.lblLicense.setVisible(true);
				objmodify.txtLicense.setVisible(true);
				objmodify.txtId.setEditable(false);
				objmodify.btnUpdate.setVisible(true);
				objmodify.btnEnter.setVisible(false);
			}
			catch(Exception q)
			{
				JOptionPane.showMessageDialog(null,"Id does not exists");
				objmodify.lblName.setVisible(false);
				objmodify.txtName.setVisible(false);
				objmodify.lblStreet.setVisible(false);
				objmodify.txtStreet.setVisible(false);
				objmodify.lblLoc.setVisible(false);
				
				objmodify.txtLoc.setVisible(false);
				objmodify.lblCity.setVisible(false);
				objmodify.txtCity.setVisible(false);
				objmodify.lblState.setVisible(false);
				objmodify.txtState.setVisible(false);
				objmodify.lblPin.setVisible(false);
				objmodify.txtPin.setVisible(false);
				objmodify.lblMob.setVisible(false);
				objmodify.txtMob.setVisible(false);
				objmodify.lblLicense.setVisible(false);
				objmodify.txtLicense.setVisible(false);
				objmodify.btnUpdate.setVisible(false);
				objmodify.btnBack.setVisible(true);
				objmodify.txtId.setEditable(true);
				objmodify.txtId.setText("");
				objmodify.btnEnter.setVisible(true);
				
			}
		}
		}
			 if(e.getSource()==objmodify.btnUpdate)
			{
				String result = null;
				if(objmodify.txtName.getText().equals("")||objmodify.txtStreet.getText().equals("")||objmodify.txtLoc.getText().equals("")||objmodify.txtCity.getText().equals("")||objmodify.txtState.getText().equals("")||objmodify.txtPin.getText().equals("")||objmodify.txtMob.getText().equals("")||objmodify.txtLicense.getText().equals(""))
				{
					result="Mandatory to fill all fields";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtName.getText().equals(null)||objmodify.txtName.getText().isEmpty()||objmodify.txtName.getText().length()<2)
				{
					result="Name cannot be too short,atleast 2 characters";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtStreet.getText().isEmpty()||objmodify.txtStreet.getText().length()>30)
				{
					result="Street field takes 2-30 characters";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtLoc.getText().equals("")||objmodify.txtLoc.getText().length()<2||objmodify.txtLoc.getText().length()>15)
				{
					result="Location field takes 2-15 characters only";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtCity.getText().length()<2||objmodify.txtCity.getText().length()>15)
				{
					result="City field takes 2-15 characters only";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtState.getText().length()<2||objmodify.txtState.getText().length()>15)
				{
					result="State field takes 2-15 characters only";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtPin.getText().isEmpty())
				{
					result="Enter  Pincode";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtPin.getText().length()!=6)
				{
					result="Pincode is of only 6 digits ";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtMob.getText().length()<10||objmodify.txtMob.getText().length()>10)
				{
					result="Enter 10 digit MobileNo";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtMob.getText().length()<0)
				{
					result="Invalid Mobile number";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtLicense.getText().equals(""))
				{
					result="Enter LicenseNo";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(objmodify.txtLicense.getText().length()!=10)
				{
					result="Enter 10 digit License Number";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(!(objmodify.txtName.getText().trim().matches("[a-zA-Z ]+")))
				{
					result="Fill Correct Initials for field Name";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(!(objmodify.txtLoc.getText().trim().matches("[a-zA-Z ]+")))
				{
					result="Enter a valid name for location";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(!(objmodify.txtCity.getText().trim().matches("[a-zA-Z ]+")))
				{
					result="Enter a valid name for city";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(!(objmodify.txtState.getText().trim().matches("[a-zA-Z ]+")))
				{
					result="Enter a valid name for State";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(!(objmodify.txtLicense.getText().trim().matches("[0-9]+")))
				{
					result="License Number takes only numerals";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(!(objmodify.txtMob.getText().trim().matches("[0-9]+")))
				{
					result="Mobile Number take only numeric values";
					JOptionPane.showMessageDialog(null,result);
				}
				else if(!(objmodify.txtPin.getText().trim().matches("[0-9]+")))
				{
					result="Pincode take only numeric values";
					JOptionPane.showMessageDialog(null,result);
				}
				else
				{
						DriverBean driverBean2=new DriverBean();
						boolean flag=false;
						driverBean2.setDriverID(objmodify.txtId.getText().trim().toUpperCase());
						driverBean2.setName(objmodify.txtName.getText().trim().toUpperCase());
						driverBean2.setStreet(objmodify.txtStreet.getText().trim().toUpperCase());
						driverBean2.setLocation(objmodify.txtLoc.getText().trim().toUpperCase());
						driverBean2.setCity(objmodify.txtCity.getText().trim().toUpperCase());
						driverBean2.setState(objmodify.txtState.getText().trim().toUpperCase());
						driverBean2.setPincode(objmodify.txtPin.getText().trim());
						driverBean2.setMobileNo(objmodify.txtMob.getText().trim());
						driverBean2.setLicenseNumber(objmodify.txtLicense.getText().trim());
				
						flag=objadmin.modifyDriver(driverBean2);
						if(flag==true)
							{
								JOptionPane.showMessageDialog(null,"Updated Successfully");
								new AdminUI().setVisible(true);
								objmodify.dispose();
								
							}
						else if(flag==false)
						{
							JOptionPane.showMessageDialog(null,"License already exists");
						}
							else
							{
							JOptionPane.showMessageDialog(null,"Failed to Update");
							}
					}
				}
		if(e.getSource()==objmodify.btnCancel)
		{
			objmodify.txtId.setText("");
			objmodify.txtName.setText("");
			objmodify.txtStreet.setText("");
			objmodify.txtLoc.setText("");
			objmodify.txtCity.setText("");
			objmodify.txtState.setText("");
			objmodify.txtPin.setText("");
			objmodify.txtMob.setText("");
			objmodify.txtLicense.setText("");
			
		}
		if(e.getSource()==objmodify.btnBack)
		{
			new AdminUI().setVisible(true);
			objmodify.dispose();
		}
	}
}
