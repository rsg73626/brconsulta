package br.com.mack.rest;

import br.com.mack.persistence.CommonUserDAO;
import br.com.mack.persistence.InstagramUserDAO;
import br.com.mack.persistence.entities.InstagramUser;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.mack.persistence.entities.Restaurant;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.PathParam;

/**
 *
 * @author 41583469
 */
@Path("/favoritos")
public class Favorito {

    CommonUserDAO commonUserDAO = lookupCommonUserDAOBean();

    InstagramUserDAO instagramUserDAO = lookupInstagramUserDAOBean();
    
    

    

    public Favorito() {
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("/usuario-insta/{id}")
    public List<Restaurant> userInsta(@PathParam("id") int id) {
        InstagramUser user = instagramUserDAO.readById(id);
        System.out.println("Instagram User: " + user);
        System.out.println("Restaurantes: " + user.getRestaurants().size());
        return user.getRestaurants();
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
