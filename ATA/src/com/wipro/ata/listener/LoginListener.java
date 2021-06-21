package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.ChangePasswordUI;
import com.wipro.ata.ui.CustomerUI;
import com.wipro.ata.ui.LoginUI;
import com.wipro.ata.ui.RegisterUI;
import com.wipro.ata.util.Authentication;
import com.wipro.ata.util.User;

public class LoginListener implements ActionListener
{
	static String userId="";
	LoginUI ui;
	public LoginListener(LoginUI ui) 
	{
		this.ui = ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==ui.loginButton)
		{
			CredentialsBean credentialsBean=new CredentialsBean();
			Authentication ath=new Authentication();
			User user=new User();
			credentialsBean.setUserID(ui.userIdtextField.getText());
			credentialsBean.setPassword(ui.passwordtextField.getText());
			/*if(ath.checkLoginStatus(ui.userIdtextField.getText(), ui.passwordtextField.getText())==1)
			{
				JOptionPane.showMessageDialog(ui.frame,"User is already Logged In");
			}
			else
			{*/
				try 
				{
					String str=user.login(credentialsBean);
					if(str.equalsIgnoreCase("a"))
					{
						new AdminUI().setVisible(true);
						ui.dispose();
						userId=ui.userIdtextField.getText();
					}
					else if(str.equalsIgnoreCase("c"))
					{
						new CustomerUI().setVisible(true);
						ui.dispose();
						userId=ui.userIdtextField.getText();
					}
					else
					{
						JOptionPane.showMessageDialog(ui.frame,str);
					}			
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
		//}
		if(e.getSource()==ui.changePasswordButton)
		{
			ui.dispose();
			new ChangePasswordUI().setVisible(true);
		}
		if(e.getSource()==ui.cancelButton)
		{
			ui.userIdtextField.setText("");
			ui.passwordtextField.setText("");
		}
		if(e.getSource()==ui.registerButton)
		{
			ui.dispose();
			new RegisterUI().setVisible(true);
		}
	}
}
