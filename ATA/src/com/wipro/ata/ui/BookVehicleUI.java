package com.wipro.ata.ui;

import java.awt.Choice;
import java.awt.Font;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.wipro.ata.listener.BookVehicleListener;

public class BookVehicleUI extends JFrame
{
	public JFrame frame;
	public JLabel titleLabel,sourceLabel,destinationLabel,journeyDateLabel;
	public JTextField sourceText,destinationText,journeyDateText;
	public JButton viewRouteButton;
	public JDateChooser chooser;
	public Object col[]=new Object[5];
	public DefaultTableModel model=new DefaultTableModel();
	public JTable routeTable;
	public JScrollPane routeScrollPane;
	
	public JButton viewVehicleButton;
	public Object col1[]=new Object[5];
	public DefaultTableModel model1=new DefaultTableModel();
	public JTable vehicleTable;
	public JScrollPane vehicleScrollPane;
	
	public JLabel selectRouteLabel,selectvehicleLabel;
	public Choice routeChoice,vehicleChoice;
	public JButton bookButton,btnBack;
	public BookVehicleUI()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setTitle("Book Vehicle Page");
		setSize(800,700);
		setLayout(null);
		btnBack=new JButton("Back");
		btnBack.setBounds(10,10,100,25);
		titleLabel=new JLabel("Book Vehicle");
		titleLabel.setBounds(320,20,125,25);
		titleLabel.setFont(new Font("",Font.BOLD,16));
		sourceLabel=new JLabel("Enter Source");
		sourceLabel.setBounds(70,60,125,25);
		sourceText=new JTextField(20);
		sourceText.setBounds(150,60,125,25);
		destinationLabel=new JLabel("Enter Destination");
		destinationLabel.setBounds(300,60,125,25);
		destinationText=new JTextField(20);
		destinationText.setBounds(400,60,125,25);
		journeyDateLabel=new JLabel("Journey Date");
		journeyDateLabel.setBounds(540,60,125,25);
		viewRouteButton=new JButton("View Route");
		viewRouteButton.setBounds(320,100,100,25);
		chooser=new JDateChooser();
		chooser.setLocale(Locale.US);
		chooser.setMinSelectableDate(new Date());
		add(chooser);
		chooser.setBounds(640,60,125,25);
		JTextFieldDateEditor editor=(JTextFieldDateEditor) chooser.getDateEditor();
		editor.setEditable(false);
		model.addColumn("Route ID");
		model.addColumn("Source");
		model.addColumn("Destination");
		model.addColumn("Distance(KM)");
		model.addColumn("Travel Duration(Hrs)");
		routeTable=new JTable(model);
		routeTable.setSize(650,100);
		routeScrollPane=new JScrollPane(routeTable);
		routeScrollPane.setBounds(60,140,125,25);
		routeScrollPane.setSize(650,100);
		routeScrollPane.setVisible(false);
		viewVehicleButton=new  JButton("View Available Vehicles");
		viewVehicleButton.setBounds(280,260,180,25);
		viewVehicleButton.setVisible(false);
		
		model1.addColumn("Vehicle ID");
		model1.addColumn("Name");
		model1.addColumn("Type");
		model1.addColumn("SeatingCapacity");
		model1.addColumn("Fare Per KM(In Rs)");
		vehicleTable=new JTable(model1);
		vehicleTable.setSize(650,100);
		vehicleScrollPane=new JScrollPane(vehicleTable);
		vehicleScrollPane.setBounds(60,300,125,25);
		vehicleScrollPane.setSize(650,100);
		vehicleScrollPane.setVisible(false);
		
		selectRouteLabel=new JLabel("Select RouteId");
		selectRouteLabel.setBounds(200,430,125,25);
		routeChoice=new Choice();
		routeChoice.setBounds(290,430,75,25);
		add(routeChoice);
		selectvehicleLabel=new JLabel("Select VehicleId");
		selectvehicleLabel.setBounds(400,430,95,25);
		add(selectvehicleLabel);
		vehicleChoice=new Choice();
		vehicleChoice.setBounds(500,430,75,25);
		bookButton=new JButton("BOOK");
		bookButton.setBounds(330,490,75,25);
		selectRouteLabel.setVisible(false);
		routeChoice.setVisible(false);
		selectvehicleLabel.setVisible(false);
		vehicleChoice.setVisible(false);
		bookButton.setVisible(false);
		add(bookButton);
		add(btnBack);
		add(vehicleChoice);
		add(selectRouteLabel);
		add(vehicleScrollPane);
		add(routeScrollPane);
		add(titleLabel);
		add(sourceLabel);
		add(sourceText);
		add(destinationLabel);
		add(destinationText);
		add(journeyDateLabel);
		add(viewRouteButton);
		add(viewVehicleButton);
		viewRouteButton.addActionListener(new BookVehicleListener(this));
		viewVehicleButton.addActionListener(new BookVehicleListener(this));
		routeChoice.addItemListener(new BookVehicleListener(this));
		vehicleChoice.addItemListener(new BookVehicleListener(this));
		bookButton.addActionListener(new BookVehicleListener(this));
		btnBack.addActionListener(new BookVehicleListener(this));
	}
	public static void main(String args[])
	{
		new BookVehicleUI().setVisible(true);
	}
}

