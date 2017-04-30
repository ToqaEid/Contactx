/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.dao;

import com.jets.contactx.entitiy.*;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author Eslam
 */
public class ContactDAO {

    public ArrayList<Contact> getAllContacts(int userId) {
        return null;
    }

    public ArrayList<Contact> getGroupContacts(int userId, int groupId) {
        return null;
    }

    public Contact getContactDetails(int contactId) {
        return null;
    }

    public boolean addOrUpdateContact(Contact contact) {
        return false;
    }

    public boolean deleteContact(int contactId) {
        return false;
    }

    public boolean purgeContacts(int userId) {
        return false;
    }

}
