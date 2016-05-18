package model;

import java.io.Serializable;

/**
 * Created by huy on 13/05/2016.
 */
public class Image implements Serializable {

    private int id;
    private String mini_url;
    private String normal_url;
    private String large_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMini_url() {
        return mini_url;
    }

    public void setMini_url(String mini_url) {
        this.mini_url = mini_url;
    }

    public String getNormal_url() {
        return normal_url;
    }

    public void setNormal_url(String normal_url) {
        this.normal_url = normal_url;
    }

    public String getLarge_url() {
        return large_url;
    }

    public void setLarge_url(String large_url) {
        this.large_url = large_url;
    }
}
