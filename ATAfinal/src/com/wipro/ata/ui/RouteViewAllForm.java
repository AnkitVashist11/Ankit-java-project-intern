package com.wipro.ata.ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wipro.ata.listener.RouteViewAllListener;

public class RouteViewAllForm extends JFrame
{
	//public JFrame frame;
	public JLabel titleLabel;
	//public JPanel panel;
	public JButton btnViewAll,btnBack;
	public JOptionPane optpane;
	public JScrollPane scrollpane;
	public DefaultTableModel dfTableModel;
	public JTable table;
	public Object col[]=new Object[5];
	
	public RouteViewAllForm()
	{
		//panel=new JPanel();
		setVisible(true);
		setSize(1000,750);
		setLayout(null);
		setLocation(0,0);
		setTitle("View Details");
		
		setResizable(false);
		
		 titleLabel=new JLabel("View All Routes");
			titleLabel.setFont(new Font("Papyrus",Font.BOLD,20));
			titleLabel.setBounds(405,90,350,25);
		btnViewAll=new JButton("View All Route Details");
		btnViewAll.setBounds(375,150,220,25);
		btnBack=new JButton("BACK");
		btnBack.setBounds(10,10,100,25);
		//btnView.setBounds(40, 40, 60, 30);
		/*table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(27);*/
		
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
		scrollpane.setBounds(150,220,600,400);
		ImageIcon imageIcon = new ImageIcon("src\\image.jpg");
		 setContentPane(new JLabel(imageIcon));
		
		add(titleLabel);
		//add(btnViewAll);
		add(btnBack);
		add(scrollpane);
		
		
		btnViewAll.setToolTipText("Click Here To VIEW ALL DETAILS");
		btnBack.setToolTipText("Click Here To Go Back");
		addWindowListener(new RouteViewAllListener(this));
		//btnViewAll.addActionListener(new RouteViewAllListener(this));
		btnBack.addActionListener(new RouteViewAllListener(this));
	}
	
	public static void main(String[] args) 
	{
		new RouteViewAllForm();

	}

}
