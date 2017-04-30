/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.entitiy;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eslam
 */
@Entity
@Table(name = "user_has_contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHasContact.findAll", query = "SELECT u FROM UserHasContact u")
    , @NamedQuery(name = "UserHasContact.findByUsersId", query = "SELECT u FROM UserHasContact u WHERE u.userHasContactPK.usersId = :usersId")
    , @NamedQuery(name = "UserHasContact.findByContactsId", query = "SELECT u FROM UserHasContact u WHERE u.userHasContactPK.contactsId = :contactsId")
    , @NamedQuery(name = "UserHasContact.findByGroupsId", query = "SELECT u FROM UserHasContact u WHERE u.userHasContactPK.groupsId = :groupsId")})
public class UserHasContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasContactPK userHasContactPK;
    @JoinColumn(name = "contacts_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contact contact;
    @JoinColumn(name = "groups_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Group1 group1;
    @JoinColumn(name = "users_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public UserHasContact() {
    }

    public UserHasContact(UserHasContactPK userHasContactPK) {
        this.userHasContactPK = userHasContactPK;
    }

    public UserHasContact(int usersId, int contactsId, int groupsId) {
        this.userHasContactPK = new UserHasContactPK(usersId, contactsId, groupsId);
    }

    public UserHasContactPK getUserHasContactPK() {
        return userHasContactPK;
    }

    public void setUserHasContactPK(UserHasContactPK userHasContactPK) {
        this.userHasContactPK = userHasContactPK;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Group1 getGroup1() {
        return group1;
    }

    public void setGroup1(Group1 group1) {
        this.group1 = group1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userHasContactPK != null ? userHasContactPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasContact)) {
            return false;
        }
        UserHasContact other = (UserHasContact) object;
        if ((this.userHasContactPK == null && other.userHasContactPK != null) || (this.userHasContactPK != null && !this.userHasContactPK.equals(other.userHasContactPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jets.contactx.entitiy.UserHasContact[ userHasContactPK=" + userHasContactPK + " ]";
    }
    
}
