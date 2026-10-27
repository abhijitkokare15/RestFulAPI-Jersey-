
package com.abhijit.Response_TO_Client;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("student")
public class GenerateResponse {

    @GET
   @Produces(MediaType.APPLICATION_XML)
  
    public  List<Student> getStudent() {
       
    	System.out.println("I am in the method");
        Student s1 = new Student();
        s1.setName("Abhijit");
        s1.setAge(22);
        
        Student s2 = new Student();
        s2.setName("Pavan");
        s2.setAge(16);
         
        List<Student> ls = Arrays.asList(s1,s2);
        
        

        return ls ;
    }
}
