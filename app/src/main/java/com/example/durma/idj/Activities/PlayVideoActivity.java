package com.example.durma.idj.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.durma.idj.Adapters.PlayVideoAdapter;
import com.example.durma.idj.R;

import java.util.ArrayList;

public class PlayVideoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlayVideoAdapter adapter;

    private ArrayList mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        mod = new ArrayList();
        mod.add(new Object());
        mod.add(new Object());
        mod.add(new Object());
        mod.add(new Object());
        mod.add(new Object());

        recyclerView = (RecyclerView) findViewById(R.id.playVideoContainer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        adapter = new PlayVideoAdapter(this, mod);

        recyclerView.setAdapter(adapter);

    }
}
