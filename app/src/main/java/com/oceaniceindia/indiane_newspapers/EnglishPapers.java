package com.oceaniceindia.indiane_newspapers;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EnglishPapers extends Fragment {
    View view;
    RecyclerView recyclerView;
    RecyclerViewAdapterEnglish recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        view=layoutInflater.inflate(R.layout.englishpapers,container,false);
        recyclerView=view.findViewById(R.id.recyclerviewenglish);

        recyclerViewAdapter=new RecyclerViewAdapterEnglish();

        recyclerViewAdapter.addItems(new DataList("The Indian Express" ,R.drawable.express));
        recyclerViewAdapter.addItems(new DataList("Deccan Chronical" ,R.drawable.deccan));
        recyclerViewAdapter.addItems(new DataList("The Hindu" ,R.drawable.thehindu));
        recyclerViewAdapter.addItems(new DataList("The Financial Express" ,R.drawable.financial));
        recyclerViewAdapter.addItems(new DataList("Times of India" ,R.drawable.timesofindia));
        recyclerViewAdapter.addItems(new DataList("Hindustan Times" ,R.drawable.hindustantimes));
        recyclerViewAdapter.addItems(new DataList("Economic Times" ,R.drawable.economictimes));


        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}
