/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ariel.cayo.vargas.pkg1examenparcial;

import java.rmi.RemoteException;

/**
 *
 * @author LENOVO
 */
public interface IBancos {
    
    public String Buscar(String ci, String nombres, String apellidos) throws RemoteException;
    public String Congelar(String cuenta, String monto) throws RemoteException;
    
}
