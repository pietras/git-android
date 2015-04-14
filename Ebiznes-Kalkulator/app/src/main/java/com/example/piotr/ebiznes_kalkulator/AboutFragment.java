package com.example.piotr.ebiznes_kalkulator;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AboutFragment extends Fragment implements View.OnClickListener{
    public AboutFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,container,false);

        // Inflate the layout for this fragment
return view;
    }

    @Override
    public void onClick(View v) {

    }
}
