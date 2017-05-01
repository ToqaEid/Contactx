/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.services;

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
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/login")
  public String login() {
    return "Mr7ababak - User";
  }
  
  /*-------------- Register -------------*/
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/register")
  public String register(User user) {
      UserDAO db = new UserDAO();
      if(db.validateUniquePhone(user.getPhoneNo())){
          db.addOrUpdateUser(user);
          return "";
      }else{
          return "";
      }
  }
  
  /*-------------- Update -------------*/
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/update")
  public String updateUser(User user) {
    UserDAO db = new UserDAO();
      if(db.validateUniquePhone(user.getPhoneNo())){
          db.addOrUpdateUser(user);
          return "";
      }else{
          return "";
      }
  }
  
  
}
