package com.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.AuthenticationService;
import com.models.request.LoginRequest;
import com.models.request.SignUpRequest;
import com.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.listener.TestListener.class)

public class AuthenticationTests {
    @Test
    public void login(){
        LoginRequest loginRequest = new LoginRequest("srujal","srujal123");
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());
    }

    @Test
    public void signUp(){

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

    @Test
    public void forgetPassword(){
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.forgetUserPassword("srujalsancheti55@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
