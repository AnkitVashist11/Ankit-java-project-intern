package com.wipro.ata.ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wipro.ata.listener.RouteModifyListener;


public class RouteModifyForm 
{
	 public JFrame frame;
	  //public JPanel panel=new JPanel();
	  public JTextField txtRouteId,txtSource,txtDestination,txtDistance,txtTravelDuration;
	  public JLabel lblRouteId,lblSource,lblDestination,lblDistance,lblTravelDuration,titleLabel;
	  public JButton btnModify,btnCancel,btnBack,btnEnter;
	  
	  
	   public RouteModifyForm()
	   {  
		   frame=new JFrame();
		   frame.setTitle("Route Modify Form");
		   frame.setVisible(true);
		   frame.setSize(1000,750);
		   //frame.setLocation(150,150);
		   frame.setResizable(false);
	       frame.setLayout(null);
		  // panel.setLayout(new BorderLayout());
	       
	       titleLabel=new JLabel("Modify Route");
			titleLabel.setFont(new Font("Papyrus",Font.BOLD,20));
			titleLabel.setBounds(415,90,350,25);
		   
		   lblRouteId=new JLabel("ROUTE ID");
		   lblRouteId.setBounds(310,140,125,25);
		   lblSource=new JLabel("SOURCE");
		   lblSource.setBounds(310,180,125,25);
		   lblDestination=new JLabel("DESTINATION");
		   lblDestination.setBounds(310,220,125,25);
		   lblDistance=new JLabel("DISTANCE (in KM)");
		   lblDistance.setBounds(310,260,125,25);
		   lblTravelDuration=new JLabel("TRAVEL DURATION (in HOURS)");
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
		   
		   btnModify=new JButton("MODIFY");
		   btnCancel=new JButton("CANCEL");
		   btnBack=new JButton("BACK");
		   btnEnter=new JButton("VIEW");
		   btnModify.setBounds(410,350,125,25);
		   btnEnter.setBounds(410,350,125,25);
		   btnCancel.setBounds(410,390,125,25);
		   btnBack.setBounds(10,10,75,25);
		   
		   txtSource.setToolTipText("Enter Valid Source ");
		   txtDestination.setToolTipText("Enter Valid Destination");
		   txtDistance.setToolTipText("Enter Numeric Value In Kilometer");
		   txtTravelDuration.setToolTipText("Enter Numeric value In Hours");
		   
			 btnModify.setToolTipText("Click Here To ADD Details");
			 btnCancel.setToolTipText("Click Here To Cancel Entered Values");
			 btnBack.setToolTipText("Click Here To Go Back");
			 btnEnter.setToolTipText("Click Here To Fetch Details For This Id");
			 
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
		   frame.add(btnModify);
		   frame.add(btnCancel);
		   frame.add(btnBack);
		   frame.add(btnEnter);
		   //frame.add(panel);
		   
		   lblSource.setVisible(false);
		   lblDestination.setVisible(false);
		   lblDistance.setVisible(false);
		   lblTravelDuration.setVisible(false);
		   txtSource.setVisible(false);
		   txtDestination.setVisible(false);
		   txtDistance.setVisible(false);
		   txtTravelDuration.setVisible(false);
		   btnModify.setVisible(false);
		   
		   
		   
		   btnModify.addActionListener(new RouteModifyListener(this));
		   btnCancel.addActionListener(new RouteModifyListener(this));
		   btnBack.addActionListener(new RouteModifyListener(this));
		   btnEnter.addActionListener(new RouteModifyListener(this));
		   
	   }
	  
		public static void main(String[] args) 
		{
			new RouteModifyForm();

		}
}

