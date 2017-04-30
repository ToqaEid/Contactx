/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.contactx.entitiy;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Eslam
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
    , @NamedQuery(name = "Contact.findById", query = "SELECT c FROM Contact c WHERE c.id = :id")
    , @NamedQuery(name = "Contact.findByName", query = "SELECT c FROM Contact c WHERE c.name = :name")
    , @NamedQuery(name = "Contact.findByImgPath", query = "SELECT c FROM Contact c WHERE c.imgPath = :imgPath")
    , @NamedQuery(name = "Contact.findByTitle", query = "SELECT c FROM Contact c WHERE c.title = :title")
    , @NamedQuery(name = "Contact.findByCompany", query = "SELECT c FROM Contact c WHERE c.company = :company")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "img_path")
    private String imgPath;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "company")
    private String company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactsId", fetch = FetchType.LAZY)
    private List<Address> addressList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactsId", fetch = FetchType.LAZY)
    private List<Phone> phoneList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact", fetch = FetchType.LAZY)
    private List<UserHasContact> userHasContactList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactsId", fetch = FetchType.LAZY)
    private List<Email> emailList;

    public Contact() {
    }

    public Contact(Integer id) {
        this.id = id;
    }

    public Contact(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @XmlTransient
    @JsonIgnore
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @XmlTransient
    @JsonIgnore
    public List<UserHasContact> getUserHasContactList() {
        return userHasContactList;
    }

    public void setUserHasContactList(List<UserHasContact> userHasContactList) {
        this.userHasContactList = userHasContactList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jets.contactx.entitiy.Contact[ id=" + id + " ]";
    }
    
}
