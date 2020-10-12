package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/usu_farmacia?serverTimezone=UTC";
	private static final String USUARIO = "root";	
	private static final String CONTRASENA = "Enared01";
	
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al Cargar el Controlador");
			e.printStackTrace();
		}
	}
	
	
	public Connection conectar() {
		Connection conexion = null;
	try {
			
			
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
			System.out.println("Conexion Establecida");
			
		} 
			catch (SQLException e) {
			System.out.println("Error en la Conexion");
			e.printStackTrace();
		}
		return conexion;
	}

	

}
