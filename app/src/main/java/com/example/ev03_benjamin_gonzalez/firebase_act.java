package com.example.ev03_benjamin_gonzalez;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import Clases.Clientes;

public class firebase_act extends AppCompatActivity {

    private EditText nombre,destino,promocion;
    private Button guardar;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        inicializarFirebase();
        nombre=(EditText)findViewById(R.id.etnombre);
        destino=(EditText)findViewById(R.id.etdestino);
        promocion=(EditText)findViewById(R.id.etpromocion);
        guardar=(Button) findViewById(R.id.bguardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!nombre.equals(""))
                {
                    Clientes clientes=new Clientes();
                    clientes.setId(UUID.randomUUID().toString());
                    clientes.setNombre(nombre.getText().toString());
                    clientes.setDestino(destino.getText().toString());
                    clientes.setPromocion(promocion.getText().toString());

                    databaseReference.child("Clientes").child(clientes.getId()).setValue(clientes);
                    Toast.makeText(getBaseContext(), "Se ha guardado", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "No se ha guardado", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public void inicializarFirebase()
    {
        FirebaseApp.initializeApp(this);
        firebase=FirebaseDatabase.getInstance();
        databaseReference=firebase.getReference();

    }
    public void Listado(View v) {

        Intent i = new Intent(this, listado_clientes_act.class);
        startActivity(i);
    }

}