import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_ReqRes_POST_Request {
	
	
	@Test
	public void createUserTest() {
		
		//base URI
		RestAssured.baseURI = "https://reqres.in/api";
		
		//Request object creation
		RequestSpecification httpRequest = RestAssured.given();
		
		//request payload for post request
		JSONObject requestPayLoad = new JSONObject();
		requestPayLoad.put("name", "Sumit");
		requestPayLoad.put("job", "Engineer");
		
		httpRequest.header("Content-Type","Application/json");
		httpRequest.body(requestPayLoad.toJSONString());
		
		//Response Object creation
		Response responseObj = httpRequest.request(Method.POST,"/users");
		
		//getting status code
		int statusCode = responseObj.getStatusCode();
		
		//verifying status code
		Assert.assertEquals(statusCode, 201);
		
		//print response in console window
		String responseBody = responseObj.getBody().asString();
		System.out.println("Response body is: "+responseBody);
		//getting field from json response
		String name = responseObj.jsonPath().get("name");
		String job = responseObj.jsonPath().get("job");
		
		//verifying field value from response
		Assert.assertEquals(name, "Sumit");
		Assert.assertEquals(job, "Engineer");
	}

}
