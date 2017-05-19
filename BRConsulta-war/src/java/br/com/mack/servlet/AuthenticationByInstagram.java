package br.com.mack.servlet;

import br.com.mack.parser.InstagramUserJSONParser;
import br.com.mack.parser.JSONParser;
import br.com.mack.persistence.GenericDAO;
import br.com.mack.persistence.InstagramUserDAO;
import br.com.mack.persistence.entities.InstagramUser;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31595472
 */
@WebServlet(name = "AuthenticationByInstagram", urlPatterns = {"/AuthenticationByInstagram"})
public class AuthenticationByInstagram extends HttpServlet {

    
    private InstagramUserJSONParser parser = new InstagramUserJSONParser();
    
    private InstagramUserDAO dao = new InstagramUserDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String CLIENT_ID = "1631b13910b44f0a8b95f3c96b061470";
    private final String CLIENT_SECRET = "d5860134357c45b5a1dcc795f6912eaa";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code, error, error_reason, error_description;

        error = request.getParameter("error");

        if (error == null) {
            code = request.getParameter("code");
            System.out.println(code);

            //Requisição para pegar token
            String uri = "https://api.instagram.com/oauth/access_token";
            URL url = new URL(uri);

            //Conexão HTTP
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.10", 3128));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);

            //Requet Header
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            String redirect_uri = "http://localhost:8080/BRConsulta-war/AuthenticationByInstagram";
            String urlParameters = "client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=" + code + "&grant_type=authorization_code&redirect_uri=" + redirect_uri;
            //String urlParameters = "client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=" + code + "&grant_type=public_content&redirect_uri=" + redirect_uri;
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer resp = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    resp.append(inputLine);
                }
                in.close();

                System.out.println("**********PRINTANDO DAO E PARSER**********");
                System.out.println(dao);
                System.out.println(parser);

                InstagramUser u = (InstagramUser) parser.parse(resp.toString());
                u.setEmail("teste@teste.com");
                u.setBirthday("1997-02-17");
                System.out.println("*************USUARIO DO INSTAGRAM************");
                System.out.println(u);
                
                InstagramUser usuario = ((InstagramUserDAO) dao).readByInstagramId(u.getInstagramId());
                System.out.println("Usuário do Instagram: " + usuario);
                if (usuario == null) {
                    System.out.println(dao);
                    dao.create(u);
                }

                request.getSession().setAttribute("usuario", u);
                request.getSession().setAttribute("usuario_instagram", true);
                request.getRequestDispatcher("user_area/home.jsp").forward(request, response);
            }
        } else {
            error_reason = request.getParameter("error_reason");
            error_description = request.getParameter("error_description");
            request.getSession().setAttribute("errorMessages", new String[]{error_reason, error_description});
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
