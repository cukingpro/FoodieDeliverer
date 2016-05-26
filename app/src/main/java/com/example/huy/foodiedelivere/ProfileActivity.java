package com.example.huy.foodiedelivere;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import model.Deliverer;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imgAvatar;
    private TextView txtFirstname, txtLastname, txtEmail, txtSpreeAPIKey;
    private Deliverer deliverer;
    private ImageLoader imageLoader;
    private NetworkImageView networkImageView;
    private Button btnNextOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        controls();
        events();

        loadDeliverer();

    }

    private void loadDeliverer() {
        Intent intent = getIntent();
//        deliverer = (Deliverer) intent.getSerializableExtra("Deliverer");
        deliverer = Deliverer.getInstance();

        loadAvatar();
        txtFirstname.setText(deliverer.getFirst_name());
        txtLastname.setText(deliverer.getLast_name());
        txtEmail.setText(deliverer.getEmail());
        txtSpreeAPIKey.setText(deliverer.getSpree_api_key());


    }

    private void loadAvatar(){
        String avatar_url;
        if (deliverer.getImages().length>0)
        {
            avatar_url = deliverer.getImages()[0].getLarge_url();
        } else
        {
            avatar_url = null;
        }
        imageLoader = MySingleton.getInstance().getImageLoader();
        networkImageView.setImageUrl(avatar_url, imageLoader);
        networkImageView.setDefaultImageResId(R.drawable.no_avatar);
        networkImageView.setErrorImageResId(R.drawable.no_avatar);

    }

    private void controls() {
//        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        txtFirstname = (TextView) findViewById(R.id.txtFirstname);
        txtLastname = (TextView) findViewById(R.id.txtLastname);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtSpreeAPIKey = (TextView) findViewById(R.id.txtSpreeAPIKey);
        networkImageView = (NetworkImageView) findViewById(R.id.networkImageView);
        btnNextOrders = (Button) findViewById(R.id.btnNextOrders);
    }

    public void events(){
        btnNextOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }
}
