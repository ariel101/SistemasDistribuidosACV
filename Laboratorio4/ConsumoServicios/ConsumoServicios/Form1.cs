using ConversionMoneda;

namespace ConsumoServicios
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            
            if (decimal.TryParse(textBox1.Text, out decimal valor))
            {
               
                WebServiceBancoSoapClient client = new WebServiceBancoSoapClient(new WebServiceBancoSoapClient.EndpointConfiguration());

                
                string moneda = "US"; 
                decimal cotizacion = client.Obtnercotizacion(moneda);

                
                decimal resultadoConversion = valor * cotizacion;

                // Mostrar el resultado de la conversión en el TextBox "txtResultadoConversion"
                textBox2.Text = resultadoConversion.ToString("0.00");
            }
            else
            {
                MessageBox.Show("Ingresa un valor válido.");
            }
        }
    }
}