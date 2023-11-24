/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package laboratorio3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author LENOVO
 */
public interface IUniversidad extends Remote {
    
    public Diploma emitirDiploma(String ci, String nombres, String primer_apellido, String segundo_oapellido, String fecha_nacimiento, String carrera) throws RemoteException;
    
}
