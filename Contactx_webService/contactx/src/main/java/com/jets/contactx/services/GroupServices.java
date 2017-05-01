/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.services;

import com.jets.contactx.entitiy.Group1;
import com.jets.contactx.entitiy.GroupContactsCount;
import com.jets.dao.GroupDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author michael
 */

@Path("/group")
public class GroupServices {
    
  /*-------------- Get list of groups names -----------------*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{userID}/names_list")
  public ArrayList<Group1> getGroupsList(@PathParam("userID") int userID) {
     
     GroupDAO db = new GroupDAO();
     return db.getGroups(userID);
  }
  
  
  /*-------------- Get list of groups details -----------------*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{userID}/detailed_list")
  public ArrayList<GroupContactsCount> getGroups(@PathParam("userID") int userID) {
     GroupDAO db = new GroupDAO();
     return db.getGroupsContactsCount(userID);
  }
  
  
    
}
