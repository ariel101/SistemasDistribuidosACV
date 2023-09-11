/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio1cayo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author LENOVO
 */
public class CotesImp extends UnicastRemoteObject implements IEmpresa {

    public CotesImp() throws RemoteException {
        super();
    }

    @Override
    public Factura[] pendientes(int idcliente) throws RemoteException {
        Factura[]aux=null;
        Empresa empresa=new Empresa("COTES",123123126L);
        switch (idcliente){
            case 1:
                aux=new Factura[3];
                aux[0]=new Factura(empresa, 154, Mes.Diciembre,2021, 170);
                aux[1]=new Factura(empresa, 321, Mes.Enero,2022, 100);
                aux[2]=new Factura(empresa, 22454, Mes.Febrero,2022, 150);
            break;
            case 2:
                aux=new Factura[2];
                aux[0]=new Factura(empresa, 225, Mes.Enero,2022, 150);
                aux[1]=new Factura(empresa, 1125, Mes.Febrero,2022, 200);
            break;
        }
        return aux;
    }

    @Override
    public String pagar(Factura[] facturas) throws RemoteException {
         StringBuilder respuesta = new StringBuilder();
    
    
    double saldoCessa = 1000.00;
    
    for (Factura factura : facturas) {
        int idFactura = factura.getIdFactura();
        double monto = factura.getMonto();

        // Verifica si hay saldo suficiente para el pago
        if (saldoCessa >= monto) {
            saldoCessa -= monto;
            respuesta.append("Pago exitoso para la factura ").append(idFactura)
                    .append(" de la empresa COTES\n");
        } else {
            respuesta.append("Pago fallido para la factura ").append(idFactura)
                    .append(" de la empresa COTES debido a saldo insuficiente\n");
        }
    }
    
    return respuesta.toString();
    }

    
    
    
    
}
