/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)//Uma tabela para cada classe (incluindo a abstrata)
public abstract class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String fullName;
    
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    private String email;
    
    @Column(unique = true)
    private String userName;

    public User() {
    }

    public User(String fullName, Date birthday, String email, String userName) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }
    
    public String getBirthdayAsString(){
        return new SimpleDateFormat("dd/MM/yyyy").format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setBirthday(String birthday) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthday = df.parse(birthday);
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullName=" + fullName + ", birthday=" + birthday + ", email=" + email + ", userName=" + userName + '}';
    }
    
    

}
