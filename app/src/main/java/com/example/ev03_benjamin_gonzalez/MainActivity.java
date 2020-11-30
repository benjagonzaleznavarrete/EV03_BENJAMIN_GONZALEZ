package com.example.ev03_benjamin_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtname,txtpass;
    private TextView tvmensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname=(EditText) findViewById(R.id.name);
        txtpass=(EditText) findViewById(R.id.pass);
        tvmensaje=(TextView) findViewById(R.id.mensaje);

    }

    public void Login(View v) {
        String user, password;
        user=txtname.getText().toString();
        password=txtpass.getText().toString();

        if ((user.equals("ANDROID") || user.equals("Android")) && (password.equals("123"))) {
            Intent i = new Intent(this, menu_act.class);
            startActivity(i);

        }
        else{
            tvmensaje.setText("Usuario o contraseña incorrecta, intentelo nuevamente");
        }
    }
}