package com.ar.apimovies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/proyecto_final";
	private static final String USER = "root";
	private static final String PASS = "";

	//Cargamos el controlador JDBC.
	//Este bloque se ejecuta "una vez" cuando la clase se carga en la memoria.
	static {
		try {
			Class.forName(CONTROLADOR);
			System.out.println("Driver JDBC se cargo correctamente.");
		}
		catch (ClassNotFoundException error) {
				System.out.println("Error al cargar Driver JDBC");
				error.printStackTrace();
		}
	}
	
	//Metodo para establecer la conexion.
	//Este metodo establece la conexion con la base de datos y maneja posibles excepciones.
	//Si hay una expecion, la imprime por pantalla y devuelve null.
	public Connection conectar () {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conexion establecida correctamente!");
		}
		catch (SQLException e){
			System.out.println("Error al establecer la conexion.");
			e.printStackTrace();
			
		}
		
		return conexion ;
	}
}