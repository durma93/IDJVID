package com.example.durma.idj.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.durma.idj.Activities.MainActivity;
import com.example.durma.idj.BuildConfig;
import com.example.durma.idj.R;
import com.marcinmoskala.videoplayview.VideoPlayView;

import java.util.ArrayList;

/**
 * Created by ivandjordjevic on 5.3.18..
 */

public class PlayVideoAdapter extends RecyclerView.Adapter<PlayVideoAdapter.PlayVideoViewHolder> {

    private Context context;
    private ArrayList mod;

    private final int VIDEO_MODE = 0;
    private final int LIKE_SHARE_USER_MODE = 1;
    private final int KUPI_SLUSAJ_MODE = 2;
    private final int SPOTOVI_MODE = 3;
    private final int PREPORUCENO_MODE = 4;

    public PlayVideoAdapter(Context context, ArrayList mod) {
        this.context = context;
        this.mod = mod;
    }

    @Override
    public PlayVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);

        switch (viewType) {
            case VIDEO_MODE:
                view = inflater.inflate(R.layout.video, parent, false);
                break;
            case LIKE_SHARE_USER_MODE:
                view = inflater.inflate(R.layout.like_share_user, parent, false);
                break;
            case KUPI_SLUSAJ_MODE:
                view = inflater.inflate(R.layout.kupi_slusaj, parent, false);
                break;
            case SPOTOVI_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            case PREPORUCENO_MODE:
                view = inflater.inflate(R.layout.recyclerview_first_3, parent, false);
                break;
            default:
                view = inflater.inflate(R.layout.video, parent, false);
        }
        return new PlayVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayVideoViewHolder holder, int position) {
        if (holder.getItemViewType() == VIDEO_MODE) {

            VideoPlayView videoPlayView = (VideoPlayView)holder.itemView.findViewById(R.id.videoPlayer);

            videoPlayView.setVideoUrl("https://github.com/MarcinMoskala/VideoPlayView/raw/master/videos/cat1.mp4");


            /*WebView video = (WebView) holder.itemView.findViewById(R.id.videoPlayer);
            video.loadData("<iframe width=\"350\" height=\"200\" src=\"https://www.youtube.com/embed/BGHR2oCGvgQ\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>", "text/html", "utf-8");
            video.getSettings().setJavaScriptEnabled(true);
            video.setWebChromeClient(new WebChromeClient() {});*/
        } else if(holder.getItemViewType() == LIKE_SHARE_USER_MODE) {

        } else if(holder.getItemViewType() == KUPI_SLUSAJ_MODE) {

        } else if(holder.getItemViewType() == SPOTOVI_MODE) {
            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("SPOTOVI");
            RecyclerView recyclerView = holder.itemView.findViewById(R.id.recyclerViewcontainer);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setHasFixedSize(true);
            RecyclerViewAdapterSpotovi adapter = new RecyclerViewAdapterSpotovi(context, MainActivity.getAllVideos(), "");
            recyclerView.setAdapter(adapter);
        } else if(holder.getItemViewType() == PREPORUCENO_MODE) {
            TextView title = (TextView) holder.itemView.findViewById(R.id.headTitle);
            title.setText("PREPORUČENO");
            RecyclerView recyclerView = holder.itemView.findViewById(R.id.recyclerViewcontainer);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setHasFixedSize(true);
            RecyclerViewAdapterSpotovi adapter = new RecyclerViewAdapterSpotovi(context, MainActivity.getAllVideos2(), "");
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return mod.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class PlayVideoViewHolder extends RecyclerView.ViewHolder {

        public PlayVideoViewHolder(View itemView) {
            super(itemView);
        }

    }

}
