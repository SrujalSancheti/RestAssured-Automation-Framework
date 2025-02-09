package com.tests;

import org.testng.annotations.Test;

import com.base.AuthenticationService;
import com.models.request.LoginRequest;
import com.models.request.SignUpRequest;
import com.models.response.LoginResponse;

import io.restassured.response.Response;




public class RestAssuredLogin2 {

    // @Test
//    public void Login(){
    //     RestAssured.baseURI="http://64.227.160.186:8080";
    //     // RestAssured.basePath="/api/auth/login";

    //     Response response = RestAssured.given().header("Content-Type","application/json").body("{  \"username\": \"srujal\",  \"password\": \"srujal\"}").post("/api/auth/login");
    //     System.out.println(response.asPrettyString());
    // }


    @Test
    public void Login2(){
        LoginRequest loginRequest = new LoginRequest("srujal","srujal");
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());
    }

    @Test
    public void SignUp(){

        SignUpRequest signUpRequest = new SignUpRequest.Builder()
            .Username("Janki123")
            .Password("Janki123")
            .Email("janki@123")
            .FirstName("Janki")
            .LastName("Nandan")
            .MobileNumber("1234567890")
            .build();
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());
    }
}
