package com.automation.tests;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestREST {
	
	Logger logger = LoggerFactory.getLogger(TestREST.class);
	
	@Test( groups="firstTest")
	public void validateCodeResponse() {
		logger.info("Running 1st Test case");
		
		Response res = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/");
		logger.info("Response code: {}", res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_OK);
	}

}
