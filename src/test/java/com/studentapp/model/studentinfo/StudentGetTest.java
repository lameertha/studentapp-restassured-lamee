package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/* Created
 * by Lamee */
public class StudentGetTest extends TestBase {
    @Test
    public void getAllStudentsInformation() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        System.out.println(response.prettyPrint());
    }

    @Test
    public void searchStudentWithParameter() {
        Response response =given()
                .param("programme", "Computer Science")
                .param("limit", 2)
                .when()
                .get("/list");
        response.then().statusCode(200);
    }
    @Test
    public void searchStudentById(){
        Response response=given()
                .when()
                .get("7");
        response.then().statusCode(200);
        response.prettyPrint();


    }
    @Test

    public void searchStudentWithProgramme(){
        Response response=given()
                .queryParam("programme","Mechanical Engineering")
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
