package logic;

import interfaces.IOperacionesBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Actividad;
import clases.Peregrinacion;
import clases.Peregrino;

public class OperacionesBD extends Conexion implements IOperacionesBD {

	private ResultSet resultSet;

	@Override
	public void insertarPeregrino(int idPeregrinacion, String nombre,
			String apellido1, String apellido2, String bus, String tipoHab,
			int cantidad, boolean pagado) {

		String query = "INSERT INTO peregrinos(id_peregrinaciones, nombre, apellido1, apellido2, bus, tipo_hab, cantidad, pagado) VALUES ("
				+ idPeregrinacion
				+ ","
				+ q(nombre)
				+ ","
				+ q(apellido1)
				+ ","
				+ q(apellido2)
				+ ","
				+ q(bus)
				+ ","
				+ q(tipoHab)
				+ ","
				+ cantidad + "," + pagado + ")";

		ejecutarConsulta(query);

	}

	@Override
	public void editarPeregrino(int idPeregrino, int idPeregrinacion,
			String nombre, String apellido1, String apellido2, String bus,
			String tipoHab, int cantidad, boolean pagado) {

		String query = "UPDATE OR REPLACE peregrinos SET id_peregrinaciones ="
				+ idPeregrinacion + ", nombre = " + q(nombre)
				+ ", apellido1 = " + q(apellido1) + ", apellido2 ="
				+ q(apellido2) + ", bus=" + q(bus) + ", tipo_hab ="
				+ q(tipoHab) + ", cantidad=" + cantidad + ", pagado=" + pagado
				+ " WHERE id =" + idPeregrino;

		ejecutarConsulta(query);

	}

	@Override
	public void eliminarPeregrino(int idPeregrino) {

		String query = "DELETE FROM peregrinos WHERE id=" + idPeregrino;
		ejecutarConsulta(query);

	}

	@Override
	public void insertarPeregrinacion(String fecha, String lugar) {

		String query = "INSERT INTO peregrinaciones(fecha, lugar) VALUES("
				+ q(fecha) + "," + q(lugar) + ")";

		ejecutarConsulta(query);

	}

	@Override
	public void editarPeregrinacion(int idPeregrinacion, String fecha,
			String lugar) {

		String query = "UPDATE OR REPLACE peregrinaciones SET fecha="
				+ q(fecha) + ", lugar=" + q(lugar) + "WHERE id="
				+ idPeregrinacion;

		ejecutarConsulta(query);

	}

	@Override
	public void eliminarPeregrinacion(int idPeregrinacion) {

		String query = "DELETE FROM peregrinaciones WHERE id="
				+ idPeregrinacion;
		ejecutarConsulta(query);

	}

	@Override
	public void insertarActividad(int idPeregrinacion, String lugar,
			String actividad, String fecha) {

		String query = "INSERT INTO actividades(idPeregrinacion, lugar, actividad, fecha) VALUES("
				+ idPeregrinacion
				+ ","
				+ q(lugar)
				+ ","
				+ q(actividad)
				+ ","
				+ q(fecha) + ")";

		ejecutarConsulta(query);

	}

	@Override
	public void editarActividad(int idActividad, int idPeregrinacion,
			String lugar, String actividad, String fecha) {

		String query = "UPDATE OR REPLACE actividades SET id_peregrinacion ="
				+ idPeregrinacion + ",lugar=" + q(lugar) + ",actividad="
				+ q(actividad) + ",fecha=" + q(fecha) + "WHERE id="
				+ idActividad;

		ejecutarConsulta(query);

	}

	@Override
	public void eliminarActividad(int idActividad) {

		String query = "DELETE FROM actividades WHERE id=" + idActividad;
		ejecutarConsulta(query);

	}

	@Override
	public Peregrino obtenerPeregrino(int idPeregrino) throws SQLException {

		String query = "SELECT * FROM peregrinos WHERE id=" + idPeregrino;
		resultSet = ejecutarConsulta(query);
		Peregrino peregrino = new Peregrino(idPeregrino,
				resultSet.getInt("id_peregrinaciones"),
				resultSet.getString("nombre"),
				resultSet.getString("apellido1"),
				resultSet.getString("apellido2"), resultSet.getString("bus"),
				resultSet.getString("tipo_hab"), resultSet.getInt("cantidad"),
				resultSet.getBoolean("pagado"));
		return peregrino;
	}

