package com.ngajiyuk.islamicmovie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AccountFragment extends Fragment {
    TextView tvAccount;


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_account, container, false);

        tvAccount = v.findViewById(R.id.farg_account);

        String ket = String.format(v.getResources().getString(R.string.frag_account));
        tvAccount.setText(ket);

        return v;
    }

}
