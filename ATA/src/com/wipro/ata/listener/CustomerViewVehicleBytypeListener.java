package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.service.Customer;
import com.wipro.ata.ui.CustomerUI;
import com.wipro.ata.ui.CustomerViewVehicleBytypeForm;

public class CustomerViewVehicleBytypeListener implements ActionListener,ItemListener  
{
	CustomerViewVehicleBytypeForm obj;
	
	public CustomerViewVehicleBytypeListener(CustomerViewVehicleBytypeForm in)
	{
		obj=in;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==obj.btnBack)
		{
			new CustomerUI().setVisible(true);
			obj.frame.setVisible(false);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource()==obj.ctype)
		{

			Customer customerService=new Customer();
			String vehicleType=obj.ctype.getSelectedItem();
			
			/*if(obj.ctype.getSelectedItem().equals("SMALL"))
			{   
				vehicleType=obj.ctype.getSelectedItem();
			}*/
			
			
				obj.dfTableModel.getDataVector().removeAllElements();
				ArrayList<VehicleBean>list=customerService.viewVehicleByType(vehicleType);
				
				Iterator<VehicleBean>itr=list.iterator();
				while(itr.hasNext())
				{
					VehicleBean vehicleBean=new VehicleBean();
					vehicleBean=itr.next();
					obj.col[0]=vehicleBean.getVehicleID().toUpperCase();
					obj.col[1]=vehicleBean.getName().toUpperCase();
					obj.col[2]=vehicleBean.getType().toUpperCase();
					obj.col[3]=vehicleBean.getRegistrationNumber().toUpperCase();
					obj.col[4]=vehicleBean.getSeatingCapacity();
					obj.col[5]=vehicleBean.getFarePerKM();
					
					obj.dfTableModel.addRow(obj.col);
				}
			
		}
		
	}

}
