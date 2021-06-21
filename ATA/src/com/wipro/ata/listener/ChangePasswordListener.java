package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.ui.ChangePasswordUI;
import com.wipro.ata.ui.LoginUI;
import com.wipro.ata.util.User;

public class ChangePasswordListener implements ActionListener
{
	ChangePasswordUI cpui;
	public ChangePasswordListener(ChangePasswordUI cpui)
	{
		this.cpui=cpui;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==cpui.okButton)
		{
			if(cpui.userIdText.getText().isEmpty() || cpui.newPasswordText.getText().isEmpty() || cpui.passwordText.getText().isEmpty()||cpui.confirmPasswordText.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(cpui.frame,"Please fill all the fields..");
			}
			else if(cpui.newPasswordText.getText().charAt(0)==' ')
			{
				JOptionPane.showMessageDialog(cpui.frame,"Password cannot start with space..");
			}
			else if(cpui.newPasswordText.getText().charAt(0)<48 || cpui.newPasswordText.getText().charAt(0)>122 || (cpui.newPasswordText.getText().charAt(0)>90 && cpui.newPasswordText.getText().charAt(0)<97)|| (cpui.newPasswordText.getText().charAt(0)>57 && cpui.newPasswordText.getText().charAt(0)<65))
			{
				JOptionPane.showMessageDialog(cpui.frame,"Password's first letter should be alphanumeric only...");
			}
			else if(cpui.newPasswordText.getText().length()<9)
			{
				JOptionPane.showMessageDialog(cpui.frame,"Password should be greater than eight characters...");
			}
			else if(cpui.newPasswordText.getText().length()>20)
			{
				JOptionPane.showMessageDialog(cpui.frame,"Password length should not be greater than 20 characters...");
			}
			else if(cpui.confirmPasswordText.getText().charAt(0)==' ')
			{
				JOptionPane.showMessageDialog(cpui.frame,"Password cannot start with space..");
			}
			else if(cpui.confirmPasswordText.getText().charAt(0)<48 || cpui.confirmPasswordText.getText().charAt(0)>122 || (cpui.newPasswordText.getText().charAt(0)>90 && cpui.newPasswordText.getText().charAt(0)<97)|| (cpui.newPasswordText.getText().charAt(0)>57 && cpui.newPasswordText.getText().charAt(0)<65))
			{
				JOptionPane.showMessageDialog(cpui.frame,"Password's first letter should be alphanumeric only...");
			}
			else if(cpui.confirmPasswordText.getText().length()<9)
			{
				JOptionPane.showMessageDialog(cpui.frame,"Password should be greater than eight characters...");
			}
			else if(cpui.confirmPasswordText.getText().length()>20)
			{
				JOptionPane.showMessageDialog(cpui.frame,"Password length should not be greater than 20 characters...");
			}
			else if(!cpui.newPasswordText.getText().equals(cpui.confirmPasswordText.getText()))
			{
				JOptionPane.showMessageDialog(cpui.frame,"Both passwords did not match.Please enter new password again");
				cpui.newPasswordText.setText("");
				cpui.confirmPasswordText.setText("");
			}
			else
			{
				CredentialsBean cb=new CredentialsBean();
				User user=new User();
				cb.setUserID(cpui.userIdText.getText());
				cb.setPassword(cpui.passwordText.getText());
				try 
				{
					String s=user.changePassword(cb,cpui.newPasswordText.getText());
					JOptionPane.showMessageDialog(cpui.frame,"Password Changed Successfully");
					cpui.dispose();
					new LoginUI().setVisible(true);
				} 
				catch (ClassNotFoundException e1) 
				{
					e1.printStackTrace();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==cpui.cancelButton)
		{
			cpui.userIdText.setText("");
			cpui.passwordText.setText("");
			cpui.newPasswordText.setText("");
			cpui.confirmPasswordText.setText("");
		}
		if(e.getSource()==cpui.backButton)
		{
			cpui.dispose();
			new LoginUI().setVisible(true);
		}
		
	}

}
