package com.example.samplenotes;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class PDFAdapter extends RecyclerView.Adapter<PDFAdapter.MyViewHolder>{
    Context context;
    String name[];
    String links[];
    public PDFAdapter(Context ct,String n[],String l[]) {
        name=n;
        context=ct;
        links=l;
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
        holder.title.setText(name[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
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
                    intent = new Intent(context, Web.class);
                    intent.putExtra("url", links[pos]);
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
