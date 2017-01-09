package jjimenez.app.com.mascotasrecyclerviewactionview.presenter;

import android.content.Context;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.database.ConstructorMascota;
import jjimenez.app.com.mascotasrecyclerviewactionview.fragment.IPerfilFragment;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;

/**
 * Created by henry on 25/12/2016.
 */

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {

   private  Context context;
   private  IPerfilFragment iPerfilFragment;
   private  ConstructorMascota constructorMascota;
   private ArrayList<Mascotas> mascota;

    public PerfilFragmentPresenter(Context context, IPerfilFragment iPerfilFragment){

        this.context = context;
        this.iPerfilFragment = iPerfilFragment;
        obtenerMascotasBaseDatos();


    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascota = new ConstructorMascota(context);
        mascota = constructorMascota.obtenerMascotas();
        mostrarMascotasFavoritas();

    }

    @Override
    public void mostrarMascotasFavoritas() {
        iPerfilFragment.inicializaradaptador(iPerfilFragment.mascotaadaptador(mascota));
        iPerfilFragment.generarGridLayout();
    }
}
