/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio1cayo;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class Factura implements Serializable {
    
    Empresa empresa;
    int idFactura;
    int anio;
    Mes mes;
    double monto;

    public Factura(Empresa empresa, int idFactura, Mes mes, int anio, int monto) {
        this.empresa = empresa;
        this.idFactura = idFactura;
        this.anio = anio;
        this.mes = mes;
        this.monto = monto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Factura{" + "empresa=" + empresa + ", idFactura=" + idFactura + ", anio=" + anio + ", mes=" + mes + ", monto=" + monto + '}';
    }
    
    

    
    
}
