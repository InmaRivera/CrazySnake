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
public class Tablero extends Frame {
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
	// Las coordenadas del cuadrado
	int posX, posY;
	//El tama�o
	int dimension;
	// Las coordenadas del lugar donde pulse
	int pulX, pulY;
	// Las vidas
	int vidas;
	//Los puntos
	int puntos;
	//Estilos Fuentes
	Font font = new Font("Colonna MT", Font.TRUETYPE_FONT, 20);

	//Controlador
	public Tablero()
	{    
		//Damos estilo a la ventana
		setLayout(new FlowLayout());
		setSize(700, 600); // Ancho y altura
		setResizable(false);// no permitir redimensionar
		setBackground(Color.black);
		setLocationRelativeTo(null);//fijar que la ventana salga
	
		Panel panel= new Panel();
		panel.setLayout(new FlowLayout());

		panel.add(img);
		panel.add(area);
		panel.add(img2);
		panel.add(area2);
		panel.add(img3);

		//A�adimos las herramientas
		herramienta = getToolkit();
		// Especificar la ruta de la imagen
		imagen = herramienta.getImage("img\\Captura3.PNG");
		imagen2 = herramienta.getImage("img\\Captura.PNG");
	
		panel.setBackground(Color.CYAN);
		panel.setSize(40, 560);
		//Agregamos panel.
		add(panel);
		setVisible(true);//mostrar la ventana
	}

	public void paint(Graphics g)
	{
		//posicionar la imagen
		g.drawRect(posX, posY, dimension, dimension);
		g.setFont(font);
		g.setColor(Color.black);
		// Dibujar la imagen
		g.drawImage(imagen ,660,36,this);
		g.drawImage(imagen2,6,36,this);
	}
}