package com.automation.data;

import org.testng.annotations.DataProvider;

public class ResourcesDataProvider {

	@DataProvider(name = "resourcesProvider")
    public static Object[][] resourcesDataProvider() {
        return new Object[][] { {"posts","postsSchema.json"},
        	{"comments","commentsSchema.json"},
        	{"albums","albumsSchema.json"},
        	{"photos","photosSchema.json"},
        	{"todos","todosSchema.json"},
        	{"users","usersSchema.json"}};
    }
	
	@DataProvider(name = "postsIdsProvider")
    public static Object[][] postsIdsDataProvider() {
        return new Object[][] { 
        	{20,1,"optio molestias id quia eum"},
        	{50,5,"repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem"},
        	{100,10,"at nam consequatur ea labore ea harum"}
        	};
    }
}
