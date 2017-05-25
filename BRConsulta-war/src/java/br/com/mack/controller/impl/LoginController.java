/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.CommonUserDAO;
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
public class LoginController extends AbstractController {

    ProducerSessionBeanLocal logger = lookupProducerSessionBeanLocal();

    CommonUserDAO commonUserDAO = lookupCommonUserDAOBean();

    @Override
    public void execute() {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        User user = null;
        user = ((CommonUserDAO) commonUserDAO).login(usuario, senha);

        if (user != null) {
            this.returnPage = "user_area/home.jsp";
            this.request.getSession().setAttribute("usuario", user);
            logger.sendMessage("Usuário " + user.getUserName() + " logou");
        } else {
            this.returnPage = "erro.jsp";
            this.request.getSession().setAttribute("errorMessages", new String[]{"Usuário ou senha incorreto!"});
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
