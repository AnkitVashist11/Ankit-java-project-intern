package com.wipro.ata.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Action;

import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.VehicleUi;
import com.wipro.ata.ui.VehicleUpdateUi;

public class VehicleUpdateListener implements ActionListener , ItemListener
{
	VehicleUpdateUi uiObj;
	public VehicleUpdateListener(VehicleUpdateUi uiObj)
	{
		this.uiObj = uiObj;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == VehicleUpdateUi.btnEnter)
		{
			if(VehicleUpdateUi.txtId.getText().trim().equals(""))
			{
				VehicleUpdateUi.option.showMessageDialog(VehicleUpdateUi.optionFrame, "Enter Vehicle id");
			}
			else
			{
				Administrator adminObj = new Administrator();
				
				VehicleBean vBean =	adminObj.viewVehicle(VehicleUpdateUi.txtId.getText());
				if(vBean==null)
				{
					VehicleUpdateUi.option.showMessageDialog(VehicleUpdateUi.optionFrame, "Invalid Vehicle id");
				}
				else
				{
					VehicleUpdateUi.frame.setVisible(true);
					VehicleUpdateUi.txtName.setText(vBean.getName());
					VehicleUpdateUi.txtType.setText(vBean.getType());
					VehicleUpdateUi.txtRegistrationNo.setText(vBean.getRegistrationNumber());
					VehicleUpdateUi.txtSeatingCapacity.setText(Integer.toString(vBean.getSeatingCapacity()));
					VehicleUpdateUi.txtFarePerKm.setText(Double.toString(vBean.getFarePerKM()));
				}
			}
		}

		if(ae.getSource() == VehicleUpdateUi.btnModify)
		{
			VehicleUpdateUi.frame.setVisible(true);
			String modify = null  ;
			
			Administrator adminObj = new Administrator();
			
			if(VehicleUpdateUi.txtName.getText().equals("") || VehicleUpdateUi.txtRegistrationNo.getText().equals("") || VehicleUpdateUi.txtFarePerKm.getText().equals(""))   
			{
				modify="Don't leave blank fields";
			}
			
			else if(VehicleUpdateUi.txtName.getText().trim().length()<2)
			{
				modify="Name should be greater than 2 characters.";
			}
			else if(!(VehicleUpdateUi.txtName.getText().trim().matches("[a-zA-Z0-9 ]+")))
			{
				modify = "Name can contain only characters and numbers. ";
			}
			
			
			else if(VehicleUpdateUi.txtRegistrationNo.getText().trim()==null)
			{
				modify = "Enter registration Number";
			}
			else if(VehicleUpdateUi.txtRegistrationNo.getText().trim().isEmpty())
			{
				modify = "Registration number can not be left blank";
			}
			else if( VehicleUpdateUi.txtRegistrationNo.getText().trim().length()>12)
			{
				modify = "Registration number should be of length between 1 to 12";
			}
			else if(!(VehicleUpdateUi.txtRegistrationNo.getText().trim().matches("[a-zA-Z0-9]+")))
			{
				modify = "Registration Number can contain only characters and numbers. ";
			}
						
			else if(VehicleUpdateUi.txtFarePerKm.getText().trim().length()>6 || VehicleUpdateUi.txtFarePerKm.getText().trim().length()<=0)
			{
				modify = "Fare per km should be between 1 to 999. ";
			}

			else
			{
				double fare = 0;
			
						try
						{
							fare = Double.parseDouble(VehicleUpdateUi.txtFarePerKm.getText().trim());
							
							if(fare<=0)
							{
								modify = "Fare per km should be between 1 to 999.";
							}
							else
							{
								boolean update;
								VehicleBean vBean =	new VehicleBean();
								
								vBean.setVehicleID(VehicleUpdateUi.txtId.getText().trim());
								vBean.setName(VehicleUpdateUi.txtName.getText().trim());
								vBean.setType(VehicleUpdateUi.txtType.getText());
								vBean.setRegistrationNumber(VehicleUpdateUi.txtRegistrationNo.getText().trim());
								vBean.setSeatingCapacity(Integer.parseInt(VehicleUpdateUi.txtSeatingCapacity.getText()));
								vBean.setFarePerKM(fare);
							
								update = adminObj.modifyVehicle(vBean);
								
								if(update==true)
								{
									modify = "Vehicle details updated";
								}
								
								else 
								{
									modify = "Vehicle details not modified";
								}
							}
						}	
						catch(NumberFormatException e)
						{
							modify="Fare per km can contain only numbers.";
							//e.printStackTrace();
						}
			//		}
			//	}	
			/*	catch(NumberFormatException ei)
				{
					modify="Seating capacity can contain only numbers.";
				} */
			}
			VehicleUpdateUi.option.showMessageDialog(VehicleUpdateUi.optionFrame, modify);
			VehicleUpdateUi.txtId.setText("");
		}
		
		if(ae.getSource() == VehicleUpdateUi.btnCancel)
		{
		//	VehicleUpdateUi.txtName.setText("");
		//	VehicleUpdateUi.cType.select("");
		//	VehicleUpdateUi.txtRegistrationNo.setText("");
		//	VehicleUpdateUi.cSeats.select("");
			VehicleUpdateUi.txtFarePerKm.setText("");
		}
		
		if(ae.getSource() == VehicleUpdateUi.btnBack)
		{
			//new AdminUI().setVisible(true);
			VehicleUpdateUi.frame.setVisible(false);
		
			//VehicleUpdateUi.frame.dispose();
		}
		
		if(ae.getSource() == VehicleUpdateUi.btnBack1)
		{
			new AdminUI().setVisible(true);
			uiObj.dispose();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) 
	{
		if(ie.getSource()==VehicleUpdateUi.cType)
		{
			if(VehicleUpdateUi.cType.getSelectedItem().equals("SMALL"))
			{
				VehicleUpdateUi.cSeats.removeAll();
				VehicleUpdateUi.cSeats.add("4");
			}
			
			if(VehicleUpdateUi.cType.getSelectedItem().equals("MEDIUM"))
			{
				VehicleUpdateUi.cSeats.removeAll();
				VehicleUpdateUi.cSeats.add("6");
				VehicleUpdateUi.cSeats.add("8");
			}
			
			if(VehicleUpdateUi.cType.getSelectedItem().equals("LARGE"))
			{
				VehicleUpdateUi.cSeats.removeAll();
				VehicleUpdateUi.cSeats.add("10");
				VehicleUpdateUi.cSeats.add("17");
			}
		}
	}
}
