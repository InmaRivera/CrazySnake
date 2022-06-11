package es.studium.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo
{
	// Crear un objeto tipo Connection
	Connection con = null;

	// Data Source Name de la Base de Datos
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/crazysnake";
	String login = "root";
	String password = "Studium2021;";

	// Creamos una consulta a la base de datos
	String sentencia = "SELECT nombreJugador puntosJugador FROM jugadores where puntosJugador order by 2 desc;" ; 
	
	 
	// Objeto donde se guarda la información de la consulta a la base de datos
	ResultSet rs = null;

	// Crear un statement de SQL
	Statement stmt = null;
	int contador = 0;

	Modelo()
	{}
	public void conectar()
	{
		
		// Cargar el Driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Se ha producido un error al cargar el Driver");
		}
	
		// Establecer la conexión con la base de datos
		try {
			con = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			System.out.println("Se produjo un error al conectar a la Base de Datos");
		}
	}
	
	
	public String consularRanking()
	{
		String resultado = "";
		// Realizar la consulta
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM jugadores");
			// Para averiguar el número de registros obtenidos
		
			int i=0;
			
			//para poder mostrar los 10 primeros
			while (rs.next() && (i<10)) {
				resultado =resultado+rs.getString("nombreJugador")+
						", "+rs.getInt("puntosJugador")+"\n";
				i++;
			}

		} catch (SQLException e) {
			System.out.println("Error en la sentencia SQL");
		}

		return resultado;
	}
	
	
	public void finPartida(String nombre, int puntuacion)
	{
		
		try {

			stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO crazysnake.jugadores (nombreJugador, puntosJugador) VALUES ('" + nombre + "',  + " + puntuacion + ")");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
	
	public void desconectar()
	{

		try
		{		
			if(con!=null)
			{
				con.close();
			}
		}
		catch (SQLException e)
		{

		}
	}
	
}







