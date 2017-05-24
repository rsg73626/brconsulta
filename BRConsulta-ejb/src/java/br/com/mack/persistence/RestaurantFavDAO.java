/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.persistence;

import br.com.mack.persistence.entities.Restaurant;
import java.util.List;

/**
 *
 * @author 41583469
 */
public class RestaurantFavDAO implements GenericDAO<Restaurant>{

    
    
    @Override
    public void create(Restaurant e) {
        
    }

    @Override
    public List<Restaurant> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Restaurant readById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Restaurant e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Restaurant e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
