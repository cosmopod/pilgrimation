package interfaces;

import java.sql.ResultSet;

import clases.Actividad;
import clases.Peregrinacion;
import clases.Peregrino;

public interface IOperacionesBD {

	public void insertarPeregrino(int idPeregrinacion, String nombre,
			String apellido1, String apellido2, String bus, String tipoHab);

	public void editarPeregrino(int idPeregrino);

	public void eliminarPeregrino(int idPeregrino);

	public void insertarPeregrinacion(String fecha, String lugar);

	public void editarPeregrinacion(int idPeregrinacion);

	public void eliminarPeregrinacion(int idPeregrinacion);

	public void insertarActividad(int idPeregrinacion, String lugar,
			String actividad, String fecha);

	public void editarActividad(int idActividad);

	public void eliminarActividad(int idActividad);

	public Peregrino obtenerPeregrino(int idPeregrino);

	public Actividad obtenerActividad(int idActividad);

	public Peregrinacion obtenerPeregrinacion(int idPeregrinacion);
	
	public ResultSet ejecutarConsulta(String query);

}
