/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package microsistemarmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Hotel {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            // TODO code application logic here
            IServidorReserva reserva;

            reserva = (IServidorReserva) Naming.lookup("rmi://localhost/reserva"); // instanciar un objeto remoto
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            //Date fechaInicio = dateFormat.parse("12-12-2020");
            //Date fechaFin = dateFormat.parse("12-12-2021");
            //Date fechaCotizacion = dateFormat.parse("11-12-2020");
            Scanner scanner = new Scanner(System.in);
            System.out.println("presiona '1' para cotizar o presione '2' para reservar");
            int valor = scanner.nextInt();
            if (valor == 1) {

                System.out.println("Ingresa la fecha de inicio (dd/mm/yy): ");
                String fechaInicio = scanner.next();
                Date fechaI = dateFormat.parse(fechaInicio);

                System.out.println("Ingresa la fecha de fin (dd/mm/yy): ");
                String fechaFin = scanner.next();
                Date fechaF = dateFormat.parse(fechaFin);

                //Date fechaCotizacion = new Date();
                String fechaCotiza = "02-12-23";
                Date fechaCotizacion = dateFormat.parse(fechaCotiza);
                reserva.Cotizar(fechaI, fechaF, fechaCotizacion);

            } else {
                if (valor == 2) {

                    System.out.println("Ingresa la fecha de inicio (dd/mm/yy): ");
                    String fechaInicio = scanner.next();
                    Date fechaIni = dateFormat.parse(fechaInicio);

                    System.out.println("Ingresa la fecha de fin (dd/mm/yy): ");
                    String fechaFin = scanner.next();
                    Date fechaFinal = dateFormat.parse(fechaFin);

                    System.out.println("Ingresa el ID del cliente: ");
                    int idCliente = scanner.nextInt();
                    Date fechaCot = new Date();
                    
                    reserva.Reservar(fechaIni, fechaFinal, idCliente, fechaCot);

                }
            }

            scanner.close();
            //System.out.println(reserva.Cotizar(fechaInicio, fechaFin, fechaCotizacion));
        } catch (NotBoundException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
