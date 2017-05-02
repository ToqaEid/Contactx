/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.services;

import com.jets.contactx.entitiy.Contact;
import com.jets.contactx.entitiy.Phone;
import com.jets.contactx.entitiy.User;
import com.jets.dao.UserDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Eslam
 */
@Path("/test")
public class Test {
    
    //Toqa
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/uservalid")
    public Boolean userDao() {

      User user = new User(1, "01008894627", "Toqa", "1234");
      UserDAO userDao = new UserDAO();
      return userDao.validateUser(user);
      
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/phonevalid")
    public Boolean userPhone() {

      UserDAO userDao = new UserDAO();
      return userDao.validateUniquePhone("01008894627");
      
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUser")
    public User getUser() {

      UserDAO userDao = new UserDAO();
      return userDao.getUser(2);
      
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saveUser")
    public User saveUser() {

      User user = new User();
      user.setName("Mirna");
      user.setPassword("12345");
      user.setPhoneNo("01000000000");
      UserDAO userDao = new UserDAO();
      return userDao.addOrUpdateUser(user);
      
    }

    //-----End Toqa
    
    //Marko
    
    //-----End Marko
    
    //Islam
    
    //-----End Islam
    
    //Samy
    
    //-----End Samy
    
    //Michael
    
    //-----End Michael
    
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/contacts")
  public ArrayList<Object> sayPlainTextHello() {
      
    Phone p1 = new Phone(12, "01234324", "type ahoh");
    Phone p2 = new Phone(12, "01234324", "type ahoh");
    Phone p3 = new Phone(12, "01234324", "type ahoh");
    
    
    ArrayList<Object> phones = new ArrayList<>();
    phones.add(p1);
    phones.add(p2);
    phones.add(p3);
    return phones;
  }
  

}
