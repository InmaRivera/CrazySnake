package es.studium.mvc;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
public class MenuPrincipal extends Frame
{
	private static final long serialVersionUID = 1L;
	Label lblMenu = new Label ("Menú principal", 1);
	Button btnPartida = new Button("Empezar partida");
	Button btnTop = new Button("Top 10");
	Button btnAyuda= new Button("Ayuda");// btnExit
	Button btnExit= new Button("Exit");
	Panel pnlSalir = new Panel();

	public MenuPrincipal()
	{
		//Configuración Pantalla
		setSize(300, 220); // Tamaño: Ancho x Alto
		setResizable(false); // No permitir redimensión
		setLayout(new GridLayout(5,1));
		
		setBackground(new Color(255, 255, 153));
		setTitle("Menú Principal");
		add(lblMenu);
		add(btnPartida);
		add(btnTop);
		add(btnAyuda);
		
		pnlSalir.add(btnExit);
		add("South", pnlSalir);
		
		setVisible(true);
		setSize(299, 246); // En pixeles Width, Height. Ir probando y cambiando anchura y altura
		setLocationRelativeTo(null); // Centrar
	}
}
