package com.wipro.ata.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.ata.listener.DriverViewAllListener;

public class DriverViewAllForm extends JFrame
{
	public JFrame frame;
	public JLabel lblId,lblReservationId,lblTitle;
	public JTextField txtReservationId;
	public JPanel panel;
	public JButton btnView,btnAllot,btnBack;
	public JOptionPane optpane;
	public JScrollPane scrollpane;
	public DefaultTableModel dfTableModel;
	public JTable table;
	public Object col[]=new Object[9];
	public Choice list,list1;
	
	public DriverViewAllForm() 
	{
		setVisible(true);
		
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		
		//panel=new JPanel();
		setSize(1000,700);
		//panel.
		setLayout(null);
		//setLocation(10,10);
		setTitle("View Details");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		list=new Choice();
		list1=new Choice();
		
		btnView=new JButton("View Driver");
		btnView.setBounds(300,20,140,30);
		//btnView.setForeground(Color.RED);
		//btnView.setFont(new Font("papyrus",Font.BOLD,20));
		//panel.
		add(btnView);
		btnView.addActionListener(new DriverViewAllListener(this));
		
		dfTableModel=new DefaultTableModel();
		dfTableModel.addColumn("DRIVER ID");
		dfTableModel.addColumn("NAME");
		dfTableModel.addColumn("STREET");
		dfTableModel.addColumn("LOCATION");
		dfTableModel.addColumn("CITY");
		dfTableModel.addColumn("STATE");
		dfTableModel.addColumn("PINCODE");
		dfTableModel.addColumn("MOBILE NO");
		dfTableModel.addColumn("LICENSE NUMBER");
		
		table=new JTable(dfTableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		
		table.setSize(700,300);
		scrollpane=new JScrollPane(table);
		
		scrollpane.setSize(700,300);
		scrollpane.setBounds(100,60,700,300);
		
		//panel.
		add(scrollpane);
		
		lblId=new JLabel("Driver ID");
		lblId.setBounds(100,400,175,25);
		list.setBounds(300,400,80,25);
		//panel.
		add(list);
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		lblReservationId=new JLabel("Reservation Id");
		lblReservationId.setBounds(100,450,300,25);
		lblReservationId.setForeground(Color.BLACK);
		lblReservationId.setFont(new Font("Serif",Font.BOLD,20));
		
		list1=new Choice();
		list1.setBounds(300,450,100,25);
		//panel.
		add(list1);
		/*txtId=new JTextField(10);
		txtId.setToolTipText("Enter Driver Id who can be allotted to this route");
		txtId.setBounds(300,400,100,25);*/
		
		/*
		txtReservationId=new JTextField(10);
		txtReservationId.setBounds(300, 450, 100, 25);
		txtReservationId.setToolTipText("Reservation Id of customer for which driver is to be allotted");*/
		
		//panel.
		add(lblId);
		//panel.add(txtId);
		//panel.
		add(lblReservationId);
		//panel.add(txtReservationId);
		btnAllot=new JButton("Allot Driver");
		btnAllot.setToolTipText("Press to allot Driver");
		btnAllot.setBounds(200,500,120,25);
		//btnAllot.setFont(new Font("Papyrus",Font.BOLD,18));
		//panel.
		add(btnAllot);
		btnAllot.addActionListener(new DriverViewAllListener(this));
		
		
		btnBack=new JButton("Back");
		btnBack.setBounds(10,10,75,25);
		btnBack.addActionListener(new DriverViewAllListener(this));
		//panel.
		add(btnBack);
		
		
		//add(panel);
		//panel.setBounds(50, 500, 600, 400);
		
		
	}
	public static void main(String[] args) 
	{
		new DriverViewAllForm();
	}

}
