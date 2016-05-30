package com.example.huy.foodiedelivere;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import model.Deliverer;

public class SignInActivity extends AppCompatActivity {

    public static final String SIGNIN_URL = "http://foodie-2016-back.herokuapp.com/api/deliverer_login";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnSignIn;

    private Deliverer deliverer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        controls();
        events();

    }

    private void openHome(){
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    public void controls(){
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
    }

    public void events(){
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtEmail.getText().toString().trim();
                final String password = edtPassword.getText().toString().trim();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, SIGNIN_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                deliverer = new Gson().fromJson(response, Deliverer.class);
                                openHome();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(SignInActivity.this, "Email or Password is wrong", Toast.LENGTH_SHORT).show();
                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put(KEY_EMAIL, email);
                        params.put(KEY_PASSWORD, password);
                        return params;
                    }
                };

                MySingleton.getInstance().addToRequestQueue(stringRequest);
            }
        });
    }
}
