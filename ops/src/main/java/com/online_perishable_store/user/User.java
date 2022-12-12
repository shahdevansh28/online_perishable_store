package com.online_perishable_store.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class User {
    
    @Id
    @GeneratedValue
    public Long userid;
    @Column(name="email")
    public String email;
    @Column(name="password")
    public String password;
    @Column(name="usertype")
    public String userType;
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public Long getUserid() {
        return userid;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getUserType(){
        return this.userType;
    }
    public void setUserType(String userType){
        this.userType=userType;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    @Override
    public String toString(){
        return "User{" + "userid=" + userid +"} "+" email {" + email +"} "+ "userType { " + userType + " } ";
    }
}
