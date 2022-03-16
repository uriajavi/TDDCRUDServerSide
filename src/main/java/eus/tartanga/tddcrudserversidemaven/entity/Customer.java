/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eus.tartanga.tddcrudserversidemaven.entity;

import java.io.Serializable;
import javax.enterprise.context.Dependent;

/**
 * Customer TDD entity.
 * @author javi
 */
@Dependent
public class Customer implements Serializable{

    private Long id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private Long phone;
    private String email;
    
    public void setId(Long id) {
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial=middleInitial;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setStreet(String street) {
        this.street=street;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city=city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state=state;
    }

    public String getState() {
        return state;
    }

    public void setZip(Integer zip) {
        this.zip=zip;
    }

    public Integer getZip() {
        return zip;
    }

    public void setPhone(Long phone) {
        this.phone=phone;
    }

    public Long getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString(){
        return "Customer: ID="+id+" NAME="+firstName+" "+lastName;
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
    
    @Override
    public boolean equals(Object object){
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || 
            (this.id != null && !this.id.equals(other.id))||
            (this.firstName == null && other.firstName != null) || 
            (this.firstName != null && !this.firstName.equals(other.firstName))||
            (this.lastName == null && other.lastName != null) || 
            (this.lastName != null && !this.lastName.equals(other.lastName))) {
            return false;
        }
        return true;
    }
}
