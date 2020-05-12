package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/* Created
 * by Lamee */
public class StudentPatchTest extends TestBase {
    @Test
    public void StudentDataUpdatedByEmailId() {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Hamilton");
        studentPojo.setLastName("Dennis");
        studentPojo.setEmail("hamilton@gmail.com");
        studentPojo.setProgramme("Mechanical Engineering");
        List<String> course=new ArrayList<>();
        course.add("Machine Element Design");
        course.add("Engineering Analysis I");
        course.add("Calculus & Linear Algebra I");
        studentPojo.setCources(course);




        Response response = given()
                .header("Content-Type", "application/json")
                .log().body()
                .body(studentPojo)
                .patch("/95");
        response.then().statusCode(200);
        response.prettyPrint();


        given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .patch("/95")
                .then();
        get("/list").then().body("[94].email",equalTo("hamilton@gmail.com"));

    }

}
