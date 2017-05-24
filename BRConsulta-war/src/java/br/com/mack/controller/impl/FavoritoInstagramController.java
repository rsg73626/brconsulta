/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.InstagramUserDAO;
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
public class FavoritoInstagramController extends AbstractController {

    private InstagramUserDAO instagramUserDAO = lookupInstagramUserDAOBean();   
    private Restaurant restaurant;
    private InstagramUser instagramUser;
    private Location location;
    
    @Override
    public void execute() {
        String name = request.getParameter("name");
        String image = request.getParameter("imagem");
        String url = request.getParameter("url");
        String city = request.getParameter("city");
        String address = request.getParameter("adrress");
        
        location = new Location(address, city);
        restaurant = new Restaurant(name, image, url, location);
        
//        long id = ((InstagramUser) request.getSession().getAttribute("usuario")).getId();
//        
//        instagramUser = instagramUserDAO.readById(id);

        instagramUser = (InstagramUser) this.request.getSession().getAttribute("usuario");

        instagramUser.addRestaurant(restaurant);

        instagramUserDAO.update(instagramUser);

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

}