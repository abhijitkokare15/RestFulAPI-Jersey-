
package com.abhijit.Response_TO_Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("student")
public class GenerateResponse {

    static List<Student> ls = new ArrayList<>();

    Connection con;
    Statement st;
    ResultSet rs;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> getStudent() {

        ls.clear();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "");

              st = con.createStatement();
              rs = st.executeQuery("SELECT * FROM demo");

            while (rs.next()) {
                Student s = new Student();
                s.setAge(rs.getInt(1));
                s.setName(rs.getString(2));
                
//                System.out.println(s.getAge());
//                System.out.println(s.getName());
                ls.add(s);
            }

          

        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }

        return ls;
    }

    @GET
    @Path("{age}")
    @Produces(MediaType.APPLICATION_XML)
    public Student getOnAge(@PathParam("age") int age) {
        Student s=null;
    	try
        {
    		 con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/studentdb", "root", "");
             st = con.createStatement();
    		rs = st.executeQuery("select * from demo where age ="+age);
    		if(rs.next())
    		{
    			s=new Student();
    			s.setAge(rs.getInt(1));
    			s.setName(rs.getString(2));
    			
    			}
        	
        }
        
        catch(Exception e )
    	{
        	System.out.println("The msg"+e);
    	}
    	
    	return s;
       
    }

    @POST
    @Path("add")
    public void  AddData(Student s) {
    	
    	 try {
           Class.forName("com.mysql.cj.jdbc.Driver");

           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");
             
               String que="insert into demo values(?,?)";
                 
               PreparedStatement ps = con.prepareStatement(que);
               ps.setInt(1,s.getAge());
               ps.setString(2,s.getName());
            
           int row = ps.executeUpdate();
           
           if(row==0)
           {
        	   System.out.println("Not updated any thing");
        	   
           }
           
           
           }

         
        catch (Exception e) {
           System.out.println("Error occurred: " + e);
       }
    	 }
    	 
    
    
    @PUT
    @Path("update")
    public void update(Student s )
    {
    	 try {
             Class.forName("com.mysql.cj.jdbc.Driver");

             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");
               
                 String que="update demo set name=? where age=?";
                   
                 PreparedStatement ps = con.prepareStatement(que);
                
                 ps.setString(1,s.getName());
                 ps.setInt(2, s.getAge());
              
             int row = ps.executeUpdate();
             
             if(row==0)
             {
          	   AddData(s);
          	   
             }
             
             else
             {
                 System.out.println("updated succesffully");
             }
             
             
             }

           
          catch (Exception e) {
             System.out.println("Error occurred: " + e);
         }
    	 
  }
    
    
    @DELETE
    @Path("del")
   public  void delete(Student  s)
    {
    	 try {
             Class.forName("com.mysql.cj.jdbc.Driver");

             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");
               
                 String que="delete from demo where age=?";
                   
                 PreparedStatement ps = con.prepareStatement(que);
                
          
                 ps.setInt(1, s.getAge());
              
             int row = ps.executeUpdate();
             
             if(row==0)
             {
            	 System.out.println("age is not presnet");
          	   
             }
             
             else
             {
                 System.out.println("deleted succesffully");
             }
             
             
             }

           
          catch (Exception e) {
             System.out.println("Error occurred: " + e);
         }
    	 
    	
    }
      	 
}
