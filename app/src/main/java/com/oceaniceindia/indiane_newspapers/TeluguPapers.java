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

public class TeluguPapers extends Fragment {
    View view;
    RecyclerView recyclerView;
    RecyclerViewAdapterTelugu recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        view=layoutInflater.inflate(R.layout.telugupapers,container,false);
        recyclerView=view.findViewById(R.id.recyclerviewtelugu);

        recyclerViewAdapter=new RecyclerViewAdapterTelugu();

        recyclerViewAdapter.addItems(new DataList("Eenadu" ,R.drawable.eenadu));
        recyclerViewAdapter.addItems(new DataList("AndhraJyothi" ,R.drawable.andhrajyothi));
        recyclerViewAdapter.addItems(new DataList("NavaTelangana" ,R.drawable.navatelangana));
        recyclerViewAdapter.addItems(new DataList("Sakshi" ,R.drawable.sakshi));
        recyclerViewAdapter.addItems(new DataList("NamasteTelangana" ,R.drawable.namaste));
        recyclerViewAdapter.addItems(new DataList("Vaartha" ,R.drawable.vaartha));
        recyclerViewAdapter.addItems(new DataList("AndhraPrabha" ,R.drawable.prabha));
        recyclerViewAdapter.addItems(new DataList("Surya" ,R.drawable.surya));


        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}
