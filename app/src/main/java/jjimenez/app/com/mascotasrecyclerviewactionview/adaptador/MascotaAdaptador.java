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

import java.util.ArrayList;

import jjimenez.app.com.mascotasrecyclerviewactionview.database.ConstructorMascota;
import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.Mascotas;
import jjimenez.app.com.mascotasrecyclerviewactionview.R;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;


    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotacv, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imagendogCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvnombreVC.setText(mascota.getNombreMascota());
        mascotaViewHolder.likes.setText(toString().valueOf(mascota.getDetallelike()+ " like"));




        mascotaViewHolder.imglikecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "diste like a " + mascota.getNombreMascota(), Toast.LENGTH_SHORT).show();

                ConstructorMascota constructorMascota = new ConstructorMascota(activity);
                constructorMascota.darlikemascota(mascota);
                mascotaViewHolder.likes.setText(toString().valueOf(constructorMascota.obtenerLikeMascotas(mascota)+ " like"));


            }
        });



    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private TextView tvnombreVC;
        private ImageView imagendogCV;
        private ImageButton imglikecv;
        private ImageView huesolikes;
        private TextView likes;




        public MascotaViewHolder(View itemView) {
            super(itemView);
            imagendogCV = (ImageView) itemView.findViewById(R.id.imagenperroCV);
            tvnombreVC = (TextView)itemView.findViewById(R.id.nombreCV);
            imglikecv = (ImageButton) itemView.findViewById(R.id.imagenlikeCV);
            likes = (TextView) itemView.findViewById(R.id.tvReitingcv);
            huesolikes = (ImageView) itemView.findViewById(R.id.imgreitingCV);



        }
    }




}
