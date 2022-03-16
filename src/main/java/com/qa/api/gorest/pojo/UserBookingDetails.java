package com.qa.api.gorest.pojo;

public class UserBookingDetails {
	// class variables
	private String firstname;
	private String lastname;
	private String totalprice;
	private String depositpaid;
	private Bookingdates bookingdates;
	private AdditionalNeeds additionalneeds;
	
	// constructor
	public UserBookingDetails(String firstname, String lastname, String totalprice, String depositpaid, Bookingdates bookingdates, AdditionalNeeds additionalneeds) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}

	// getter & setter methods
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public String getDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(String depositpaid) {
		this.depositpaid = depositpaid;
	}	
	
	public Bookingdates getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(Bookingdates bookingdates) {
		this.bookingdates = bookingdates;
	}
	
	public AdditionalNeeds getAddneeds() {
		return additionalneeds;
	}

	public void setAddneeds(AdditionalNeeds additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
}
