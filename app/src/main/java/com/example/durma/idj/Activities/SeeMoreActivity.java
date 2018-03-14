package com.example.durma.idj.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.durma.idj.Adapters.RecyclerViewAdapterEmisije;
import com.example.durma.idj.Adapters.RecyclerViewAdapterIDJClips;
import com.example.durma.idj.Adapters.RecyclerViewAdapterIzdanja;
import com.example.durma.idj.Adapters.RecyclerViewAdapterIzvodjaci;
import com.example.durma.idj.Adapters.RecyclerViewAdapterPlaylist;
import com.example.durma.idj.Adapters.RecyclerViewAdapterSpotovi;
import com.example.durma.idj.R;

import java.util.ArrayList;

public class SeeMoreActivity extends AppCompatActivity {

    RecyclerViewAdapterEmisije recyclerViewAdapterEmisije;
    RecyclerViewAdapterSpotovi recyclerViewAdapterSpotovi;
    RecyclerViewAdapterIDJClips recyclerViewAdapterIDJClips;
    RecyclerViewAdapterIzdanja recyclerViewAdapterIzdanja;
    RecyclerViewAdapterPlaylist recyclerViewAdapterPlaylist;
    RecyclerViewAdapterIzvodjaci recyclerViewAdapterIzvodjaci;
    RecyclerView recyclerView;

    TextView seeMoreTitle;

    LinearLayoutManager linearLayoutManager;

    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerSeemore);
        recyclerView.setFocusable(false);
        seeMoreTitle = (TextView)findViewById(R.id.headTitleSeeMore);

        backButton = (ImageView)findViewById(R.id.backbutton);

        //Dugme za back u toolbaru
        backButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onBackPressed();
           }
        });

        if (getIntent().getStringExtra("headTitle").equals("SPOTOVI")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterSpotovi = new RecyclerViewAdapterSpotovi(this,MainActivity.getAllSpotovi(),text);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterSpotovi);


        }
        else if (getIntent().getStringExtra("headTitle").equals("IDJKLIPS")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterIDJClips = new RecyclerViewAdapterIDJClips(this,MainActivity.getAllClips(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterIDJClips);


        }
        else if (getIntent().getStringExtra("headTitle").equals("EMISIJE")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterEmisije = new RecyclerViewAdapterEmisije(this,MainActivity.getAllEmisije(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterEmisije);


        }
        else if (getIntent().getStringExtra("headTitle").equals("IZDANJA")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterIzdanja = new RecyclerViewAdapterIzdanja(this,MainActivity.getAllIzdanja(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterIzdanja);


        }
        else if (getIntent().getStringExtra("headTitle").equals("PLAYLIST")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterPlaylist = new RecyclerViewAdapterPlaylist(this,MainActivity.getAllPlaylist(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterPlaylist);


        }
        else if (getIntent().getStringExtra("headTitle").equals("IZVODJACI")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterIzvodjaci = new RecyclerViewAdapterIzvodjaci(this,MainActivity.getAllIzvodjaci(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterIzvodjaci);


        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
