package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.parser.RestauranteParser;
import br.com.mack.persistence.entities.Restaurant;
import br.com.mack.persistence.entities.User;
import br.com.mack.sessionbeans.ProducerSessionBeanLocal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 41583469
 */
public class SearchRestaurantController extends AbstractController {

    ProducerSessionBeanLocal logger = lookupProducerSessionBeanLocal();

    RestauranteParser restaurante = lookupRestauranteParserBean();

    @Override
    public void execute() {
        String location = request.getParameter("restaurat");
        String content = RestauranteParser.openURL(location.replace(" ", "+"));

        ArrayList<Restaurant> rs = (ArrayList<Restaurant>) restaurante.parse(content);
        request.getSession().setAttribute("restaurants", rs);
        returnPage = "user_area/home.jsp";
        
        User user = (User)request.getSession().getAttribute("usuario");
        logger.sendMessage("Usuário " + user.getUserName() + " buscou por \"" + location + "\"");
    }

    private RestauranteParser lookupRestauranteParserBean() {
        try {
            Context c = new InitialContext();
            return (RestauranteParser) c.lookup("java:global/BRConsulta/BRConsulta-ejb/RestauranteParser!br.com.mack.parser.RestauranteParser");
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
