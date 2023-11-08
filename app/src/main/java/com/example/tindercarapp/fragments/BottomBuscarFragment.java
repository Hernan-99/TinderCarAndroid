package com.example.tindercarapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.tindercarapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BtnBuscarFragment extends BottomSheetDialogFragment {

    private ArrayAdapter<String> adapter;
    private List<String> listaCocheras;

    private SearchView buscarView;

    public BtnBuscarFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_search_bottom_sheet, container, false);

        String[] dataCocheras = {"Cochera 1", "Cochera 2", "Cochera 3"};

       listaCocheras = new ArrayList<>(Arrays.asList(dataCocheras));

        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, listaCocheras);

        ListView listView = view.findViewById(R.id.listaCocheras);
        listView.setAdapter(adapter);

        buscarView = view.findViewById(R.id.busquedaCocherasView);
        buscarView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return view;
    }

}
