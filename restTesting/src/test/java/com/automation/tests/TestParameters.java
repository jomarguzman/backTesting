package com.automation.tests;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestParameters {
	
	Logger logger = LoggerFactory.getLogger(TestParameters.class);
	
	@Test(groups = "secondTestPartThree")
	public void parametersComments() {
		
		logger.info("Running 2nd Test case part 3");
		
		Response res = RestAssured
				.given()
					.queryParam("postId", 1)
				.when()
					.get("https://jsonplaceholder.typicode.com/comments");
		logger.info("Response body: {}", res.body().asString());
		Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test(groups = "secondTestPartThree")
	public void parametersPosts() {
		
		logger.info("Running 2nd Test case part 3");
		
		Response res = RestAssured
				.given()
					.queryParam("userId", 1)
				.when()
					.get("https://jsonplaceholder.typicode.com/posts");
		logger.info("Response body: {}", res.body().asString());
		Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_OK);
	}

}
