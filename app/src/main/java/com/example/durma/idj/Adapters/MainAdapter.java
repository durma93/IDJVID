package com.example.durma.idj.Adapters;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antonyt.infiniteviewpager.InfinitePagerAdapter;
import com.example.durma.idj.Activities.MainActivity;
import com.example.durma.idj.Model.Video;
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
            default:
                view = inflater.inflate(R.layout.carosel_layout, parent, false);
        }
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (holder.getItemViewType() == SLIDER_MODE) {
            ViewPager viewPager = (ViewPager) holder.itemView.findViewById(R.id.infiniteScrool);
            SliderAdapter adapter = new SliderAdapter(context, MainActivity.getAllVideos());
            PagerAdapter wrapperAdapter = new InfinitePagerAdapter(adapter);
            viewPager.setAdapter(wrapperAdapter);
        }
        if (holder.getItemViewType() == TAB_MODE){

            TabLayout tabLayout = (TabLayout) holder.itemView.findViewById(R.id.tabLayout);
            ViewPager viewPager = (ViewPager) holder.itemView.findViewById(R.id.videoContent);
            TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(context);
            tabPagerAdapter.addTab(R.layout.tab_card_content,"NAJNOVIJI");
            tabPagerAdapter.addTab(R.layout.tab_card_content2,"NAJGLEDANIJI");
            viewPager.setAdapter(tabPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            Log.d("MainAdapter", "Loaded TAB");

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

    /*@Override
    public int getItemViewType(int position) {
        if(rows.get(position) instanceof Video) {
            return SLIDER_MODE;
        } else if(rows.get(position) instanceof Video) {
            return TAB_MODE;
        }else {
            return 0;
        }
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //RecyclerView recyclerView;

        public MyViewHolder (View itemView) {
            super(itemView);
            //recyclerView = (RecyclerView) itemView.findViewById(R.id.mainRecyclerView);
        }
    }
}
