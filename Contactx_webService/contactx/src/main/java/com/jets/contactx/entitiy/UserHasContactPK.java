/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.entitiy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eslam
 */
@Embeddable
public class UserHasContactPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users_id")
    private int usersId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contacts_id")
    private int contactsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "groups_id")
    private int groupsId;

    public UserHasContactPK() {
    }

    public UserHasContactPK(int usersId, int contactsId, int groupsId) {
        this.usersId = usersId;
        this.contactsId = contactsId;
        this.groupsId = groupsId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getContactsId() {
        return contactsId;
    }

    public void setContactsId(int contactsId) {
        this.contactsId = contactsId;
    }

    public int getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(int groupsId) {
        this.groupsId = groupsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usersId;
        hash += (int) contactsId;
        hash += (int) groupsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasContactPK)) {
            return false;
        }
        UserHasContactPK other = (UserHasContactPK) object;
        if (this.usersId != other.usersId) {
            return false;
        }
        if (this.contactsId != other.contactsId) {
            return false;
        }
        if (this.groupsId != other.groupsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jets.contactx.entitiy.UserHasContactPK[ usersId=" + usersId + ", contactsId=" + contactsId + ", groupsId=" + groupsId + " ]";
    }
    
}
