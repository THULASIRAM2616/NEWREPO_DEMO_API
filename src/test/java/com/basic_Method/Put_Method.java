package com.basic_Method;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Put_Method {
      
	     @Test
	     public void Update_Repo() {
	    	 RestAssured.baseURI = "https://api.github.com";

				String bearerToken = "";

				Response response = RestAssured.given()
						.headers("Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept",
								ContentType.JSON)
						.body("{\r\n" + 
								"    \"names\": [\r\n" + 
								"        \"corejava\",\r\n" + 
								"        \"seleniumwebdriver\"\r\n" + 
								
								"    ]\r\n" + 
								"}").when().put("/repos/THULASIRAM2616/NEWREPO_DEMO").then().log().all()
						.extract().response();

				System.out.println(response.asString());

				System.out.println(response.getStatusCode());
		}
	
	
}
