package com.example.durma.idj.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.durma.idj.Model.Video;
import com.example.durma.idj.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ivandjordjevic on 27.2.18..
 */

public class TabVideoAdapter extends RecyclerView.Adapter<TabVideoAdapter.TabVideoViewHolder> {
    private Context context;
    private ArrayList<Video> videos;

    public TabVideoAdapter(Context context, ArrayList<Video> videos) {
        this.context = context;
        this.videos = videos;
    }

    @Override
    public TabVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item, parent, false);

        return new TabVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TabVideoViewHolder holder, int position) {
        Picasso.with(context)
                .load(videos.get(position).getSlika()).resize(200,100)
                .into(holder.image);
        holder.name.setText(videos.get(position).getNaziv());
        holder.views.setText(videos.get(position).getBroj_pregleda());


    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class TabVideoViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, views;

        public TabVideoViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            views = (TextView) itemView.findViewById(R.id.views);
        }

    }

}
