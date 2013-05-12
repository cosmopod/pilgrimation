package logic;

import java.sql.ResultSet;

import clases.Actividad;
import clases.Peregrinacion;
import clases.Peregrino;
import interfaces.IOperacionesBD;

public class OperacionesBD extends Conexion implements IOperacionesBD{

	@Override
	public void insertarPeregrino(int idPeregrinacion, String nombre,
			String apellido1, String apellido2, String bus, String tipoHab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarPeregrino(int idPeregrino) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPeregrino(int idPeregrino) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarPeregrinacion(String fecha, String lugar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarPeregrinacion(int idPeregrinacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPeregrinacion(int idPeregrinacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarActividad(int idPeregrinacion, String lugar,
			String actividad, String fecha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarActividad(int idActividad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarActividad(int idActividad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Peregrino obtenerPeregrino(int idPeregrino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actividad obtenerActividad(int idActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Peregrinacion obtenerPeregrinacion(int idPeregrinacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet ejecutarConsulta(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
