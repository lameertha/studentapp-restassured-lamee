package com.studentapp.model.loggingrequestresponse;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/* Created
 * by Lamee */
public class LoggingResponseDetails extends TestBase {
    String email="lamee"+getRandomString(2)+"@gmail.com";

    /**
     * This test will print out all the Response Headers
     */
    @Test
    public void test001() {
        System.out.println("---------------Printing Response Headers------------------");


        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200)
                .log().headers();

    }


    /**
     * This test will print the Response Status Line
     */
    @Test
    public void test002() {
        System.out.println("---------------Printing Response Status Line------------------");


        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200)
                .log().status();


    }


    /**
     * This test will print the Response Body
     */
    @Test
    public void test003() {
        System.out.println("---------------Printing Response Body------------------");


        Response response = given()
                .when()
                .get("/1");
        response.then().statusCode(200)
                .log().body();
    }

    /**
     * This test will print the Response in case of an error
     */
    @Test
    public void test004() {
        System.out.println("---------------Printing Response Body in case of an error------------------");
//

        StudentPojo studentPojo = new StudentPojo();

        studentPojo.setEmail("est.congue@velit.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .patch("/110");
        response.then().log().body().statusCode(200);

    }
}
