package com.example.durma.idj.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.durma.idj.Adapters.MainAdapter;
import com.example.durma.idj.Model.Emisije;
import com.example.durma.idj.Model.IDJClips;
import com.example.durma.idj.Model.Izdanja;
import com.example.durma.idj.Model.Izvodjaci;
import com.example.durma.idj.Model.Playlist;
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
        rows.add(new Video());
        rows.add(new IDJClips());
        rows.add(new Emisije());
        rows.add(new Izdanja());
        rows.add(new Playlist());
        rows.add(new Izvodjaci());



        recyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        adapter = new MainAdapter(this, rows);
        recyclerView.setAdapter(adapter);


    }

    public static ArrayList<Video> getAllVideos(){
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.nikolija, "Nikolija - Los momak (Official Video)", "20,392,564 Views"));
        videos.add(new Video(R.drawable.cvija, "Cvija - Brzina", "8,545,243 Views"));
        videos.add(new Video(R.drawable.krvavi_balkan, "THC feat Coby - Krvavi balkan (Official Video)", "11,305,549 Views"));
        videos.add(new Video(R.drawable.marko_mandic, "Marko Mandic - Ramdagadam (Official Video)", "11,305,549 Views"));
        videos.add(new Video(R.drawable.elena, "Elena - Zlato", "11,305,549 Views"));


        return videos;
    }

    public static ArrayList<Video> getAllVideos2() {
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.nikolija, "Nikolija - Los momak (Official Video)", "20,392,564 Views"));
        videos.add(new Video(R.drawable.elena, "Elena - Zlato", "11,305,549 Views"));
        videos.add(new Video(R.drawable.cvija, "Cvija - Brzina", "8,545,243 Views"));
        videos.add(new Video(R.drawable.krvavi_balkan, "THC feat Coby - Krvavi balkan (Official Video)", "11,305,549 Views"));
        videos.add(new Video(R.drawable.marko_mandic, "Marko Mandic - Ramdagadam (Official Video)", "11,305,549 Views"));


        return videos;
    }

    public static ArrayList<Video> getAllSpotovi() {
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.acalukas, "Aca Lukas Mile Kitc Sasa Matic - Da me je ona volela", "55,875,564 Views"));
        videos.add(new Video(R.drawable.coronabela, "Corrona - Bella", "17,444,002 Views"));
        videos.add(new Video(R.drawable.crnisin, "Cvija Relja Coby - Crni sine", "66,545,243 Views"));
        videos.add(new Video(R.drawable.dadootebi, "Dado Polumenta - O tebi (Official Video)", "8,305,549 Views"));
        videos.add(new Video(R.drawable.mainshatcz, "Mc Stojan ft. Darko lazic - Mein Schatz (Official Video)", "20,305,549 Views"));


        return videos;
    }

    public static ArrayList<IDJClips> getAllClips() {
        ArrayList<IDJClips> clips = new ArrayList<>();

        clips.add(new IDJClips(R.drawable.gru, "Gru"));
        clips.add(new IDJClips(R.drawable.mcstojanmotor, "Mc Stojan otriva ko mu je dao motor"));
        clips.add(new IDJClips(R.drawable.sara_idj, "Sara jo u emisiji prica o"));
        clips.add(new IDJClips(R.drawable.lanausne, "Lana je dobila priliku da se konacno pokaze"));
        clips.add(new IDJClips(R.drawable.indira, "Indira"));

        return clips;
    }

    public static ArrayList<Emisije> getAllEmisije() {
        ArrayList<Emisije> emisije = new ArrayList<>();

        emisije.add(new Emisije(R.drawable.idjhot, "IDJHot"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "IDJToplista"));
        emisije.add(new Emisije(R.drawable.idjhot2, "IDJHot 2"));
        emisije.add(new Emisije(R.drawable.idjhot3, "Playlist"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "Emerging"));

        return emisije;
    }

    public static ArrayList<Izdanja> getAllIzdanja() {
        ArrayList<Izdanja> izdanja = new ArrayList<>();

        izdanja.add(new Izdanja(R.drawable.nikolija, new Izvodjaci(R.drawable.nikolija, "Nikolija Jovanovic"),"Moj tempo"));
        izdanja.add(new Izdanja(R.drawable.relja, new Izvodjaci(R.drawable.relja, "Relja Popovic"),"Beograd jos zivo"));
        izdanja.add(new Izdanja(R.drawable.severina, new Izvodjaci(R.drawable.severina, "Severina"),"Uno momento"));
        izdanja.add(new Izdanja(R.drawable.indira, new Izvodjaci(R.drawable.indira, "Indira"),"Zmaj"));
        izdanja.add(new Izdanja(R.drawable.idjhot3, new Izvodjaci(R.drawable.acalukas, "Aca Lukas"),"Balkan"));

        return izdanja;
    }

    public static ArrayList<Playlist> getAllPlaylist() {
        ArrayList<Playlist> playlists = new ArrayList<>();

        playlists.add(new Playlist(R.drawable.hearthis,"Hear this"));
        playlists.add(new Playlist(R.drawable.summerhits,"Summer hits"));
        playlists.add(new Playlist(R.drawable.idjtoplista,"Top lista"));
        playlists.add(new Playlist(R.drawable.idjhot,"Hot list"));
        playlists.add(new Playlist(R.drawable.idjhot3,"Hot hotova"));


        return playlists;
    }

    public static ArrayList<Izvodjaci> getAllIzvodjaci() {
        ArrayList<Izvodjaci> izvodjaci = new ArrayList<>();

        izvodjaci.add(new Izvodjaci(R.drawable.nikolija,"Nikolija Jovanovic"));
        izvodjaci.add(new Izvodjaci(R.drawable.relja,"Relja Popovic"));
        izvodjaci.add(new Izvodjaci(R.drawable.severina, "Severina"));
        izvodjaci.add(new Izvodjaci(R.drawable.lanausne, "Lana Jurcevic"));
        izvodjaci.add( new Izvodjaci(R.drawable.harisskarep, "Haris Skarep"));

        return izvodjaci;
    }

}
