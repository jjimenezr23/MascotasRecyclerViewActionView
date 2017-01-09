package jjimenez.app.com.mascotasrecyclerviewactionview.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;

/**
 * Created by henry on 09/12/2016.
 */

public class BaseDatosMascota extends SQLiteOpenHelper {

    private Context context;

    public BaseDatosMascota(Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablamascota = "CREATE TABLE " + ConstanteBaseDatos.TABLE_MASCOTA + "(" +
                ConstanteBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER, " +
                ConstanteBaseDatos.TABLE_MASCOTA_NOMBREMASCOTA + " TEXT" +
                ")";


        String queryCrearTablalikeMascotas = "CREATE TABLE " + ConstanteBaseDatos.TABLET_LIKE_MASCOTAS + "(" +
                ConstanteBaseDatos.TABLET_LIKE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstanteBaseDatos.TABLET_LIKE_MASCOTAS_ID_MASCOTAS + " INTEGER, " +
                ConstanteBaseDatos.TABLE_MASCOTA_DETALLE_LIKE + " INTEGER, " +
                "FOREIGN KEY (" + ConstanteBaseDatos.TABLET_LIKE_MASCOTAS_ID_MASCOTAS + ") " +
                "REFERENCES " + ConstanteBaseDatos.TABLE_MASCOTA + "(" + ConstanteBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";


        sqLiteDatabase.execSQL(queryCrearTablamascota);
        sqLiteDatabase.execSQL(queryCrearTablalikeMascotas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXIST" + ConstanteBaseDatos.TABLE_MASCOTA);

        db.execSQL("DROP TABLE IF EXIST" + ConstanteBaseDatos.TABLET_LIKE_MASCOTAS);

        onCreate(db);


    }

    public ArrayList<Mascotas> obtenertodaslasmascotas() {
        ArrayList<Mascotas> mascota = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {

            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombreMascota(registros.getString(2));


            String queryLike = "SELECT COUNT(" + ConstanteBaseDatos.TABLE_MASCOTA_DETALLE_LIKE + ") as like" +
                    " FROM " + ConstanteBaseDatos.TABLET_LIKE_MASCOTAS +
                    " WHERE " + ConstanteBaseDatos.TABLET_LIKE_MASCOTAS_ID_MASCOTAS + "=" + mascotaActual.getId();

            Cursor registrolike = db.rawQuery(queryLike, null);
            if (registrolike.moveToNext()) {
                mascotaActual.setDetallelike(registrolike.getInt(0));
            } else {

                mascotaActual.setDetallelike(0);

            }


            mascota.add(mascotaActual);

        }
        db.close();

        return mascota;

    }

    public void insertarMascotas(ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();


    }

    public void insertarLikeMascota(ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLET_LIKE_MASCOTAS,null, contentValues);
        db.close();
    }

    public int obtenerlikeMascota(Mascotas mascotas) {

        int like = 0;

        String query = "SELECT COUNT(" + ConstanteBaseDatos.TABLE_MASCOTA_DETALLE_LIKE + ")" +
                " FROM " + ConstanteBaseDatos.TABLET_LIKE_MASCOTAS +
                " WHERE " + ConstanteBaseDatos.TABLET_LIKE_MASCOTAS_ID_MASCOTAS + "=" + mascotas.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()) {

            like = registros.getInt(0);
        }
        db.close();
        return like;
    }





}



