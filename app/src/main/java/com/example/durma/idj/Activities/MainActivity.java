package com.example.durma.idj.Activities;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.antonyt.infiniteviewpager.InfinitePagerAdapter;
import com.example.durma.idj.Adapters.MainAdapter;
import com.example.durma.idj.Adapters.SliderAdapter;
import com.example.durma.idj.Model.Video;
import com.example.durma.idj.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList rows;
    RecyclerView recyclerView;
    MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rows = new ArrayList();
        rows.add(new Video());
        rows.add(new Video());


        recyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        adapter = new MainAdapter(this, rows);
        recyclerView.setAdapter(adapter);


    }

    public static ArrayList<Video> getAllVideos(){
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.nikolija, "Nikolija - Los momak (Official Video)", "20,392,564 Views"));
        videos.add(new Video(R.drawable.cvija, "Cvija - Mnogo dobra pesma brateu", "8,545,243 Views"));
        videos.add(new Video(R.drawable.krvavi_balkan, "THC feat Coby - Krvavi balkan (Official Video)", "11,305,549 Views"));
        videos.add(new Video(R.drawable.marko_mandic, "Marko Mandic - Ramdagadam (Official Video)", "11,305,549 Views"));
        videos.add(new Video(R.drawable.elena, "Elena - Zlato", "11,305,549 Views"));


        return videos;
    }

    public static ArrayList<Video> getAllVideos2() {
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.nikolija, "Nikolija - Los momak (Official Video)", "20,392,564 Views"));
        videos.add(new Video(R.drawable.elena, "Elena - Zlato", "11,305,549 Views"));
        videos.add(new Video(R.drawable.cvija, "Cvija - Mnogo dobra pesma brateu", "8,545,243 Views"));
        videos.add(new Video(R.drawable.krvavi_balkan, "THC feat Coby - Krvavi balkan (Official Video)", "11,305,549 Views"));
        videos.add(new Video(R.drawable.marko_mandic, "Marko Mandic - Ramdagadam (Official Video)", "11,305,549 Views"));


        return videos;
    }
}
