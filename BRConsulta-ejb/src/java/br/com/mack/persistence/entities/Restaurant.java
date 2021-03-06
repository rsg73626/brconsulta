package br.com.mack.persistence.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 41583469
 */
@XmlRootElement
@Entity
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String image;
    private String url;
    private Location location;

    public Restaurant() {
    }

    public Restaurant(String name, String image, String url) {
        this.name = name;
        this.image = image;
        this.url = url;
    }

    public Restaurant(String name, String image, String url, Location location) {
        this.name = name;
        this.image = image;
        this.url = url;
        this.location = location;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return "Restaurant{" + "name=" + name + ", image=" + image + ", url=" + url + ", location=" + location + '}';
    }
}