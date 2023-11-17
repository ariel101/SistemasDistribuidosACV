using ServiceBNB;

namespace ConsumoBNB
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServiceBNBSoapClient Client = new ServiceBNBSoapClient(new ServiceBNBSoapClient.EndpointConfiguration());
            try
            {
                
                string Ncuenta = textBox1.Text;

                  
                string saldo = (Client.ConsultarSaldo(Ncuenta)).ToString();
                //string sal = saldo.ToString();

                    // Muestra el saldo en un MessageBox o en otro control de tu formulario
                MessageBox.Show($"El saldo para la cuenta {Ncuenta} es: {saldo:C}");
 
                // Actualiza un control en el formulario, por ejemplo, un Label
                textBox2.Text = $"Saldo actual: {saldo:C}";

                
                
            
                

            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al consultar el saldo: {ex.Message}");
            }
        }
    }
}