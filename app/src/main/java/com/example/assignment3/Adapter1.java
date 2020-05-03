package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder1> {

    private  List<Items> productList;
    public  Adapter1(MainActivity mainActivity, List<Items> productList)
    {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_layout , parent ,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {
        Items prodcut=productList.get(position);
        holder.textViewTitle.setText(prodcut.getTitle());
        holder.Level.setText(prodcut.getLevel());
        holder.info.setText(prodcut.getInfo());
        holder.auther.setText(prodcut.getAuthor());
        holder.autherUrl.setText(prodcut.getAuthor());
        Picasso.get().load(prodcut.getUrl()).into((Target) holder.btn1);

        Picasso.get().load(prodcut.getCover()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder{

         Button btn1;
        TextView info;

        ImageView imageView;
        TextView Level;
        TextView textViewTitle;
        TextView auther;
        TextView autherUrl;



        public ViewHolder1(@NonNull View itemView) {
            super(itemView);


           auther=itemView.findViewById(R.id.auther);
           autherUrl=itemView.findViewById(R.id.autherUrl);
            btn1=itemView.findViewById(R.id.btn1);
            info=itemView.findViewById(R.id.info);
            imageView=itemView.findViewById(R.id.imageView);
            Level=itemView.findViewById(R.id.Level);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
        }
    }

}
