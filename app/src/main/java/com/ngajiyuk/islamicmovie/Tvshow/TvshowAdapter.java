package com.ngajiyuk.islamicmovie.Tvshow;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ngajiyuk.islamicmovie.R;

import java.util.ArrayList;

public class TvshowAdapter extends RecyclerView.Adapter<TvshowAdapter.TvshowViewHolder> {
    private ArrayList<Tvshow> listTv;
    public TvshowAdapter(ArrayList<Tvshow> listTvshowAdapter){
        this.listTv = listTvshowAdapter;
    }

    @NonNull
    @Override
    public TvshowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tvshow, viewGroup, false);
        return new TvshowViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull final TvshowViewHolder holder, final int position){
        Tvshow tvshow = listTv.get(position);

        holder.tvTitle.setText(tvshow.getTitle());
        holder.tvDate.setText(tvshow.getDate());
        holder.tvCategory.setText(tvshow.getCategory());
        holder.tvDescrip.setText(tvshow.getDescrip());
        Glide.with(holder.itemView.getContext())
                .load(tvshow.getImage())
                .apply(new RequestOptions().override(350,550))
                .into(holder.image);
        holder.dCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailTvshow.class);
                intent.putExtra(DetailTvshow.EXTRA_DATA, listTv.get(position));
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount(){
        return listTv.size();
    }


    public class TvshowViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvDate, tvCategory, tvDescrip;
        ImageView image;
        CardView dCardView;

        public TvshowViewHolder(@NonNull View itemView){
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvDescrip = itemView.findViewById(R.id.tv_descrip);
            image = itemView.findViewById(R.id.img_photo);
            dCardView = itemView.findViewById(R.id.card_tvshow);
        }
    }
}
