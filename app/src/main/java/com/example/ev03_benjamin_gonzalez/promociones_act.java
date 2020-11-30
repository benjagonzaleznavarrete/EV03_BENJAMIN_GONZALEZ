package com.example.ev03_benjamin_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Promociones;

public class promociones_act extends AppCompatActivity {

    private Spinner clientes;
    private EditText promocion, destino;
    private TextView mensaje, precio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        clientes=(Spinner)findViewById(R.id.spclientes);
        promocion=(EditText)findViewById(R.id.etpromo);
        destino=(EditText)findViewById(R.id.etdespacho);
        mensaje=(TextView)findViewById(R.id.tvmensaje);
        precio=(TextView)findViewById(R.id.tvprecio);
        



        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaclientes");
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        clientes.setAdapter(adapt);
    }

    public void CalcularPrecio(View v)
    {

        if(!promocion.getText().toString().isEmpty())
        {

            if(promocion.getText().toString().equals("Master pizza")||promocion.getText().toString().equals("Pizzas promo")||promocion.getText().toString().equals("Pizzas max"))
            {
                if(!destino.getText().toString().isEmpty())
                {
                    int precioFinal;
                    Promociones promo= new Promociones();
                    int valorEnvio =Integer.parseInt(destino.getText().toString());
                    String cliente = clientes.getSelectedItem().toString();


                    if(promocion.getText().toString().equals("Master pizza"))
                    {
                        precioFinal=promo.getMasterpizza()+valorEnvio;
                        mensaje.setText("Estimado "+cliente+" el precio final según su promoción y envio es:");
                        precio.setText("$"+precioFinal);
                    }
                    else if(promocion.getText().toString().equals("Pizzas promo"))
                    {
                        precioFinal=promo.getPizzaspromo()+valorEnvio;
                        mensaje.setText("Estimado "+cliente+" el precio final según su promoción y envio es:");
                        precio.setText("$"+precioFinal);
                    }
                    else
                    {
                        precioFinal=promo.getPizzamax()+valorEnvio;
                        mensaje.setText("Estimado "+cliente+" el precio final según su promoción y envio es:");
                        precio.setText("$"+precioFinal);
                    }

                }
                else
                {
                    Toast.makeText(this,"Debe ingresar un valor",Toast.LENGTH_LONG).show();
                }



            }
            else
            {
                Toast.makeText(this,"Ingrese una promoción válida",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Debe ingresar una promocion",Toast.LENGTH_LONG).show();
        }
    }

}