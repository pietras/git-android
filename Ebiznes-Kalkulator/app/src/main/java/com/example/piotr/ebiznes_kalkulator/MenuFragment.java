package com.example.piotr.ebiznes_kalkulator;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {

private IFragmentContainer fragmentContainer;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentContainer = (IFragmentContainer) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_menu,container,false);
        // Inflate the layout for this fragment

        Button simple = (Button)rootView.findViewById(R.id.gotoSimple);
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContainer.replaceFragment(new SimpleFragment(),"simple");
            }
        });
        Button advanced = (Button)rootView.findViewById(R.id.gotoAdvanced);
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContainer.replaceFragment(new AdvancedFragment(),"advanced");
            }
        });
        Button about = (Button)rootView.findViewById(R.id.gotoAbout);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContainer.replaceFragment(new AboutFragment(),"about");
            }
        });

        Button exit = (Button)rootView.findViewById(R.id.gotoExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return rootView;
    }

}
