package com.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class RestAssuredLogin1 {

    @Test
    public void Login(){
        RestAssured.baseURI="http://64.227.160.186:8080";
        // RestAssured.basePath="/api/auth/login";

        RequestSpecification rs1 = RestAssured.given();
        RequestSpecification rs2 = rs1.header("Content-Type","application/json");
        RequestSpecification rs3 = rs2.body("{  \"username\": \"srujal\",  \"password\": \"srujal\"}");
        Response response = rs3.post("/api/auth/login");
        System.out.println(response.asPrettyString());
    }
}
