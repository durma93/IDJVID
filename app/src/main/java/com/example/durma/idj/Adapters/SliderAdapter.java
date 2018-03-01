package com.example.durma.idj.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
 * Created by durma on 26.2.18..
 */
public class SliderAdapter extends PagerAdapter {

        private Context context;
        private LayoutInflater inflater;
        private ArrayList<Video> images;

        public SliderAdapter(Context context, ArrayList<Video> images) {
            this.context = context;
            this.images = images;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.element_carosel_layout, null);
            ImageView slika = (ImageView)view.findViewById(R.id.sliderImage);
            TextView naziv = (TextView) view.findViewById(R.id.naziv);
            TextView brojPregleda = (TextView) view.findViewById(R.id.brojPregleda);

            //slika.setImageResource(images.get(position).getSlika());
            naziv.setText(images.get(position).getNaziv());
            brojPregleda.setText(images.get(position).getBroj_pregleda());

            Picasso.with(context).
                    load(images.get(position).getSlika()).resize(800,600)
                    .into(slika);

            ViewPager viewPager = (ViewPager) container;
            viewPager.addView(view, 0);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ViewPager viewPager = (ViewPager) container;
            View view = (View) object;
            viewPager.removeView(view);
        }
}



