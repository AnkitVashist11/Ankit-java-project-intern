package com.wipro.ata.ui;


import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.ata.listener.CustomerViewRouteListener;

public class CustomerViewRouteForm
{
	  public JFrame frame;
	  public JPanel panel=new JPanel();
	  public JTextField txtSource,txtDestination;
      public JLabel lblSource,lblDestination,lblHeading;
	  public JButton btnView,btnCancel,btnBack;
	  
	  public JScrollPane scrollpane;
	  public DefaultTableModel dfTableModel;
	  public JTable table;
	  public Object col[]=new Object[5];
	  
	  
	   public CustomerViewRouteForm()
	   {  
		   
		   frame=new JFrame();
		   frame.setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		   frame.setVisible(true);
		   frame.setTitle("Customer Route View Form");
		   
		   frame.setSize(1020,750);
		   //frame.setLocation(150,150);
		   frame.setLayout(null);
		   //frame.setResizable(false);
		   
		   lblHeading = new JLabel("Customer View Routes");
		   lblHeading.setBounds(280, 10, 300, 25);
		   lblHeading.setFont(new Font("Papyrus",Font.BOLD,22));
		  
		   lblSource=new JLabel("SOURCE");
		   lblSource.setBounds(150, 50, 100, 25);
		   
		   lblDestination=new JLabel("DESTINATION");
		   lblDestination.setBounds(320, 50, 100, 25);
		  
		   txtSource=new JTextField(20);
		   txtSource.setBounds(200, 50, 100, 25);
		   txtDestination=new JTextField(20);
		   txtDestination.setBounds(400, 50, 100, 25);

		   
		   btnView=new JButton("VIEW");
		   btnView.setBounds(520,50,70,25);

		   btnCancel=new JButton("CANCEL");
		   btnCancel.setBounds(600,50,80,25);

		    btnBack=new JButton("BACK");
			btnBack.setBounds(20,20,100,25);
			btnBack.setToolTipText("Click Here To Go Back");
		  
		   txtSource.setToolTipText("Enter Valid Source ");
		   txtDestination.setToolTipText("Enter Valid Destination");

             btnView.setToolTipText("Click Here To View Details");
			 btnCancel.setToolTipText("Click Here To Cancel Entered Values");
			 btnBack.setToolTipText("Click Here To Go Back");
			 
			 dfTableModel=new DefaultTableModel();
			 dfTableModel.addColumn("ROUTE ID");
		   	 dfTableModel.addColumn("SOURCE");
			 dfTableModel.addColumn("DESTINATION");
			 dfTableModel.addColumn("DISTANCE");
			 dfTableModel.addColumn("TRAVEL DURATION");
				
			 table=new JTable(dfTableModel);
			 table.setSize(700,600);
			 scrollpane=new JScrollPane(table);
			 scrollpane.setSize(700,600);
			 scrollpane.setBounds(140,160,600,400);	
				
				
				
	//		  ImageIcon imageIcon = new ImageIcon("D:\\Vishal\\ATA\\src\\com\\wipro\\ata\\ui\\ata8.jpg");
	//		  frame.setContentPane(new JLabel(imageIcon));
				
		   frame.add(lblHeading);	
		   frame.add(lblSource);
		   frame.add(txtSource);
		   frame.add(lblDestination);
		   frame.add(txtDestination);
		   frame.add(btnView);
		   frame.add(btnCancel);
		   frame.add(btnBack);
		   frame.add(scrollpane);

		   // frame.add(panel);
		   
		   btnView.addActionListener(new CustomerViewRouteListener(this));
		   btnCancel.addActionListener(new CustomerViewRouteListener(this));
		   btnBack.addActionListener(new CustomerViewRouteListener(this));
		   
	   }
	  
		public static void main(String[] args) 
		{
			new CustomerViewRouteForm();

		}

}
