package com.wipro.carrental.bean;

import java.util.Date;

public class CarBookingBean 
{  private String bookingId;
   private Date DateOfHire;
   private String cartype;
   private String customerName;
   private String phoneNumber;
   
		public String getBookingId() {
			return bookingId;
		}
		public void setBookingId(String bookingId) {
			this.bookingId = bookingId;
		}
		public Date getDateOfHire() {
			return DateOfHire;
		}
		public void setDateOfHire(Date dateOfHire) {
			DateOfHire = dateOfHire;
		}
		public String getCartype() {
			return cartype;
		}
		public void setCartype(String cartype) {
			this.cartype = cartype;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		   
 }
