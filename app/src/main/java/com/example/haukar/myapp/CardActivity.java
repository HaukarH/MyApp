package com.example.haukar.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class CardActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private ListView cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.cardsButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardList();
            }
        });


    }

    private void cardList() {
        String text = spinner.getSelectedItem().toString();
        if (text.equals("Starter Deck: Yugi")) {
            cardList = findViewById(R.id.cardlist);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.yugiCards, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cardList.setAdapter(adapter);
        } else if (text.equals("Starter Deck: Kaiba")) {
            cardList = findViewById(R.id.cardlist);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kaibaCards, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cardList.setAdapter(adapter);
        } else if (text.equals("Starter Deck: Joey")) {
            cardList = findViewById(R.id.cardlist);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.joeyCards, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cardList.setAdapter(adapter);
        } else if (text.equals("Starter Deck: Pegasus")) {
            cardList = findViewById(R.id.cardlist);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pegasusCards, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cardList.setAdapter(adapter);
        }
    }

}
