using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ServiceWeb
{
    public class DetalleFactura
    {
        public int Cantidad { get; set; }
        public string Producto { get; set; }
        public decimal PrecioUnitario { get; set; }
        public decimal PrecioTotal { get; set; }
    }
}