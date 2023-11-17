using ConversionMoneda;
using ServiceImpuestos;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsumoServicios
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {


        }

        private void button1_Click(object sender, EventArgs e)
        {
            WebServiceImpuestosSoapClient client = new WebServiceImpuestosSoapClient(new WebServiceImpuestosSoapClient.EndpointConfiguration());
            DateTime syncTime = client.SincronizarFechaHora();

            // Mostrar la hora sincronizada en un cuadro de texto o etiqueta
            textBox1.Text = syncTime.ToString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            WebServiceImpuestosSoapClient client = new WebServiceImpuestosSoapClient(new WebServiceImpuestosSoapClient.EndpointConfiguration());

            string idAmbiente = textBox2.Text;
            string modalidad = textBox3.Text;
            string nit = textBox4.Text;


            string cuf = client.ObtenerCufd(idAmbiente, modalidad, nit);

            // Mostrar el CUF en un cuadro de texto o etiqueta
            textBox5.Text = cuf;

        }
    }
}
