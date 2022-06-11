package es.studium.mvc;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.Random;

public class Tablero extends Frame 
{
	private static final long serialVersionUID = 1L;
	//dialog para acabar
	Dialog dlgFeedback = new Dialog (this, "Feedback", true);
	Label lblMensaje = new Label ("GAME OVER");
	//Creamos los objetos
	Panel panel= new Panel();
	//3 Tamaño del area
	TextField area= new TextField(3);
	TextField area2= new TextField(3);
	Image imagen;
	Image imagen2;
	Label img = new Label(" ");
	Label img2 = new Label("                                                                                                                                                       ");
	Label img3 = new Label(" ");
	Toolkit herramienta;
	String nombreJugador;
	// Las coordenadas de la serpiente
	int posXser, posYser;
	//El tamaño
	int dimension;
	// Las coordenadas del lugar donde pulse
	int pulX, pulY;
	// Las vidas
	int vidas = 1;
	//Los puntos
	int puntos;
	//coordenadas de manzana
	int posXman, posYman;
	int direccion; 
	//0 a izq
	//1 derecha
	//2 arriba
	//3 Abajo

	//random para la manzana
	Random rnd = new Random();

	//Controlador
	public Tablero()
	{    
		//Damos estilo a la ventana
		setLayout(new FlowLayout());
		setSize(700, 600); // Ancho x alto
		setResizable(false);// no permitir redimensionar
		setBackground(Color.black);
		setLocationRelativeTo(null);//fijar que la ventana salga

		//posición inicial serpiente
		posXser = 350;
		posYser = 360;
		//tamaño inicial serpiente
		dimension = 20;
		//Obtenemos la posición aleatoria de las manzanas
		obtenerPosicionManzana();
		//Agregamos imagen al panel
		panel.add(img);

		//Agregamos el area al panel
		panel.add(area);
		//Para mostrar los puntos en el txtArea
		area.setText(" " + puntos);
		//mostramos el panel
		panel.add(img2);
		panel.add(area2);
		//Para mostrar las vidas en el txtArea
		area2.setText(" " + vidas);
		//Agregamos imagen al panel
		panel.add(img3);


		//Añadimos las herramientas
		herramienta = getToolkit();
		// Especificar la ruta de la imagen
		imagen = herramienta.getImage("img\\Captura3.PNG");
		imagen2 = herramienta.getImage("img\\Captura.PNG");

		area.setEnabled(false);//Para que no se pueda escribir
		area2.setEnabled(false);
		panel.setBackground(Color.CYAN);

		//Agregamos panel.
		add(panel);

	}
	public void obtenerPosicionManzana()
	{
		//indicamos posicion manzanas
		posXman = rnd.nextInt(530)+70;
		posYman = rnd.nextInt(430)+70;
	}
	public void mostrarTablero()
	{//mostrar la ventana
		setVisible(true);		
	}

	public void ocultarTablero()
	{
		//ocultarla
		setVisible(false);		
	}

	public void paint(Graphics g)
	{
		// Dibujar la imagen
		g.drawImage(imagen ,660,36,this);
		g.drawImage(imagen2,6,36,this);

		//Damos color primero a serpiente
		g.setColor(new Color(19,119,61));
		//creamos el rectángulo para serpiente
		g.fillRect(posXser, posYser, dimension, 20);

		//creamos el circulo de manzana y le damos tamaño
		g.setColor(Color.red);
		g.fillOval(posXman, posYman, 20, 20);
		if(vidas!=0)
		{
			//Damos movilidad a la serpiente automáticamente
			switch(direccion)
			{
			case 0:
				posXser--;
				break;
			case 1:
				posXser++;
				break;
			case 2:
				posYser--;
				break;
			case 3:
				posYser++;
				break;
			}
			try
			{
				//Velocidad serpiente
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	public void cambiarDireccion(int i)
	{
		//cambiamos direccion de la serpiente al pulsar
		direccion = i;
		repaint();

	}
	public void mostrarDialogo()
	{
		// ventana del mensaje de fin de juego
		dlgFeedback.setTitle("GAME OVER");
		dlgFeedback.setLayout(new FlowLayout());
		dlgFeedback.setSize(200,150);
		dlgFeedback.add(lblMensaje);
		dlgFeedback.setLocationRelativeTo(null);
		dlgFeedback.setVisible(true);

	}
	public void setNombre(String nombreJugador) {
		this.nombreJugador = nombreJugador;
}
	public String getNombre() {
		return nombreJugador;
	}
}