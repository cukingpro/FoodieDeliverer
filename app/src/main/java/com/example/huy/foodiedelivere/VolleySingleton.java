package com.example.huy.foodiedelivere;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by huy on 25/04/2016.
 */
public class VolleySingleton {
    private static VolleySingleton sIntence = null;

    private RequestQueue mRequestQueue;

    private VolleySingleton(){
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getIntence(){
        if (sIntence == null)
        {
            sIntence = new VolleySingleton();
        }
        return sIntence;
    }

    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
}
