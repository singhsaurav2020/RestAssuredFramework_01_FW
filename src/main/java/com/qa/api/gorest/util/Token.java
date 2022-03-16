package com.qa.api.gorest.util;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import io.restassured.path.json.JsonPath;

public class Token {

	public static String client__id = "2983eba32ece491";
	
	public static Map<Object, Object> appTokenMap;
	public static Map<String, String> tokenMap = new HashMap<String, String>();
	// Client-ID 2983eba32ece491


	public static Map<Object, Object> getAccessToken() {
		/**
		 * "access_token": "ae66c6318a7a5f0e782866d7b7a42fc95e846cc8", "expires_in":
		 * 315360000, "token_type": "bearer", "scope": null, "refresh_token":
		 * "212c3927fed56e584bfae80c2a09ed9682264789", "account_id": 160690917,
		 * "account_username": "sauravsingh01"
		 */

		Map<String, String> formParams = new HashedMap<String, String>();
		formParams.put("refresh_token", "26fdd65678a920cb40a8c74dd8fd0096cdb7e733");
		formParams.put("client_id", client__id);
		formParams.put("client_secret", "87b9f0afd7e3337c1ee9e213557ef52fa48085e9");
		formParams.put("grant_type", "refresh_token");

		JsonPath tokenJson = given().formParams(formParams)
				.when().post("https://api.imgur.com/oauth2/token")
				.then()
				.extract()
				.jsonPath();

		System.out.println(tokenJson.getMap(""));

		appTokenMap = tokenJson.getMap("");
		return appTokenMap;
	}

	public static Map<String, String> getAuthToken() {
		String authToken = appTokenMap.get("access_token").toString();
		System.out.println("Auth Token =====>" + authToken);
		tokenMap.put("Authorization", "Bearer " + authToken);
		return tokenMap;
	}

	public static Map<String, String> getClientId() {
		System.out.println("client__id =====>" + client__id);
//		tokenMap.put("Authorization", "Client-ID "+client__id); // Client-ID 2983eba32ece491
		tokenMap.put("Authorization", "Client-ID 2983eba32ece491");
		return tokenMap;
	}

}
