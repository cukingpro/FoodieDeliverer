package com.example.huy.foodiedelivere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import model.Shipment;

public class AvailableShipmentsActivity extends AppCompatActivity {

    public static final String AVAILABLE_SHIPMENTS_URL = "http://foodie-2016-back.herokuapp.com/api/available_shipments";

    private Shipment shipments[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment);
    }
}
