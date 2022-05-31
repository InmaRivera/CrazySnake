package es.studium.mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class Controlador implements WindowListener, ActionListener
{
	MenuPrincipal principal;
	Modelo modelo;
	NuevaPartida nuevaPartida = new NuevaPartida();
	Ranking ranking = new Ranking();
	Tablero tablero = new Tablero();
	int cerrar = 0;

	public Controlador(MenuPrincipal p, Modelo m)
	{
		this.principal = p;
		this.modelo = m;
		principal.addWindowListener(this);
		principal.btnPartida.addActionListener(this);
		principal.btnTop.addActionListener(this);
		principal.btnAyuda.addActionListener(this);
		principal.btnExit.addActionListener(this);
		nuevaPartida.btnAceptar.addActionListener(this);
		ranking.addWindowListener(this);
		tablero.addWindowListener(this);
		nuevaPartida.addWindowListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource().equals(principal.btnExit))
		{
			principal.setVisible(false);
		}
		else if(evento.getSource().equals(principal.btnPartida))
		{
			//Función de los botones del Tablero
			nuevaPartida.mostrarNuevaPartida();
			cerrar =1;
		}
		else if(evento.getSource().equals(nuevaPartida.btnAceptar))
		{
			//Función de los botones del Tablero
			tablero.mostrarTablero();
			cerrar =1;
		}
		else if (evento.getSource().equals(principal.btnTop))
		{
			ranking.mostrarRanking();
			cerrar = 1;
		}
		else if (evento.getSource().equals(principal.btnAyuda))
		{
			//Ayuda.mostrarRanking();
			cerrar = 1;
		}
	}
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent evento)
	{
		//Indicamos cuando cerrar las ventanas
		if(cerrar == 1)
		{
			//ocultar ranking
			ranking.ocultarRanking();
		}
		else if(cerrar == 1)
		{
			//Se cierra pantalla de nueva partida
			//NO SE CIERRA
			nuevaPartida.ocultarNuevaPartida();
		}
		else if(cerrar == 1)
		{
			//se cierra ventana de juego
			//PROBLEMA NO SE CIERRA
			tablero.ocultarTablero();
		}

		else
		{
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
