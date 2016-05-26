package com.example.huy.foodiedelivere;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import fragment.ProfileFragment;
import model.Deliverer;

public class TestActivity extends AppCompatActivity {

    public static final String  menu[] = {"Profile", "History Orders", "Next Orders"};

    private ListView lv;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        lv = (ListView) findViewById(R.id.left_drawer);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
    }

    private void selectItem(int position) {
       switch(position){
           case 0: openProfile();
               break;
           default:
               break;
       }


    }

    public void openProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
