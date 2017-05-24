/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence;

import br.com.mack.persistence.entities.CommonUser;
import br.com.mack.persistence.entities.Restaurant;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 41583469
 */
@LocalBean
@Stateful
public class RestaurantDAO implements GenericDAO<Restaurant> {

    @PersistenceContext(name = "BRConsulta-ejbPU")
    private EntityManager em;

    @Override
    public void create(Restaurant restaurant) {
        em.persist(restaurant);
    }

    @Override
    public List<Restaurant> readAll() {
        Query q = em.createQuery("SELECT re FROM Restaurant re");
        List<Restaurant> lista = q.getResultList();
        return lista;
    }

    @Override
    public Restaurant readById(long id) {
        return em.find(Restaurant.class, id);
    }

    @Override
    public void update(Restaurant e) {
        em.persist(em.merge(e));
    }

    @Override
    public void delete(Restaurant e) {
        em.remove(em.merge(e));
    }

}
