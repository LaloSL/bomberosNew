/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberog5.entidades;

import java.sql.Time;

import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalTime;

/**
 *
 * @author Asus
 */
public class Siniestro {
    private int idCodigo;
    private String tipo;
    private Date fechaSiniestro;
    private LocalTime horaSinestro;
    private int coordX;
    private int coordY;
    private String detalles;
    private Date fechaResol;
    private LocalTime horaResol;
    private int puntuacion;
    private Brigada idBrigada;
    private boolean estadoS;

    public Siniestro() {
    }

    public Siniestro(int idCodigo, String tipo, Date fechaSiniestro, LocalTime horaSinestro, int coordX, int coordY, String detalles, Date fechaResol, LocalTime horaResol, int puntuacion, Brigada idBrigada, boolean estadoS) {
        this.idCodigo = idCodigo;
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.horaSinestro = horaSinestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResol = fechaResol;
        this.horaResol = horaResol;
        this.puntuacion = puntuacion;
        this.idBrigada = idBrigada;
        this.estadoS = estadoS;
    }

    public Siniestro(String tipo, Date fechaSiniestro, LocalTime horaSinestro, int coordX, int coordY, String detalles, Date fechaResol, LocalTime horaResol, int puntuacion, Brigada idBrigada, boolean estadoS) {
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.horaSinestro = horaSinestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResol = fechaResol;
        this.horaResol = horaResol;
        this.puntuacion = puntuacion;
        this.idBrigada = idBrigada;
        this.estadoS = estadoS;
    }

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

    public Date getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(Date fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public LocalTime getHoraSinestro() {
        return horaSinestro;
    }

    public void setHoraSinestro(LocalTime horaSinestro) {
        this.horaSinestro = horaSinestro;
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

    public Date getFechaResol() {
        return fechaResol;
    }

    public void setFechaResol(Date fechaResol) {
        this.fechaResol = fechaResol;
    }

    public LocalTime getHoraResol() {
        return horaResol;
    }

    public void setHoraResol(LocalTime horaResol) {
        this.horaResol = horaResol;
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

    public boolean isEstadoS() {
        return estadoS;
    }

    public void setEstadoS(boolean estadoS) {
        this.estadoS = estadoS;
    }

    @Override
    public String toString() {
        return "Siniestro{" + "idCodigo=" + idCodigo + ", tipo=" + tipo + ", fechaSiniestro=" + fechaSiniestro + ", horaSinestro=" + horaSinestro + ", coordX=" + coordX + ", coordY=" + coordY + ", detalles=" + detalles + ", fechaResol=" + fechaResol + ", horaResol=" + horaResol + ", puntuacion=" + puntuacion + ", idBrigada=" + idBrigada + ", estadoS=" + estadoS + '}';
    }
    
    
    
}