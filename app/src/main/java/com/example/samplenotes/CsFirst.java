package com.example.samplenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CsFirst extends AppCompatActivity {
    RecyclerView recyclerView;
    String name[]={"Engg Math I","Engg Chemistry","C language","Electrical","Electronics","Professinal Communication"};
    String links[]={"https://drive.google.com/file/d/1ljqo2u4_8wb6UPgqHLy1-mJiv0EdW7jF/view?usp=sharing",
                    "https://drive.google.com/file/d/1r8va7u5V8ZwMJ7yKfVT4t4lNhnuyAXkS/view?usp=sharing",
                    "https://drive.google.com/file/d/1TmcS6ZvEgAyB7gmGuFkFOsVgRatAD6KH/view?usp=sharing",
                    "https://drive.google.com/file/d/1YJOzC6_aSNhYCDXykBAM0Ylf6KAhG893/view?usp=sharing",
                    "https://drive.google.com/file/d/1zVNdg04MTLHgd4OQkVr66i3NKkosbKmR/view?usp=sharing",
                    "https://drive.google.com/file/d/0B7RBrJBsud5YMEJZVUVmYUNGSzA/view?usp=sharing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_first);
        recyclerView=findViewById(R.id.recyclceView);
        PDFAdapter pdfAdapter=new PDFAdapter(this,name,links);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pdfAdapter);
    }
}