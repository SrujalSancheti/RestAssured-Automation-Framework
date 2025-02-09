package com.base;

import com.models.request.ProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {
    private static final String BASE_PATH = "/api/users/";

    public Response getProfile(String token){
        setToken(token);
        return getRequest(BASE_PATH + "profile");
    }

    public Response updateProfile(String token, ProfileRequest payload){
        setToken(token);
        return putRequest(payload,BASE_PATH + "profile");
    }
}
