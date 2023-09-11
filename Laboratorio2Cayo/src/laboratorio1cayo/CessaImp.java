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
public class CessaImp extends UnicastRemoteObject implements IEmpresa {

    public CessaImp() throws RemoteException {
            super();
    }

    @Override
    public Factura[] pendientes(int idcliente) throws RemoteException {
        Factura[]aux=new Factura[2];
        Empresa empresa=new Empresa("CESSA",343123456L);
        switch (idcliente){
            case 1:
                aux[0]=new Factura(empresa, 154, Mes.Diciembre,2021, 150);
                aux[1]=new Factura(empresa, 326, Mes.Enero,2022, 701);
            break;
            case 2:
                aux[0]=new Factura(empresa, 325, Mes.Enero,2022, 610);
                aux[1]=new Factura(empresa, 457, Mes.Febrero,2022, 801);
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
                        .append(" de la empresa CESSA\n");
            } else {
                respuesta.append("Pago fallido para la factura ").append(idFactura)
                        .append(" de la empresa CESSA debido a saldo insuficiente\n");
            }
        }
    
    return respuesta.toString();
    }
    
    
    
}
    

