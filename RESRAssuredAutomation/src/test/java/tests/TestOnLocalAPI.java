package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestOnLocalAPI {
@Test
	
	public void get() {
		baseURI = "http://localhost:3000";
		given().get("/users")
		.then()
		.statusCode(200).log().all();
}
		
		@Test
		public void post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Isuru");
		request.put("lastName",  "Weerasinghe");
		request.put("subjectId",  4);

		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		  body(request.toJSONString()).
		when().
		  post("/users").
		then().
		  statusCode(201).
		  log().all();
	}
		
		@Test
		public void put() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Raghav");
		request.put("lastName",  "Kumara");
		request.put("subjectId",  1);

		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		  body(request.toJSONString()).
		when().
		  put("/users/3").
		then().
		  statusCode(200).
		  log().all();
	}
		
		@Test
		public void patch() {
		
		JSONObject request = new JSONObject();
		request.put("lastName",  "Karunathilaka");

		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		  body(request.toJSONString()).
		when().
		  patch("/users/3").
		then().
		  statusCode(200).
		  log().all();
	}
	
		@Test	
		public void delete() {

		baseURI = "http://localhost:3000";

		when().
		  delete("/users/2").
		then().
		  statusCode(204).
		  log().all();
		}
		}

