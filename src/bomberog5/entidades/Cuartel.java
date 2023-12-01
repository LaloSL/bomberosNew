/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.entidades;

/**
 *
 * @author Asus
 */
public class Cuartel {
     private int idCuartel;
    private String nombreCuartel;
    private String direccion;
    private double longitud;
    private double latitud;
    private String telefono;
    private String correo;
    private boolean estadoC;

    public Cuartel() {
    }

    public Cuartel(int idCuartel, String nombreCuartel, String direccion, double longitud, double latitud, String telefono, String correo, boolean estadoC) {
        this.idCuartel = idCuartel;
        this.nombreCuartel = nombreCuartel;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.telefono = telefono;
        this.correo = correo;
        this.estadoC = estadoC;
    }

    public Cuartel(String nombreCuartel, String direccion, double longitud, double latitud, String telefono, String correo, boolean estadoC) {
        this.nombreCuartel = nombreCuartel;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.telefono = telefono;
        this.correo = correo;
        this.estadoC = estadoC;
    }

    public int getIdCuartel() {
        return idCuartel;
    }

    public void setIdCuartel(int idCuartel) {
        this.idCuartel = idCuartel;
    }

    public String getNombreCuartel() {
        return nombreCuartel;
    }

    public void setNombreCuartel(String nombreCuartel) {
        this.nombreCuartel = nombreCuartel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstadoC() {
        return estadoC;
    }

    public void setEstadoC(boolean estadoC) {
        this.estadoC = estadoC;
    }

    @Override
    public String toString() {
        return "Cuartel{" + "idCuartel=" + idCuartel + ", nombreCuartel=" + nombreCuartel + ", direccion=" + direccion + ", longitud=" + longitud + ", latitud=" + latitud + ", telefono=" + telefono + ", correo=" + correo + ", estadoC=" + estadoC + '}';
    }

 

    
    
}
