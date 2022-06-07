package es.studium.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class Controlador implements WindowListener, ActionListener, KeyListener
{
	MenuPrincipal menuPrincipal;
	Modelo modelo;
	NuevaPartida nuevaPartida = new NuevaPartida();
	Ranking ranking = new Ranking();
	Tablero tablero = new Tablero();
	int cerrar = 0;
	//boolean closing = true;

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
		tablero.addKeyListener(this);
		nuevaPartida.addWindowListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource().equals(menuPrincipal.btnExit))
		{
			//Se cierra menu principal
			menuPrincipal.ocultarMenuPrincipal();
		
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
			//Ayuda.mostrarAyuda();
			cerrar = 2;

			try {
				Runtime.getRuntime().exec("hh.exe ficheroAyuda.chm");
			}
			
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else 
		{
			System.exit(1);
		}
	}
	@Override
	public void keyPressed(KeyEvent ke)
	{
		
		//Funcionalidad serpiente 
		//Si pulsamos a la izquierda
		if(ke.getKeyCode()==37)//37 tecla izquierda
		{
			tablero.posXser--;
			//Indicamos 
			if(tablero.posXser>=-800)
			{
				tablero.posXser--;
			}
		}
		// Pulsamos cursor arriba
		else if(ke.getKeyCode()==38)//tecla arriba
		{
			//indicamos hasta donde llegar serpiente para no salir del tablero arriba, que quede por debajo del panel
			if(tablero.posYser>=70)
			{
				tablero.posYser--;
			}
		}
		// Pulsamos cursor derecha
		else if(ke.getKeyCode()==39)
		{
			//indicamos hasta donde llegar serpiente para no salir del tablero derecha
			if(tablero.posXser<=680)
			{
				tablero.posXser++;
			}
		}
		// Pulsamos cursor abajo
		else if(ke.getKeyCode()==40)
		{
			//indicamos hasta donde llegar serpiente para no salir del tablero abajo
			if(tablero.posYser<=580)
			{
				tablero.posYser++;
			}
		}
		// Comprobamos si las coordenadas del ratón están entre las del cuadrado
		if((tablero.posXser<=tablero.posXman)&&(tablero.posXman<=tablero.posXser+10)&&(tablero.posYser<=tablero.posYman)&&(tablero.posYman<=tablero.posYser+10))
		{
			//vidas++;
			tablero.puntos ++;
			
			tablero.area.setText("Puntos: " + tablero.puntos);
			tablero.area2.setText("Vidas: " + tablero.vidas);
			System.out.print("Acertaste!!!!");
			System.out.println("Llevas " + tablero.puntos + " puntos.");
			//cambiamos la manzana de posición
			tablero.obtenerPosicionManzana();
			//Aumentamos la serpiente cuando come una manzana
			tablero.dimension +=10;
			
		}
		//Volvemos a pintar
		tablero.repaint(); // --> update() --> paint()
		
	}
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent evento)
	{
		//Indicamos cuando cerrar las ventanas
		if ((cerrar == 1) && (menuPrincipal.isActive()))
		{
			//Para salir de menu principal
			menuPrincipal.ocultarMenuPrincipal();
			cerrar = 1;
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
			//1 para cerrar Menú principal después de usar las demás ventanas
			//Conseguido
			System.exit(1);
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
	@Override
	public void keyTyped(KeyEvent e){}
	
	@Override
	public void keyReleased(KeyEvent e){}
}
