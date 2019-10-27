package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuCatLeitores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cat_leitores);


    Button cadCatLeitor = (Button) findViewById(R.id.btnCadCatLeitor);
        cadCatLeitor.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent it = new Intent(MenuCatLeitores.this,CatLeitores.class);
            startActivity(it);
        }
    } );

    Button altCatLeitor = (Button) findViewById(R.id.btnAltCatLeitor);
        altCatLeitor.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent it = new Intent(MenuCatLeitores.this,AltCatLeitores.class);
            startActivity(it);
        }
    } );

    Button exCatLeitor = (Button) findViewById(R.id.btnAltCatLeitor);
        exCatLeitor.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent it = new Intent(MenuCatLeitores.this,ExCatLeitores.class);
            startActivity(it);
        }
    } );



}}
