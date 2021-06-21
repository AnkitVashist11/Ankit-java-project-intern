package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Action;

import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.CancelBookingUi;
import com.wipro.ata.ui.VehicleDeleteUi;
import com.wipro.ata.ui.VehicleViewUi;

public class VehicleDeleteListener implements ActionListener , ItemListener ,WindowListener
{
	VehicleDeleteUi deleteObj;
	public static String vehicleId;
	public VehicleDeleteListener(VehicleDeleteUi deleteObj)
	{
		this.deleteObj = deleteObj;
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
			deleteObj.cVehicleId.add(vBean.getVehicleID());
		}
	}
	
	
	
	@Override
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==deleteObj.cVehicleId)
		{
			vehicleId=deleteObj.cVehicleId.getSelectedItem();
			
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==VehicleDeleteUi.btnDelete)
		{
			Administrator adminObj = new Administrator();
			if(vehicleId==null)
			{
				VehicleDeleteUi.option.showMessageDialog(VehicleDeleteUi.frame, "Select Vehicle Id");
			}
			else
			{

				int btnYes = VehicleDeleteUi.option.showConfirmDialog(VehicleDeleteUi.frame,  "Do you want to delete the vehicle?");

				if(btnYes == VehicleDeleteUi.option.YES_OPTION)
				{				
					int delete = adminObj.deleteVehicle(vehicleId);

					if(delete==1)
					{
						VehicleDeleteUi.option.showMessageDialog(VehicleDeleteUi.frame, "Vehicle deleted", " Message ", VehicleDeleteUi.option.INFORMATION_MESSAGE);
					}
					else if(delete==-1)
					{
						VehicleDeleteUi.option.showMessageDialog(VehicleDeleteUi.frame, "Vehicle is allotted so it cannot be deleted", " Message ", VehicleDeleteUi.option.INFORMATION_MESSAGE);
					}
				}

				else if(btnYes == VehicleDeleteUi.option.NO_OPTION)
				{
					VehicleDeleteUi.option.showMessageDialog(VehicleDeleteUi.frame, "'NO' button pressed.");
				}
				else if(btnYes == VehicleDeleteUi.option.CANCEL_OPTION)
				{
					VehicleDeleteUi.option.showMessageDialog(VehicleDeleteUi.frame, "'CANCEL' button pressed.");
				}
			}
		}


		
		if(ae.getSource()==VehicleDeleteUi.btnCancel)
		{
			VehicleDeleteUi.txtVehicleId.setText("");
		}
		
		if(ae.getSource()==VehicleDeleteUi.btnBack)
		{
			new AdminUI().setVisible(true);
			deleteObj.dispose();
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

