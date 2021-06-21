package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.service.Customer;
import com.wipro.ata.ui.CustomerViewRouteForm;

public class CustomerViewRouteListener implements ActionListener
{
	CustomerViewRouteForm obj;
	
  public CustomerViewRouteListener(CustomerViewRouteForm in)
  {
	  obj=in;
  }

	@Override
	public void actionPerformed(ActionEvent e)
	{
      if(e.getSource()==obj.btnView)
      {
    	  if(obj.txtSource.getText().isEmpty() || obj.txtDestination.getText().isEmpty())
			{	
				
				JOptionPane.showMessageDialog(obj.frame, "Mandatory to fill all Fields");
			}
			else
			{ 
				
				if(obj.txtSource.getText()==null || obj.txtDestination.getText() ==null )
				 {
					JOptionPane.showMessageDialog(obj.frame,"Fill All Details");
				 }
				else if(obj.txtSource.getText().trim().length() <2 || obj.txtDestination.getText().trim().length()<2) 
				 {
					 JOptionPane.showMessageDialog(obj.frame,"ATLEAST 2 CHARACTER VALUES MUST BE ENTER FOR SOURCE & DESTINATION");
				 }
				else if(obj.txtSource.getText().trim().equalsIgnoreCase(obj.txtDestination.getText().trim()))
				 {
					JOptionPane.showMessageDialog(obj.frame,"SOURCE AND DESTINATION CAN'T BE SAME");

				 }
				else if (!(obj.txtSource.getText().trim().matches("[a-zA-Z ]+")) && !(obj.txtDestination.getText().trim().matches("[a-zA-Z ]+")))
	            {
	              JOptionPane.showMessageDialog(null, "Please enter a valid character For SOURCE and DESTINATION", "Error", JOptionPane.ERROR_MESSAGE);
	            }
			   
	            else if(!(obj.txtSource.getText().trim().matches("[a-zA-Z ]+")))
	            {
	         	   JOptionPane.showMessageDialog(null, "Please Enter Valid Character For Source");
	            }
	            else if(!(obj.txtDestination.getText().trim().matches("[a-zA-Z ]+")))
	            {
	         	   JOptionPane.showMessageDialog(null, "Please Enter Valid Character For Destination");
	            }
	            else if(obj.txtSource.getText().trim().length()>20)             
	            {
		          JOptionPane.showMessageDialog(null, "FAILED: YOU EXCEED THE ENTRY LIMIT OF 20 CHARACTER Of SOURCE");

	            } 
	            else if(obj.txtDestination.getText().trim().length()>20)             
	            {
		          JOptionPane.showMessageDialog(null, "FAILED: YOU EXCEED THE ENTRY LIMIT OF 20 CHARACTER Of DESTINATION");

	            }
	            else
				{   
	            	
	            	obj.dfTableModel.getDataVector().removeAllElements();
			    	 // obj.btnView.setVisible(true);
			    	  //obj.btnBack.setVisible(true);
			  		String source=obj.txtSource.getText().trim().toUpperCase();
			  		String destination=obj.txtDestination.getText().trim().toUpperCase();
			  		
			  		
			  		
			  		Customer customerService=new Customer();
			  		
			  		ArrayList<RouteBean> list=null;
			  		
			  		
			  		list=customerService.viewRoutesBySourceAndByDestination(source, destination);
                    
                    if(!list.isEmpty())
	                 {
                    	obj.scrollpane.setVisible(true);
				  		Iterator<RouteBean>itr=list.iterator();
						while(itr.hasNext())
						{
							RouteBean routeBean=new RouteBean();
							routeBean=itr.next();
							obj.col[0]=routeBean.getRouteID();
							obj.col[1]=routeBean.getSource().trim().toUpperCase();
							obj.col[2]=routeBean.getDestination().trim().toUpperCase();
							obj.col[3]=routeBean.getDistance();
							obj.col[4]=routeBean.getTravelDuration();
							
							obj.dfTableModel.addRow(obj.col);
						}
	                 }
						  		/*JTable table;
						  		table=new JTable(row,col);
						  		
						  		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
								table.getColumnModel().getColumn(0).setPreferredWidth(27);
						  		
						  		JScrollPane scroll =new JScrollPane(table);
						  		
						  		obj.panel.add(scroll);
						  		obj.frame.add(obj.panel);*/
	                
                    else
                    {
                    	obj.scrollpane.setVisible(false);
     	         	   JOptionPane.showMessageDialog(null, "SORRY: CURRENTLY NO ROUTE AVAILABLE FOR THIS, WE TRY TO ADD YOUR REQUESTED ROUTE SOON");

                    }
			    }
				
			}
      }
      else if(e.getSource()==obj.btnCancel)
      {
    	 obj.txtSource.setText("");
    	 obj.txtDestination.setText("");
      }
      else if(e.getSource()==obj.btnBack)
      {
    	  obj.frame.setVisible(false);
      }

		
	}
}

