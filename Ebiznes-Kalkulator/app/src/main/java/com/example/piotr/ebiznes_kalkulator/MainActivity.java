package com.example.piotr.ebiznes_kalkulator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements IFragmentContainer{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new MenuFragment(),"menu");
    }

    public void replaceFragment(Fragment fragment, String stackid) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, stackid);
        //fragmentTransaction.replace(R.id.container, new Fragment2(), null);
        //powinno sie uzywac replace zamiast add zeby byl widoczny ostatni fragment i aktywny.
        //kontener, fragment, nazwa transakcji

        //do animowania wjazdu fragmentu
//        fragmentTransaction.setCustomAnimations();
        fragmentTransaction.addToBackStack(stackid);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed()
    {
        if(getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

}
