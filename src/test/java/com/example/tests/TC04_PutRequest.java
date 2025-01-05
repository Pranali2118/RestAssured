package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TC04_PutRequest {

    @Test
    void updateposts(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
        RequestSpecification requestSpecification=RestAssured.given();

        JSONObject requestParams= new JSONObject();
        requestParams.put("id","101");
        requestParams.put("title", "this is my updated put request");
        requestParams.put("body", "put request");
        requestParams.put("userId", 790);


        requestSpecification.header("Content-Type","application/json");

        requestSpecification.body(requestParams.toString());


        Response response= requestSpecification.request(Method.PUT,"posts/101");

        System.out.println(response.getBody().asString());
    }

}
