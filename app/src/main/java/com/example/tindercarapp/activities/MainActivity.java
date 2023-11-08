package com.example.tindercarapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.tindercarapp.R;
import com.example.tindercarapp.adapter.CocheraAdapter;
import com.example.tindercarapp.adapter.VehiculoAdapter;
import com.example.tindercarapp.domain.CocheraDomain;
import com.example.tindercarapp.domain.VehiculoDomain;
import com.example.tindercarapp.fragments.BottomBuscarFragment;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnBuscar;

    //---------------CAROUSEL-----------
    List<CarouselItem> cocheraCarouselList = new ArrayList<>();

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewVehiculoList, recyclerViewCocheraList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewholderView = LayoutInflater.from(this).inflate(R.layout.viewholder_vehiculo, null);


        // REFERENCIA BOTON PERFIL
        LinearLayout profileButton = findViewById(R.id.profileBtn);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad del perfil cuando se hace clic en el botón de perfil
                Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

        // REFERENCIA BOTON SOPORTE
        LinearLayout profileSoporteBtn = findViewById(R.id.profileSoporte);
        profileSoporteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SoporteActivity.class);
                startActivity(intent);
            }
        });

        btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSearchDialog();
            }
        });

        //---------------CAROUSEL-----------
        ImageCarousel carousel = findViewById(R.id.carousel);
        cocheraCarouselList.add(new CarouselItem("https://circontrol.com/wp-content/uploads/2019/02/180125-Circontrol-BAIXA-80-1080x675.jpg", "Cochera 1"));
        cocheraCarouselList.add(new CarouselItem("https://hips.hearstapps.com/hmg-prod/images/vacant-car-parking-space-royalty-free-image-1591721505.jpg", "Cochera 2"));
        carousel.addData(cocheraCarouselList);
        //----------------------------------

        //COCHERAS / TIPO ESTACIONAMIENTO
        recycleViewTipoVehiculos();
        RecycleViewCocheras();
    }


    private void showSearchDialog() {
        BottomBuscarFragment bottomSheetFragment = new BottomBuscarFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }

    //TIPO DE VEHICULO
    private void recycleViewTipoVehiculos(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewVehiculoList = findViewById(R.id.tipoVehiculo);
        recyclerViewVehiculoList.setLayoutManager(linearLayoutManager);

        ArrayList<VehiculoDomain> tiposVehiculos = new ArrayList<>();
        tiposVehiculos.add(new VehiculoDomain("Auto","moto"));
        tiposVehiculos.add(new VehiculoDomain("Moto","auto"));
        tiposVehiculos.add(new VehiculoDomain("Camioneta","camioneta"));

        adapter = new VehiculoAdapter(tiposVehiculos);
        recyclerViewVehiculoList.setAdapter(adapter);
    }

    //COCHERAS DISPONIBLES
    private void  RecycleViewCocheras(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCocheraList = findViewById(R.id.tiempoSeleccion);
        recyclerViewCocheraList.setLayoutManager(linearLayoutManager);

        ArrayList<CocheraDomain> cocherasDisponibles = new ArrayList<>();
        cocherasDisponibles.add(new CocheraDomain("cochera_uno", "San Jerónimo", "Alquiler $20.000 expensas e impuestos incluidos"));
        cocherasDisponibles.add(new CocheraDomain("cochera_dos", "Florida 87", "Alquiler $30.000 expensas e impuestos incluidos"));
        cocherasDisponibles.add(new CocheraDomain("cochera_tres", "Sagrada Familia", "Alquiler $15.000 expensas e impuestos incluidos"));
        cocherasDisponibles.add(new CocheraDomain("cochera_uno", "PARANA 353", "Alquiler $10.000 expensas e impuestos incluidos"));

        adapter2 = new CocheraAdapter(cocherasDisponibles);
        recyclerViewCocheraList.setAdapter(adapter2);
    }

}