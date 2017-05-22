/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.parser;

import br.com.mack.persistence.entities.InstagramUser;
import br.com.mack.persistence.entities.User;
import java.io.StringReader;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author 31595472
 */
@LocalBean
@Stateful
public class InstagramUserJSONParser implements JSONParser<User>{

    public InstagramUserJSONParser() {
    }   

    @Override
    public User parse(String content) {
        User user = null;

        //Leitor do JSON
        JsonReader reader = Json.createReader(new StringReader(content));
        //Objeto raiz
        JsonObject root = reader.readObject();
        //Fechando reader, uma vez que o mesmo não é mais necessário, já que pegamos o objeto raiz
        reader.close();

        JsonObject u = root.getJsonObject("user");

        System.out.println(u.containsKey("email"));
        System.out.println(u.containsKey("username"));

        long id = Long.parseLong(u.getJsonString("id").getString());
        String username = u.getJsonString("username").getString();
        String profilePicture = u.getJsonString("profile_picture").getString();
        String fullName = u.getJsonString("full_name").getString();
        String accessToken = root.getJsonString("access_token").getString();
        user = new InstagramUser(id, profilePicture, accessToken, fullName, null, null, username);
        
        return user;
    }

}
