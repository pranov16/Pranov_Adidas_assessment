package rest_api_assessment;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class exercise1_restapi {
	
	@Test
	public void get_available_pets(){
		
		given().
		when().
			get("https://petstore.swagger.io/").
		then().
			assertThat().
				statusCode(200).and().
				body("status", equalTo("available"));
	
		
	}
	
}
