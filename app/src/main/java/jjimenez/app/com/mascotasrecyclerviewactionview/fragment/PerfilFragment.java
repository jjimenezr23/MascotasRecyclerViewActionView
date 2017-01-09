package jjimenez.app.com.mascotasrecyclerviewactionview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import jjimenez.app.com.mascotasrecyclerviewactionview.R;
import jjimenez.app.com.mascotasrecyclerviewactionview.adaptador.MascotaAdaptador;
import jjimenez.app.com.mascotasrecyclerviewactionview.adaptador.MascotaDetalleAdaptador;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;
import jjimenez.app.com.mascotasrecyclerviewactionview.presenter.IPerfilFragmentPresenter;
import jjimenez.app.com.mascotasrecyclerviewactionview.presenter.PerfilFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragment {

    private CircularImageView circularImageView;
    private IPerfilFragmentPresenter presenter;
    private RecyclerView miRecycleviewDetallemascotas;
    private ArrayList<Mascotas> mascota;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        // Inflate the layout for this fragment
        miRecycleviewDetallemascotas = (RecyclerView)v.findViewById(R.id.miRVMascotaPerfil);
        presenter = new PerfilFragmentPresenter(getContext(), this);
        return v;


    }







   /* public void inicializarDatos(){

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.mastin_espa_ol, 3,R.drawable.dog_bone_48_color));
        mascotas.add(new Mascotas(R.drawable.mastin_espa_ol, 0,R.drawable.dog_bone_48_color));
        mascotas.add(new Mascotas(R.drawable.mastin_espa_ol, 1,R.drawable.dog_bone_48_color));
        mascotas.add(new Mascotas(R.drawable.mastin_espa_ol, 5,R.drawable.dog_bone_48_color));
        mascotas.add(new Mascotas(R.drawable.mastin_espa_ol, 2,R.drawable.dog_bone_48_color));
    }*/


    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        miRecycleviewDetallemascotas.setLayoutManager(glm);

    }

    @Override
    public MascotaDetalleAdaptador mascotaadaptador(ArrayList<Mascotas> mascota) {
        MascotaDetalleAdaptador adaptadorD = new MascotaDetalleAdaptador(mascota,getActivity());
        return adaptadorD;
    }

    @Override
    public void inicializaradaptador(MascotaDetalleAdaptador adaptador) {
        miRecycleviewDetallemascotas.setAdapter(adaptador);

    }
}


