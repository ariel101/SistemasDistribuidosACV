/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ariel.cayo.vargas.pkg1examenparcial;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public interface IAsfi extends Remote {
    
    public Cuenta[] ConsultarCuenta(String ci, String nombres, String apellidos) throws RemoteException ;
    public Cuenta[] ListarCuenta(String ci, String nombres, String apellidos) throws RemoteException ;
    public Bool RetenerMonto(String cuenta, double monto, String glosa) throws RemoteException;
    
    
}
