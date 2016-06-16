package com.think.formulario;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Confirmacion extends AppCompatActivity {
    Button btnAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        Bundle b = getIntent().getExtras();
        String nombre = b.getString("nombre");
        String email = b.getString("email");
        String fechaNacimiento = b.getString("fechaNacimiento");
        String telefono = b.getString("telefono");
        String detalle = b.getString("detalle");

        TextView tvNombre = (TextView) findViewById(R.id.tvNombreConf);
        TextView tvTelefono = (TextView)findViewById(R.id.tvTelefonoConf);
        TextView tvEmail = (TextView)findViewById(R.id.tvMailConf);
        TextView tvDetalle = (TextView)findViewById(R.id.tvDescripcionConf);
        TextView tvFecha = (TextView)findViewById(R.id.tvFechaConf);

        tvNombre.setText(nombre);
        tvEmail.setText(email);
        tvDetalle.setText(detalle);
        tvFecha.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
