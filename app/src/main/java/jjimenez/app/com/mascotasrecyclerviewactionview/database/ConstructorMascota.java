package jjimenez.app.com.mascotasrecyclerviewactionview.database;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.R;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;

/**
 * Created by henry on 02/12/2016.
 */

public class ConstructorMascota {

    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascota(Context context){
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerMascotas(){

        BaseDatosMascota bd = new BaseDatosMascota(context);
        insertarcincoMascotas(bd);
        return bd.obtenertodaslasmascotas();


    }

    public void insertarcincoMascotas(BaseDatosMascota db){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.american_pit_bull_terrier );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBREMASCOTA,"American PitBull Terrier" );



        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.barbet );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBREMASCOTA,"Barter" );



        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.boxer );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBREMASCOTA,"Boxer" );



        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.terrier_tibetano );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBREMASCOTA,"Terrier Tibetano" );



        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mastin_espa_ol );
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBREMASCOTA,"Mastin Español");



        db.insertarMascotas(contentValues);



    }


    public void darlikemascota(Mascotas mascotas){

        BaseDatosMascota db = new BaseDatosMascota(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLET_LIKE_MASCOTAS_ID_MASCOTAS, mascotas.getId());
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_DETALLE_LIKE, LIKE);
        db.insertarLikeMascota(contentValues);


    }



    public  int obtenerLikeMascotas(Mascotas mascota){

        BaseDatosMascota db = new BaseDatosMascota(context);

     return db.obtenerlikeMascota(mascota);
    }








}
