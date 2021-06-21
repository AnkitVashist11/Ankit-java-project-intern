package com.wipro.ata.listener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.ProfileBean;
import com.wipro.ata.ui.LoginUI;
import com.wipro.ata.ui.RegisterUI;
import com.wipro.ata.util.Authentication;
import com.wipro.ata.util.User;

public class RegisterListener implements ActionListener
{
	RegisterUI rui;
	static ProfileBean pb=new ProfileBean();
	public RegisterListener(RegisterUI rui) 
	{
		this.rui=rui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource()==rui.maleButton)
		{
			if(rui.maleButton.isSelected())
			{
				pb.setGender("Male");
			}
		}
		if(arg0.getSource()==rui.femaleButton)
		{
			if(rui.femaleButton.isSelected())
			{
				pb.setGender("Female");
			}
		}
		if(arg0.getSource()==rui.submitButton)
		{
			Date date1=rui.chooser.getDate();
			if(rui.firstNameText.getText().equals("") || rui.lastNameText.getText().equals("") ||rui.streetText.getText().equals("") ||rui.cityText.getText().equals("") || rui.locationText.getText().equals("") ||rui.stateText.getText().equals("") ||rui.pincodeText.getText().equals("") ||rui.mobNoText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(rui.frame,"Mandatory to fill all fields..");
			}
			else if(!rui.firstNameText.getText().trim().matches("[a-zA-Z]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"First name can only take characters..");
			}
			else if(rui.firstNameText.getText().trim().length()<2 || rui.firstNameText.getText().trim().length()>15)
			{
				JOptionPane.showMessageDialog(rui.frame,"First name's length range is between 2 to 15");
			}
			else if(!rui.lastNameText.getText().trim().matches("[a-zA-Z]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"Last name can only take characters..");
			}
			else if(rui.lastNameText.getText().trim().length()<2 || rui.lastNameText.getText().trim().length()>15)
			{
				JOptionPane.showMessageDialog(rui.frame,"Last name's length range is between 2 to 15");
			}
			else if(!rui.streetText.getText().trim().matches("[a-zA-Z0-9 ]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"Street can only take characters..");
			}
			else if(rui.streetText.getText().trim().length()<2 || rui.streetText.getText().trim().length()>30)
			{
				JOptionPane.showMessageDialog(rui.frame,"Street's length range is between 2 to 30");
			}
			else if(!rui.locationText.getText().trim().matches("[a-zA-Z ]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"Location can only take characters..");
			}
			else if(rui.locationText.getText().trim().length()<2 || rui.locationText.getText().trim().length()>15)
			{
				JOptionPane.showMessageDialog(rui.frame,"Location's length range is between 2 to 15");
			}
			else if(!rui.cityText.getText().trim().matches("[a-zA-Z ]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"City can only take characters..");
			}
			else if(rui.cityText.getText().trim().length()<2 || rui.cityText.getText().trim().length()>15)
			{
				JOptionPane.showMessageDialog(rui.frame,"City's length range is between 2 to 15");
			}
			else if(!rui.stateText.getText().trim().matches("[a-zA-Z ]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"State can only take characters..");
			}
			else if(rui.stateText.getText().trim().length()<2 || rui.stateText.getText().trim().length()>15)
			{
				JOptionPane.showMessageDialog(rui.frame,"State's length range is between 2 to 15");
			}
			else if(!rui.stateText.getText().trim().matches("[a-zA-Z ]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"State can only take characters..");
			}
			else if(rui.stateText.getText().trim().length()<2 || rui.stateText.getText().trim().length()>15)
			{
				JOptionPane.showMessageDialog(rui.frame,"State's length range is between 2 to 15");
			}
			else if(!rui.pincodeText.getText().trim().matches("[0-9]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"Pincode can only take numeric values..");
			}
			else if(rui.pincodeText.getText().trim().length()!=6)
			{
				JOptionPane.showMessageDialog(rui.frame,"Pincode's length should be 6 only...");
			}
			else if(rui.pincodeText.getText().trim().charAt(0)=='0')
			{
				JOptionPane.showMessageDialog(rui.frame,"Pincode cannot start with 0");
			}
			else if(!rui.mobNoText.getText().trim().matches("[0-9]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"Mobile No can only take numeric values..");
			}
			else if(rui.mobNoText.getText().trim().length()!=10)
			{
				JOptionPane.showMessageDialog(rui.frame,"Mobile No's length should be 10 only...");
			}
			else if(rui.mobNoText.getText().trim().charAt(0)=='0')
			{
				JOptionPane.showMessageDialog(rui.frame,"Mobile No cannot start with 0");
			}
			else if(!rui.emailIdText.getText().trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			{
				JOptionPane.showMessageDialog(rui.frame,"Invalid Email Id");
			}
			/*else if(!rui.emailIdText.getText().trim().matches("[a-zA-Z0-9_@.]+"))
			{
				JOptionPane.showMessageDialog(rui.frame,"Email-Id should be in abc@xyz.pqr format..");
			}
			else if(rui.emailIdText.getText().trim().charAt(0)=='@')
			{
				JOptionPane.showMessageDialog(rui.frame,"Email-Id should not start with @..");
			}
			else if(rui.emailIdText.getText().trim().charAt(rui.emailIdText.getText().trim().length()-1)=='.' && rui.emailIdText.getText().trim().charAt(rui.emailIdText.getText().trim().length()-1)=='@')
			{
				JOptionPane.showMessageDialog(rui.frame,"Email-Id should not end with @ or dot..");
			}
			else if(rui.emailIdText.getText().trim().length()>30)
			{
				JOptionPane.showMessageDialog(rui.frame,"E-Mail field length exceeded.Enter maximum 30 characters...");
			}
			else if(!rui.emailIdText.getText().trim().contains("@") && !rui.emailIdText.getText().trim().contains("."))
			{
				JOptionPane.showMessageDialog(rui.frame,"Invalid Email-Id");
			}
			else if(rui.emailIdText.getText().trim().charAt(0)=='.')
			{
				JOptionPane.showMessageDialog(rui.frame,"Invalid Email-Id");
			}*/
			else if(rui.maleButton.isSelected()==false && rui.femaleButton.isSelected()==false)
			{
				JOptionPane.showMessageDialog(rui.frame,"Select Gender");
			}
			else if(date1==null)
			{
				JOptionPane.showMessageDialog(rui.frame,"Enter Date of Birth");
			}
			else if(rui.passField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(rui.frame,"Please fill all the fields..");
			}
			else if(rui.passField.getText().charAt(0)==' ')
			{
				JOptionPane.showMessageDialog(rui.frame,"Password cannot start with space..");
			}
			else if(rui.passField.getText().charAt(0)<48 || rui.passField.getText().charAt(0)>122 || (rui.passField.getText().charAt(0)>90 && rui.passField.getText().charAt(0)<97)|| (rui.passField.getText().charAt(0)>57 && rui.passField.getText().charAt(0)<65))
			{
				JOptionPane.showMessageDialog(rui.frame,"Password's first letter should be alphanumeric only...");
			}
			else if(rui.passField.getText().length()<9)
			{
				JOptionPane.showMessageDialog(rui.frame,"Password should be greater than eight characters...");
			}
			else if(rui.passField.getText().length()>20)
			{
				JOptionPane.showMessageDialog(rui.frame,"Password length should not be greater than 20 characters...");
			}
			else
			{
				Authentication ath=new Authentication();
				User user=new User();
				String s=null;
				try 
				{
					SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy");
					Date date=rui.chooser.getDate();
					pb.setFirstName(rui.firstNameText.getText().trim());
					pb.setLastName(rui.lastNameText.getText().trim());
					pb.setDateOfBirth(date);
					pb.setStreet(rui.streetText.getText().trim());
					pb.setCity(rui.cityText.getText().trim());
					pb.setState(rui.stateText.getText().trim());
					pb.setLocation(rui.locationText.getText().trim());
					pb.setPincode(rui.pincodeText.getText().trim());
					pb.setEmailID(rui.emailIdText.getText().trim());
					pb.setMobileNo(rui.mobNoText.getText().trim());
					s=ath.generateUserId(pb.getFirstName());
					pb.setUserID(s);
					//rui.useridLabel.setVisible(true);
					//rui.userval.setText(s);
					//rui.userval.setFont(new Font("",Font.BOLD,20));
					//rui.useridLabel.setVisible(true);
					rui.passwordLabel.setVisible(true);
					rui.passField.setVisible(true);
					rui.okButton.setVisible(true);
					rui.submitButton.setVisible(false);
					
					

					CredentialsBean cb=new CredentialsBean();
					cb.setUserID(pb.getUserID());
					cb.setPassword(rui.passField.getText());
					try 
					{
						boolean b=ath.addUser(cb);
						if(b)
						{
							String ss=user.register(pb);
							if(ss.equals(rui.userval.getText()));
							{
								JOptionPane.showMessageDialog(rui.frame,"Registered Successfully...Your User Id is "+s);
								new LoginUI().setVisible(true);
								rui.dispose();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(rui.frame,"Problem in Registering the User...");
						}
					} 
					catch (ClassNotFoundException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		if(arg0.getSource()==rui.cancelButton)
		{
			rui.firstNameText.setText("");
			rui.lastNameText.setText("");
			rui.streetText.setText("");
			rui.cityText.setText("");
			rui.stateText.setText("");
			rui.pincodeText.setText("");
			rui.mobNoText.setText("");
			rui.emailIdText.setText("");
			rui.locationText.setText("");	
		}
		if(arg0.getSource()==rui.backButton)
		{
			rui.dispose();
			new LoginUI().setVisible(true);
		}
	}

}
