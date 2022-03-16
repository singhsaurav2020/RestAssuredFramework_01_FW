package com.qa.api.gorest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

	/**
	 * This method is used to convert POJO object to JSON String.
	 * 
	 * @param obj
	 * @return jsonString
	 */
	public static String getSerializedJSON(Object obj) {

		// Create ObjectMapper object of JACKSON API
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(obj); // throws JsonProcessingException
			System.out.println("JSON Body PayLoad ===>"+jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
}
