/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.CommonUserDAO;
import br.com.mack.persistence.InstagramUserDAO;
import br.com.mack.persistence.entities.CommonUser;
import br.com.mack.persistence.entities.InstagramUser;
import br.com.mack.sessionbeans.ProducerSessionBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 31595472
 */
public class UnsubscribeController extends AbstractController{

    ProducerSessionBeanLocal logger = lookupProducerSessionBeanLocal();

    InstagramUserDAO instagramUserDAO = lookupInstagramUserDAOBean();

    CommonUserDAO commonUserDAO = lookupCommonUserDAOBean();
    
    
    
    @Override
    public void execute() {
        String userName;
        if(this.request.getSession().getAttribute("usuario_instagram") != null){            
            InstagramUser usuario = (InstagramUser)this.request.getSession().getAttribute("usuario"); 
            instagramUserDAO.delete(usuario);
            userName = usuario.getUserName();
        }else{
            CommonUser usuario = (CommonUser)this.request.getSession().getAttribute("usuario"); 
            commonUserDAO.delete(usuario);
            userName = usuario.getUserName();
        }
        logger.sendMessage("Usuário " + userName + " deletou sua conta");
        this.returnPage = "index.jsp";
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
