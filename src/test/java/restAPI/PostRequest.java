package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
	
	Response response	= request.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
.body("    {\n" + 
		"      \"name\": \"Sunny\",\n" + 
		"      \"salary\": \"10000\"\n" + 
		"    }")
.post("/create");
		String Responsebody = response.getBody().asString();
	     System.out.println(Responsebody);
	  
	  int Responsecode = response.getStatusCode();
	  AssertJUnit.assertEquals(Responsecode,201);
	  
	   JsonPath Jpath =response.jsonPath();
       Jpath.get("id");
       System.out.println("id"+Jpath.get("id"));

	  	}

	  }

	
