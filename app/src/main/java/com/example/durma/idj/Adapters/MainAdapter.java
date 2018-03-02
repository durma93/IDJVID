package com.example.durma.idj.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.antonyt.infiniteviewpager.InfinitePagerAdapter;
import com.example.durma.idj.Activities.MainActivity;
import com.example.durma.idj.R;

import java.util.ArrayList;

/**
 * Created by durma on 28.2.18..
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    Context context;
    ArrayList rows;

    private final int SLIDER_MODE = 0;
    private final int TAB_MODE = 1;
    private final int SPOTS_MODE = 2;
    private final int CLIPS_MODE = 3;
    private final int EMISIJE_MODE = 4;
    private final int IZDANJA_MODE = 5;
    private final int PLAYLIST_MODE = 6;
    private final int IZVODJACI_MODE = 7;





    public MainAdapter(Context context, ArrayList rows) {
        this.context = context;
        this.rows = rows;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch(viewType) {
            case SLIDER_MODE:
                view = inflater.inflate(R.layout.carosel_layout, parent, false);
                break;
            case TAB_MODE:
                view = inflater.inflate(R.layout.tab_layout, parent, false);
                break;
            case SPOTS_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case CLIPS_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case EMISIJE_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case IZDANJA_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case PLAYLIST_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case IZVODJACI_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            default:
                view = inflater.inflate(R.layout.carosel_layout, parent, false);
        }
        return new MyViewHolder(view);
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (holder.getItemViewType() == SLIDER_MODE) {
            ViewPager viewPager = (ViewPager) holder.itemView.findViewById(R.id.infiniteScrool);
            SliderAdapter adapter = new SliderAdapter(context, MainActivity.getAllVideos());
            PagerAdapter wrapperAdapter = new InfinitePagerAdapter(adapter);
            viewPager.setAdapter(wrapperAdapter);
        }
        else if (holder.getItemViewType() == TAB_MODE){

            TabLayout tabLayout = (TabLayout) holder.itemView.findViewById(R.id.tabLayout);
            ViewPager viewPager = (ViewPager) holder.itemView.findViewById(R.id.videoContent);
            TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(context);
            tabPagerAdapter.addTab(R.layout.tab_card_content,"NAJNOVIJI");
            tabPagerAdapter.addTab(R.layout.tab_card_content2,"NAJGLEDANIJI");
            viewPager.setAdapter(tabPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            Log.d("MainAdapter", "Loaded TAB");
        }
        else if (holder.getItemViewType() == SPOTS_MODE) {

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("SPOTOVI");
            String name = title.getText().toString();

            RecyclerViewAdapterSpotovi recyclerViewAdapterSpotovi = new RecyclerViewAdapterSpotovi(context, MainActivity.getAllSpotovi(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterSpotovi);
        }
        else if (holder.getItemViewType() == CLIPS_MODE) {

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("IDJKLIPS");
            String name = title.getText().toString();
            RecyclerViewAdapterIDJClips recyclerViewAdapterIDJClips = new RecyclerViewAdapterIDJClips(context, MainActivity.getAllClips(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterIDJClips);
        }
        else if (holder.getItemViewType() == EMISIJE_MODE) {

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("EMISIJE");
            String name = title.getText().toString();
            RecyclerViewAdapterEmisije recyclerViewAdapterEmisije = new RecyclerViewAdapterEmisije(context, MainActivity.getAllEmisije(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterEmisije);
        }

        else if (holder.getItemViewType() == IZDANJA_MODE) {

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("IZDANJA");
            String name = title.getText().toString();
            RecyclerViewAdapterIzdanja recyclerViewAdapterIzdanja = new RecyclerViewAdapterIzdanja(context, MainActivity.getAllIzdanja(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterIzdanja);
        }
        else if (holder.getItemViewType() == PLAYLIST_MODE) {

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("PLAYLIST");
            String name = title.getText().toString();
            RecyclerViewAdapterPlaylist recyclerViewAdapterPlaylist = new RecyclerViewAdapterPlaylist(context, MainActivity.getAllPlaylist(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterPlaylist);
        }
        else if (holder.getItemViewType() == IZVODJACI_MODE) {

            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("IZVODJACI");
            String name = title.getText().toString();
            RecyclerViewAdapterIzvodjaci recyclerViewAdapterIzvodjaci = new RecyclerViewAdapterIzvodjaci(context, MainActivity.getAllIzvodjaci(), name);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setAdapter(recyclerViewAdapterIzvodjaci);
        }
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;

        public MyViewHolder (View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerViewcontainer);
        }
    }
}
