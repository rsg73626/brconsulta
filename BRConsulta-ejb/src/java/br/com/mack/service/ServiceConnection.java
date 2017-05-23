package br.com.mack.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceConnection {

    public static HttpURLConnection doConnection(String content) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL("https://developers.zomato.com/api/v2.1/search?entity_id=67&entity_type=city&q=" + content);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.10", 3128));
            conn = (HttpURLConnection) url.openConnection(proxy);
            //conn = (HttpURLConnection) url.openConnection();

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
        } catch (MalformedURLException | ProtocolException ex) {
            Logger.getLogger(ServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
}
