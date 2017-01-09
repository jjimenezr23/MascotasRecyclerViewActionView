package jjimenez.app.com.mascotasrecyclerviewactionview.constantes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.R;
import jjimenez.app.com.mascotasrecyclerviewactionview.adaptador.MascotaAdaptador;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;

/**
 * Created by henry on 04/10/2016.
 */

public class Confi {

    public static final String EMAIL ="pruevascoursera@gmail.com";
    public static final String PASSWORD ="bleach2017";

    public static class DetalleMascota extends AppCompatActivity {

        private RecyclerView miRecycleviewmascotas;
        ArrayList<Mascotas> mascotas;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detalle_mascota);

            Toolbar mitoolbar = (Toolbar)findViewById(R.id.detalletoobar);
            setSupportActionBar(mitoolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            miRecycleviewmascotas = (RecyclerView)findViewById(R.id.miDetalleRVMascota);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            miRecycleviewmascotas.setLayoutManager(llm);
            inicializarDatos();
            inicializaradaptador();
        }

        public void inicializaradaptador(){

            MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
            miRecycleviewmascotas.setAdapter(adaptador);


        }

        public void inicializarDatos(){
            mascotas = new ArrayList<Mascotas>();

            mascotas.add(new Mascotas(R.drawable.american_pit_bull_terrier,"American PitBull Terrier", 3));
            mascotas.add(new Mascotas(R.drawable.barbet,"Barte", 6));
            mascotas.add(new Mascotas(R.drawable.boxer,"Boxer", 2));
            mascotas.add(new Mascotas(R.drawable.terrier_tibetano,"Terrier Tibetano", 7));
            mascotas.add(new Mascotas(R.drawable.mastin_espa_ol,"Mastin Español", 0));




        }


    }
}
