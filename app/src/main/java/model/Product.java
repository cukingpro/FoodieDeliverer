package model;

import java.io.Serializable;

/**
 * Created by huy on 27/05/2016.
 */
public class Product implements Serializable{

    private int id;
    private String name;
    private Image[] images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
}
