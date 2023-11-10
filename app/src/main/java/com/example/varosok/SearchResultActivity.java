package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends AppCompatActivity {

    private Button Vissza_s;
    private TextView Textview_S;
    private boolean igen = false;
    private varosok varosok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();
        Intent intent = getIntent();
        String str = intent.getStringExtra("orszag");
        Cursor adatok = varosok.adatlekerdezes();
        if(adatok.getCount()==0){
            StringBuilder builder = new StringBuilder();
            builder.append("Nem található a következő ").append(str);
            Textview_S.setText(builder);
        }
        else{
            StringBuilder builder = new StringBuilder();
            while(adatok.moveToNext()){
                if(adatok.getString(2).equals(str)) {
                    builder.append(adatok.getString(1)).append("\n");
                    igen = true;
                }
            }
            Textview_S.setText(builder);
        }
        if(igen == false){
            StringBuilder builder = new StringBuilder();
            builder.append("Nem található a következő ").append(str);
            Textview_S.setText(builder);
        }
        Vissza_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchResultActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public void init(){
        Vissza_s= findViewById(R.id.Vissza_s);
        Textview_S = findViewById(R.id.TextView_S);
        varosok = new varosok(SearchResultActivity.this);
    }
}