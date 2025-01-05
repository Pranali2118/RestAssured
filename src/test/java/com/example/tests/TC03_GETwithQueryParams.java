package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_GETwithQueryParams {

    @Test
    void getcommentswithID()
    {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";

        RequestSpecification requesbody=RestAssured.given();

        requesbody.queryParams("id",1);
        Response response= requesbody.request(Method.GET,"/comments");

        String ResponseBody=response.getBody().asString();

       // Assert.assertEquals(ResponseBody.contains("email=Eliseo@gardner.biz"));
        System.out.println(ResponseBody);
    }

}
