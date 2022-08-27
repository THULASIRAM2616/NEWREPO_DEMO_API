package com.basic_Method;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Post_Method {
	@Test
	public void Create_Program() {
		RestAssured.baseURI = "https://api.github.com";

		String bearerToken = "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";

		Response response = RestAssured.given()
				.headers("Authorization", "Bearer " + bearerToken)
				.body("{\r\n" + "  \"name\": \"NEWREPO_DEMO_API\"\r\n" + "}")
				
				.when().post("/user/repos")
				
				.then().log().all().extract().response();

		System.out.println(response.asString());

		System.out.println(response.getStatusCode());
	}

}
