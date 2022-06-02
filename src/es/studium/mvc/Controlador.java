package es.studium.mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class Controlador implements WindowListener, ActionListener
{
	MenuPrincipal menuPrincipal;
	Modelo modelo;
	NuevaPartida nuevaPartida = new NuevaPartida();
	Ranking ranking = new Ranking();
	Tablero tablero = new Tablero();
	int cerrar = 0;
	boolean closing = true;

	public Controlador(MenuPrincipal p, Modelo m)
	{
		this.menuPrincipal = p;
		this.modelo = m;
		menuPrincipal.addWindowListener(this);
		menuPrincipal.btnPartida.addActionListener(this);
		menuPrincipal.btnTop.addActionListener(this);
		menuPrincipal.btnAyuda.addActionListener(this);
		menuPrincipal.btnExit.addActionListener(this);
		nuevaPartida.btnAceptar.addActionListener(this);
		ranking.addWindowListener(this);
		tablero.addWindowListener(this);
		nuevaPartida.addWindowListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource().equals(menuPrincipal.btnExit))
		{
			//Se cierra menu principal
			menuPrincipal.ocultarMenuPrincipal();
			cerrar = 1;
		}
		else if(evento.getSource().equals(menuPrincipal.btnPartida))
		{
			//Se abre pantalla nueva partida (introducir nombre)
			nuevaPartida.mostrarNuevaPartida();
			cerrar = 2;
		}
		else if(evento.getSource().equals(nuevaPartida.btnAceptar))
		{
			//Función de los botones del Tablero
			tablero.mostrarTablero();
			cerrar = 2;
		}
		else if (evento.getSource().equals(menuPrincipal.btnTop))
		{
			ranking.mostrarRanking();
			cerrar = 2;
		}
		else if (evento.getSource().equals(menuPrincipal.btnAyuda))
		{
			//Ayuda.mostrarRanking();
			cerrar = 2;
		}
	}
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent evento)
	{
		//Indicamos cuando cerrar las ventanas
		if ((cerrar == 1) && (menuPrincipal.isActive()))
		{
			//sigue sin cerrarse
			menuPrincipal.setVisible(false);
			menuPrincipal.ocultarMenuPrincipal();
		}
		 if(cerrar == 2)
		{
			//Se cierra pantalla de nueva partida
			nuevaPartida.ocultarNuevaPartida();
		}
		 if(cerrar == 2)
		{
			//se cierra ventana de juego
			tablero.ocultarTablero();			
		}
		if(cerrar == 2)
		{
			//ocultar ranking
			ranking.ocultarRanking();
		}
		
		/*if(cerrar = 2)
		{
			Ayuda.ocultarAyda();
		}*/
		else 
		{
			cerrar = 1;
			menuPrincipal.setVisible(false);
			menuPrincipal.ocultarMenuPrincipal();	
			System.exit(0);
		}
	}
	@Override
	public void windowClosed(WindowEvent e){}
	@Override
	public void windowIconified(WindowEvent e){}
	@Override
	public void windowDeiconified(WindowEvent e){}
	@Override
	public void windowActivated(WindowEvent e){}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}
