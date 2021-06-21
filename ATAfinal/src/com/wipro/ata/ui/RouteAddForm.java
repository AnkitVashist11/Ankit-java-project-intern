package com.wipro.ata.ui;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.ata.listener.RouteAddListener;

public class RouteAddForm 
{ public JFrame frame;
 // public JPanel panel=new JPanel();
  public JTextField txtRouteId,txtSource,txtDestination,txtDistance,txtTravelDuration;
  public JLabel lblRouteId,lblSource,lblDestination,lblDistance,lblTravelDuration,titleLabel;
  public JButton btnAdd,btnCancel,btnBack;
  
  
   public RouteAddForm()
   {  
	   frame=new JFrame();
	   frame.setVisible(true);
	   frame.setTitle("Route Add Form");
	   frame.setSize(1000,750);
	  // frame.setLocation(150,150);
	   //frame.setResizable(false);
       frame.setLayout(null);
	  // panel.setLayout(new BorderLayout());
       titleLabel=new JLabel("Add Route");
		titleLabel.setFont(new Font("Papyrus",Font.BOLD,20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(425,90,350,25);
	   lblRouteId=new JLabel("Route Id");
	   lblRouteId.setBounds(310,140,125,25);
	   lblRouteId.setForeground(Color.WHITE);
	   lblSource=new JLabel("Source");
	   lblSource.setBounds(310,180,125,25);
	   lblSource.setForeground(Color.WHITE);
	   lblDestination=new JLabel("Destination");
	   lblDestination.setBounds(310,220,125,25);
	   lblDestination.setForeground(Color.WHITE);
	   lblDistance=new JLabel("Distance (in KM)");
	   lblDistance.setBounds(310,260,125,25);
	   lblDistance.setForeground(Color.WHITE);
	   lblTravelDuration=new JLabel("Travel Duration (in HOURS)");
	   lblTravelDuration.setBounds(310,300,195,25);
	   lblTravelDuration.setForeground(Color.WHITE);
	   txtRouteId=new JTextField(20);
	   txtRouteId.setBounds(530,140,125,25);
	   txtSource=new JTextField(20);
	   txtSource.setBounds(530,180,125,25);
	   txtDestination=new JTextField(20);
	   txtDestination.setBounds(530,220,125,25);
	   txtDistance=new JTextField(20);
	   txtDistance.setBounds(530,260,125,25);
	   txtTravelDuration=new JTextField(20);
	   txtTravelDuration.setBounds(530,300,125,25);
	   
	   btnAdd=new JButton("ADD");
	   btnAdd.setBounds(410,350,125,25);
	   btnCancel=new JButton("CANCEL");
	   btnCancel.setBounds(410,390,125,25);
	   btnBack=new JButton("BACK");
	   btnBack.setBounds(10,10,75,25);
	   
	   txtSource.setToolTipText("Enter Valid Source ");
	   txtDestination.setToolTipText("Enter Valid Destination");
	   txtDistance.setToolTipText("Enter Numeric Value In Kilometer");
	   txtTravelDuration.setToolTipText("Enter Numeric value In Hours");
	   
		 btnAdd.setToolTipText("Click Here To ADD Details");
		 btnCancel.setToolTipText("Click Here To Cancel Entered Values");
		 btnBack.setToolTipText("Click Here To Go Back");
		 
	   ImageIcon imageIcon = new ImageIcon("src\\Car33.jpg");
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
	   frame.add(btnAdd);
	   frame.add(btnCancel);
	   frame.add(btnBack);
	   //frame.add(panel);
	   txtRouteId.setEditable(false);
	   
	   
	   btnAdd.addActionListener(new RouteAddListener(this));
	   btnCancel.addActionListener(new RouteAddListener(this));
	   btnBack.addActionListener(new RouteAddListener(this));
	   
   }
  
	public static void main(String[] args) 
	{
		new RouteAddForm();

	}

}
