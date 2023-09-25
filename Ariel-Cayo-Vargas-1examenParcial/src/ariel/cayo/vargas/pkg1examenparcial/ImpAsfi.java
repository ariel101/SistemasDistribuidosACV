/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ariel.cayo.vargas.pkg1examenparcial;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ImpAsfi extends UnicastRemoteObject implements IAsfi {

    public ImpAsfi() throws RemoteException {
        super();
    }

    @Override
    public Cuenta[] ConsultarCuenta(String ci, String nombres, String apellidos) throws RemoteException {
        
        try {
        IBancos BCP,Mercantil;
        Cuenta cuenta;
        
        Cuenta[] cuentaBCP=BCP.Buscar("123432", "jowe", "ewfe");
        
        Factura[] facturasCotes=cotes.pendientes(idcliente);
        Factura[] auxiliar=new Factura[facturasCessa.length+facturasCotes.length];    
        int i=0;
        for (Factura factura:facturasCessa)
        {
            auxiliar[i]=factura;
            i++;
        }
        for (Factura factura:facturasCotes)
        {
            auxiliar[i]=factura;
            i++;
        }
        return auxiliar;        
    } catch (NotBoundException ex) {
        Logger.getLogger(BancoImp.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(BancoImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return null; 
    }

    @Override
    public Cuenta[] ListarCuenta(String ci, String nombres, String apellidos) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bool RetenerMonto(String cuenta, double monto, String glosa) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
