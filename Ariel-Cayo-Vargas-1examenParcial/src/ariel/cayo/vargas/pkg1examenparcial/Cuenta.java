/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariel.cayo.vargas.pkg1examenparcial;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
class Cuenta implements Serializable {
    
    private String nrocuenta;
    private String ci;
    private String nombres;
    private String apellidos;
    private double saldo;

    public Cuenta(String nrocuenta, String ci, String nombres, String apellidos, double saldo) {
        this.nrocuenta = nrocuenta;
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.saldo = saldo;
    }

    public String getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(String nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "nrocuenta=" + nrocuenta + ", ci=" + ci + ", nombres=" + nombres + ", apellidos=" + apellidos + ", saldo=" + saldo + '}';
    }
    
    
    
}
