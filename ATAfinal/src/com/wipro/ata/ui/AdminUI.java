package com.wipro.ata.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.wipro.ata.listener.AdminListener;

public class AdminUI extends JFrame
{
	public JFrame frame;
	public JLabel titleLabel,l1;
	public JButton logoutButton;
	public JMenuBar menubar;
	public JMenu vehicleMenu,routeMenu,driverMenu,allotDriver,viewDetails,viewRoute,viewVehicle;
	public JMenuItem addVehicle,deleteVehicle,modifyVehicle,viewAllVehicle,viewVehicleById,addDriver,deleteDriver,modifyDriver,viewAllRoutes,viewRouteById,addRoute,deleteRoute,modifyRoute;
	public AdminUI()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setTitle("Admin Page");
		setSize(1000,750);
		setLayout(null);
		titleLabel=new JLabel("ADMINISTRATOR  PAGE");
		titleLabel.setFont(new Font("Papyrus", Font.BOLD,20));
		titleLabel.setBounds(340,120,350,25);
		menubar=new JMenuBar();
		vehicleMenu=new JMenu("Vehicle Operations");
		routeMenu=new JMenu("Route Operations");
		driverMenu=new JMenu("Driver Operations");
		allotDriver=new JMenu("Allot Driver to Customer");
		viewDetails=new JMenu("View Customer Details");
		addVehicle=new JMenuItem("Add Vehicle");
		deleteVehicle=new JMenuItem("Delete Vehicle");
		viewVehicle=new JMenu("View Vehicle");
		modifyVehicle=new JMenuItem("Modify Vehicle");
		addRoute=new JMenuItem("Add Route");
		deleteRoute=new JMenuItem("Delete Route");
		viewRoute=new JMenu("View Route");
		modifyRoute=new JMenuItem("Modify Route");
		addDriver=new JMenuItem("Add Driver");
		deleteDriver=new JMenuItem("Delete Driver");
		modifyDriver=new JMenuItem("Modify Driver");
		viewAllRoutes=new JMenuItem("View All Routes");
		viewRouteById=new JMenuItem("View Route By Id");
		viewAllVehicle=new JMenuItem("View All Vehicles");
		viewVehicleById=new JMenuItem("View Vehicle By Id");
		viewVehicle.add(viewAllVehicle);
		viewVehicle.add(viewVehicleById);
		viewRoute.add(viewAllRoutes);
		viewRoute.add(viewRouteById);
		vehicleMenu.add(addVehicle);
		vehicleMenu.add(deleteVehicle);
		vehicleMenu.add(viewVehicle);
		vehicleMenu.add(modifyVehicle);
		routeMenu.add(addRoute);
		routeMenu.add(deleteRoute);
		routeMenu.add(viewRoute);
		routeMenu.add(modifyRoute);
		driverMenu.add(addDriver);
		driverMenu.add(deleteDriver);
		driverMenu.add(modifyDriver);
		menubar.add(vehicleMenu);
		menubar.add(routeMenu);
		menubar.add(driverMenu);
		menubar.add(allotDriver);
		menubar.add(viewDetails);
		menubar.setBounds(145,260,650,25);
		l1=new JLabel("Click To Perform The Desired Operation");
		l1.setFont(new Font("",Font.PLAIN,18));
		l1.setBounds(335,200,350,25);
		logoutButton=new JButton("Logout");
		logoutButton.setBounds(10,10,75,25);
		add(logoutButton);
		add(titleLabel);
		add(l1);
		add(menubar);
		logoutButton.addActionListener(new AdminListener(this));
		addDriver.addActionListener(new AdminListener(this));
		deleteDriver.addActionListener(new AdminListener(this));
		modifyDriver.addActionListener(new AdminListener(this));
		allotDriver.addMenuListener(new AdminListener(this));
		viewDetails.addMenuListener(new AdminListener(this));
		addVehicle.addActionListener(new AdminListener(this));
		deleteVehicle.addActionListener(new AdminListener(this));
		modifyVehicle.addActionListener(new AdminListener(this));
		viewAllVehicle.addActionListener(new AdminListener(this));
		viewVehicleById.addActionListener(new AdminListener(this));
		addRoute.addActionListener(new AdminListener(this));
		deleteRoute.addActionListener(new AdminListener(this));
		modifyRoute.addActionListener(new AdminListener(this));
		viewAllRoutes.addActionListener(new AdminListener(this));
		viewRouteById.addActionListener(new AdminListener(this));
	}
	public static void main(String[] args) 
	{
		new AdminUI().setVisible(true);
	}
}

