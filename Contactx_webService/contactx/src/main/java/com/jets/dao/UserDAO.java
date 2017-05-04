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
    
    public Object validateUser(User user){
        //TOQA
        
        EntityManager entityManager = EntityManagerProvider.getEntityManager(EntityManagerProvider.USER_DAO);
        
        List<User> usersResult = checkPhoneUniqueness(entityManager, user);
        
        if(!usersResult.isEmpty()){  //valid phoneNo
     
            List<User> usersResult2 = getUser(entityManager, user);

            if(!usersResult2.isEmpty()) //valid phone & password
                return usersResult2.get(0);  
            
            else    //invalid phone & pass
                return "invalid Phone Number or Password";               
        }
        return "invalid Phone Number";
    }
    
    public User addOrUpdateUser(User user){
        //TOQA
        
        EntityManager entityManager = EntityManagerProvider.getEntityManager(EntityManagerProvider.USER_DAO);
        
        List<User> usersResult = checkPhoneUniqueness(entityManager, user);
        
        if(usersResult.isEmpty()){  //phone number is unique
            /*== add or update user ==*/
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return user;
            
        }
        return null;
   
    }
    
    /*=============================== UTILITY METHODS (Queries Preparations)=================================*/
    
    private List<User> getUser(EntityManager entityManager, User user){
        Query query2 = entityManager.createQuery(
                    "SELECT u "
                  + "FROM User AS u "
                  + "WHERE u.phoneNo = :phone "
                    + "AND u.password = :password"
                , User.class)
                .setParameter("phone", user.getPhoneNo())
                .setParameter("password", user.getPassword());
                
            return query2.getResultList();
    }
    
    private List<User> checkPhoneUniqueness(EntityManager entityManager, User user){
        Query query = entityManager.createNamedQuery("User.findByPhoneNo", User.class )
                                    .setParameter("phoneNo", user.getPhoneNo());
                   
        return query.getResultList();
    }  
}
