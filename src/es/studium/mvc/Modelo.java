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
	String sentencia = "SELECT * FROM jugadores";

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
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * FROM jugadores");
			// Para averiguar el número de registros obtenidos
			while (rs.next()) {
				resultado =resultado+rs.getInt("idJugador")+
						" "+rs.getString("nombreJugador"+", "+rs.getInt("puntosJugador")+"\n");
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







