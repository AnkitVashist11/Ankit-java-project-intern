package com.wipro.ata.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.wipro.ata.listener.BookingDetailsViewListener;

public class BookingDetailsViewForm
{
	 public JFrame frame;
	 public JPanel panel=new JPanel();
	 public JTextField txtSource,txtDestination;
     public JLabel lblSource,lblDestination,lblDate,titleLabel;
	 public JButton btnView,btnCancel,btnBack;
	 public JScrollPane scrollpane;
	 public DefaultTableModel dfTableModel;
	 public JTable table;
	 public Object col[]=new Object[11];
	 public JDateChooser cDate;
	  
   public BookingDetailsViewForm()
   {
	   frame=new JFrame();
	  frame.setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
	 // frame.setVisible(true);
	   frame.setSize(1020,750);
	  
	   frame.setTitle("ADMIN VIEW BOOKING DETAILS");
	   frame.setLayout(null);
	  // panel.setLayout(null);
	   titleLabel=new JLabel("View Booking Details");
	   titleLabel.setFont(new Font("Papyrus",Font.BOLD,20));
	   titleLabel.setBounds(400,50,225,25);
	   lblSource=new JLabel("SOURCE");
	   lblSource.setBounds(400,100,125,25);
	   lblDestination=new JLabel("DESTINATION");
	   lblDestination.setBounds(400,150,125,25);
	   lblDate=new JLabel("DATE");
	   lblDate.setBounds(400,200,125,25);
	  
	   txtSource=new JTextField(20);
	   txtSource.setBounds(500,100,125,25);
	   txtDestination=new JTextField(20);
	   txtDestination.setBounds(500,150,125,25);
	   
	   btnView=new JButton("VIEW");
	   btnView.setBounds(350,250,125,25);
	   btnCancel=new JButton("CANCEL");
	   btnCancel.setBounds(520,250,125,25);
	   btnBack=new JButton("BACK");
	   btnBack.setBounds(10,10,100,25);
	  
	   cDate=new JDateChooser();
	   cDate.setLocale(Locale.US);
	   //cDate.setMinSelectableDate(new Date()); //for showing date from before now
	   //cDate.setMaxSelectableDate(new Date());//for showing date from now onwards
	   cDate.setBounds(500,200,125,25);
	   txtSource.setToolTipText("Enter Valid Source ");
	   txtDestination.setToolTipText("Enter Valid Destination");
	   
	    dfTableModel=new DefaultTableModel();
		dfTableModel.addColumn("reservation Id");
		dfTableModel.addColumn("User Id");
		dfTableModel.addColumn("Vehicle Id");
		dfTableModel.addColumn("Route Id");
		dfTableModel.addColumn("Booking Date");
		dfTableModel.addColumn("Journey Date");
		dfTableModel.addColumn("Driver Id");
        dfTableModel.addColumn("Booking Status");
        dfTableModel.addColumn("Total Fare");
        dfTableModel.addColumn("Boarding Point");
        dfTableModel.addColumn("Drop Point");

       /* ImageIcon imageIcon = new ImageIcon("D:\\AN766536(3rd system)\\ATAproject\\src\\com\\wipro\\ata\\ui\\ata4.jpg");
 	   frame.setContentPane(new JLabel(imageIcon));*/

		
		
		table=new JTable(dfTableModel);
		table.setSize(700,600);
		scrollpane=new JScrollPane(table);
		scrollpane.setSize(700,600);
		scrollpane.setBounds(100,350,800,200);

         btnView.setToolTipText("Click Here To View Booking Details");
		 btnCancel.setToolTipText("Click Here To Cancel Entered Values");
		 btnBack.setToolTipText("Click Here To Go Back");
		 frame.add(titleLabel);
		 frame.add(lblSource); // panel.add(lblSource);
		 frame.add(txtSource); //  panel.add(txtSource);
		 frame.add(lblDestination); // panel.add(lblDestination);
		 frame.add(txtDestination);// panel.add(txtDestination);
		 frame.add(lblDate);// panel.add(lblDate);
		 frame.add(cDate);// panel.add(cDate);
		 frame.add(btnView);//  panel.add(btnView);
		 frame.add(btnCancel);// panel.add(btnCancel);
		 frame.add(btnBack);//  panel.add(btnBack);
		 frame.add(scrollpane);//   panel.add(scrollpane);
	   
	   

	 //  frame.add(panel);
	   btnView.addActionListener(new BookingDetailsViewListener(this));
	   btnCancel.addActionListener(new BookingDetailsViewListener(this));
       btnBack.addActionListener(new BookingDetailsViewListener(this));
       
       frame.setVisible(true);

   }
	public static void main(String[] args) 
	{
		new BookingDetailsViewForm();

	}

}

