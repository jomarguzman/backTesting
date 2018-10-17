package com.automation.tests;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.List;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.automation.data.ResourcesDataProvider;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestResourcePosts {
	
	Logger logger = LoggerFactory.getLogger(TestResourcePosts.class);
	
	@Test (groups="secondTestPartTwo", dataProvider="postsIdsProvider", dataProviderClass = ResourcesDataProvider.class)
	public void getPosts(Integer idPost, Integer userId, String title) {
		
		logger.info("Running 2nd Test case part 2");
		
		List<String> postData = 
				RestAssured.given()
				.accept(ContentType.JSON)
				.when()
				.get("https://jsonplaceholder.typicode.com/posts")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.body("userId", hasItems(userId))
				.body("id", hasItems(idPost))
				.body("title", hasItems(title))
				.extract()
					.jsonPath()
						.getJsonObject("findAll {it.id == " + idPost + "}");
		
		logger.info("JSON data: {}",postData);
		
	}

}
