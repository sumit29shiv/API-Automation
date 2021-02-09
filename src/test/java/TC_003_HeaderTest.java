import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_HeaderTest {
	
	@Test
	public void verifyHeaderTest() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpsRequest = RestAssured.given();
		Response response = httpsRequest.request(Method.GET,"/api/users?page=2");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: "+responseBody);
		
		String contentType = response.header("Content-Type");
		System.out.println("Content type is: "+contentType);
		
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
	}

}
