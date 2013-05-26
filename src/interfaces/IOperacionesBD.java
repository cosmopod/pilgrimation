package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Actividad;
import clases.Peregrinacion;
import clases.Peregrino;

public interface IOperacionesBD {

	public void insertarPeregrino(int idPeregrinacion, String nombre,
			String apellido1, String apellido2, String bus, String tipoHab, int cantidad, boolean pagado, String telefono);

	public void editarPeregrino(int idPeregrino, int idPeregrinacion,
			String nombre, String appelido1, String apellido2, String bus,
			String tipoHab, int cantidad, boolean pagado, String telefono);

	public void eliminarPeregrino(int idPeregrino);

	public void insertarPeregrinacion(String fecha, String lugar);

	public void editarPeregrinacion(int idPeregrinacion, String lugar,
			String fecha);

	public void eliminarPeregrinacion(int idPeregrinacion);

	public void insertarActividad(int idPeregrinacion, String lugar,
			String actividad, String fecha);

	public void editarActividad(int idActividad, int idPeregrinacion,
			String lugar, String actividad, String fecha);

	public void eliminarActividad(int idActividad);

	public Peregrino obtenerPeregrino(int idPeregrino) throws SQLException;
	
	public ArrayList<Peregrino> totalPeregrinos(int idPeregrinacion);
	
	public ArrayList<Peregrino> peregrinosPagados();
	
	public Actividad obtenerActividad(int idActividad) throws SQLException;
	
	public ArrayList<Actividad> totalActividades();

	public Peregrinacion obtenerPeregrinacion(int idPeregrinacion) throws SQLException;
	
	public ArrayList<Peregrinacion> totalPeregrinaciones();

	

}
