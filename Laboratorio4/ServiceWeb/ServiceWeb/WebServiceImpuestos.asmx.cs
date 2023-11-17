using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ServiceWeb
{
    /// <summary>
    /// Descripción breve de WebServiceImpuestos
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WebServiceImpuestos : System.Web.Services.WebService
    {

        [WebMethod]
        public DateTime SincronizarFechaHora()
        {
            return DateTime.Now;
        }


        [WebMethod]
        public string ObtenerCufd(string idAmbiente, string modalidad, string nit)
        {
            return "AB0000134534521";
        }

        /*[WebMethod]
        public Respuesta EmitirFactura(int idAmbiente, int nit, string cufd, int modalidad, Factura factura)
        {
            Respuesta aux = new Respuesta("valido", "recibido");
            return aux;
        }*/

    }
}
