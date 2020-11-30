package com.example.ev03_benjamin_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class menu_act extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        videoView = (VideoView)findViewById(R.id.video);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }

    public void Promociones(View v) {

        ArrayList<String> clientes = new ArrayList<String>();
        clientes.add("Ramiro");
        clientes.add("Rosa");
        clientes.add("Robert");

        Intent i = new Intent(this, promociones_act.class);
        i.putExtra("listaclientes", clientes);
        startActivity(i);
    }

    public void Gestion(View v) {

        Intent i = new Intent(this, firebase_act.class);
        startActivity(i);
    }

}