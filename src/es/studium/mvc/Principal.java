package es.studium.mvc;
public class Principal
{
	public static void main(String[] args)
	{
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		Modelo modelo = new Modelo();
		new Controlador(menuPrincipal, modelo);
	}
}
