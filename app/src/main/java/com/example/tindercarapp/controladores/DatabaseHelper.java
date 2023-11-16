package com.example.tindercarapp.controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.tindercarapp.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "TinderCarDb.db";

    //User table name
    private static final String TABLE_USER = "usuario";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "id_usuario";
    private static final String COLUMN_USER_NOMBRE= "nombre_usuario";
    private static final String COLUMN_USER_APELLIDO ="apellido_usuario";
    private static final String COLUMN_USER_PASSWORD ="contrasenia_usuario";
    private static final String COLUMN_USER_CONF_PASS="confirmarcontrasenia_usuario";
    private static final String COLUMN_USER_CORREO ="correo_usuario";
    private static final String COLUMN_USER_Telefono="telefono_usuario";

    //create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + COLUMN_USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_NOMBRE + "TEXT," + COLUMN_USER_APELLIDO + "TEXT, " + COLUMN_USER_PASSWORD + "TEXT, "
            + COLUMN_USER_CONF_PASS + "TEXT," + COLUMN_USER_CORREO + "TEXT, " + COLUMN_USER_Telefono + "TEXT" + ")";

    //drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    //Constructor
    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop user table if exists
        db.execSQL(DROP_USER_TABLE);

        //Create tables again
        onCreate(db);

    }

    // Este metodo se utiliza para grabar un usuario

    public void addUser (Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NOMBRE, usuario.getNombre_usuario());
        values.put(COLUMN_USER_CORREO, usuario.getCorreo_usuario());
        values.put(COLUMN_USER_PASSWORD, usuario.getContrasenia_usuario());

        //Insertar Row
        db.insert(TABLE_USER, null, values);
        db.close();

    }
        //Este Metodo es para devolver la lista de todos los usarios

        public List<Usuario> getAllUser() {
            //Array de columnas
            String[] columns = {
                    COLUMN_USER_ID,
                    COLUMN_USER_CORREO,
                    COLUMN_USER_NOMBRE,
                    COLUMN_USER_PASSWORD
            };
            //Sorting order
            String sortOrder =
                    COLUMN_USER_NOMBRE + " ASC";
            List<Usuario> userList = new ArrayList<Usuario>();

            SQLiteDatabase db = this.getReadableDatabase();

            //query de la tabla de usuarios

            Cursor cursor= db.query(TABLE_USER, //Query
                    columns,    //columns to return
                    null,
                    null,
                    null,
                    null,
                    sortOrder);

            if (cursor.moveToFirst()){
                do {
                    Usuario usuario = new Usuario ();
                    usuario.setId_usuario(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                    usuario.setNombre_usuario(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NOMBRE)));
                    usuario.setCorreo_usuario((cursor.getString(cursor.getColumnIndex(COLUMN_USER_CORREO))));
                    usuario.setContrasenia_usuario(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                    //adding user record list
                    userList.add(usuario);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();

            //return user list
            return userList;
    }
        //este metodo es para hacer update
    public void updateUser(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

    }



}
