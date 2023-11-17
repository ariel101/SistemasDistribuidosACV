using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ServiceWeb
{
    public class Factura
    {
        public int IdAmbiente;
        public int Nit;
        public string CufD;
        public int Modalidad;
        public string NIT;
        public string RazonSocial;
        public DateTime Fecha;
        public string NumeroFactura;
        public string CUF;
        public string TipoDocumentoCliente;
        public string NombreCliente;
        public List<DetalleFactura> Detalles;
    }
}