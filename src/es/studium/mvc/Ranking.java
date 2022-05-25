package es.studium.mvc;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.Toolkit;
public class Ranking extends Frame 
{
	private static final long serialVersionUID = 1L;
	//alto*ancho
	Label lblTop = new Label("                           		 Lista 10 personas                                            ");
	TextArea txtSnake= new TextArea(15, 30);
	// Declarar el objeto Image
	Image imagen;
	// Declarar el objeto Toolkit para manejo de imágenes
	Toolkit herramienta;

	public Ranking()
	{
		setLayout(new FlowLayout());
		setSize(480,410);
		
		setTitle("Top 10");
		add(lblTop);
		add(txtSnake);
		
		setResizable(false);
		// Establecer el método de trabajo con imágenes
		herramienta = getToolkit();
		// Especificar la ruta de la imagen
		imagen = herramienta.getImage("imagenes\\Snake.PNG"); 
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		// Dibujar la imagen
		g.drawImage(imagen,4,23,this);
	}
}


