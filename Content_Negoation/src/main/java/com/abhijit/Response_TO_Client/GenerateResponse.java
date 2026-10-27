
package com.abhijit.Response_TO_Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("student")
public class GenerateResponse {

    static List<Student> ls = new ArrayList<>();

    static {
        Student s1 = new Student();
        s1.setName("Abhijit");
        s1.setAge(22);

        Student s2 = new Student();
        s2.setName("Pavan");
        s2.setAge(16);

        ls.addAll(Arrays.asList(s1, s2));
    }

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Student> getStudent() {
        return ls;
    }

    @GET
    @Path("{age}")
    @Produces(MediaType.APPLICATION_XML)
    public Student getOnAge(@PathParam("age") int age) {

        for (Student s : ls) {
            if (s.getAge() == age) {
                return s;
            }
        }

        return null;
    }

    @POST
    @Path("add")
    public String getData(Student s) {
        System.out.println("Received student: " + s.getName());
        ls.add(s);
        return "Student added successfully: " + s.getName();
    }
}
