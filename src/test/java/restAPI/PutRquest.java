package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRquest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		//JSONObject jobj  = new JSONObject();
		//jobj.put("name", "Greg");
		//jobj.put("Salary", "10000");
		
		Map<String,Object> MapObj = new HashMap<String,Object>();
		 MapObj.put("name", "Vas");
		 MapObj.put("salary","5000");

		RequestSpecification request = RestAssured.given();
	
	Response response	= request.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(MapObj)
		.put("/8");
		String Responsebody = response.getBody().asString();
	     System.out.println(Responsebody);
	  
	  int Responsecode = response.getStatusCode();
	  AssertJUnit.assertEquals(Responsecode,200);
	  
	   JsonPath Jpath =response.jsonPath();
       Jpath.get("id");
       System.out.println("id"+Jpath.get("id"));

	  	}

	  }

	









