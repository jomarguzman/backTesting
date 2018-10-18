package com.automation.tests;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CallWithHeader {
	
	Logger logger = LoggerFactory.getLogger(CallWithHeader.class);
	
	@Test (groups = "thirdTest")
	@Parameters({"headerValue"})
	public void call(String headerValue) {
		
		logger.info("Running 3rd Test case");
		
		Response res = RestAssured
				.given()
					.header("Authorization",headerValue)
					.queryParam("u", "qa")
					.queryParam("q", "publish_6847")
				.when()
					.get("https://gp_search.grey.com/gp_searchapi/search?d=id&p=t&c=t&s=publish&m=all");
		logger.info("Response body: {}", res.body().asString());
		Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_OK);
	}

}
