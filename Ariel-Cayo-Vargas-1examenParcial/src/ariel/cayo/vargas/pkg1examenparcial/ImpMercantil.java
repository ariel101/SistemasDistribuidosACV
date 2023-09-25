/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariel.cayo.vargas.pkg1examenparcial;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author LENOVO
 */
public class ImpMercantil extends UnicastRemoteObject implements IBancos {

    public ImpMercantil() throws RemoteException {
        super();
    }

    @Override
    public String Buscar(String ci, String nombres, String apellidos) throws RemoteException {
        Cuenta cuenta = new Cuenta("233423","2323435","jose","perez",234);
        String resul="";
        String cuentaBanco = "34395435";
        
        
        if(cuentaBanco == cuenta.getNrocuenta()){
            
            System.err.println("cuenta existente ");
            
        }
        else{
            System.err.println("usted no tiene cuenta en mercantil");
        }
        
        return resul;
    }

    @Override
    public String Congelar(String cuenta, String monto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
