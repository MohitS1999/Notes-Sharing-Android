package com.example.samplenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondSemester extends AppCompatActivity {
    CardView cs;
    CardView me;
    CardView ec;
    CardView ee;
    CardView ce;
    CardView bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_semester);
        cs = findViewById(R.id.csecard);
        me = findViewById(R.id.mecard);
        ec = findViewById(R.id.eccard);
        ee = findViewById(R.id.eecard);
        ce = findViewById(R.id.cecard);
        bt = findViewById(R.id.btecard);
        cs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CsSecond.class);
                Toast.makeText(getApplicationContext(),"Computer Science",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        me.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MeSecond.class);
                Toast.makeText(getApplicationContext(),"Mechanical Engineering",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        ec.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EcSecond.class);
                Toast.makeText(getApplicationContext(),"Electronic Engineering",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        ee.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EeSecond.class);
                Toast.makeText(getApplicationContext(),"Electrical Engineering",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CeSecond.class);
                Toast.makeText(getApplicationContext(),"Civil Engineering",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BtSecond.class);
                Toast.makeText(getApplicationContext(),"Bio Tech",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

}