/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.accesoDatos;

import bomberog5.entidades.Brigada;
import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class SiniestroData {
    private int idCodigo;
    private String tipo;
    private int coordX;
    private int coordY;
    private String detalles;
    private int puntuacion;
    private Brigada idBrigada;
    private LocalDateTime fechaSiniestro;
    private LocalDateTime fechaResol;
    private int idBriga;

    public SiniestroData() {
    }

    public SiniestroData(int idCodigo, String tipo, int coordX, int coordY, String detalles, int puntuacion, Brigada idBrigada, LocalDateTime fechaSiniestro, LocalDateTime fechaResol) {
        this.idCodigo = idCodigo;
        this.tipo = tipo;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.puntuacion = puntuacion;
        this.idBrigada = idBrigada;
        this.fechaSiniestro = fechaSiniestro;
        this.fechaResol = fechaResol;
    }

    public SiniestroData(String tipo, int coordX, int coordY, String detalles, int puntuacion, Brigada idBrigada, LocalDateTime fechaSiniestro, LocalDateTime fechaResol) {
        this.tipo = tipo;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.puntuacion = puntuacion;
        this.idBrigada = idBrigada;
        this.fechaSiniestro = fechaSiniestro;
        this.fechaResol = fechaResol;
    }
    
//--------------------------- Sin idCodigo ni objeto Birgada y con int int idBriga-----------------------------------
    
   public SiniestroData(String tipo, int coordX, int coordY, String detalles, int puntuacion, LocalDateTime fechaSiniestro, LocalDateTime fechaResol, int idBriga) {
        this.tipo = tipo;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.puntuacion = puntuacion;
        this.fechaSiniestro = fechaSiniestro;
        this.fechaResol = fechaResol;
        this.idBriga = idBriga;
    }  
    
//---------------------------FIN Sin idCodigo ni objeto Birgada y con int int idBriga-----------------------------------

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Brigada getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(Brigada idBrigada) {
        this.idBrigada = idBrigada;
    }

    public LocalDateTime getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(LocalDateTime fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public LocalDateTime getFechaResol() {
        return fechaResol;
    }

    public void setFechaResol(LocalDateTime fechaResol) {
        this.fechaResol = fechaResol;
    }

    public int getIdBriga() {
        return idBriga;
    }

    public void setIdBriga(int idBriga) {
        this.idBriga = idBriga;
    }

    @Override
    public String toString() {
        return "SiniestroData{" + "idCodigo=" + idCodigo + ", tipo=" + tipo + ", coordX=" + coordX + ", coordY=" + coordY + ", detalles=" + detalles + ", puntuacion=" + puntuacion + ", idBrigada=" + idBrigada + ", fechaSiniestro=" + fechaSiniestro + ", fechaResol=" + fechaResol + ", idBriga=" + idBriga + '}';
    }
   
   
   
}
