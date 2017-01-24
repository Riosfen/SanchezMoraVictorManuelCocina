package com.example.alumno2damdiurno.sanchezmoravictormanuelcocina.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumno2damdiurno.sanchezmoravictormanuelcocina.R;

/**
 * Created by alumno2damdiurno on 24/01/17.
 */
public class FragmentVino extends Fragment {

    private Spinner vinos;
    private RadioGroup contenido;
    private RadioButton chico, mediano, grande, maxi;
    private EditText comensales;
    private TextView resultado;
    private Button pedir;
    private String botella;
    private StringBuilder botellas = new StringBuilder("");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vino, container, false);

        vinos = (Spinner) v.findViewById(R.id.spinner_vinos);
        contenido = (RadioGroup) v.findViewById(R.id.group_contenido);
        chico = (RadioButton) v.findViewById(R.id.radioButton_chico);
        mediano = (RadioButton) v.findViewById(R.id.radioButton_mediano);
        grande = (RadioButton) v.findViewById(R.id.radioButton_grande);
        maxi = (RadioButton) v.findViewById(R.id.radioButton_maxi);
        pedir = (Button) v.findViewById(R.id.button_pedir);
        comensales = (EditText) v.findViewById(R.id.editText_numeroComensales);
        resultado = (TextView) v.findViewById(R.id.textView_resultado);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this.getContext(), R.array.array_vinos, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        vinos.setAdapter(adapter);

        vinos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                botella = (String) parentView.getItemAtPosition(position);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(getContext(), "Selecciona un vino...", Toast.LENGTH_SHORT).show();
            }
        });

        pedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText("");
                if (comensales.getText().toString().equals("")){
                    resultado.setText("No se puede calcular, introduce los comensales");
                }else{
                    double nBotellas = Double.valueOf(comensales.getText().toString());

                    if (chico.isChecked()){
                        botellas.append(nBotellas + " botellas de " + botella + ".");
                    }else if (mediano.isChecked()){
                        botellas.append((int) Math.ceil(nBotellas / 2) + " botellas de " + botella + ".");
                    }else if(grande.isChecked()){
                        botellas.append((int) Math.ceil(nBotellas / 3) + " botellas de " + botella + ".");
                    }else{
                        botellas.append((int) Math.ceil(nBotellas / 4) + " botellas de " + botella + ".");
                    }

                    resultado.setText(botellas.toString());
                }
            }
        });

        return v;
    }

}
