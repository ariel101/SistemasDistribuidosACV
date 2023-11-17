using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ServiceWeb
{
    [Serializable]
    public class Respuesta
    {
        public String estado;
        public String mensaje;
        public Respuesta(string estado, string mensaje)
        {

        }
    }
}