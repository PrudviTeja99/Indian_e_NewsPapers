package com.oceaniceindia.indiane_newspapers;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterEnglish extends RecyclerView.Adapter<RecyclerViewAdapterEnglish.MyViewHolder> {

    DataList dataList;
    ArrayList<DataList> list=new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.singleitem,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        dataList=list.get(position);
        holder.textname.setText(dataList.getTitle());
        holder.image.setImageResource(dataList.getImage());


        holder.paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),NewsPaperEnglish.class);
                dataList=list.get(position);
                intent.putExtra("name",dataList.getTitle());
                v.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView textname;
        ConstraintLayout paper;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.image);
            textname=itemView.findViewById(R.id.textname);
            paper=itemView.findViewById(R.id.paper);

        }

    }
    void addItems(DataList dataList){
        list.add(dataList);
    }
}
