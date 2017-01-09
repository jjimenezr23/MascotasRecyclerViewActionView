package jjimenez.app.com.mascotasrecyclerviewactionview.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.R;
import jjimenez.app.com.mascotasrecyclerviewactionview.database.ConstructorMascota;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;

/**
 * Created by henry on 21/10/2016.
 */

public class MascotaDetalleAdaptador extends RecyclerView.Adapter<MascotaDetalleAdaptador.MascotaDetalleViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;
    


    public MascotaDetalleAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;


    }

    @Override
    public MascotaDetalleAdaptador.MascotaDetalleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotadetallecv, parent, false);
        return new MascotaDetalleAdaptador.MascotaDetalleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaDetalleAdaptador.MascotaDetalleViewHolder mascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imagenperroCDV.setImageResource(mascota.getFoto());



        ConstructorMascota constructorMascota = new ConstructorMascota(activity);









    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaDetalleViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagenperroCDV;
        private ImageView imagenreitingCDV;
        private TextView tvReitingDcv;
        private CircularImageView circularImageView;


        public MascotaDetalleViewHolder(View itemView) {
            super(itemView);
            imagenperroCDV = (ImageView) itemView.findViewById(R.id.imagenperroDCV);
            tvReitingDcv = (TextView) itemView.findViewById(R.id.tvReitingcv);
            imagenreitingCDV = (ImageView) itemView.findViewById(R.id.imgreitingDCV);
            circularImageView = (CircularImageView)itemView.findViewById(R.id.imagenCircular);




        }

    }
}

