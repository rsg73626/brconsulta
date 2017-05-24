/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.InstagramUserDAO;
import br.com.mack.persistence.entities.InstagramUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 31595472
 */
public class UpdateInstagramProfileController extends AbstractController {

    InstagramUserDAO instagramUserDAO = lookupInstagramUserDAOBean();

    @Override
    public void execute() {
        String fullName = this.request.getParameter("nome_completo");
        String birthday = this.request.getParameter("dt_nasc");
        String email = this.request.getParameter("email");

        if (fullName != null && birthday != null && email != null) {
            InstagramUser usuario = (InstagramUser) this.request.getSession().getAttribute("usuario");

            usuario.setFullName(fullName);
            usuario.setBirthday(birthday);
            usuario.setEmail(email);

            instagramUserDAO.update(usuario);

            this.returnPage = "user_area/profile.jsp";
        } else {
            List<String> erros = new ArrayList();
            if (fullName == null) {
                erros.add("Preencha o campo \"Nome Completo\"!");
            }
            if (birthday == null) {
                erros.add("Preencha o campo \"Data de Nascimento\"!");

            }
            if (email == null) {
                erros.add("Preencha o campo \"E-mail\"!");

            }
            this.request.getSession().setAttribute("errorMessages", erros);
            this.returnPage = "erro.jsp";
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
