/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence;

import br.com.mack.persistence.entities.CommonUser;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
@LocalBean
@Stateful
public class CommonUserDAO implements GenericDAO<CommonUser> {

    @PersistenceContext(name = "BRConsulta-ejbPU")
    private EntityManager em;

    @Override
    public void create(CommonUser e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<CommonUser> readAll() {
        Query q = em.createQuery("SELECT cu FROM CommonUser cu");
        List<CommonUser> lista = q.getResultList();
        return lista;
    }

    @Override
    public CommonUser readById(long id) {
        return em.find(CommonUser.class, id);
    }

    public CommonUser readByUserName(String userName) {
        try {
            return (CommonUser) em.createQuery("SELECT cu FROM CommonUser cu WHERE cu.userName = :un")
                    .setParameter("un", userName)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void update(CommonUser e) {
        em.persist(em.merge(e));
    }

    @Override
    public void delete(CommonUser e) {
        em.remove(em.merge(e));
    }

    public CommonUser login(String userName, String password) {
        try {
            return (CommonUser) em.createQuery("SELECT cu FROM CommonUser cu WHERE cu.userName = :un and cu.password = :p")
                    .setParameter("un", userName)
                    .setParameter("p", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
