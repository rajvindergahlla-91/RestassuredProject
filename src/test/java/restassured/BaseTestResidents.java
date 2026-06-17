package restassured;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTestResidents {
	
	protected static String token;

    @BeforeSuite
    	public void generateToken() throws Exception {

    	    String requestBody = new String(
    	            Files.readAllBytes(
    	                    Paths.get("src/test/resources/payloads/loginUser.json")));

    	    RestAssured.baseURI =
    	            "https://report-ease-prj-666-naa.vercel.app";

    	    Response response =
    	            RestAssured.given()
    	                       .header("Content-Type", "application/json")
    	                       .body(requestBody)
    	                    .when()
    	                       .post("api/login");

    	    //response.then().statusCode(200);
    	    System.out.println("Status Code: " + response.getStatusCode());
    	    response.prettyPrint();
    	    

    	    token = response.jsonPath().getString("token");

    	    System.out.println("Generated Token : " + token);
    }
    
    }


