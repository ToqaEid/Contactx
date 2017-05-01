/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Eslam
 */
@Path("/test")
public class Test {
    
    //Toqa
    
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
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/contacts")
  public String sayPlainTextHello() {
    return "Mr7ababak - contacts";
  }
}
