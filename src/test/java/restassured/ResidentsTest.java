package restassured;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResidentsTest extends BaseTestResidents {
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
@Test
    
    public void postForgotPasswordTest() throws Exception
    {
    	String requestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/forgotPassword.json")));
    	RestAssured.baseURI="https://report-ease-prj-666-naa.vercel.app";
    	
    	Response response = RestAssured.given().header("Content-Type","application/json").body(requestBody).when().post("api/forgot-password");
    	response.then().statusCode(200);
    	response.prettyPrint();
   
}
@Test
public void postResetpasswordTest() throws Exception
{
	String requestBody= new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/resetPassword.json")));
	RestAssured.baseURI="https://report-ease-prj-666-naa.vercel.app";
	Response response = RestAssured.given().header("Content-Type","application/json").body(requestBody).when().post("api/reset-password");
	response.then().statusCode(200);
	response.prettyPrint();
}
@Test
public void postReportTest() throws Exception
{
	String requestBody= new String(Files.readAllBytes(Paths.get("src/test/resources/payloads/userReport.json")));
	RestAssured.baseURI="https://report-ease-prj-666-naa.vercel.app";
	Response response = RestAssured.given().header("Content-Type","application/json").header("Authorization", "Bearer " + token).body(requestBody).when().post("api/report");
	response.then().statusCode(201);
	response.prettyPrint();	
}
@Test
public void getUserIssues()
{
	RestAssured.baseURI="https://report-ease-prj-666-naa.vercel.app";
	Response response= RestAssured.given().header("Authorization", "Bearer "+ token).when().get("api/issues/user");
	response.then().statusCode(200);
	response.prettyPrint();
}
@Test
public void getIssueId()
{
	RestAssured.baseURI="https://report-ease-prj-666-naa.vercel.app";
	Response response= RestAssured.given().header("Authorization", "Bearer " + token).when().get("api/issues/6a32e1768b86e27fd65c2635");
	response.then().statusCode(200);
	response.prettyPrint();
}
}
