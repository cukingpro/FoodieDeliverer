package com.example.huy.foodiedelivere;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import model.Deliverer;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imgAvatar;
    private TextView txtFirstname, txtLastname, txtEmail, txtSpreeAPIKey;
    private Deliverer deliverer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        controls();

        loadDeliverer();

    }

    private void loadDeliverer() {
        Intent intent = getIntent();
        deliverer = (Deliverer) intent.getSerializableExtra("Deliverer");
        txtFirstname.setText(deliverer.getFirst_name());
//        txtFirstname.setText(deliverer.getImages()[0].getLarge_url());
        txtLastname.setText(deliverer.getLast_name());
        txtEmail.setText(deliverer.getEmail());
        txtSpreeAPIKey.setText(deliverer.getSpree_api_key());

        loadAvatar();
    }

    private void loadAvatar(){
        new ImageLoadTask(deliverer.getImages()[0].getLarge_url(), imgAvatar).execute();
    }

    private void controls() {
        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        txtFirstname = (TextView) findViewById(R.id.txtFirstname);
        txtLastname = (TextView) findViewById(R.id.txtLastname);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtSpreeAPIKey = (TextView) findViewById(R.id.txtSpreeAPIKey);
    }
}
