/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.dao;
import com.jets.contactx.entitiy.*;
import org.hibernate.Session;
/**
 *
 * @author Eslam
 */
public class UserDAO {
    
    public boolean validateUser(User user){
        return false;
    }
    
    public User getUser(int userId){
        return null;
    }
    
    public boolean validateUniquePhone(String phone){
        return false;
    }
    
    public boolean addOrUpdateUser(User user){
        return false;
    }
}
