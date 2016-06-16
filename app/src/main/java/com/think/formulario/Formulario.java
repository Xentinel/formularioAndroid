package com.think.formulario;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class Formulario extends AppCompatActivity {


    private String fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button btnSiguiente = (Button) findViewById(R.id.btnFor);
        final TextInputEditText tiNombre = (TextInputEditText) findViewById(R.id.tiNombre);
        final TextInputEditText tiTelefono = (TextInputEditText) findViewById(R.id.tiTelefono);
        final TextInputEditText tiEmail = (TextInputEditText) findViewById(R.id.tiEmail);
        final TextInputEditText tiDetalle = (TextInputEditText) findViewById(R.id.tiContacto);
        DatePicker BirthDateDP = (DatePicker) findViewById(R.id.dpFechaNacimientoFor);
        final int minYear = 1960;
        final int minMonth = 0; // january
        final int minDay = 25;
        final Calendar c = Calendar.getInstance();
        final int maxYear = c.get(Calendar.YEAR) - 20; // this year ( 2011 ) - 20 = 1991
        final int maxMonth = c.get(Calendar.MONTH);
        final int maxDay = c.get(Calendar.DAY_OF_MONTH);
        BirthDateDP.init(maxYear - 10, maxMonth, maxDay, new DatePicker.OnDateChangedListener()
        {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                fechaNacimiento = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
            }}); // BirthDateDP.init()

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Formulario.this, Confirmacion.class);
                i.putExtra("nombre", tiNombre.getText().toString());
                i.putExtra("telefono",tiTelefono.getText().toString());
                i.putExtra("email",tiEmail.getText().toString());
                i.putExtra("detalle",tiDetalle.getText().toString());
                i.putExtra("fechaNacimiento",fechaNacimiento);
                startActivity(i);
            }
        });

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
