package com.base;

import java.util.HashMap;

import com.models.request.LoginRequest;
import com.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthenticationService extends BaseService {
    private static final String BASE_PATH = "/api/auth/";

    public Response login(LoginRequest payload){
        return postRequest(payload, BASE_PATH + "login");
    }

    public Response signUp(SignUpRequest payload){
        return postRequest(payload, BASE_PATH + "signup");
    }

    public Response forgetUserPassword(String email){
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email", email);
        return postRequest(payload, BASE_PATH + "forgot-password");
    }
}
