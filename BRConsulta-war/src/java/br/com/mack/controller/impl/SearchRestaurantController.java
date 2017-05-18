/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.controller.impl;

import br.com.mack.controller.AbstractController;
import br.com.mack.parser.RestauranteParser;
import br.com.mack.persistence.entities.Restaurant;
import java.util.ArrayList;

/**
 *
 * @author 41583469
 */
public class SearchRestaurantController extends AbstractController{

    @Override
    public void execute() {
            String location = request.getParameter("restaurat");
            String content = RestauranteParser.openURL(location.replace(" ", "_"));
            ArrayList<Restaurant> rs = (ArrayList< Restaurant>) RestauranteParser.parser(content);
            request.getSession().setAttribute("restaurants", rs);
            returnPage = "resultado.jsp";
    }
    
}
