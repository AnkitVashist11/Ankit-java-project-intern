package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.VehicleDAO;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.VehicleViewAll;

public class VehicleViewAllListener implements ActionListener ,WindowListener
{
	VehicleViewAll viewAllObj ;
	public VehicleViewAllListener(VehicleViewAll viewAllObj)
	{
		this.viewAllObj = viewAllObj;
	}
	
	@Override
	public void windowOpened(WindowEvent e)
	{
		VehicleViewAll.dfTable.getDataVector().removeAllElements();
		Administrator adminObj = new Administrator();
		ArrayList<VehicleBean> list = adminObj.findAll();
		Iterator i = list.iterator();
		while(i.hasNext())
		{
			VehicleBean vBean = new VehicleBean();
			vBean = (VehicleBean) i.next();
			
			VehicleViewAll.col[0] = vBean.getVehicleID();
			VehicleViewAll.col[1] = vBean.getName();
			VehicleViewAll.col[2] = vBean.getType();
			VehicleViewAll.col[3] = vBean.getRegistrationNumber();
			VehicleViewAll.col[4] = vBean.getSeatingCapacity();
			VehicleViewAll.col[5] = vBean.getFarePerKM();
			VehicleViewAll.dfTable.addRow(VehicleViewAll.col);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==VehicleViewAll.btnBack)
		{
			new AdminUI().setVisible(true);
			viewAllObj.dispose();
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

