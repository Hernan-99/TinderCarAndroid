package com.example.tindercarapp;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.inputmethod.EditorInfo;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;


import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private List<CarouselItem> list = new ArrayList<>();
    private List<String> cocheraList = new ArrayList<>();
    private List<String> originalCocheraList = new ArrayList<>();
    private ArrayAdapter<String> adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);



        //Referencias
        ImageCarousel carousel = view.findViewById(R.id.carousel);
        EditText editTextSearch = view.findViewById(R.id.editTextSearch);
        ListView listViewResults = view.findViewById(R.id.listViewResults);

        //
        editTextSearch.setSingleLine();
        editTextSearch.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                filterResults(editTextSearch.getText().toString());
                hideKeyboard();
                return true;
            }
            return false;
        });

        // Inicializar la lista de cocheras para la búsqueda
        cocheraList.add("Cochera 1");
        cocheraList.add("Cochera 2");
        cocheraList.add("Cochera 3");
        cocheraList.add("Cochera 4");
        cocheraList.add("Cochera 5");
        cocheraList.add("Cochera 6");
        cocheraList.add("Cochera 7");
        cocheraList.add("Cochera 8");

        originalCocheraList.addAll(cocheraList);

        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, cocheraList);
        listViewResults.setAdapter(adapter);

        list.add(new CarouselItem("https://circontrol.com/wp-content/uploads/2019/02/180125-Circontrol-BAIXA-80-1080x675.jpg", "Cochera 1"));
        list.add(new CarouselItem("https://hips.hearstapps.com/hmg-prod/images/vacant-car-parking-space-royalty-free-image-1591721505.jpg", "Cochera 2"));

        carousel.addData(list);


        // Agregar un listener al EditText para filtrar los resultados mientras se escribe
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // Filtra lista de cocheras
                filterResults(charSequence.toString());

            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        return view;
    }

    // funcion para buscar cochera por nombre
    private void filterResults(String query){
        List<String> filteredList = new ArrayList<>();
        for (String el : originalCocheraList) {
            if (query.isEmpty() || el.toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(el);
            }
        }
        adapter.clear();
        adapter.addAll(filteredList);
        adapter.notifyDataSetChanged();

        hideKeyboard();

    }

    // Función para ocultar el teclado
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = requireView();
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}