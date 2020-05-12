package com.studentapp.model.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/* Created
 * by Lamee */
public class TestBase {
    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/student";
    }

    public String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}

