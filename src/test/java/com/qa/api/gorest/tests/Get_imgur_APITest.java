package com.qa.api.gorest.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.restassured.response.Response;

public class Get_imgur_APITest {
	
	Map<Object, Object> tokenMap;
	String accessToken;
	String refreshToken;
	String accountUsername;
	
	@BeforeMethod
	public void setUp() {
		tokenMap = Token.getAccessToken();
		accessToken = tokenMap.get("access_token").toString();
		refreshToken = tokenMap.get("refresh_token").toString();
		accountUsername = tokenMap.get("account_username").toString();
	}
	
	@Test(priority = 5)
	public void getAccountBlockStatusTest() {
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com", "/account/v1/"+accountUsername+"/block", 
				authTokenMap, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test(priority = 7)
	public void getAccountImageTest() {
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com", "/3/account/me/images", 
				authTokenMap, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test(priority = 6)
	public void uploadImagePostAPITest() {
		Map<String, String> clientIdMap = Token.getClientId();
		
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("title", "Title -  Rest Assured");
		formMap.put("description", "Desc - description description description");
		
		Response response = RestClient.doPost("multipart", "https://api.imgur.com", "/3/image", clientIdMap, null, true, formMap);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}

}
