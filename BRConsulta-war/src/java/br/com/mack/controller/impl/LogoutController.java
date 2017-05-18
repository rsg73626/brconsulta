/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;

/**
 *
 * @author 31595472
 */
public class LogoutController extends AbstractController{

    @Override
    public void execute() {
        this.request.getSession().invalidate();
        this.returnPage = "signin.jsp";
    }
    
}
