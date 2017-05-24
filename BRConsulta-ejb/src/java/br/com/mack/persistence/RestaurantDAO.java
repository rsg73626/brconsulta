package br.com.mack.persistence;

import br.com.mack.persistence.entities.Restaurant;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@LocalBean
@Stateful
public class RestaurantDAO implements GenericDAO<Restaurant> {

    @PersistenceContext(unitName = "BRConsulta-ejbPU")
    private EntityManager em;

    @Override
    public void create(Restaurant e) {
        em.persist(e);
    }

    @Override
    public List<Restaurant> readAll() {
        Query q = em.createNamedQuery("SELECT re FROM Restaurant re");
        List<Restaurant> lista = q.getResultList();
        return lista;
    }

    @Override
    public Restaurant readById(long id) {
        return em.find(Restaurant.class, id);
    }

    @Override
    public void update(Restaurant e) {
        em.persist(e);
    }

    @Override
    public void delete(Restaurant e) {
        em.remove(em.merge(e));
    }
}
