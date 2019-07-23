package com.ngajiyuk.islamicmovie.Movie;

import android.content.Intent;
import android.support.annotation.NonNull;
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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Movie> listMovie;
    public MovieAdapter(ArrayList<Movie> listMovieAdapter) {
        this.listMovie = listMovieAdapter;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position){
        Movie movie = listMovie.get(position);

        holder.tvName.setText(movie.getName());
        holder.tvDate.setText(movie.getDate());
        holder.tvRate.setText(movie.getRate());
        holder.tvDescrip.setText(movie.getDescrip());
        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);
        holder.cCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailMovie.class);
                intent.putExtra(DetailMovie.EXTRA_DATA, listMovie.get(position));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return listMovie.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvDate, tvRate, tvDescrip;
        ImageView imgPhoto;
        CardView cCardView;

        public MovieViewHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvRate = itemView.findViewById(R.id.tv_rate);
            tvDescrip = itemView.findViewById(R.id.tv_descrip);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            cCardView = itemView.findViewById(R.id.card_movies);
        }
    }
}
