package com.qa.api.gorest.restclient;

import java.util.Map;

//import io.restassured.
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.gorest.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is having all http methods which will call the apis and having
 * generic methods for getting the response and fetch the values from response.
 * 
 * @author sauravsinghrawat
 *
 */

public class RestClient {

	// HTTP Methods : GET, PUT, POST, DELETE

	/**
	 * This method is used to call GET api
	 * 
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @return this method is returning response from the GET call
	 */

	public static Response doGet(String contentType, String baseURI, String basePath, Map<String, String> token,
			Map<String, String> paramsMap, boolean log) {

		if (setBaseURI(baseURI)) {
			RequestSpecification request = createRequest(contentType, token, paramsMap, log);
			return getResponse("GET", request, basePath);
		}
		return null;

	}

	/**
	 * This method is used to call POST api
	 * 
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @param obj
	 * @return this method is returning response from the POST call
	 */
	public static Response doPost(String contentType, String baseURI, String basePath, Map<String, String> token,
			Map<String, String> paramsMap, boolean log, Object obj) {

		if (setBaseURI(baseURI)) {
			RequestSpecification request = createRequest(contentType, token, paramsMap, log);
			addRequestPayLoad(request, obj);
			return getResponse("POST", request, basePath);
		}
		return null;
	}

	private static void addRequestPayLoad(RequestSpecification request, Object obj) {
		if (obj instanceof Map) {
			request.formParams((Map<String, String>) obj);
		} else {
			String jsonPayLoad = TestUtil.getSerializedJSON(obj);
			request.body(jsonPayLoad);
		}
	}

	private static boolean setBaseURI(String baseURI) {
		if (baseURI == null || baseURI.isEmpty()) {
			System.out.println("Please pass the correct base URI, either it is null OR Empty/Blank");
			return false;
		}
		try {
			RestAssured.baseURI = baseURI;
			return true;
		} catch (Exception e) {
			System.out.println("Some exception got occured while assigning the base URI with Rest Assured");
			return false;
		}
	}

	private static RequestSpecification createRequest(String contentType, Map<String, String> token,
			Map<String, String> paramsMap, boolean log) {
		RequestSpecification request;

		// Required lops or not
		if (log) {
			request = RestAssured.given().log().all();
		} else {
			request = RestAssured.given();
		}

		// Passing the token ID
		if (token == null) {

		} else if (token.size() > 0) {
//			request.header("Authorization", "Bearer " + token);
			request.headers(token);
		}

		// Passing the Parameters
		if (!(paramsMap == null)) {
			request.queryParams(paramsMap);
		}

		// Passing the Content Type
		if (contentType != null) {
			if (contentType.equalsIgnoreCase("JSON")) {
				request.contentType(ContentType.JSON);
			} else if (contentType.equalsIgnoreCase("XML")) {
				request.contentType(ContentType.XML);
			} else if (contentType.equalsIgnoreCase("TEXT")) {
				request.contentType(ContentType.TEXT);
			} else if (contentType.equalsIgnoreCase("multipart")) {
				request.multiPart("image", new File("src/main/java/com/qa/api/gorest/testdata/whatsapp.jpeg"));
			}
		}
		return request;
	}

	private static Response getResponse(String httpMethod, RequestSpecification request, String basePath) {
		return executeAPI(httpMethod, request, basePath);
	}

	private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath) {
		Response response = null;
		switch (httpMethod) {
		case "GET":
			response = request.get(basePath);
			break;
		case "POST":
			response = request.post(basePath);
			break;
		case "PUT":
			response = request.put(basePath);
			break;
		case "DELETE":
			response = request.delete(basePath);
			break;
		default:
			System.out.println("Please pass the correct http method....");
			break;
		}
		return response;
	}

}
