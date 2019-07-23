package com.ngajiyuk.islamicmovie.Movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ngajiyuk.islamicmovie.R;

public class DetailMovie extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);


        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra(EXTRA_DATA);

        String tvName = movie.getName();
        String tvDate = movie.getDate();
        String tvRate = movie.getRate();
        String tvDescrip = movie.getDescrip();
        String imgPhoto = movie.getPhoto();

        TextView tvDetailName = findViewById(R.id.detail_name);
        tvDetailName.setText(tvName);

        TextView tvDetailDate = findViewById(R.id.detail_date);
        tvDetailDate.setText(tvDate);

        TextView tvDetailRate = findViewById(R.id.detail_rate);
        tvDetailRate.setText(tvRate);

        TextView tvDetailDescrip = findViewById(R.id.detail_descrip);
        tvDetailDescrip.setText(tvDescrip);

        ImageView ivDimg = findViewById(R.id.detail_img);
        Glide.with(ivDimg)
                .load(imgPhoto)
                .apply(new RequestOptions().override(350,550))
                .into(ivDimg);
    }
}
