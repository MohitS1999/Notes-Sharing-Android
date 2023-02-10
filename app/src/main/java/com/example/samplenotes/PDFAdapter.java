package com.example.samplenotes;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class PDFAdapter extends RecyclerView.Adapter<PDFAdapter.MyViewHolder>{
    private static final String TAG = "PDFAdapter";
    Context context;
    List<NotesModel> list;
    public PDFAdapter(Context ct,List<NotesModel> list) {
        context=ct;
        this.list = list;
        Log.d(TAG, "PDFAdapter: "+list);
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.pdf,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        holder.title.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView title;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                title=itemView.findViewById(R.id.textView);
                itemView.setOnClickListener(this);
                context=itemView.getContext();
            }

            @Override
            public void onClick(View v) {
                Intent intent;
                int pos=getAdapterPosition();
                if (!isNetworkAvailable()){
                    Toast.makeText(context,"You are Not Connected!!!",Toast.LENGTH_SHORT).show();
                }else {
//                    intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(Uri.parse(list.get(pos).getUrl()),"application/pdf");
//                    context.startActivity(intent);
                    intent = new Intent(context, Web.class);
                    intent.putExtra("url", list.get(pos).getUrl());
                    context.startActivity(intent);
                }
            }
         public boolean isNetworkAvailable() {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }

        }
}
