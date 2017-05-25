/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.sessionbeans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 31595472
 */
@Stateless
public class ProducerSessionBean implements ProducerSessionBeanLocal {

    @Resource(mappedName = "jms/brconsulta")
    private Queue brconsulta;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private void sendJMSMessageToBrconsulta(String messageData) {
        context.createProducer().send(brconsulta, messageData);
    }

    @Override
    public void sendMessage(String message) {
        
        this.sendJMSMessageToBrconsulta(message);
        
    }

    

    

}
