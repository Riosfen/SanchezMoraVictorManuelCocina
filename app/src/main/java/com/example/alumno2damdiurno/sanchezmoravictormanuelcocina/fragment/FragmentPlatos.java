package com.example.alumno2damdiurno.sanchezmoravictormanuelcocina.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.alumno2damdiurno.sanchezmoravictormanuelcocina.R;

/**
 * Created by alumno2damdiurno on 24/01/17.
 */
public class FragmentPlatos extends Fragment {

    private RadioGroup primero, segundo, postre;
    private RadioButton macarr, sopa, paella, atun, choco, arroz, tocino;
    private Button btnPlato;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plato, container, false);

        primero = (RadioGroup) v.findViewById(R.id.group_primero);
        segundo = (RadioGroup) v.findViewById(R.id.group_segundo);
        postre = (RadioGroup) v.findViewById(R.id.group_postre);
        macarr = (RadioButton) v.findViewById(R.id.radioButton_macarrones);
        sopa = (RadioButton) v.findViewById(R.id.radioButton_sopa);
        paella = (RadioButton) v.findViewById(R.id.radioButton_paella);
        atun = (RadioButton) v.findViewById(R.id.radioButton_atun);
        choco = (RadioButton) v.findViewById(R.id.radioButton_choco);
        arroz = (RadioButton) v.findViewById(R.id.radioButton_arroz);
        tocino = (RadioButton) v.findViewById(R.id.radioButton_tocino);
        btnPlato = (Button) v.findViewById(R.id.button_enviar);

        btnPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contCheck = 0;
                StringBuilder platos = new StringBuilder("");

                if (macarr.isChecked()){
                    platos.append("De primero: " + getResources().getString(R.string.macarrones) + ", ");
                }else{
                    platos.append("De primero: " + getResources().getString(R.string.sopa) + ", ");
                }

                if (paella.isChecked()) {
                    platos.append("de segundo: " + getResources().getString(R.string.paella) + ", ");
                }else if(atun.isChecked()){
                    platos.append("de segundo: " + getResources().getString(R.string.atun) + ", ");
                }else{
                    platos.append("de segundo: " + getResources().getString(R.string.choco_frito) + ", ");
                }

                if (arroz.isChecked()){
                    platos.append("de postre: " + getResources().getString(R.string.arroz_con_leche) + ".");
                }else{
                    platos.append("de postre: " + getResources().getString(R.string.tocino_de_cielo) + ".");
                }

                Toast.makeText(getContext(), platos.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
