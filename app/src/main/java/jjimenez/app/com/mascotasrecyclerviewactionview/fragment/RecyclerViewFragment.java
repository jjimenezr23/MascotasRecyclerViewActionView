package jjimenez.app.com.mascotasrecyclerviewactionview.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.R;
import jjimenez.app.com.mascotasrecyclerviewactionview.adaptador.MascotaAdaptador;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;
import jjimenez.app.com.mascotasrecyclerviewactionview.presenter.IRecyclerViewFragmentPresenter;
import jjimenez.app.com.mascotasrecyclerviewactionview.presenter.RecyclerViewFragmentPresenter;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {



    private RecyclerView miRecycleviewmascotas;
    ArrayList<Mascotas> mascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        miRecycleviewmascotas = (RecyclerView)v.findViewById(R.id.miRVMascota);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;


    }



    @Override
    public void crearLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        miRecycleviewmascotas.setLayoutManager(llm);


    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotaAdaptador adaptadorRV = new MascotaAdaptador(mascotas,getActivity());
        return adaptadorRV;
    }

    @Override
    public void inicializaradaptadorRV(MascotaAdaptador adaptadorRV) {
        miRecycleviewmascotas.setAdapter(adaptadorRV);

    }





  /*  public void inicializarDatos(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.american_pit_bull_terrier,"American PitBull Terrier", 3,R.drawable.dog_bone_48,R.drawable.dog_bone_48_color));
        mascotas.add(new Mascotas(R.drawable.barbet,"Barte", 6,R.drawable.dog_bone_48,R.drawable.dog_bone_48_color));
        mascotas.add(new Mascotas(R.drawable.boxer,"Boxer", 2,R.drawable.dog_bone_48,R.drawable.dog_bone_48_color));
        mascotas.add(new Mascotas(R.drawable.terrier_tibetano,"Terrier Tibetano", 7,R.drawable.dog_bone_48,R.drawable.dog_bone_48_color));
        mascotas.add(new Mascotas(R.drawable.mastin_espa_ol,"Mastin Español", 0,R.drawable.dog_bone_48,R.drawable.dog_bone_48_color));
    }*/




}
