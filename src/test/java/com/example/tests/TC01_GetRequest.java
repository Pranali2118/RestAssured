package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


// Whenever we test our API Few things to remember
//1.We need to send a request => create a request object
//2.We will get a response => create a response object
//3 once we get the response few things we have to validate
//  statuscode, statusline,content,responsebody,header,responsetime
public class TC01_GetRequest {
    @Test
    void getuserdetails(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";

        RequestSpecification httprequest= RestAssured.given();// RequestBody

        Response response= httprequest.request(Method.GET,"/posts/1");//ResponseBody


        String ResponseBody=response.getBody().asString();// getbody returned in json formate and then converted json to string using asString()

//        System.out.println(response.headers());

        int statuscode=response.getStatusCode();

//        System.out.println(statuscode);

        Assert.assertEquals(statuscode,200,"Pass");

        Assert.assertEquals(ResponseBody.contains("id"),true);// true
      //  Assert.assertEquals(ResponseBody.contains("idd"),true);//false beause of idd not exists


        //Validate headers

//        for(Header header:response.headers())
//        {
//            System.out.println(header.getName()+"              bbbb  hhhhhhhhh        "+header.getValue());
//        }



         Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
    }
}
