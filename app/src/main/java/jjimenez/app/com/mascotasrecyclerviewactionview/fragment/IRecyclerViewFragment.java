package jjimenez.app.com.mascotasrecyclerviewactionview.fragment;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.adaptador.MascotaAdaptador;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;

/**
 * Created by henry on 01/12/2016.
 */

public interface  IRecyclerViewFragment {


    public void crearLinearLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializaradaptadorRV(MascotaAdaptador adaptador);
}
