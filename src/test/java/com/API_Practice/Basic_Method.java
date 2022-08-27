package com.API_Practice;

import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Basic_Method {
	// @Test
			public static void postMethod() {

				RestAssured.baseURI = "https://api.github.com";

				String bearerToken = "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";

				Response response = RestAssured.given()
						.headers("Authorization", "Bearer " + bearerToken)
					//	.auth().preemptive().basic("greensjenkins@gmail.com", "12345678")
						.body("{\r\n" + "  \"name\": \"NEWREPO81\"\r\n" + "}")
						
						.when().post("/user/repos")
						
						.then().log().all().extract().response();

				System.out.println(response.asString());

				System.out.println(response.getStatusCode());

			}

		@Test
		private void getMethod() {

			RestAssured.baseURI = "https://api.github.com";

			String bearerToken = "";

			Response response = RestAssured.given()
					.headers("Authorization", "Bearer " + bearerToken)
					.when().get("/user/repos")
					.then().log().all().extract()
					.response();

			System.out.println(response.asString());

			System.out.println(response.getStatusCode());

		}
		
		//@Test
		public static void putMethod() {

			RestAssured.baseURI = "https://api.github.com";

			String bearerToken = "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";

			Response response = RestAssured.given()
					.headers("Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept",
							ContentType.JSON)
					.body("{\r\n" + 
							"    \"names\": [\r\n" + 
							"        \"java\",\r\n" + 
							"        \"selenium\"\r\n" + 
							"    ]\r\n" + 
							"}").when().put("/repos/sureshthirusr/Adactin_New").then().log().all()
					.extract().response();

			System.out.println(response.asString());

			System.out.println(response.getStatusCode());

		}

//		@Test
		public static void deleteMethod() {

			RestAssured.baseURI = "https://api.github.com";

			String bearerToken = "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";

			Response response = RestAssured.given()
					.headers("Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept",
							ContentType.JSON)
					.when().delete("/repos/sureshthirusr/NEWREPO81").then().log().all()
					.extract().response();

			System.out.println(response.asString());

			System.out.println(response.getStatusCode());

		}
}

