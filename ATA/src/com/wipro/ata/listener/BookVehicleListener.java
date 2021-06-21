package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.service.Customer;
import com.wipro.ata.ui.BookVehicleUI;
import com.wipro.ata.ui.CustomerUI;
import com.wipro.ata.ui.PaymentPageUI;

public class BookVehicleListener implements ActionListener,ItemListener
{
	static public String routeId;
	static public String vehicleId;
	static public int distance=0;
	static public double fare=0;
	static public double totalFare;
	static public String source;
	static public String destination;
	static public Date date;
	BookVehicleUI bui;
	public BookVehicleListener(BookVehicleUI bui)
	{
		this.bui=bui;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==bui.btnBack)
		{
			new CustomerUI().setVisible(true);
			bui.dispose();
		}
		if(e.getSource()==bui.viewRouteButton)
		{
			bui.routeChoice.removeAll();
			Date d=bui.chooser.getDate();
			if(bui.sourceText.getText().equals("") || bui.destinationText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(bui.frame,"Mandatory to fill all fields");
			}
			else if(d==null)
			{
				JOptionPane.showMessageDialog(bui.frame,"Enter Journey Date");
			}
			else
			{
				bui.model.getDataVector().removeAllElements();
				Customer customer=new Customer();
				ReservationBean rb=new ReservationBean();
				source=bui.sourceText.getText().trim().toUpperCase();
				destination=bui.destinationText.getText().trim().toUpperCase();
				date=bui.chooser.getDate();
				try
				{
					ArrayList<RouteBean> al=customer.viewRouteBySAndD(source, destination);
					if(al.isEmpty())
					{
						JOptionPane.showMessageDialog(bui.frame,"No routes available");
					}
					else
					{
						Iterator itr=al.iterator();
						while(itr.hasNext())
						{
							RouteBean rbn=new RouteBean();
							rbn=(RouteBean) itr.next();
							bui.routeChoice.add(rbn.getRouteID());
							bui.col[0]=rbn.getRouteID();
							bui.col[1]=rbn.getSource();
							bui.col[2]=rbn.getDestination();
							bui.col[3]=rbn.getDistance();
							bui.col[4]=rbn.getTravelDuration();
							bui.model.addRow(bui.col);
						}
						bui.routeScrollPane.setVisible(true);
						bui.viewVehicleButton.setVisible(true);
					}
				} 
				catch (ClassNotFoundException e1)
				{
					e1.printStackTrace();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==bui.viewVehicleButton)
		{
			bui.vehicleChoice.removeAll();
			bui.model1.getDataVector().removeAllElements();
			Customer customer=new Customer();
			ArrayList<VehicleBean> al=customer.findAll();
			if(al.isEmpty())
			{
				JOptionPane.showMessageDialog(bui.frame,"No vehicles available");
			}
			else
			{
				Iterator itr=al.iterator();
				while(itr.hasNext())
				{
					VehicleBean vbn=new VehicleBean();
					vbn=(VehicleBean) itr.next();
					String s=customer.checkReservationByVehicleId(vbn.getVehicleID(),bui.chooser.getDate());
					if(s.equalsIgnoreCase("booked"))
					{
						continue;
					}
					bui.vehicleChoice.add(vbn.getVehicleID());
					bui.col1[0]=vbn.getVehicleID();
					bui.col1[1]=vbn.getName();
					bui.col1[2]=vbn.getType();
					bui.col1[3]=vbn.getSeatingCapacity();
					bui.col1[4]=vbn.getFarePerKM();
					bui.model1.addRow(bui.col1);
				}
				bui.vehicleScrollPane.setVisible(true);
				bui.selectRouteLabel.setVisible(true);
				bui.selectvehicleLabel.setVisible(true);
				bui.routeChoice.setVisible(true);
				bui.vehicleChoice.setVisible(true);
				bui.bookButton.setVisible(true);
			}
		}
		if(e.getSource()==bui.bookButton)
		{
			totalFare=distance*fare;
			if(distance!=0.0)
			{
				if(fare!=0.0)
				{
					new PaymentPageUI().setVisible(true);
					bui.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(bui.frame,"First select vehicle Id");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(bui.frame,"First select route Id");
			}
			
		}
	}
	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		if(arg0.getSource()==bui.routeChoice)
		{
			Administrator admn=new Administrator();
			RouteBean rb=new RouteBean();
			routeId=bui.routeChoice.getSelectedItem();
			rb=admn.viewRoute(routeId);
			distance=rb.getDistance();
		}
		if(arg0.getSource()==bui.vehicleChoice)
		{
			Administrator admn=new Administrator();
			VehicleBean vb=new VehicleBean();
			vehicleId=bui.vehicleChoice.getSelectedItem();
			vb=admn.viewVehicle(vehicleId);
			fare=vb.getFarePerKM();
		}
		
	}
	
}
