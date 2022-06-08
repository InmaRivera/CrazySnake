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
		tablero.dlgFeedback.addWindowListener(this);

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
			//Funci�n de los botones del Tablero
			tablero.mostrarTablero();
			tablero.setNombre(nuevaPartida.getNombre());
			cerrar = 2;
		}
		else if (evento.getSource().equals(menuPrincipal.btnTop))
		{
			//conectar con base de datos para mostrar informaci�n del ranking
			modelo.conectar();
			String resultado = modelo.consularRanking();
			modelo.desconectar();
			// A�adir el contenido al TextArea
			ranking.txtSnake.setText(resultado);
			//abrir ventana del ranking
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
			//Indicamos hasta donde llegar serpiente a la izquierda
			if(tablero.posXser>=4)
			{
				tablero.posXser--;
				tablero.cambiarDireccion(0);
			}
		}
		// Pulsamos cursor arriba
		else if(ke.getKeyCode()==38)//tecla arriba
		{
			//indicamos hasta donde llegar serpiente para no salir del tablero arriba, que quede por debajo del panel

			if(tablero.posYser>=100)
			{
				tablero.posYser--;
				//para que serpiente cambie de direccion
				tablero.cambiarDireccion(2);
			}

		}
		// Pulsamos cursor derecha
		else if(ke.getKeyCode()==39)
		{
			//indicamos hasta donde llegar serpiente para no salir del tablero derecha
			if(tablero.posXser<=700)
			{
				tablero.posXser++;
				tablero.cambiarDireccion(1);
			}
		}
		// Pulsamos cursor abajo
		else if(ke.getKeyCode()==40)
		{
			//indicamos hasta donde llegar serpiente para no salir del tablero abajo
			if(tablero.posYser<=590)
			{
				tablero.posYser++;
				tablero.cambiarDireccion(3);
			}
		}
		// Comprobamos si las coordenadas del rat�n est�n entre las de la serpiente
		if((tablero.posXser<=tablero.posXman)&&(tablero.posXman<=tablero.posXser+20)&&(tablero.posYser<=tablero.posYman)&&(tablero.posYman<=tablero.posYser+20))
		{
			
			tablero.puntos ++;
			tablero.area.setText(" " + tablero.puntos);//mostramos los puntos en area
			System.out.print("Acertaste!!!!");
			System.out.println("Llevas " + tablero.puntos + " puntos.");
			//cambiamos la manzana de posici�n
			tablero.obtenerPosicionManzana();
			//Aumentamos la serpiente cuando come una manzana
			tablero.dimension +=10;
			
		}
		//Fin del juego, cuando se salga del tablero
		if((tablero.posXser == 4)||(tablero.posXser==100)||(tablero.posXser==700)||(tablero.posXser==590))
		{			
			//Mostramos el mensaje de acabado
			tablero.mostrarDialogo();
			//Eliminamos la vida
			tablero.vidas--;
			tablero.area2.setText(" " + tablero.vidas);//mostramos la vida en area
			
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
			modelo.conectar();
			modelo.finPartida(tablero.getNombre(), tablero.puntos);
			modelo.desconectar();
		}
		if(cerrar == 2)
		{
			//ocultar ranking
			ranking.ocultarRanking();
		}		
		else 
		{	
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
