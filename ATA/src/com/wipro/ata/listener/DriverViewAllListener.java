package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.service.Customer;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.DriverViewAllForm;

public class DriverViewAllListener implements ActionListener
{
	DriverViewAllForm objview;
	
	public DriverViewAllListener(DriverViewAllForm objview)
	{
		this.objview=objview;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Administrator objadmin=new Administrator();
		Customer objcustom=new Customer();
		if(e.getSource()==objview.btnView)
		{
			objview.list.removeAll();
			//1.objview.list1.removeAll();
			
			objview.dfTableModel.getDataVector().removeAllElements();
			ArrayList<DriverBean>list=objadmin.findAllDrivers();
			
			Iterator<DriverBean>itr=list.iterator();
			while(itr.hasNext())
			{
				DriverBean driverBean=new DriverBean();
				driverBean=itr.next();
				if(driverBean.getDriverID().equalsIgnoreCase("xxx"))
				{
					continue;
				}
				objview.list.add(driverBean.getDriverID());
				objview.col[0]=driverBean.getDriverID();
				objview.col[1]=driverBean.getName();
				objview.col[2]=driverBean.getStreet();
				objview.col[3]=driverBean.getLocation();
				objview.col[4]=driverBean.getCity();
				objview.col[5]=driverBean.getState();
				objview.col[6]=driverBean.getPincode();
				objview.col[7]=driverBean.getMobileNo();
				objview.col[8]=driverBean.getLicenseNumber();
				objview.dfTableModel.addRow(objview.col);
			}
			ArrayList<ReservationBean>list1=objadmin.viewAllReservationDetails();
			Iterator iter=list1.iterator();
			while(iter.hasNext())
			{
				ReservationBean reserveBean=(ReservationBean) iter.next();
				objview.list1.add(reserveBean.getReservationID());
			}
			
			
		}
		if(e.getSource()==objview.btnAllot)
		//{
			//String result="";
			/*if(objview.txtId.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter Driver Id");
			}*/
			//else 
			/*	if(objview.txtReservationId.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter Reservation Id");
			}*/
			
			//else
			{
				String result="";
				DriverBean driverBean=new DriverBean();
				driverBean=objadmin.findById(objview.list.getSelectedItem());
				if(driverBean==null)
				{
					JOptionPane.showMessageDialog(null, "Invalid Driver ID");
				}
				else
				{
					result=objadmin.allotDriver(objview.list1.getSelectedItem(),objview.list.getSelectedItem());
					if(result.equalsIgnoreCase("SUCCESS"))
					{
					JOptionPane.showMessageDialog(null, "Successfully Alotted New Driver");
					}
					else if(result.equalsIgnoreCase("INVALID"))
					{
					JOptionPane.showMessageDialog(null, "Invalid Reservation Id");
					}
					else if(result.equalsIgnoreCase("DRIVER BUSY"))
					{
						JOptionPane.showMessageDialog(null, "Driver Busy");
					}
					else if(result.equalsIgnoreCase("UNBOOKED"))
					{
						JOptionPane.showMessageDialog(null, "This Reservation has been cancelled");
					}
					else if(result.equalsIgnoreCase("Already Allotted"))
					{
						JOptionPane.showMessageDialog(null, "Driver has already been alotted for this reservation Id");
					}
				}
			}
		//}
		
		if(e.getSource()==objview.btnBack)
		{
			new AdminUI().setVisible(true);
			 objview.dispose();
		}
		

}
}
