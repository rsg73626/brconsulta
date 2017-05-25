/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.CommonUserDAO;
import br.com.mack.persistence.entities.CommonUser;
import br.com.mack.persistence.entities.Location;
import br.com.mack.persistence.entities.Restaurant;
import br.com.mack.sessionbeans.ProducerSessionBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41583469
 */
public class FavoritoCommonController extends AbstractController {

    ProducerSessionBeanLocal logger = lookupProducerSessionBeanLocal();

    Restaurant restaurant = lookupRestaurantBean();

    CommonUserDAO userDAO = lookupCommonUserDAOBean();

    CommonUser user = lookupCommonUserBean();

    Location location = lookupLocationBean();

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

        user= (CommonUser) request.getSession().getAttribute("usuario");
        
        user.addRestaurant(restaurant);

        userDAO.create(user);
        logger.sendMessage("Usuário " + user.getUserName() + " favoritou o restaurante " + restaurant.getId() + ": \"" + restaurant.getName() + "\"");

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

    private CommonUser lookupCommonUserBean() {
        try {
            Context c = new InitialContext();
            return (CommonUser) c.lookup("java:global/BRConsulta/BRConsulta-ejb/CommonUser!br.com.mack.persistence.entities.CommonUser");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CommonUserDAO lookupCommonUserDAOBean() {
        try {
            Context c = new InitialContext();
            return (CommonUserDAO) c.lookup("java:global/BRConsulta/BRConsulta-ejb/CommonUserDAO!br.com.mack.persistence.CommonUserDAO");
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

    private ProducerSessionBeanLocal lookupProducerSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (ProducerSessionBeanLocal) c.lookup("java:global/BRConsulta/BRConsulta-ejb/ProducerSessionBean!br.com.mack.sessionbeans.ProducerSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
