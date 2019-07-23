package com.ngajiyuk.islamicmovie.Movie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngajiyuk.islamicmovie.R;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    RecyclerView rvMovie;
    private ArrayList<Movie> arrayList = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        arrayList.addAll(MovieData.getListData());
        showRvCardView();
        return view;
    }

    private void showRvCardView(){
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(arrayList);
        rvMovie.setAdapter(movieAdapter);
    }
}
