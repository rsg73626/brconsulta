package br.com.mack.taglib;

import br.com.mack.persistence.entities.Restaurant;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 *
 * @author Bruno
 */
public class RestaurantTag extends SimpleTagSupport {

    private List<Restaurant> items;
    private String context;

    public void setItems(List<Restaurant> items) {
        this.items = items;
    }

    public void setContext(String context) {
        this.context = context;
    }
    

    private StringWriter sw = new StringWriter();

    @Override
    public void doTag() {
        try {
            JspWriter out = getJspContext().getOut();
            for (Restaurant restaurant : items) {
                out.println("<div id='bloco'>"
                        + "<div id=\"description\"><h1>" + restaurant.getName() + "</h1><h3>Endereço</h3><p>" + restaurant.getLocation().getAddress() + "</p></div>"
                        + "<div id=\"foto\"><img src=" + restaurant.getImage() + "></div>");                

                out.print("<form method=\"post\" action=\""+context+"/FrontController\">\n" +
"    <input type=\"text\" hidden name=\"name\" value=\""+restaurant.getName().replace("\"", "")+"\">\n" +
"    <input type=\"text\" hidden name=\"imagem\" value=\""+restaurant.getImage().replace("\"", "")+"\">\n" +
"    <input type=\"text\" hidden name=\"url\" value=\""+restaurant.getUrl().replace("\"", "")+"\">\n" +
"    <input type=\"text\" hidden name=\"city\" value=\""+restaurant.getLocation().getCity()+"\">\n" +
"    <input type=\"text\" hidden name=\"address\" value=\""+restaurant.getLocation().getAddress()+"\">\n" +
"    <input type hidden name=\"ctrl\" value=\"Favorito\">\n"
        + "<input type=\"submit\" value=\"Salvar Favorito\">" +
"</form></div>");
            }
//            out.print("<h1>Hello World!</h1>");
        } catch (IOException ex) {
            Logger.getLogger(RestaurantTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
