/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.entities.Location;
import br.com.mack.persistence.entities.Restaurant;
import br.com.mack.persistence.entities.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41583469
 */
public class FavoritoController extends AbstractController{

    Location location = lookupLocationBean();

    Restaurant restaurant = lookupRestaurantBean();

    
    @Override
    public void execute() {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String url = request.getParameter("url");
        String city = request.getParameter("city");
        String address = request.getParameter("adrress");
        
        System.out.println(city);
        
        restaurant.setName(name);
        restaurant.setImage(image);
        restaurant.setUrl(url);
        
        location.setCity(city);
        location.setAddress(address);
        restaurant.setLocation(location);
                
        returnPage = "user_area/home.jsp";
        
        
    }

    private Restaurant lookupRestaurantBean() {
        try {
            Context c = new InitialContext();
            return (Restaurant) c.lookup("java:global/BRConsulta/BRConsulta-ejb/Restaurant!br.com.mack.persistence.entities.Restaurant");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Location lookupLocationBean() {
        try {
            Context c = new InitialContext();
            return (Location) c.lookup("java:global/BRConsulta/BRConsulta-ejb/Location!br.com.mack.persistence.entities.Location");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private User lookupUserBean() {
        try {
            Context c = new InitialContext();
            return (User) c.lookup("java:global/BRConsulta/BRConsulta-ejb/User!br.com.mack.persistence.entities.User");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}