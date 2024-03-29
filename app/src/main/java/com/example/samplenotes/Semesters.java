package com.example.samplenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class Semesters extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView courseName;
    String s1[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
    int image[]={R.drawable.sem1,R.drawable.sem2,R.drawable.sem3,R.drawable.sem4,R.drawable.sem5,R.drawable.sem6,R.drawable.sem7,R.drawable.sem8};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semesters);
        courseName = findViewById(R.id.courseName);
        String course = getIntent().getStringExtra("courseName");
        courseName.setText(course.trim());

        recyclerView=findViewById(R.id.recyclceView);
        //s1=getResources().getStringArray(R.array.semester);
        MyAdapter myAdapter=new MyAdapter(this,s1,image,course);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);


    }
}