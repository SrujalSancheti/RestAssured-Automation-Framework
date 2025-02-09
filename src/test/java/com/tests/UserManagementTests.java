package com.tests;

import org.testng.annotations.Test;

import com.base.AuthenticationService;
import com.base.UserManagementService;
import com.models.request.LoginRequest;
import com.models.request.ProfileRequest;
import com.models.response.LoginResponse;
import com.models.response.ProfileResponse;

import io.restassured.response.Response;

public class UserManagementTests {
    @Test
    public void getUserProfile(){
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.login(new LoginRequest("srujal", "srujal123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        UserManagementService userManagementService = new UserManagementService();
        response = userManagementService.getProfile(loginResponse.getToken());
        ProfileResponse profileResponse = response.as(ProfileResponse.class);
        System.out.println(profileResponse.getFirstName());

    }


    @Test
    public void updateUserProfile(){
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.login(new LoginRequest("srujal", "srujal123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());  

        System.out.println("----------------------------------------------------------");

        UserManagementService userManagementService = new UserManagementService();
        response = userManagementService.getProfile(loginResponse.getToken());
        ProfileResponse profileResponse = response.as(ProfileResponse.class);
        System.out.println(response.asPrettyString());

        System.out.println("----------------------------------------------------------");


        ProfileRequest profileRequest = new ProfileRequest.Builder()
            .FirstName("Mathew")
            .LastName("Mardock")
            .MobileNumber("8008008011")
            .Email("srujalsancheti70@gmail.com")
            .build();

        response = userManagementService.updateProfile(loginResponse.getToken(), profileRequest);
        System.out.println(response.asPrettyString());
    }
}
