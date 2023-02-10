package com.example.samplenotes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class NotesForEachSemester extends AppCompatActivity {

    private static final String TAG = "NotesForEachSemester";
    private RecyclerView recyclerView;
    private FirebaseFirestore database;
    private List<NotesModel> list;
    private String courseName;
    private String semesterName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_for_each_semester);
        database = FirebaseFirestore.getInstance();
        list = new ArrayList<>();

        courseName = getIntent().getStringExtra("courseName");
        semesterName = getIntent().getStringExtra("semesterName");
        recyclerView=findViewById(R.id.recyclceViewNotes);

        getNotesIntoList(courseName,semesterName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<list.size();i++){
            Log.d(TAG, "onCreate:  "+list.get(i).getName());
        }
        PDFAdapter pdfAdapter=new PDFAdapter(NotesForEachSemester.this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(NotesForEachSemester.this));
        Log.d(TAG, "onCreate: setlayoutmanager");
        recyclerView.setAdapter(pdfAdapter);
        pdfAdapter.notifyDataSetChanged();


    }

    private void getNotesIntoList(String courseName, String semesterName) {

        // Computer Science
        if (courseName.equals("Computer Science")){

            switch(semesterName){
                case "firstSemester" : callFireStore("1cs"); break;
                case "secondSemester" : callFireStore("2cs"); break;
                case "thirdSemester" : callFireStore("3cs"); break;
                case "forthSemester" : callFireStore("4cs"); break;
                case "fifthSemester" : callFireStore("5cs"); break;
                case "sixthSemester" : callFireStore("6cs"); break;
                case "seventhSemester" : callFireStore("7cs"); break;
                case "eightSemester" : callFireStore("8cs"); break;
                default: Log.d(TAG, "getNotesIntoList: ");
            }

        }

        // Mechanical
        if (courseName.equals("Mechanical")){

            switch(semesterName){
                case "firstSemester" : callFireStore("1me"); break;
                case "secondSemester" : callFireStore("2me"); break;
                case "thirdSemester" : callFireStore("3me"); break;
                case "forthSemester" : callFireStore("4me"); break;
                case "fifthSemester" : callFireStore("5me"); break;
                case "sixthSemester" : callFireStore("6me"); break;
                case "seventhSemester" : callFireStore("7me"); break;
                case "eightSemester" : callFireStore("8me"); break;
                default: Log.d(TAG, "getNotesIntoList: ");
            }

        }
        // Electronics

        // Electrical

        //Civil

        //BioTech

    }

    private void callFireStore(String collectionPath){
        Log.d(TAG, "callFireStore: "+collectionPath);
        database.collection(collectionPath)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()){
                            List<DocumentSnapshot> snapshots = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d:snapshots){
                                list.add(new NotesModel(d.getData().get("name").toString(),d.getData().get("url").toString()));
                            }
                        }
                        for (int i=0;i<list.size();i++){
                            Log.d(TAG, "onsuccess: "+list.get(i).getName());
                        }
                    }
                });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}