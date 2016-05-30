package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huy on 25/04/2016.
 */
public class Shipment implements Serializable {

    private int id;
    private String number;
    private Date date_delivery;
    private String time_frame;
    private Address address;
    private Manifest[] manifest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Manifest[] getManifest() {
        return manifest;
    }

    public void setManifest(Manifest[] manifest) {
        this.manifest = manifest;
    }

    public Date getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(Date date_delivery) {
        this.date_delivery = date_delivery;
    }

    public String getTime_frame() {
        return time_frame;
    }

    public void setTime_frame(String time_frame) {
        this.time_frame = time_frame;
    }

    @Override
    public String toString() {
        return number;
    }

    public String getDeliveryTime(){
        return time_frame+", "+date_delivery;
    }

}
