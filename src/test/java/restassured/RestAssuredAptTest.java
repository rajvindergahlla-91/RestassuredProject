package restassured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class RestAssuredAptTest {
	@Test
	
	public void postRequest()
	{
		String requestBody= "{\r\n"
				+ "\"name\": \"John Doe\",\r\n"
				+ "\"email\": \"john@example.com\", \"password\": \"SecurePass@123\", \"role\": \"resident\"\r\n"
				+ "}\r\n"
				+ "";
		RestAssured.baseURI="https://report-ease-prj-666-naa.vercel.app";
		RestAssured.given()
		               .header("Content-Type", "application/json" )
		               .body(requestBody)
		             .when()
		               .post("api/register")
		             .then()
		               .statusCode(201);
	} 

	
}
