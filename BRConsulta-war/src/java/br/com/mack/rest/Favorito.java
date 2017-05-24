package br.com.mack.rest;

import br.com.mack.persistence.CommonUserDAO;
import br.com.mack.persistence.InstagramUserDAO;
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

    InstagramUserDAO instagramUserDAO = lookupInstagramUserDAOBean();

    CommonUserDAO commonUserDAO = lookupCommonUserDAOBean();

    public Favorito() {
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("/usuario-insta/{id}")
    public List<Restaurant> userInsta(@PathParam("id") int id) {
        return instagramUserDAO.readById(id).getRestaurants();
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("/usuario-commom/{id}")
    public List<Restaurant> userCommmom(@PathParam("id") int id) {
        System.out.println(id);
        return instagramUserDAO.readById(id).getRestaurants();
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

    private InstagramUserDAO lookupInstagramUserDAOBean() {
        try {
            Context c = new InitialContext();
            return (InstagramUserDAO) c.lookup("java:global/BRConsulta/BRConsulta-ejb/InstagramUserDAO!br.com.mack.persistence.InstagramUserDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
