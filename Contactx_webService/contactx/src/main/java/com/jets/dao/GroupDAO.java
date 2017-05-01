/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.dao;

import com.jets.contactx.entitiy.Group1;
import com.jets.contactx.entitiy.GroupContactsCount;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author Eslam
 */
public class GroupDAO {

    public ArrayList<GroupContactsCount> getGroupsContactsCount(int userId) {
        
        EntityManager ent =  EntityManagerProvider.getEntityManager(EntityManagerProvider.GROUP_DAO);
        //Samy
        return null;
    }

    public ArrayList<Group1> getGroups(int userId) {
        EntityManager ent =  EntityManagerProvider.getEntityManager(EntityManagerProvider.GROUP_DAO);
        //Samy
        return null;
    }
}
