package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParams {

	@Test
	public void test1() {
		
			RestAssured.baseURI = "http://localhost:3000/employees";
			
			RequestSpecification request = RestAssured.given();
			
			Response response = request.param("id", "1").get();
			
			String ResponseBody = response.getBody().asString();
			
			System.out.println(ResponseBody);
			
			int ResponseCode = response.getStatusCode();
			
			AssertJUnit.assertEquals(ResponseCode, 200);
			
			AssertJUnit.assertTrue(ResponseBody.contains("Pankaj"));
			
			JsonPath jpath = response.jsonPath();
			//List<String> names = jpath.get("name");
			List<String> names = jpath.get("name");
			
			System.out.println(names.get(0));  //to get single name from list
		AssertJUnit.assertEquals(names.get(0), "Pankaj");
			

			String Header = response.getHeader("Content-Type");
			System.out.println(Header);
			
			
		}

	}

