/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.services;

import com.jets.contactx.entitiy.utilityclasses.ReturnObject;
import com.jets.contactx.entitiy.User;
import com.jets.dao.UserDAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *  
 * @author michael
 */

@Path("/user")
public class UserServices {
    
  /*-------------- Login -------------*/
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/login")
  public ReturnObject login(User user) {
      
      System.out.println("login");
    UserDAO db = new UserDAO();
    Object validateReturn  = db.validateUser(user);
    if(validateReturn instanceof User){
        return new ReturnObject("success","valid user", user);
    }
    return new ReturnObject("failure", (String) validateReturn, null);
  }
  
  /*-------------- Register OR Update -------------*/
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/saveUser")
  public ReturnObject register(User user) {
      UserDAO db = new UserDAO();
        user = db.addOrUpdateUser(user);
        if(user != null){
            return new ReturnObject("success","user saved successfully", user);
        }
        return new ReturnObject("failure", "failed to save user", null);
  }
  
  
  
}
