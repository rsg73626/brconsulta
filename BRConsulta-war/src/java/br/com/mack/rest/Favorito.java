package br.com.mack.rest;

import br.com.mack.persistence.entities.Location;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.mack.persistence.entities.Restaurant;
import javax.ws.rs.PathParam;

/**
 *
 * @author 41583469
 */
@Path("/favoritos")
public class Favorito {

    public Favorito() {
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("/usuario/{id}")
    public Restaurant favorito(@PathParam("id") String id) {
        System.out.println(id);
        Restaurant r = new Restaurant("Bruno", "www.googe.com", "www.google.com.br");
        Location l = new Location();
        l.setAddress("Rua Inocencio Pires de oliveira");
        r.setLocation(l);
        return r;
    }
}
