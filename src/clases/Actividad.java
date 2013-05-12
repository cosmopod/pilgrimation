package clases;

public class Actividad {
	public int id;
	public int idPeregrinacion;
	public String lugar;
	public String actividad;
	public String fecha;

	public Actividad(int id, int idPeregrinacion, String lugar,
			String actividad, String fecha) {
		super();
		this.id = id;
		this.idPeregrinacion = idPeregrinacion;
		this.lugar = lugar;
		this.actividad = actividad;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPeregrinacion() {
		return idPeregrinacion;
	}

	public void setIdPeregrinacion(int idPeregrinacion) {
		this.idPeregrinacion = idPeregrinacion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
