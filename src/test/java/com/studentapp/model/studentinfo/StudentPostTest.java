package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/* Created
 * by Lamee */
public class StudentPostTest extends TestBase {
    String email="lamee"+getRandomString(2)+"@gmail.com";
    String fname="lamee" +getRandomString(2);
    String lname="thev"+ getRandomString(2);

    @Test

    public void createNewStudent(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName(fname);
        studentPojo.setLastName(lname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String> course=new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCources(course);

        Response response=given()
                .header("Content-Type","application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test

    public void createNewStudentWithEmptyFirstName(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName(fname=" ");
        studentPojo.setLastName(lname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String>course=new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCources(course);

        Response response=given()
                .header("Content-Type","application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test
    public void createNewStudentWithEmptyLastName(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setLastName(lname=" ");
        studentPojo.setFirstName(fname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String>course=new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCources(course);

        Response response=given()
                .header("Content-Type","application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test
    public void createNewStudentWithNullFirstName(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName(fname=null);
        studentPojo.setLastName(lname);
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String>course=new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCources(course);

        Response response=given()
                .header("Content-Type","application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(500);
        response.prettyPrint();
    }
    @Test
    public void createNewStudentWithNullLastName(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName(fname);
        studentPojo.setLastName(lname=null);
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String>course=new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCources(course);

        Response response=given()
                .header("Content-Type","application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
