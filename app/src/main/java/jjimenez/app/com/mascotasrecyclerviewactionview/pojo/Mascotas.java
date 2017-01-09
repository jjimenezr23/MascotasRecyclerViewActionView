package jjimenez.app.com.mascotasrecyclerviewactionview.pojo;

import jjimenez.app.com.mascotasrecyclerviewactionview.R;

/**
 * Created by henry on 14/09/2016.
 */
public class Mascotas  {

    private int id;
    private int foto;
    private String nombreMascota;
    private int detallelike;



    public Mascotas(int foto, int detallelike) {
        this.foto = foto;
        this.detallelike = detallelike;

    }



    public Mascotas(int foto, String nombreMascota, int detallelike) {
        this.foto = foto;
        this.nombreMascota = nombreMascota;
        this.detallelike = detallelike;

    }

    public Mascotas(int foto) {
        this.foto = foto;

    }

    public Mascotas() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getDetallelike() {
        return detallelike;
    }

    public void setDetallelike(int detallelike) {
        this.detallelike = detallelike;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
