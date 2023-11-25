/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package microsistemarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public interface IServidorReserva extends Remote {
    
    public double Cotizar(Date inicio, Date fin, Date fechaCotizacion) throws RemoteException;
    public String Reservar(Date inicio, Date fin, int idCliente, Date fechaCompra) throws RemoteException;
    
}
