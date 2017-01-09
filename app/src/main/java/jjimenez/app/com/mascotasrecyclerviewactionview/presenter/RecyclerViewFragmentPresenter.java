package jjimenez.app.com.mascotasrecyclerviewactionview.presenter;

import android.content.Context;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.database.ConstructorMascota;
import jjimenez.app.com.mascotasrecyclerviewactionview.fragment.IRecyclerViewFragment;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;

/**
 * Created by henry on 02/12/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private Context context;
    private IRecyclerViewFragment iRecyclerViewFragment;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascotas> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context){

        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();

    }



    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascota = new ConstructorMascota(context);
       mascotas = constructorMascota.obtenerMascotas();
        mostrarMascotas();

    }

    @Override
    public void mostrarMascotas() {

        iRecyclerViewFragment.inicializaradaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.crearLinearLayout();


    }
}
