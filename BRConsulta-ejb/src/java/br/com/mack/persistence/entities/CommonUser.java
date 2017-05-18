/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence.entities;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author 31595472
 */
@Entity
public class CommonUser extends User{
    private String password;

    public CommonUser() {
    }

    public CommonUser(String password, String fullName, Date birthday, String email, String userName) {
        super(fullName, birthday, email, userName);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CommonUser{" + "password=" + password + '}';
    }
    
    
}
