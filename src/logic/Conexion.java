package logic;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {

	protected Connection conexion;
	protected Statement consulta;
	protected URL recursos;
	protected String rutaFinal;

	public Conexion() {

		recursos = getClass().getResource("peregrinacion");
		//ruta "string" del archivo de la BD
		rutaFinal = recursos.getFile();
		
	}

	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		try {
			conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaFinal);
			consulta = conexion.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
		}

	}

}
