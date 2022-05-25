package es.studium.mvc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
public class Tablero extends Frame {
	
	private static final long serialVersionUID = 1L;
	//setBackground(Color.black);
	Frame ventana= new Frame ("Tablero");
	TextField area= new TextField(10);
	TextField area2= new TextField(5);
	Image imagen;
	Image imagen2;
	Toolkit herramienta;
	
	
	public Tablero()
	{     
		ventana.setLayout(new BorderLayout());
		  
		ventana.setSize(700, 600); // Ancho y altura
		
		
		//ventana.add(panel);
		 
		ventana.setResizable(false);// no permitir redimensionar
		//ventana.setLayout(new FlowLayout());
		ventana.setBackground(Color.black);
		ventana.setLocationRelativeTo(null);//fijar que la ventana salga
		ventana.setVisible(true);//mostrar la ventana
		// Establecer el método de trabajo con imágenes
		Panel panel= new Panel();
		//panel.setSize(500,500);
		panel.setLayout(new BorderLayout());
		panel.add("West", area);
		panel.add("East", area2);
		ventana.add( "North",panel);
		panel.setBackground(Color.CYAN);
		panel.imageUpdate(imagen, ALLBITS, MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		
				herramienta = getToolkit();
				// Especificar la ruta de la imagen
				imagen = herramienta.getImage("img\\copa.PNG"); 
				imagen2 = herramienta.getImage("img\\manzana.PNG"); 
				setVisible(true);
				//panel.add("copa.PNG");
		
	}

	public void paint(Graphics g)
	{
		// Dibujar la imagen
		g.drawImage(imagen,9,40,this);
		g.drawImage(imagen2,4,90,this);
	}

}
