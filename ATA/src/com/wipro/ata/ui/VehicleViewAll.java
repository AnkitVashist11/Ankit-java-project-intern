package com.wipro.ata.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.wipro.ata.listener.VehicleListenerView;
import com.wipro.ata.listener.VehicleViewAllListener;

public class VehicleViewAll extends JFrame
{
	public static JLabel lblHeading ;
	public static JButton btnViewAll , btnBack ;
	public static JOptionPane option;
	public static JFrame frame;
	public static JScrollPane scrollPane;
	public static DefaultTableModel dfTable;
	public static JTable table;
	public static Object col[] = new Object[6];
	
	public static void main(String args[])
	{
		VehicleViewAll ui = new VehicleViewAll();
	}
	
	public VehicleViewAll()
	{
		setContentPane(new JLabel(new ImageIcon("src\\image.jpg")));
		
	//	setLocation(100,100);
		setSize(1020, 750);
		setTitle(" View Vehicle");
		//setResizable(false);
		setLayout(null);
		Font font = new Font("papyrus", Font.BOLD, 20);
		
		lblHeading = new JLabel(" Vehicle List ");
		lblHeading.setBounds(430 , 50 , 150, 50);
		lblHeading.setFont(font);
		
		btnBack = new JButton("  Back  ");
		
		option = new JOptionPane();
		frame = new JFrame();
		
		btnViewAll = new JButton( " View All ");
		dfTable = new DefaultTableModel();
		dfTable.addColumn(" VEHICLE ID ");
		dfTable.addColumn(" VEHICLE NAME ");
		dfTable.addColumn(" TYPE ");
		dfTable.addColumn(" REGISTRATION No. ");
		dfTable.addColumn(" SEATING CAPACITY");
		dfTable.addColumn(" FARE pER KM ");
		
		table = new JTable(dfTable);
	//	table.setSize(500, 50);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(200, 100, 600, 150);
		
		//**
		
		btnBack.setBounds(10, 10, 90, 30);
		
		//**
		
		add(lblHeading );
		add(scrollPane);
		add(btnBack);
		
		addWindowListener(new VehicleViewAllListener(this));    
		btnBack.addActionListener(new VehicleViewAllListener(this));
	
		setVisible(true);
	}
}
