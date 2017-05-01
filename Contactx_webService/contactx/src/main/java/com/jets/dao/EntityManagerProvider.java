/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eslam
 */
public class EntityManagerProvider {
    
    public static final String CONTACT_DAO = "contact";
    public  static final String GROUP_DAO = "group";
    public  static final String USER_DAO = "user";
    
    /**
     * provides unique EntityManager for each DAO
     * @param dao
     * @return 
     */
    public static EntityManager getEntityManager(String dao){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate");
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
    
}
