/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.dao;
import com.jets.contactx.entitiy.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
/**
 *
 * @author Eslam
 */
public class UserDAO {
    
    public boolean validateUser(User user){
        //TOQA
        
        EntityManager entityManager = EntityManagerProvider.getEntityManager(EntityManagerProvider.USER_DAO);
        Query query = entityManager.createQuery(
                    "SELECT u "
                  + "FROM User AS u "
                  + "WHERE u.phoneNo = :phone "
                    + "AND u.password = :password"
                , User.class)
                .setParameter("phone", user.getPhoneNo())
                .setParameter("password", user.getPassword());
                
        
        List<User> usersResult = query.getResultList();
        
        if(!usersResult.isEmpty())
            return true;    //exists before
        
        return false;   //doesn't exist
    }
    
    public User getUser(int userId){
        //TOQA
        EntityManager entityManager = EntityManagerProvider.getEntityManager(EntityManagerProvider.USER_DAO);
        TypedQuery<User> query = entityManager.createNamedQuery("User.findById", User.class )
                                    .setParameter("id", userId);
                          
        List<User> usersResult = query.getResultList();
        
        if(!usersResult.isEmpty())
            return usersResult.get(0);
        
        return null;
    }
    
    public boolean validateUniquePhone(String phone){
        //TOQA
        
        EntityManager entityManager = EntityManagerProvider.getEntityManager(EntityManagerProvider.USER_DAO);
        Query query = entityManager.createNamedQuery("User.findByPhoneNo", User.class )
                                    .setParameter("phoneNo", phone);
                          
        List<User> usersResult = query.getResultList();
        
        if(!usersResult.isEmpty())
            return true;
        
        return false;
    }
    
    public User addOrUpdateUser(User user){
        //TOQA
        
        EntityManager entityManager = EntityManagerProvider.getEntityManager(EntityManagerProvider.USER_DAO);
        entityManager.persist(user);
        return user;
    }
}
