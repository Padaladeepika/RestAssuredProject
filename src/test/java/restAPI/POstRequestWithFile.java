package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POstRequestWithFile {
	
	@Test
	public void test1() throws IOException {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		byte[] dataBytes = Files.readAllBytes(Paths.get("data.json"));
		
		//JSONObject jobj  = new JSONObject();
		//jobj.put("name", "Greg");
		//jobj.put("Salary", "10000");
		
		RequestSpecification request = RestAssured.given();
	Response response	= request.contentType(ContentType.JSON)
		                         .accept(ContentType.JSON)
		                         .body(dataBytes)
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


