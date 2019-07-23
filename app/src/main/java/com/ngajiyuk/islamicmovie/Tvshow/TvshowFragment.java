package com.ngajiyuk.islamicmovie.Tvshow;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngajiyuk.islamicmovie.R;

import java.util.ArrayList;

public class TvshowFragment extends Fragment {

    RecyclerView rvTvshow;
    private ArrayList<Tvshow> arrayList = new ArrayList<>();


    public TvshowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tvshow, container, false);

        rvTvshow = v.findViewById(R.id.rv_tvshow);
        rvTvshow.setHasFixedSize(true);
        arrayList.addAll(TvshowData.getListData());
        showRvCardView();
        return v;
    }

    private void showRvCardView(){
        rvTvshow.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvshowAdapter tvshowAdapter = new TvshowAdapter(arrayList);
        rvTvshow.setAdapter(tvshowAdapter);
    }

}
