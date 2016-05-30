package com.example.huy.foodiedelivere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;

import Adapter.ManifestArrayAdapter;
import model.Manifest;
import model.Shipment;

public class ShipmentDetailActivity extends AppCompatActivity {

    private ManifestArrayAdapter adapter;
    private ImageLoader imageLoader;

    private TextView tvNumber, tvDeliveryTime, tvCustomer, tvAddress, tvPhone;
    private ListView lvManifest;

    private Shipment shipment;
    private ArrayList<Manifest> manifest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment_detail);

        controls();
        loadShipment();
        loadManifest();
        showShipment();
    }

    public void controls(){
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        tvDeliveryTime = (TextView) findViewById(R.id.tvDeliveryTime);
        tvCustomer = (TextView) findViewById(R.id.tvCustomer);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        lvManifest = (ListView) findViewById(R.id.lvManifest);
    }

    public void loadShipment() {
        Intent intent = getIntent();
        shipment = (Shipment) intent.getSerializableExtra("SHIPMENT");
    }

    public void loadManifest(){
        manifest = new ArrayList<Manifest>(Arrays.asList(shipment.getManifest()));
    }

    public void showShipment(){
        tvNumber.setText(shipment.getNumber());
        tvDeliveryTime.setText(shipment.getDeliveryTime());
        tvCustomer.setText(shipment.getAddress().getFullname());
        tvAddress.setText(shipment.getAddress().getAddress());
        tvPhone.setText(shipment.getAddress().getPhone());

        imageLoader = MySingleton.getInstance().getImageLoader();
        adapter = new ManifestArrayAdapter(this, R.layout.manifest_layout, manifest,imageLoader);
        lvManifest.setAdapter(adapter);
    }
}
