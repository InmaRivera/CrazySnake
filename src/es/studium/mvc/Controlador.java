package es.studium.mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class Controlador implements WindowListener, ActionListener
{
	MenuPrincipal principal;
	Modelo modelo;
	NuevaPartida nuevaPartida;
	Ranking ranking;

	public Controlador(MenuPrincipal p, Modelo m)
	{
		this.principal = p;
		this.modelo = m;
		principal.addWindowListener(this);
		principal.btnPartida.addActionListener(this);
		principal.btnTop.addActionListener(this);
		principal.btnAyuda.addActionListener(this);
		principal.btnExit.addActionListener(this);
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
			nuevaPartida = new NuevaPartida();
			nuevaPartida.addWindowListener(this);
		}
		else if (evento.getSource().equals(principal.btnTop))
		{
			ranking = new Ranking();
			ranking.addWindowListener(this);
		}
	}
	@Override
	public void windowOpened(WindowEvent e){}
	@Override
	public void windowClosing(WindowEvent evento)
	{
		if(nuevaPartida!=null && ranking!=null)
		{
			if(nuevaPartida.isActive())
			{
				principal.setVisible(true);
				nuevaPartida.setVisible(false);
			}
			else if(ranking.isActive())
			{
				principal.setVisible(true);
				ranking.setVisible(false);	
			}
			else
			{
				System.exit(0);
			}
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
