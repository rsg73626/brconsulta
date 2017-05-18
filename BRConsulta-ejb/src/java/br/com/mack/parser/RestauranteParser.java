/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mack.parser;


import br.com.mack.persistence.entities.Location;
import br.com.mack.persistence.entities.Restaurant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author 41583469
 */
public class RestauranteParser {

    public static String openURL(String place) {

        String return_str = "";
        try {
            URL url = new URL("https://developers.zomato.com/api/v2.1/search?entity_id=67&entity_type=city&q=" + place);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.10", 3128));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);

            System.setProperty("java.net.preferIPv4Stack", "true");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("user-key", "0b6da3cfc82f81a5f3188d4cf0b340d0");

//            conn.setRequestProperty("entity_id", "67");
//            conn.setRequestProperty("entity_type", "city");
//            conn.setRequestProperty("q", "Companhia do Café - GreenPlace");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            int code = conn.getResponseCode();

            if (code == 407) {
                System.out.println("Falha na autenticação do proxy");
            } else if (code == 200) {
                System.out.println("Sucesso");
                String output;
                StringBuilder resp = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                while ((output = br.readLine()) != null) {
                    resp.append(output);
                }
                br.close();

                return_str = resp.toString();
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(RestauranteParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RestauranteParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_str;
    }

    public static List<Restaurant> parser(String content) {
        Restaurant r = null;
        JsonObject root;
        try (JsonReader reader = Json.createReader(new StringReader(content))) {
            root = reader.readObject();
        }

        JsonArray restaurants = root.getJsonArray("restaurants");

        List<Restaurant> restList = new ArrayList<>();

        for (int i = 0; i < restaurants.size(); i++) {

            JsonObject rest = restaurants.getJsonObject(i);
//            System.out.println(rest);

            JsonObject restaurant = rest.getJsonObject("restaurant");
            String name = restaurant.getJsonString("name").toString();
            String url = restaurant.getJsonString("url").toString();
            String image = restaurant.getJsonString("thumb").toString();
//            System.out.println(image);
            r = new Restaurant(name, image, url);

            JsonObject location = restaurant.getJsonObject("location");
            String address = location.getJsonString("address").getString();
            String city = location.getJsonString("city").getString();
            r.setLocation(new Location(address, city));
            restList.add(r);
//            System.out.println(address);
//            System.out.println(city);
//            System.out.println(name);
//            System.out.println(url);

        }
        return restList;
    }
}
