package com.example.huy.foodiedelivere;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import model.Shipment;

/**
 * Created by huy on 29/05/2016.
 */
public class ShipmentAdapter extends ArrayAdapter<Shipment> {

    Activity context = null;
    ArrayList<Shipment> myArray = null;
    int layoutId;

    public ShipmentAdapter(Activity context, int layoutId, ArrayList<Shipment> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(layoutId, null);
        }
        return super.getView(position, convertView, parent);
    }
}
