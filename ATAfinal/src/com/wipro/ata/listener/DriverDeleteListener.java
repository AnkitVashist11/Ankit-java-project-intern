package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.DriverDeleteForm;

public class DriverDeleteListener implements ActionListener
{
	DriverDeleteForm objdel;
	public DriverDeleteListener(DriverDeleteForm objdel)
	{
		this.objdel=objdel;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		Administrator objadmin=new Administrator();
		DriverBean driverBean=new DriverBean();
		
		if(e.getSource()==objdel.btnDelete)
		{
			int number;
			String result;
			if(objdel.txtId.getText().equals(""))
			{
				result="Please Enter Driver Id";
				JOptionPane.showMessageDialog(objdel.frame,result);
				
			}
			else
			{ 
				DriverBean driverBean2=null;
				driverBean2=objadmin.findById(objdel.txtId.getText());
				if(driverBean2 ==null)
				{
					JOptionPane.showMessageDialog(objdel.frame,"Id does not exists");
				}
				else
				{
					int btnYes=JOptionPane.showConfirmDialog(null, "Do you really want to Delete ?");
					if(btnYes==JOptionPane.YES_OPTION)
					{
						number=objadmin.deleteDriver(objdel.txtId.getText());
						if(number>0)

						{
							JOptionPane.showMessageDialog(objdel.frame,"Driver Dismissed");
							new AdminUI().setVisible(true);
							objdel.dispose();
						}
						else if(number==-1)
						{
							JOptionPane.showMessageDialog(objdel.frame,"Driver is already alotted");
						}
						else
						{
							JOptionPane.showMessageDialog(objdel.frame,"Id does not exists");
						}
					}

					if(btnYes==JOptionPane.NO_OPTION)
					{
						objdel.txtId.setText("");
					}
					if(btnYes==JOptionPane.CANCEL_OPTION)
					{
						objdel.txtId.setText("");
					}
				}
			}
		}
	
		else if(e.getSource()==objdel.btnBack)
		{
			new AdminUI().setVisible(true);
			objdel.dispose();
		}
		else if(e.getSource()==objdel.btnCancel)
		{
			objdel.txtId.setText("");
		}
	}
}
