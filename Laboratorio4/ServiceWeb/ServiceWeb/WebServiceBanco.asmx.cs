using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ServiceWeb
{
    /// <summary>
    /// Descripción breve de WebServiceBanco
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WebServiceBanco : System.Web.Services.WebService
    {

        [WebMethod]
        public decimal Obtnercotizacion(string moneda)
        {
            if (moneda == "US")
            {
                return 6.96m; 
            }
            else if (moneda == "EU")
            {
                return 8.5m; 
            }
            else
            {
                return 0;
            }
        }
    }
}
