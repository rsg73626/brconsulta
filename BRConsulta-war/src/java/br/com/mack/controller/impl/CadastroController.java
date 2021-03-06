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
 * @author Bruno
 */
public class CadastroController extends AbstractController {

    ProducerSessionBeanLocal logger = lookupProducerSessionBeanLocal();

    CommonUserDAO commonUserDAO = lookupCommonUserDAOBean();

    @Override
    public void execute() {
        this.returnPage = "user_area/home.jsp";

        String senha = request.getParameter("senha");
        String confirmacaoSenha = request.getParameter("conf_senha");
        CommonUser user = new CommonUser();
        user.setFullName(request.getParameter("nome_completo"));
        user.setBirthday(request.getParameter("dt_nasc"));
        user.setEmail(request.getParameter("email"));
        user.setUserName(request.getParameter("usuario"));
        user.setPassword(senha);

        boolean erro = false;
        List<String> erros = new ArrayList();

        if (user.getFullName() == null) {
            erro = true;
            erros.add("Preencha o campo NOME COMPLETO");
        }
        if (user.getEmail() == null) {
            erro = true;
            erros.add("Preencha o campo E-MAIL");
        }
        if (user.getUserName() == null) {
            erro = true;
            erros.add("Preencha o campo NOME DE USUÁRIO");
        }
        if (user.getPassword() == null) {
            erro = true;
            erros.add("Preencha o campo SENHA");
        }
        if (!senha.equals(confirmacaoSenha)) {
            erro = true;
            erros.add("Os campos SENHA e CONFIRMAÇÃO DE SENHA devem possuir valores iguais");
        }

        CommonUser usuario = commonUserDAO.readByUserName(user.getUserName());
        System.out.println("Fez a busca corretamente!");
        if (usuario != null) {
            erro = true;
            erros.add("Já existe um usuário cadastrado com este NOME DE USUÁRIO");
        }

        if (erro) {
            this.returnPage = "erro.jsp";
            this.request.getSession().setAttribute("errorMessages", erros);
            return;
        }

        try {
            commonUserDAO.create(user);
            request.getSession().setAttribute("usuario", user);
            logger.sendMessage("Usuário " + user.getUserName() + " registrou-se");
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            this.request.getSession().setAttribute("errorMessages", new String[]{"Erro interno de Servidor"});
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