	@Override
	public Actividad obtenerActividad(int idActividad) throws SQLException {

		String query = "SELECT * FROM actividades WHERE id=" + idActividad;
		resultSet = ejecutarConsulta(query);
		Actividad actividad = new Actividad(idActividad,
				resultSet.getInt("id_peregrinacion"),
				resultSet.getString("lugar"), resultSet.getString("actividad"),
				resultSet.getString("fecha"));

		return actividad;
	}

	@Override
	public Peregrinacion obtenerPeregrinacion(int idPeregrinacion)
			throws SQLException {

		String query = "SELECT * FROM peregrinaciones WHERE id="
				+ idPeregrinacion;
		resultSet = ejecutarConsulta(query);
		Peregrinacion peregrinacion = new Peregrinacion(idPeregrinacion,
				resultSet.getString("lugar"), resultSet.getString("fecha"));
		return peregrinacion;
	}

	@Override
	public ArrayList<Peregrino> totalPeregrinos() {
		ArrayList<Peregrino> peregrinos = new ArrayList<Peregrino>();
		String query = "SELECT * FROM peregrinos";
		resultSet = ejecutarConsulta(query);
		try {
			while (resultSet.next()) {
				Peregrino peregrino = new Peregrino(resultSet.getInt("id"),
						resultSet.getInt("id_peregrinaciones"),
						resultSet.getString("nombre"),
						resultSet.getString("apellido1"),
						resultSet.getString("apellido2"),
						resultSet.getString("bus"),
						resultSet.getString("tipo_hab"),
						resultSet.getInt("cantidad"),
						resultSet.getBoolean("pagado"));

				peregrinos.add(peregrino);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return peregrinos;
	}

	@Override
	public ArrayList<Peregrino> peregrinosPagados() {

		ArrayList<Peregrino> peregrinos = new ArrayList<Peregrino>();
		String query = "SELECT * FROM peregrinos WHERE pagado=1";
		resultSet = ejecutarConsulta(query);
		try {
			while (resultSet.next()) {
				Peregrino peregrino = new Peregrino(resultSet.getInt("id"),
						resultSet.getInt("id_peregrinaciones"),
						resultSet.getString("nombre"),
						resultSet.getString("apellido1"),
						resultSet.getString("apellido2"),
						resultSet.getString("bus"),
						resultSet.getString("tipo_hab"),
						resultSet.getInt("cantidad"),
						resultSet.getBoolean("pagado"));

				peregrinos.add(peregrino);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return peregrinos;
	}

	@Override
	public ArrayList<Actividad> totalActividades() {
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		String query = "SELECT * FROM actividades";
		resultSet = ejecutarConsulta(query);
		try {
			while (resultSet.next()) {
				Actividad actividad = new Actividad(resultSet.getInt("id"),
						resultSet.getInt("id_peregrinacion"),
						resultSet.getString("lugar"),
						resultSet.getString("actividad"),
						resultSet.getString("fecha"));

				actividades.add(actividad);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actividades;
	}

	@Override
	public ArrayList<Peregrinacion> totalPeregrinaciones() {
		ArrayList<Peregrinacion> peregrinaciones = new ArrayList<Peregrinacion>();
		String query = "SELECT * FROM peregrinaciones";
		resultSet = ejecutarConsulta(query);
		try {
			while (resultSet.next()) {
				peregrinaciones.add(new Peregrinacion(resultSet.getInt("id"),
						resultSet.getString("lugar"), resultSet
								.getString("fecha")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return peregrinaciones;
	}

	@Override
	public ResultSet ejecutarConsulta(String query) {
		conectar();
		ResultSet resultado = null;
		try {
			resultado = consulta.executeQuery(query);
		} catch (SQLException e) {
			e.getMessage();
		}

		return resultado;
	}

	// Método para entrecomillar los campos en las consultas
	private String q(String s) {
		return s = "'" + s + "'";
	}

}
