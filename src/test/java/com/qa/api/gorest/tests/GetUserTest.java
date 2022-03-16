package com.qa.api.gorest.tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.Credentials;
import com.qa.api.gorest.restclient.RestClient;

import io.restassured.response.Response;

public class GetUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "7026f809a5ef8f3a2817e6dafa1ec4ead4869ef61c6d62c45d4704caf2b31998";

	@Test(priority = 1)
	public void getAllUserListAPItest_01Test() {
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, false);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));
	}
	
	@Test(priority = 3)
	public void getUserWithQueryParamsAPItest_02Test() {
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "Shaktimaan");
		params.put("gender", "male");
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, params, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));	
	}
}
