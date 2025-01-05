package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TC05_PtachRequest {

    @Test
    void updatetitle(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
        RequestSpecification requestSpecification=RestAssured.given();

        JSONObject requestParams= new JSONObject();
        requestParams.put("title", "this is my updated patch request");

        requestSpecification.header("Content-Type","application/json");

        requestSpecification.body(requestParams.toString());


        Response response= requestSpecification.request(Method.PATCH,"posts/1");

        System.out.println(response.getBody().asString());
    }
}
