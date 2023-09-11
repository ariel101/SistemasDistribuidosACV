/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package laboratorio1cayo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author LENOVO
 */
public interface IservidorBanco extends Remote {

    public Factura[] calcular(int idcliente) throws RemoteException;

    public String pagar(Factura[] facturas) throws RemoteException;

}


