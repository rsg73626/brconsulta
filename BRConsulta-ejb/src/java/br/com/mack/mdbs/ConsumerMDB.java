/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.mdbs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSConsumer;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author 31595472
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/brconsulta")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ConsumerMDB implements MessageListener {
    
    public ConsumerMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage)message;
        try {
            System.out.println(tm.getText());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String msg = tm.getText() + " as " + sdf.format(new Date()) + ". " + System.lineSeparator();           
            
//            FileOutputStream fos = new FileOutputStream(new File("C:\\Temp\\log.txt"));
//            fos.write(msg.getBytes());
//            fos.close();
            
            File arquivo = new File("C:\\Temp\\log.txt");
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(msg);
            bw.flush();
            bw.close();
            
            
            
        } catch (JMSException ex) {
            Logger.getLogger(JMSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JMSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JMSConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
