/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.entities.User;
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
public class LogoutController extends AbstractController{

    ProducerSessionBeanLocal logger = lookupProducerSessionBeanLocal();

    @Override
    public void execute() {
        User user = (User)request.getSession().getAttribute("usuario");
        this.request.getSession().invalidate();
        this.returnPage = "signin.jsp";
        logger.sendMessage("Usuário " + user.getUserName() + " deslogou");
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
