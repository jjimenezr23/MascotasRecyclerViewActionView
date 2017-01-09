package jjimenez.app.com.mascotasrecyclerviewactionview.fragment;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.adaptador.MascotaAdaptador;
import jjimenez.app.com.mascotasrecyclerviewactionview.adaptador.MascotaDetalleAdaptador;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;

/**
 * Created by henry on 30/11/2016.
 */

public interface IPerfilFragment {


    public void generarGridLayout();



    public MascotaDetalleAdaptador mascotaadaptador(ArrayList<Mascotas> mascota);

    public void inicializaradaptador(MascotaDetalleAdaptador adaptador);



}
