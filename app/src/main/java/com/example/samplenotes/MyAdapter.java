package com.example.samplenotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[];
    int images[];
    Context context;
    String courseName;
    public MyAdapter(Context ct, String s1[], int image[],String courseName){
        context=ct;
        data1=s1;
        images=image;
        this.courseName = courseName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.myText.setText(data1[position]);
        holder.myimage.setImageResource(images[position]);
        holder.imageNext.setImageResource(R.drawable.ic_baseline_navigate_next_24);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myText;
        ImageView myimage;
        ImageView imageNext;
        private final Context context;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText=itemView.findViewById(R.id.textview);
            myimage=itemView.findViewById(R.id.imageView);
            imageNext=itemView.findViewById(R.id.imageNext);
            itemView.setOnClickListener(this);
            context=itemView.getContext();
        }
        public void onClick(View view){
            Intent intent;
            int pos=getAdapterPosition();
            if (pos==0){
                intent=new Intent(context,NotesForEachSemester.class);
                intent.putExtra("courseName",courseName);
                intent.putExtra("semesterName","firstSemester");
                Toast.makeText(context,"Welcome To First Semester",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
            if (pos==1){
                intent=new Intent(context,NotesForEachSemester.class);
                intent.putExtra("courseName",courseName);
                intent.putExtra("semesterName","secondSemester");
                Toast.makeText(context,"Welcome To Second Semester",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }

            if (pos==2){
                intent=new Intent(context,NotesForEachSemester.class);
                intent.putExtra("courseName",courseName);
                intent.putExtra("semesterName","thirdSemester");
                Toast.makeText(context,"Welcome To Third Semester",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
            if (pos==3){
                intent=new Intent(context,NotesForEachSemester.class);
                intent.putExtra("courseName",courseName);
                intent.putExtra("semesterName","forthSemester");
                Toast.makeText(context,"Welcome To Forth Semester",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
            if (pos==4){
                intent=new Intent(context,NotesForEachSemester.class);
                intent.putExtra("courseName",courseName);
                intent.putExtra("semesterName","fifthSemester");
                Toast.makeText(context,"Welcome To Fifth Semester",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
            if (pos==5){
                intent=new Intent(context,NotesForEachSemester.class);
                intent.putExtra("courseName",courseName);
                intent.putExtra("semesterName","sixthSemester");
                Toast.makeText(context,"Welcome To Six Semester",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
            if (pos==6){
                intent=new Intent(context,NotesForEachSemester.class);
                intent.putExtra("courseName",courseName);
                intent.putExtra("semesterName","seventhSemester");
                Toast.makeText(context,"Welcome To Seventh Semester",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }if (pos==7){
                intent=new Intent(context,NotesForEachSemester.class);
                intent.putExtra("courseName",courseName);
                intent.putExtra("semesterName","eightSemester");
                Toast.makeText(context,"Welcome To Eight Semester",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }



        }
    }
}
