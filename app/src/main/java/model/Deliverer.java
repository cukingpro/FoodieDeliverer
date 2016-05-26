package model;

import java.io.Serializable;

/**
 * Created by huy on 25/04/2016.
 */
public class Deliverer implements Serializable {

    private static Deliverer instance;

    private int id;
    private String first_name;
    private String last_name;
    private String spree_api_key;
    private String email;
    private Image[] images;

    public static synchronized Deliverer getInstance() {
//        if (instance == null) {
//            instance = new Deliverer();
//        }
        return instance;

    }

    private Deliverer(){
        instance = this;
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSpree_api_key() {
        return spree_api_key;
    }

    public void setSpree_api_key(String spree_api_key) {
        this.spree_api_key = spree_api_key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
}
