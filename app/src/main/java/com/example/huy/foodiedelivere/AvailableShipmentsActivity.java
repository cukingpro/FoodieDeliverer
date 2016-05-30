package com.example.huy.foodiedelivere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import model.Deliverer;
import model.Shipment;

public class AvailableShipmentsActivity extends AppCompatActivity {

    public static final String AVAILABLE_SHIPMENTS_URL = "http://foodie-2016-back.herokuapp.com/api/available_shipments";

    private Deliverer deliverer;
    private Shipment[] shipments;

    private ListView listView;
    private ArrayAdapter<Shipment> shipmentArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment);

        loadDeliverer();
        loadShipments();
        controls();
        events();

    }

    public void controls() {
        listView = (ListView) findViewById(R.id.lvShipment);
    }

    public void events() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shipment shipment = shipments[i];
                Intent intent = new Intent(AvailableShipmentsActivity.this, ShipmentDetailActivity.class);
                intent.putExtra("SHIPMENT", shipment);
                startActivity(intent);
            }
        });
    }

    public void loadDeliverer() {
        deliverer = Deliverer.getInstance();
    }

    public void loadShipments() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, AVAILABLE_SHIPMENTS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        shipments = new Gson().fromJson(response, Shipment[].class);
                        shipmentArrayAdapter = new ArrayAdapter<Shipment>(AvailableShipmentsActivity.this, android.R.layout.simple_list_item_1, shipments);
                        listView.setAdapter(shipmentArrayAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AvailableShipmentsActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("X-Spree-Token", deliverer.getSpree_api_key());
                return headers;
            }
        };

        MySingleton.getInstance().addToRequestQueue(stringRequest);

    }
}
