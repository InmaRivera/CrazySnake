package es.studium.mvc;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
public class NuevaPartida extends Frame
{
	private static final long serialVersionUID = 1L;
	//Creamos objeto para introducir nombre:
	Label lblNombre = new Label("Introduzca su nombre: ", 1);
	TextField txtNombre = new TextField(10);
	Button btnAceptar = new Button("Aceptar");
	Image imagen;
	// Declarar el objeto Toolkit para manejo de im�genes
	Toolkit herramienta;
	
	public NuevaPartida()
	{
		//Configuraci�n Pantalla
		setSize(200, 150); // Tama�o: Ancho x Alto
		//setResizable(false); // No permitir redimensi�n
		setLayout(new FlowLayout()); 
		herramienta = getToolkit();
		// Especificar la ruta de la imagen
		imagen = herramienta.getImage("img\\snake.jpg");

		setTitle("Nueva Partida");
		add(lblNombre);
		add(txtNombre);
		add(btnAceptar);
		setLocationRelativeTo(null); // Centrar
	}
	public void mostrarNuevaPartida()
	{
		//mostrar la ventana aqu� que aparezca cuando indiquemos(al pulsar bot�n de nueva partida)
		setVisible(true);		
	}
	
	public void ocultarNuevaPartida()
	{
		//ocultarla
		setVisible(false);		
	}
	public void paint(Graphics g)
	{
		// Dibujar la imagen
		g.drawImage(imagen,4,23,this);
	}

}