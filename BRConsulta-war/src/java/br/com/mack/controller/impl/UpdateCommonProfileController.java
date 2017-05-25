/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.persistence.CommonUserDAO;
import br.com.mack.persistence.entities.CommonUser;
import br.com.mack.persistence.entities.User;
import br.com.mack.sessionbeans.ProducerSessionBeanLocal;
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
public class UpdateCommonProfileController extends AbstractController {

    ProducerSessionBeanLocal logger = lookupProducerSessionBeanLocal();

    CommonUserDAO commonUserDAO = lookupCommonUserDAOBean();

    @Override
    public void execute() {
        String fullName = this.request.getParameter("nome_completo");
        String birthday = this.request.getParameter("dt_nasc");
        String email = this.request.getParameter("email");
        String senha = this.request.getParameter("senha");
        String confirmacaoSenha = this.request.getParameter("conf_senha");

        if (fullName != null && birthday != null && email != null && senha != null && confirmacaoSenha != null && senha.equals(confirmacaoSenha)) {
            CommonUser usuario = (CommonUser) this.request.getSession().getAttribute("usuario");

            usuario.setFullName(fullName);
            usuario.setBirthday(birthday);
            usuario.setEmail(email);
            usuario.setPassword(senha);

            commonUserDAO.update(usuario);

            this.returnPage = "user_area/profile.jsp";
            logger.sendMessage("Usuário " + usuario.getUserName() + " alterou dados de perfil");
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
            if (senha == null) {
                erros.add("Preencha o campo \"Senha\"!");

            }
            if (confirmacaoSenha == null) {
                erros.add("Preencha o campo \"Confirmação de Senha\"!");

            }
            if (!senha.equals(confirmacaoSenha)) {
                erros.add("Os campos \"Senha\" e \"Confirmação de Senha\" devem ser iguais!");

            }
            this.request.getSession().setAttribute("errorMessages", erros);
            this.returnPage = "erro.jsp";
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
