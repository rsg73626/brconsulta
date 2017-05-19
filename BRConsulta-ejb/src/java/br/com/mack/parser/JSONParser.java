/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.parser;

import java.io.Serializable;
import javax.ejb.Local;

/**
 *
 * @author 31595472
 */
public interface JSONParser<E> extends Serializable{
    E parse(String content);    
}
