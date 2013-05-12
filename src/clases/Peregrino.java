
package clases;

public class Peregrino {
	public int id;
	public int idPeregrinacion;
	public String nombre;
	public String apellido1;
	public String apellido2;
	public String bus;
	public String tipoHab;
	
	public Peregrino(int id, int idPeregrinacion, String nombre,
			String apellido1, String apellido2, String bus, String tipoHab) {
		super();
		this.id = id;
		this.idPeregrinacion = idPeregrinacion;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.bus = bus;
		this.tipoHab = tipoHab;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getTipoHab() {
		return tipoHab;
	}

	public void setTipoHab(String tipoHab) {
		this.tipoHab = tipoHab;
	}
	
	
	
	

}
