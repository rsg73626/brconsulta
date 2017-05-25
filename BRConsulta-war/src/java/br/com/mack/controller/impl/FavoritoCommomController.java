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
import static com.sun.xml.ws.security.impl.policy.Constants.logger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41583469
 */
public class FavoritoCommomController extends AbstractController {

    CommonUserDAO commonUserDAO = lookupCommonUserDAOBean();

    ProducerSessionBeanLocal logger = lookupProducerSessionBeanLocal();

    
    
    
    private Restaurant restaurant;
    private Location location;
    private CommonUser commonUser;

    @Override
    public void execute() {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String url = request.getParameter("url");
        String city = request.getParameter("city");
        String address = request.getParameter("adrress");


        location = new Location(address, city);
        restaurant = new Restaurant(name, image, url, location);
        
        commonUser = (CommonUser) this.request.getSession().getAttribute("usuario");
        
        commonUser.addRestaurant(restaurant);

        commonUserDAO.update(commonUser);
        
        returnPage = "user_area/home.jsp";
        logger.sendMessage("Usuário " + commonUser.getUserName() + " favoritou o restaurante \"" + restaurant.getName() + "\"");
        

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

    private CommonUserDAO lookupCommonUserDAOBean() {
        try {
            Context c = new InitialContext();
            return (CommonUserDAO) c.lookup("java:global/BRConsulta/BRConsulta-ejb/CommonUserDAO!br.com.mack.persistence.CommonUserDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
