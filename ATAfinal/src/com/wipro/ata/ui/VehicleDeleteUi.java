package com.wipro.ata.ui;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.wipro.ata.listener.VehicleDeleteListener;

public class VehicleDeleteUi extends JFrame
{
	public static JLabel lblVehicleId , lblHeading;
	public static JTextField txtVehicleId ;
	public static JButton btnDelete , btnBack , btnCancel;
	public static JOptionPane option;
	public static JFrame frame;
	public static Choice cVehicleId;
	
	public static void main(String args[])
	{
		VehicleDeleteUi ui = new VehicleDeleteUi();
	}
	
	public VehicleDeleteUi()
	{
		setContentPane(new JLabel(new ImageIcon("src\\image.jpg")));
		
		setSize(1020,750);
		setTitle("Vehicle Deletion");
	//	setLocation(100,100);
		setLayout(null);
		setResizable(false);
		
		Font font = new Font("Verdana", Font.BOLD, 17);
		Font font1 = new Font("papyrus", Font.BOLD, 20);
		
		frame = new JFrame();
		option = new JOptionPane();
		
		lblHeading = new JLabel(" Delete Vehicle ");
		lblHeading.setBounds(430, 50, 270, 50);
		lblHeading.setFont(font1);
		
		lblVehicleId = new JLabel("Enter Vehicle id to delete a vehicle");
		lblVehicleId.setBounds(350, 100, 350, 50);
		lblVehicleId.setFont(font);
		
		//txtVehicleId = new JTextField(20);
		//txtVehicleId.setBounds(410, 150, 200, 30);
		//txtVehicleId.setToolTipText("Enter vehicle id");
		cVehicleId = new Choice();
		cVehicleId.setBounds(410, 150, 200, 30);
		
		btnDelete = new JButton(" Delete ");
		btnDelete.setBounds(410, 200, 90, 30);
		
		btnBack = new JButton(" Back ");
		btnBack.setBounds(10, 10, 90, 30);
		
		btnCancel = new JButton(" Cancel ");
		btnCancel.setBounds(520, 200, 90, 30);
		
		add(lblHeading);			add(cVehicleId);
		add(lblVehicleId);			//add(txtVehicleId);
		add(btnDelete);				add(btnBack);
		add(btnCancel);	
		
		addWindowListener(new VehicleDeleteListener(this));
		cVehicleId.addItemListener(new VehicleDeleteListener(this));
		btnDelete.addActionListener(new VehicleDeleteListener(this));
		btnBack.addActionListener(new VehicleDeleteListener(this));
		btnCancel.addActionListener(new VehicleDeleteListener(this));
		
		setVisible(true);
	}
}
