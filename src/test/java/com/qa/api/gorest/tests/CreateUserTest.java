package com.qa.api.gorest.tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;

import io.restassured.response.Response;

public class CreateUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "7026f809a5ef8f3a2817e6dafa1ec4ead4869ef61c6d62c45d4704caf2b31998";

	@DataProvider
	public Object[][] getUserData() {
		Object userData[][] = ExcelUtil.getTestData("userdata");
		return userData;
	}

	@Test(dataProvider = "getUserData", priority = 2)
	public void createUserAPITest_03Test(String name, String email, String gender, String status) {
//		User user = new User("Saurav Rawat 02", "saurav02@gmail.com", "male", "active");
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);
		
		User user = new User(name, email, gender, status);

		Response response = RestClient.doPost("JSON", baseURI, basePath, authTokenMap, null, true, user);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		System.out.println("===========================");
	}

}
