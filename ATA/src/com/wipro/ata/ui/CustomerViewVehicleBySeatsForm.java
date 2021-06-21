package com.wipro.ata.ui;

import java.awt.Choice;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wipro.ata.listener.CustomerViewVehicleBySeatsListener;

public class CustomerViewVehicleBySeatsForm 
{
	  public JFrame frame;
	  //public JPanel panel;
	  public JLabel lblHeading,lblVehicleSeats;
	  public Choice cSeats;
	  public JButton btnBack;
	  public JScrollPane scrollpane;
	  public DefaultTableModel dfTableModel;
	  public JTable table;
	  public Object col[]=new Object[6];
	  
		
		public CustomerViewVehicleBySeatsForm()
		{   
			frame=new JFrame();
			frame.setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
			frame.setVisible(true);
			//panel=new JPanel();
			
			frame.setSize(900,750);
			frame.setLayout(null);
			//frame.setLocation(200, 100);
			frame.setTitle("View Details Of Vehicle By Number Of Seats");
			frame.setResizable(false);
			
			lblHeading = new JLabel("View Vehicle By Seats Number");
			lblHeading.setBounds(280, 10, 400, 25);
			lblHeading.setFont(new Font("Papyrus",Font.BOLD,20));
			
			lblVehicleSeats=new JLabel("Vehicle's Seats Number");
			lblVehicleSeats.setBounds(280, 50, 140, 25);
			
			
			cSeats=new Choice();
			cSeats.add("4");
			cSeats.add("6");
			cSeats.add("8");
			cSeats.add("10");
			cSeats.add("17");
			
			cSeats.setBounds(420,50,70,25);
			
			
			btnBack=new JButton("BACK");
			btnBack.setBounds(20,20,100,25);
			btnBack.setToolTipText("Click Here To Go Back");
			
			//btnView.setBounds(40, 40, 60, 30);
			/*table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(27);*/
			
			dfTableModel=new DefaultTableModel();
			dfTableModel.addColumn("VEHICLE ID");
			dfTableModel.addColumn("NAME");
			dfTableModel.addColumn("TYPE");
			dfTableModel.addColumn("REGISTRATION NUMBER");
			dfTableModel.addColumn("SEATING CAPACITY");
			dfTableModel.addColumn("FARE PER KM");
			
			
			table=new JTable(dfTableModel);
			table.setSize(700,600);
			scrollpane=new JScrollPane(table);
			scrollpane.setBounds(130, 130, 650, 550);
			scrollpane.setSize(650,550);
			
			frame.add(lblHeading);
			frame.add(lblVehicleSeats);
			frame.add(cSeats);
			frame.add(btnBack);
			frame.add(scrollpane);
			//frame.add(panel);
			
			cSeats.addItemListener(new CustomerViewVehicleBySeatsListener(this));
			btnBack.addActionListener(new CustomerViewVehicleBySeatsListener(this));
		}
		
	
   
	public static void main(String[] args) 
	{
		new CustomerViewVehicleBySeatsForm();

	}

}


