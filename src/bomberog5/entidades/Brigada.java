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
public class Brigada {
    private int idBrigada;
    private String nombreBrig;
    private String especialidad;
    private boolean libre;
    private Cuartel cuartel;
    private boolean estadoBr;
    private int idCuartel;

    public Brigada() {
    }
    
    public Brigada(int idBrigada, String nombreBrig, String especialidad, boolean libre, Cuartel cuartel, boolean estadoBr) {
        this.idBrigada = idBrigada;
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.cuartel = cuartel;
        this.estadoBr = estadoBr;
    }

    public Brigada(String nombreBrig, String especialidad, boolean libre, Cuartel cuartel, boolean estadoBr) {
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.cuartel = cuartel;
        this.estadoBr = estadoBr;
    }

    //------------------------------------------Sin idBrigada ni Objeto Cuartel y con int idCuartel---------------------------
    public Brigada(String nombreBrig, String especialidad, boolean libre, boolean estadoBr, int idCuartel) {
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.estadoBr = estadoBr;
        this.idCuartel = idCuartel;
    }
    //------------------------------------------FIN Sin idBrigada ni Objeto Cuartel y con int idCuartel---------------------------

    public Brigada(int idBrigada, String tipo, String especialidadBrigada, int idCuartel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    public String getNombreBrig() {
        return nombreBrig;
    }

    public void setNombreBrig(String nombreBrig) {
        this.nombreBrig = nombreBrig;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public Cuartel getCuartel() {
        return cuartel;
    }

    public void setCuartel(Cuartel cuartel) {
        this.cuartel = cuartel;
    }

    public boolean isEstadoBr() {
        return estadoBr;
    }

    public void setEstadoBr(boolean estadoBr) {
        this.estadoBr = estadoBr;
    }

    public int getIdCuartel() {
        return idCuartel;
    }

    public void setIdCuartel(int idCuartel) {
        this.idCuartel = idCuartel;
    }

    @Override
    public String toString() {
        return "Brigada{" + "idBrigada=" + idBrigada + ", nombreBrig=" + nombreBrig + ", especialidad=" + especialidad + ", libre=" + libre + ", cuartel=" + cuartel + ", estadoBr=" + estadoBr + ", idCuartel=" + idCuartel + '}';
    }

    
}
