package com.qa.api.gorest.pojo;

public class UserResult {

	public static UserBookingDetails getUserdetailsData() {
		Bookingdates bd = new Bookingdates("2022-01-01", "2022-01-02");
		AdditionalNeeds needs = new AdditionalNeeds("Dosa");
		UserBookingDetails userdetails = new UserBookingDetails("SaURaV", "RaWaT", "007", "true", bd, needs);
		return userdetails;
	}

}
