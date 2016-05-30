package model;

import java.io.Serializable;

/**
 * Created by huy on 27/05/2016.
 */
public class Manifest implements Serializable{

    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
