/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence;

import br.com.mack.persistence.entities.InstagramUser;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author 31595472
 */
@LocalBean
@Stateful
public class InstagramUserDAO implements GenericDAO<InstagramUser> {

    @PersistenceContext(name = "BRConsulta-ejbPU")
    private EntityManager em;    

    @Override
    public void create(InstagramUser insta) {
        try {
            em.persist(insta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<InstagramUser> readAll() {
        return em.createQuery("SELECT iu FROM InstagramUser iu", InstagramUser.class).getResultList();
    }

    @Override
    public InstagramUser readById(long id) {
        return em.find(InstagramUser.class, id);
    }

    public InstagramUser readByInstagramId(long id) {
        System.out.println(em != null);
        try {
            return em.createQuery("SELECT iu FROM InstagramUser iu WHERE iu.instagramId = :id", InstagramUser.class).setParameter("id", id).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void update(InstagramUser e) {
        em.persist(e);
    }

    @Override
    public void delete(InstagramUser e) {
        em.remove(em.merge(e));
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public void persist1(Object object) {
        em.persist(object);
    }

    public void persist2(Object object) {
        em.persist(object);
    }

    public void persist3(Object object) {
        em.persist(object);
    }

}
