package com.example.tests;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicApiTest {
    @Test
    public void testGetRequest() {
        // Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // API Endpoint
        String endpoint = "/posts/1";

        // Send GET Request
        Response response = given()
                .when()
                .get(endpoint);

        // Print Response
        System.out.println("Response: " + response.asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Mismatch");
        Assert.assertTrue(response.asString().contains("userId"), "Response doesn't contain 'userId'");
    }
}
