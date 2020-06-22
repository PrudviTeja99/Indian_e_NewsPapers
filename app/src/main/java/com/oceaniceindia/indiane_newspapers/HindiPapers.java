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

public class HindiPapers extends Fragment {
    View view;
    RecyclerView recyclerView;
    RecyclerViewAdapterHindi recyclerViewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        view=layoutInflater.inflate(R.layout.hindipapers,container,false);
        recyclerView=view.findViewById(R.id.recyclerviewhindi);

        recyclerViewAdapter=new RecyclerViewAdapterHindi();

        recyclerViewAdapter.addItems(new DataList("Dainik Jagran" ,R.drawable.jargan));
        recyclerViewAdapter.addItems(new DataList("Hindustan" ,R.drawable.hindustan));
        recyclerViewAdapter.addItems(new DataList("Dainik Bhaskar" ,R.drawable.bhaskar));
        recyclerViewAdapter.addItems(new DataList("Amar Ujala" ,R.drawable.amar));
        recyclerViewAdapter.addItems(new DataList("Patrika" ,R.drawable.patrika));
        recyclerViewAdapter.addItems(new DataList("Punjab Kesari" ,R.drawable.kesari));



        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

}

