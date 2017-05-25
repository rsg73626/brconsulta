/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.sessionbeans;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 31595472
 */
@Local
public interface ProducerSessionBeanLocal {

    void sendMessage(String message);
    
}
