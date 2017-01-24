package com.example.alumno2damdiurno.sanchezmoravictormanuelcocina;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.alumno2damdiurno.sanchezmoravictormanuelcocina.fragment.FragmentPago;
import com.example.alumno2damdiurno.sanchezmoravictormanuelcocina.fragment.FragmentPlatos;
import com.example.alumno2damdiurno.sanchezmoravictormanuelcocina.fragment.FragmentVino;

/**
 * Created by alumno2damdiurno on 24/01/17.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragmentPlatos();
            case 1:
                return new FragmentVino();
            case 2:
                return new FragmentPago();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Plato";
            case 1:
                return "Vino";
            case 2:
                return "Pago";
        }

        return null;
    }
}
