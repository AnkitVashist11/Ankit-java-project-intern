package com.wipro.ata.ui;


import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.ata.listener.RouteViewListener;


public class RouteViewForm 
{   public JFrame frame;
	//public JPanel panel=new JPanel();
	public JTextField txtRouteId,txtSource,txtDestination,txtDistance,txtTravelDuration;
	public JLabel lblRouteId,lblSource,lblDestination,lblDistance,lblTravelDuration,titleLabel;
	public JButton btnView,btnCancel,btnBack;


 public RouteViewForm()
 {  
	   frame=new JFrame();
	   frame.setVisible(true);
	   frame.setTitle("ROUTE VIEW FORM");
	  
	   frame.setSize(1000,750);
	   //frame.setLocation(150,150);
	   frame.setResizable(false);
      
	   frame.setLayout(null);
	  // panel.setLayout(new BorderLayout());
	   titleLabel=new JLabel("View Route");
		titleLabel.setFont(new Font("Papyrus",Font.BOLD,20));
		titleLabel.setBounds(415,90,350,25);
	   
	   lblRouteId=new JLabel("ROUTE ID");
	   lblSource=new JLabel("SOURCE");
	   lblDestination=new JLabel("DESTINATION");
	   lblDistance=new JLabel("DISTANCE (in KM)");
	   lblTravelDuration=new JLabel("TRAVEL DURATION (in HOURS)");
	   lblRouteId.setBounds(310,140,125,25);
	   lblSource.setBounds(310,180,125,25);
	   lblDestination.setBounds(310,220,125,25);
	   lblDistance.setBounds(310,260,125,25);
	   lblTravelDuration.setBounds(310,300,195,25);
	   
	   
	   txtRouteId=new JTextField(20);
	   txtSource=new JTextField(20);
	   txtDestination=new JTextField(20);
	   txtDistance=new JTextField(20);
	   txtTravelDuration=new JTextField(20);
	   txtRouteId.setBounds(530,140,125,25);
	   txtSource.setBounds(530,180,125,25);
	   txtDestination.setBounds(530,220,125,25);
	   txtDistance.setBounds(530,260,125,25);
	   txtTravelDuration.setBounds(530,300,125,25);
	   
	   btnView=new JButton("VIEW");
	   btnCancel=new JButton("CANCEL");
	   btnBack=new JButton("BACK");
	   btnView.setBounds(410,350,125,25);
	   btnCancel.setBounds(410,390,125,25);
	   btnBack.setBounds(10,10,75,25);
	   
	     txtRouteId.setToolTipText("Enter Valid RouteID");
		 btnView.setToolTipText("Click Here To View Details");
		 btnCancel.setToolTipText("Click Here To Cancel Entered Values");
		 btnBack.setToolTipText("Click Here To Go Back");
		 
	   ImageIcon imageIcon = new ImageIcon("src\\image.jpg");
	   frame.setContentPane(new JLabel(imageIcon));
	   
	   frame.add(titleLabel);
	   frame.add(lblRouteId);
	   frame.add(txtRouteId);
	   frame.add(lblSource);
	   frame.add(txtSource);
	   frame.add(lblDestination);
	   frame.add(txtDestination);
	   frame.add(lblDistance);
	   frame.add(txtDistance);
	   frame.add(lblTravelDuration);
	   frame.add(txtTravelDuration);
	   frame.add(btnView);
	   frame.add(btnCancel);
	   frame.add(btnBack);
	   //frame.add(panel);
	   
	   txtSource.setEditable(false);
	   txtDestination.setEditable(false);
	   txtDistance.setEditable(false);
	   txtTravelDuration.setEditable(false);
	   
	   
	   btnView.addActionListener(new RouteViewListener(this));
	   btnCancel.addActionListener(new RouteViewListener(this));
	   btnBack.addActionListener(new RouteViewListener(this));
	   
 }

	public static void main(String[] args) 
	{
		new RouteViewForm();

	}

}
