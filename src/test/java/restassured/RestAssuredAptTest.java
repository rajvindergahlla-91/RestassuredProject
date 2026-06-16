package restassured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.response.Response;

public class RestAssuredAptTest extends BaseTest {
	@Test

	public void postRegisterRequest() throws Exception {

		String requestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/registerUser.json")));

		RestAssured.baseURI = "https://report-ease-prj-666-naa.vercel.app";
		RestAssured.given().header("Content-Type", "application/json").body(requestBody).when().post("api/register")
				.then().statusCode(201);
	}

	@Test

	public void postLogInRequest() throws Exception {
		String requestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/loginUser.json")));

		RestAssured.baseURI = "https://report-ease-prj-666-naa.vercel.app";
		Response response = RestAssured.given().header("Content-Type", "application/json").body(requestBody).when()
				.post("api/login");

		response.then().statusCode(200);
		response.prettyPrint();

		String token = response.jsonPath().getString("token");

		System.out.println(token);

	}

}
