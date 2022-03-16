package com.qa.api.gorest.pojo;

public class Bookingdates {
	// class variables
	private String checkin;
	private String checkout;
	
	// constructor
	public Bookingdates(String checkin, String checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public String getCheckin() {
		return checkin;
	}
	// getter & setter methods
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	
}
