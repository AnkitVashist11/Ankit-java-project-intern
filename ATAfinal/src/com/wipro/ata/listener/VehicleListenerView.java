package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.VehicleDeleteUi;
import com.wipro.ata.ui.VehicleUi;
import com.wipro.ata.ui.VehicleViewUi;

public class VehicleListenerView implements ActionListener , WindowListener ,ItemListener
{
	VehicleViewUi viewObj;
	public VehicleListenerView(VehicleViewUi viewObj)
	{
		this.viewObj = viewObj;
	}
	
	@Override
	public void windowOpened(WindowEvent e) 
	{
		String vehicleId;
		Administrator adminObj = new Administrator();
		ArrayList list = adminObj.findAll();
		
		Iterator i = list.iterator();
		
		while(i.hasNext())
		{
			VehicleBean vBean = (VehicleBean) i.next() ;
			viewObj.cVehicleId.add(vBean.getVehicleID());
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent ie) 
	{
		if(ie.getSource()==viewObj.cVehicleId)
		{
			Administrator adminObj = new Administrator();
			VehicleBean vBean = adminObj.viewVehicle(VehicleViewUi.cVehicleId.getSelectedItem());
		
			VehicleViewUi.txtName.setText(vBean.getName());
			VehicleViewUi.txtType.setText(vBean.getType());
			VehicleViewUi.txtRegistrationNo.setText(vBean.getRegistrationNumber());
			VehicleViewUi.txtSeatingCapacity.setText(Integer.toString(vBean.getSeatingCapacity()));
			VehicleViewUi.txtFarePerKm.setText(Double.toString(vBean.getFarePerKM()));
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		
		if(ae.getSource()==VehicleViewUi.btnCancel)
		{
			VehicleViewUi.txtName.setText("");
			VehicleViewUi.txtType.setText("");
			VehicleViewUi.txtRegistrationNo.setText("");
			VehicleViewUi.txtSeatingCapacity.setText("");
			VehicleViewUi.txtFarePerKm.setText("");
		}
		
		if(ae.getSource()==VehicleViewUi.btnBack)
		{
			new AdminUI().setVisible(true);
			viewObj.dispose();
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

}
