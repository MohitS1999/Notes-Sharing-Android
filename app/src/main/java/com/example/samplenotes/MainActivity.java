package com.example.samplenotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    /*
    String s1[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
    int image[]={R.drawable.sem1,R.drawable.sem2,R.drawable.sem3,R.drawable.sem4,R.drawable.sem5,R.drawable.sem6,R.drawable.sem7,R.drawable.sem8};
    */
    CardView cs;
    CardView me;
    CardView ec;
    CardView ee;
    CardView ce;
    CardView bt;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        recyclerView=findViewById(R.id.recyclceView);
        //s1=getResources().getStringArray(R.array.semester);
        MyAdapter myAdapter=new MyAdapter(this,s1,image);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

         */
        cs = findViewById(R.id.csecard);
        me = findViewById(R.id.mecard);
        ec = findViewById(R.id.eccard);
        ee = findViewById(R.id.eecard);
        ce = findViewById(R.id.cecard);
        bt = findViewById(R.id.btecard);

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Semesters.class);
                intent.putExtra("courseName","Computer Science");
                Toast.makeText(MainActivity.this,"Welcome To Computer Science",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Semesters.class);
                intent.putExtra("courseName","Mechanical");
                Toast.makeText(MainActivity.this,"Welcome To Mechanical Engineering",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Semesters.class);
                intent.putExtra("courseName","Electronics");
                Toast.makeText(MainActivity.this,"Welcome To Electronics Engineering",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Semesters.class);
                intent.putExtra("courseName","Electrical");
                Toast.makeText(MainActivity.this,"Welcome To Electrical Engineering",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Semesters.class);
                intent.putExtra("courseName","Civil");
                Toast.makeText(MainActivity.this,"Welcome To Civil Engineering",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Semesters.class);
                intent.putExtra("courseName","BioTech");
                Toast.makeText(MainActivity.this,"Welcome To BioTechnology",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


        ActionBar actionBar=getSupportActionBar();
        //actionBar.hide();

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser mFirebaseUser = mAuth.getCurrentUser();

        if (mFirebaseUser != null){

        }else{
            startActivity(new Intent(MainActivity.this,OTPscreen.class));
            finish();
        }
    }
}