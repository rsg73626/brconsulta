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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)//Uma tabela para cada classe (incluindo a abstrata)
@Local
@XmlRootElement
public abstract class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;

    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private String email;

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

    public String getBirthdayAsString() {
        if(birthday != null)
            return new SimpleDateFormat("dd/MM/yyyy").format(birthday);
        return "";
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
        if(birthday.contains("/")){
            String[] dateParts = birthday.split("/");
            String ano = dateParts[2];
            String mes = dateParts[1];
            String dia = dateParts[0];
            birthday = ano + "-" + mes + "-" + dia;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthday = df.parse(birthday);
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant r) {
        this.restaurants.add(r);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullName=" + fullName + ", birthday=" + birthday + ", email=" + email + ", userName=" + userName + '}';
    }

}
