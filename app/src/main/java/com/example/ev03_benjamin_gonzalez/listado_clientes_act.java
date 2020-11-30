package com.example.ev03_benjamin_gonzalez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Clases.Clientes;

public class listado_clientes_act extends AppCompatActivity {

    private ListView lista;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    private List<Clientes> listaClientes= new ArrayList<Clientes>();

    Clientes clienteSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);
        inicializarBase();
        lista=(ListView)findViewById(R.id.listclientes);

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot objSnapshot : snapshot.getChildren())
                {
                    Clientes clientes= objSnapshot.getValue(Clientes.class);
                    listaClientes.add(clientes);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_expandable_list_item_1,listaClientes);
                    lista.setAdapter(adapt);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                clienteSelected=(Clientes)adapterView.getItemAtPosition(i);
            }
        });
    }

    public void inicializarBase()
    {
        FirebaseApp.initializeApp(this);
        firebase=FirebaseDatabase.getInstance();
        databaseReference=firebase.getReference();
    }

    public void eliminar(View v)
    {
        Clientes cliente= new Clientes();
        cliente.setId(clienteSelected.getId());
        databaseReference.child("Clientes").child(cliente.getId()).removeValue();
        Toast.makeText(this,"Cliente eliminado", Toast.LENGTH_LONG).show();
    }




}