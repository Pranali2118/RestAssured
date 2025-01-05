package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC02_PostRequest {

    @Test
    void Postuserdetails()
    {
        //1.Base Uri
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";

        //2 Request Object
        RequestSpecification requestSpecification=RestAssured.given();

        // 3. RequestPayload sending along with post request
           // 1. for the body we are using json object class
        JSONObject requestParams= new JSONObject();

           //2.Adding values to the body

        requestParams.put("id", 109);
        requestParams.put("title", "this my post request");
        requestParams.put("body", "first post");
        requestParams.put("userId", 790);


           // 3. What type of data we are sending that is json , xml.
        requestSpecification.header("Content-Type","application/json");
//        requestSpecification.header("Authorization","no-Auth");
//        requestSpecification.header("Cache-Control","no-cache");

           // 4.attching body and header we post request
        requestSpecification.body(requestParams.toString());

        // 4. ResponseObject
        Response response= requestSpecification.request(Method.POST,"posts");
        String contenttype=response.header("Content-Type");

        System.out.println(response.getBody().asString());

        Assert.assertEquals(contenttype,"application/json; charset=utf-8");


    }
}
