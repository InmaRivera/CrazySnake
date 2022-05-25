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
	Label lblNombre = new Label("Introduzca su nombre: ", 1);
	TextField txtNombre = new TextField(20);
	Button btnNueva = new Button("Aceptar");
	Image imagen;
	// Declarar el objeto Toolkit para manejo de imágenes
	Toolkit herramienta;
	
	public NuevaPartida()
	{
		//Configuración Pantalla
		setSize(200, 150); // Tamaño: Ancho x Alto
		//setResizable(false); // No permitir redimensión
		setLayout(new FlowLayout()); 
		herramienta = getToolkit();
		// Especificar la ruta de la imagen
		imagen = herramienta.getImage("img\\snake.jpg");
		
		setTitle("Nueva Partida");
		add(lblNombre);
		add(txtNombre);
		add(btnNueva);
			
		setLocationRelativeTo(null); // Centrar
		setVisible(true); // Mostrarla
		setVisible(true);// En pixeles Width, Height. Ir probando y cambiando anchura y altura
		setLocationRelativeTo(null); // Centrar
	}
	public void paint(Graphics g)
	{
		// Dibujar la imagen
		g.drawImage(imagen,4,23,this);
	}
}