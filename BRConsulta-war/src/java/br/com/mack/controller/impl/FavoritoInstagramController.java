/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.InstagramUserDAO;
import br.com.mack.persistence.RestaurantDAO;
import br.com.mack.persistence.entities.InstagramUser;
import br.com.mack.persistence.entities.Location;
import br.com.mack.persistence.entities.Restaurant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41583469
 */
public class FavoritoInstagramController extends AbstractController{

    RestaurantDAO restaurantDAO = lookupRestaurantDAOBean();

    Restaurant restaurant = lookupRestaurantBean();

    Location location = lookupLocationBean();

    InstagramUser instagramUser = lookupInstagramUserBean();

    InstagramUserDAO instagramUserDAO = lookupInstagramUserDAOBean();

    
    
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
        
        //instagramUser.addRestaurant(restaurant);
        
        //instagramUserDAO.update(instagramUser);
        
        restaurantDAO.create(restaurant);
                
        returnPage = "user_area/home.jsp";
        
        
    }

    private InstagramUserDAO lookupInstagramUserDAOBean() {
        try {
            Context c = new InitialContext();
            return (InstagramUserDAO) c.lookup("java:global/BRConsulta/BRConsulta-ejb/InstagramUserDAO!br.com.mack.persistence.InstagramUserDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private InstagramUser lookupInstagramUserBean() {
        try {
            Context c = new InitialContext();
            return (InstagramUser) c.lookup("java:global/BRConsulta/BRConsulta-ejb/InstagramUser!br.com.mack.persistence.entities.InstagramUser");
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

    private Restaurant lookupRestaurantBean() {
        try {
            Context c = new InitialContext();
            return (Restaurant) c.lookup("java:global/BRConsulta/BRConsulta-ejb/Restaurant!br.com.mack.persistence.entities.Restaurant");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private RestaurantDAO lookupRestaurantDAOBean() {
        try {
            Context c = new InitialContext();
            return (RestaurantDAO) c.lookup("java:global/BRConsulta/BRConsulta-ejb/RestaurantDAO!br.com.mack.persistence.RestaurantDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
