package com.example.haukar.myapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.LocaleList;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button seeDeckButton;
    private Button seeCardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seeDeckButton = (Button) findViewById(R.id.seeDeck);
        seeDeckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deckActivity();
            }
        });

        seeCardButton = (Button) findViewById(R.id.seeCard);
        seeCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardActivity();
            }
        });

        Button changeLang = findViewById(R.id.button);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLang();
            }
        });
    }

    private void deckActivity(){
        Intent intent = new Intent(this, DeckActivity.class);
        startActivity(intent);
    }

    private void cardActivity(){
        Intent intent = new Intent(this, CardActivity.class);
        startActivity(intent);
    }

    private void changeLang(){
        final String[] languages = {"Dutch", "English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i == 0){
                    setLocale("nl");
                    recreate();
                } else if (i == 1){
                    setLocale("en");
                    recreate();
                }

                dialog.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();

        mDialog.show();
    }

    private void setLocale (String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }

}
