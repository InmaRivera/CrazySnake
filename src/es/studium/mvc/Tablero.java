package es.studium.mvc;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
	//Creamos los objetos
	TextField area= new TextField(3);
	TextField area2= new TextField(3);
	Image imagen;
	Image imagen2;
	Label img = new Label(" ");
	Label img2 = new Label("                                                                                                                                                       ");
	Label img3 = new Label(" ");
	Toolkit herramienta;
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
	//Estilos Fuentes
	Font font = new Font("Colonna MT", Font.TRUETYPE_FONT, 20);
	//coordenadas de manzana
	int posXman, posYman;
	//coordenadas de las letras
	int posX, posY;
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
	
		Panel panel= new Panel();
		panel.setLayout(new FlowLayout());
		
		//posición inicial serpiente
		posXser = 350;
		posYser = 360;
		//tamaño inicial serpiente
		dimension = 10;
		//Obtenemos la posición aleatoria de las manzanas
		obtenerPosicionManzana();
		panel.add(img);
		panel.add(area);
		//mostramos el panel
		panel.add(img2);
		panel.add(area2);
		panel.add(img3);
		

		//Añadimos las herramientas
		herramienta = getToolkit();
		// Especificar la ruta de la imagen
		imagen = herramienta.getImage("img\\Captura3.PNG");
		imagen2 = herramienta.getImage("img\\Captura.PNG");
		
		area.setEnabled(false);//Para que no se pueda escribir
		area2.setEnabled(false);
		panel.setBackground(Color.CYAN);
		panel.setSize(40, 560);
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
		//posicionar letras de puntos y vidas
		g.drawRect(posX, posY, 20, 20);
		g.setFont(font);
		//Damos color a las letras y posicion
		g.setColor(Color.green);
		g.drawString("Puntos: " + puntos, 10, 38);
		g.drawString ("Vidas: " + vidas, 550, 38);
		
		// Dibujar la imagen
		g.drawImage(imagen ,660,36,this);
		g.drawImage(imagen2,6,36,this);
		
		//Damos color primero a serpiente
		g.setColor(new Color(19,119,61));
		//creamos el rectángulo para serpiente
		g.fillRect(posXser, posYser, dimension, 10);
		
		//creamos el circulo de manzana y le damos tamaño
		g.setColor(Color.red);
		g.fillOval(posXman, posYman, 10, 10);

	}
}