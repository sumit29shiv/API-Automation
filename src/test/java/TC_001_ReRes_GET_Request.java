import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_ReRes_GET_Request {

	
	@Test
	public void getSingleUserDetailsTest() {
		
		//specify base URI
		RestAssured.baseURI="https://reqres.in";
		
		//Request object creation before sending any request
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object creation
		Response response = httpRequest.request(Method.GET,"/api/users/2");
		
		//print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: "+responseBody);
		
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status line validation
		String statusLine = response.statusLine();
		System.out.println("Status line is: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
