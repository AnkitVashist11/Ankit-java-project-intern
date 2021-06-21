package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.RouteViewAllForm;

public class RouteViewAllListener implements ActionListener,WindowListener
{
	RouteViewAllForm obj;
	
   public RouteViewAllListener(RouteViewAllForm in) 
   {
	  obj=in;
   }

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{   
	    
		
		if(arg0.getSource()==obj.btnViewAll)
		{
			
		}
		if(arg0.getSource()==obj.btnBack)
		{
			new AdminUI().setVisible(true);
			obj.dispose();
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

	@Override
	public void windowOpened(WindowEvent arg0) 
	{
		Administrator adminService=new Administrator();
		obj.dfTableModel.getDataVector().removeAllElements();
		ArrayList<RouteBean>list=adminService.viewAllRoutes();
		//ArrayList<RouteBean>list=customerService.viewRoutesBySourceAndByDestination("Meerut"," Delhi");
		
		Iterator<RouteBean>itr=list.iterator();
		while(itr.hasNext())
		{
			RouteBean routeBean=new RouteBean();
			routeBean=itr.next();
			obj.col[0]=routeBean.getRouteID();
			obj.col[1]=routeBean.getSource().trim().toUpperCase();
			obj.col[2]=routeBean.getDestination().trim().toUpperCase();
			obj.col[3]=routeBean.getDistance();
			obj.col[4]=routeBean.getTravelDuration();
			
			obj.dfTableModel.addRow(obj.col);
		}
		
	}
}

