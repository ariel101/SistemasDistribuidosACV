/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio3;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class Diploma implements Serializable {
    
    private String ci;
    private String nombrecompleto;
    private String carrera;
    private String fecha;
    private String mensaje;

    public Diploma(String ci, String nombrecompleto, String carrera, String fecha, String mensaje) {
        this.ci = ci;
        this.nombrecompleto = nombrecompleto;
        this.carrera = carrera;
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Diploma{" + "ci=" + ci + ", nombrecompleto=" + nombrecompleto + ", carrera=" + carrera + ", fecha=" + fecha + ", mensaje=" + mensaje + '}';
    }
    
    
    
}
