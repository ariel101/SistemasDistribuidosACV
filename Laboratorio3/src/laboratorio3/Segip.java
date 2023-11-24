/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author LENOVO
 */
public class Segip extends UnicastRemoteObject implements ISegip {

    public Segip() throws RemoteException {
        super();
    }

    @Override
    public Respuesta verificar(String ci, String nombres, String apellido) {
        Respuesta respuesta=null;
        if(ci.equals("1140506") && nombres.equals("walter jhamil")){
            
            respuesta=new Respuesta(true,"Verificacion Correcta");
            
        }
        else{
            respuesta=new Respuesta(false,"Datos del CI no son correctos");
        }
        
        return respuesta;
    }
    
    
    
}
