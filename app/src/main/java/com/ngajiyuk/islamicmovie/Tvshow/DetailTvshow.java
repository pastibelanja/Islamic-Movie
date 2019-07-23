package com.ngajiyuk.islamicmovie.Tvshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ngajiyuk.islamicmovie.R;

public class DetailTvshow extends AppCompatActivity {
    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshow);

        Intent intent = getIntent();
        Tvshow tvshow = intent.getParcelableExtra(EXTRA_DATA);

        String tvTitle = tvshow.getTitle();
        String tvDate = tvshow.getDate();
        String tvCategory = tvshow.getCategory();
        String tvDescrip = tvshow.getDescrip();
        String imgImage = tvshow.getImage();

        TextView tvDtTitle = findViewById(R.id.detail_title);
        tvDtTitle.setText(tvTitle);

        TextView tvDtDate = findViewById(R.id.detail_date);
        tvDtDate.setText(tvDate);

        TextView tvDtCategory = findViewById(R.id.detail_category);
        tvDtCategory.setText(tvCategory);

        TextView tvDtDescrip = findViewById(R.id.detail_descrip);
        tvDtDescrip.setText(tvDescrip);

        ImageView imgDetailTv = findViewById(R.id.detail_img);
        Glide.with(imgDetailTv)
                .load(imgImage)
                .apply(new RequestOptions().override(350,550))
                .into(imgDetailTv);



    }
}
