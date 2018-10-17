package com.automation.tests;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.automation.data.ResourcesDataProvider;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class TestSchemaValidation {

	Logger logger = LoggerFactory.getLogger(TestSchemaValidation.class);
	
	@Test (groups="secondTestPartOne", dataProvider="resourcesProvider", dataProviderClass=ResourcesDataProvider.class)
	public void validateResources(String resource, String schema) {
		
		logger.info("Running 2nd Test case part 1 with value: {}",resource);
		
		RestAssured.given()
		.accept(ContentType.JSON)
		.when()
			.get("https://jsonplaceholder.typicode.com/"+resource)
		.then()
		.assertThat()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schema))
		.statusCode(HttpStatus.SC_OK);
	}
}
