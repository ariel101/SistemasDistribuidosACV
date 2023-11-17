using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Description;

namespace ServiceBNB
{
    /// <summary>
    /// Descripción breve de ServiceBNB
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class ServiceBNB : System.Web.Services.WebService
    {
        
        [WebMethod]
        public string ConsultarSaldo(string Ncuenta)
        {
            string cuenta = "12345";

            if (Ncuenta == cuenta)
            {
                Random random = new Random();
                double saldo = random.Next(1000, 10000);
                string sal = saldo.ToString();
                return sal;
            }
            else
            {

                //return Tuple.Create(0.0, "Número de cuenta no válido");
                //Console.WriteLine("numero de cuenta no valida");
                string mensaje = "numero de cuenta invalidp";
                return mensaje;
            }
            

            
        }
    }
}
