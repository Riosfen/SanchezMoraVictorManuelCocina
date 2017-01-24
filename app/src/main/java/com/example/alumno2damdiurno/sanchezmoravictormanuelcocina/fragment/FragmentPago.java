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
public class FragmentPago extends Fragment {

    private EditText numeroPersona, precioMenu, pago;
    private TextView vuelta;
    private Button btnVuelta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pago, container, false);

        btnVuelta = (Button) v.findViewById(R.id.button_cobrar);
        numeroPersona = (EditText) v.findViewById(R.id.editText_numeroPersonas);
        precioMenu = (EditText) v.findViewById(R.id.editText_numeroPrecioMenu);
        pago = (EditText) v.findViewById(R.id.editText_numeroPago);
        vuelta = (TextView) v.findViewById(R.id.textView_vuelta);

        btnVuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vuelta.setText("");

                if (numeroPersona.getText().toString().equals("") || precioMenu.getText().toString().equals("") || pago.getText().toString().equals("")){
                    vuelta.setText("Faltan valores por insertar");
                }else{

                    int persona = Integer.valueOf(numeroPersona.getText().toString());
                    double menu = Double.valueOf(precioMenu.getText().toString());
                    double pagos = Double.valueOf(pago.getText().toString());
                    if (pagos < menu * persona){
                        vuelta.setText("El cliente tiene que pagar mas.");
                    }else{
                        double resultado = pagos - (persona * menu);
                        vuelta.setText(String.valueOf(resultado));

                    }
                }
            }
        });

        return v;
    }

}
