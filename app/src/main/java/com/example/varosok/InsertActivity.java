package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    private Button felvetel;
    private Button vissza;
    private EditText orszag;
    private EditText nev;
    private EditText lakossag;
    private varosok varosok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();
        felvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orszags = orszag.getText().toString();
                String nevs = nev.getText().toString();
                String lakossags = lakossag.getText().toString();
                if(orszags.isEmpty() || nevs.isEmpty() || lakossags.isEmpty()){
                    Toast.makeText(InsertActivity.this, "Minden adatot meg kell adnu", Toast.LENGTH_SHORT).show();
                }
                else{
                    int lakoss = Integer.parseInt(lakossags);
                    if (varosok.adatRogzites(nevs,orszags,lakoss)){
                        Toast.makeText(InsertActivity.this, "Sikeres adat felvétel", Toast.LENGTH_SHORT).show();
                        edittextreset();
                    }
                    else{
                        Toast.makeText(InsertActivity.this, "Sikertelen adat felvétel", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        felvetel = findViewById(R.id.felvetel);
        vissza= findViewById(R.id.vissza_i);
        orszag = findViewById(R.id.orszag);
        nev = findViewById(R.id.nev);
        lakossag = findViewById(R.id.lakossag);
        varosok = new varosok(InsertActivity.this);
    }
    private void edittextreset(){
        orszag.setText(null);
        nev.setText(null);
        lakossag.setText(null);
    }
}