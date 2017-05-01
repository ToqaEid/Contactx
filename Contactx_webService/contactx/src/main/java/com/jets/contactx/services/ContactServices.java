/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.services;

import com.jets.contactx.entitiy.Contact;
import com.jets.dao.ContactDAO;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author michael
 */

@Path("/contacts")
public class ContactServices {
    
  /*-------------- Get All Contacts -----------------*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{userID}/get_contacts/all")
  public ArrayList<Contact> getAllContacts(@PathParam("userID") int userID) {
      ContactDAO db = new ContactDAO();
      
      return db.getAllContacts(userID);
      
  }
  
  /*-------------- Get Group Contacts -----------------*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{userID}/get_contacts/{groupID}")
  public ArrayList<Contact> getGroupContacts(@PathParam("userID") int userID, 
                                  @PathParam("groupID") int groupID) {
      
      ContactDAO db = new ContactDAO();
      return db.getGroupContacts(userID, groupID);
  }
  
  
  /*-------------- Get Contact Details -------------*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{userID}/get_contact/{contID}")
  public Contact getContactDetails(@PathParam("userID") int userID, 
                                  @PathParam("contID") int contID) {
      
      ContactDAO db = new ContactDAO();
      return db.getContactDetails(contID);
  } 
  
  /*-------------- Add or Update Contact --------------------*/
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{userID}/add_update_contact/{contID}")
  public String addOrUpdateContact(@PathParam("userID") int userID, 
                                    Contact cont) {
      
      ContactDAO db = new ContactDAO();
      db.addOrUpdateContact(cont);
      return "";
  } 
  
  /*-------------- Delete Contact -------------*/
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{userID}/delete_contact/{contID}")
  public String deleteContact(@PathParam("userID") int userID, 
                              @PathParam("contID") int contID) {
      
      ContactDAO db = new ContactDAO();
      db.deleteContact(contID);
      return "";
  } 
  
  
  /*-------------- Purge Contacts -------------*/
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user/{userID}/purge_contacts")
  public String purgeContacts(@PathParam("userID") int userID) {
      
      ContactDAO db = new ContactDAO();
      db.purgeContacts(userID);
      return "";
  } 
  
}
