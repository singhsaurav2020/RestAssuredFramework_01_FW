package com.qa.api.gorest.tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.Credentials;
import com.qa.api.gorest.pojo.UserBookingDetails;
import com.qa.api.gorest.pojo.UserResult;
import com.qa.api.gorest.restclient.RestClient;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestfulBookerHerokuapp {

	public static UserBookingDetails userPayload;
	public static String bookingId;

	@Test(priority = 8)
	public void getToken_RestfulBookerHerokuappAPItest_01Test() {

		Credentials cred = new Credentials("admin", "password123");

		Response response = RestClient.doPost("JSON", "https://restful-booker.herokuapp.com", "/auth", null, null, true,
				cred);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}

	@Test(priority = 9)
	public void postBookingTicket_RestfulBookerHerokuappAPItest_02Test() {

		userPayload = UserResult.getUserdetailsData();
		Response response = RestClient.doPost("JSON", "https://restful-booker.herokuapp.com", "/booking", null, null,
				true, userPayload);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
		JsonPath js = response.jsonPath();
		bookingId = js.get("bookingid").toString();
		System.out.println("bookingid ====>"+bookingId);
	}
	
	@Test(priority = 10)
	public void getUserBookingDetails_RestfulBookerHerokuappAPItest_03Test() {
		
		postBookingTicket_RestfulBookerHerokuappAPItest_02Test();
		Response response = RestClient.doGet("JSON", "https://restful-booker.herokuapp.com", "/booking/"+bookingId, null, null, true);

		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}

}
