/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bruno
 */
@Local
public interface GenericDAO<E> {

    public void create(E e);

    public List<E> readAll();

    public E readById(long id);

    public void update(E e);

    public void delete(E e);
}
