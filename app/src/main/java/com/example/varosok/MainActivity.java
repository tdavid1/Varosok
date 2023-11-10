package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button kereses;
    private Button ujfelvetel;
    private EditText orszag_main;
    private varosok varosok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        kereses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = orszag_main.getText().toString();
                if(str.isEmpty()){
                    Toast.makeText(MainActivity.this, "A mezőt ne hagyd üresen", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent1 = new Intent(getApplicationContext() , SearchResultActivity.class);
                    intent1.putExtra("orszag", str);
                    startActivity(intent1);
                    finish();

                }
            }
        });
        ujfelvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , InsertActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        kereses = findViewById(R.id.kereses);
        ujfelvetel= findViewById(R.id.ujfelvetel);
        orszag_main = findViewById(R.id.orszag_main);
        varosok = new varosok(MainActivity.this);
    }
}