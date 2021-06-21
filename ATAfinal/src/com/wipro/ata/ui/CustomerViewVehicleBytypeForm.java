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

import com.wipro.ata.listener.CustomerViewVehicleBytypeListener;

public class CustomerViewVehicleBytypeForm 
{
  public JFrame frame;
 //public JPanel panel;
  public JLabel lblHeading,lblVehicleType;
  public Choice ctype;
  public JButton btnBack;
  public JScrollPane scrollpane;
  public DefaultTableModel dfTableModel;
  public JTable table;
  public Object col[]=new Object[6];
  
	
	public CustomerViewVehicleBytypeForm()
	{   
		frame=new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		frame.setVisible(true);
		//panel=new JPanel();
		
		frame.setSize(900,750);
		frame.setLayout(null);
		//frame.setLocation(10, 10);
		frame.setTitle("View Details By Vehicle Type");
		frame.setResizable(false);
		lblHeading = new JLabel("View Vehicle By Type");
		lblHeading.setBounds(290, 10, 300, 25);
		lblHeading.setFont(new Font("Papyrus",Font.BOLD,20));
		
		lblVehicleType=new JLabel("Vehicle Type");
		lblVehicleType.setBounds(300, 50, 100, 25);
		
		ctype=new Choice();
		ctype.add("SMALL");
		ctype.add("MEDIUM");
		ctype.add("LARGE");
		
		ctype.setBounds(400,50,100,25);
		
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
		frame.add(lblVehicleType);
		frame.add(ctype);
		frame.add(btnBack);
		frame.add(scrollpane);
		//frame.add(panel);
		
		ctype.addItemListener(new CustomerViewVehicleBytypeListener(this));
		btnBack.addActionListener(new CustomerViewVehicleBytypeListener(this));
	}
	
	public static void main(String args[])
	{
		new CustomerViewVehicleBytypeForm();
	}
}

