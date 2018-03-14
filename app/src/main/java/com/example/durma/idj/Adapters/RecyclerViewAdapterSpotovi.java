package com.example.durma.idj.Adapters;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.durma.idj.Model.Video;
import com.example.durma.idj.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



/**
 * Created by durma on 2.3.18..
 */

public class RecyclerViewAdapterSpotovi extends RecyclerView.Adapter<RecyclerViewAdapterSpotovi.ViewHolder> {

    private Context context;
    private ArrayList<Video> videos;
    private String headTitle;



    public RecyclerViewAdapterSpotovi(Context context, ArrayList<Video> videos, String headTitle) {
        this.context = context;
        this.videos = videos;
        this.headTitle = headTitle;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Video video = videos.get(position);

        Picasso.with(context).
                load(video.getSlika()).
                resize(200,100).
                into(holder.image);

        holder.name.setText(video.getNaziv());
        holder.views.setText(video.getBroj_pregleda());
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, views;
        LinearLayout linearLayout;

        @RequiresApi(api = Build.VERSION_CODES.M)
        @SuppressLint("ResourceAsColor")
        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            views = (TextView) itemView.findViewById(R.id.views);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.tabLayoutmain);

            int i = itemView.getResources().getColor(R.color.colorPrimary,null);

            linearLayout.setBackgroundColor(i);

   /*         LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();

            params.setMargins(10,10,10,10);

            linearLayout.setLayoutParams(params);*/

        }
    }
}
