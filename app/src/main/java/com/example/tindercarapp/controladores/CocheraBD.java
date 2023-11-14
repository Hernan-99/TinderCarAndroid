package com.example.tindercarapp.controladores;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tindercarapp.modelos.Cochera;

import java.util.ArrayList;
import java.util.List;

public class CocheraBD extends SQLiteOpenHelper implements iCocheras {
    Context context;
    private List<Cochera> cocheraList = new ArrayList<>();

    public CocheraBD(@Nullable Context context, @Nullable String name,
                     @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.contex = context;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public Cochera elemento(int id) {
        return null;
    }

    @Override
    public Cochera elemento(String nombreCochera) {
        return null;
    }

    @Override
    public List<Cochera> lista() {
        return null;
    }

    @Override
    public void agregar(Cochera cochera) {

    }

    @Override
    public void actualizar(int id, Cochera cochera) {

    }

    @Override
    public void borrar(int id) {

    }
}
