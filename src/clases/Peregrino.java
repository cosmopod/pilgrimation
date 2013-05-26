package clases;

public class Peregrino {
	private int id;
	private int idPeregrinacion;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String bus;
	private String tipoHab;
	private int cantidad;
	private boolean pagado;
	private String telefono;


	public Peregrino() {
		super();
	}

	
	public Peregrino(int id, int idPeregrinacion, String nombre,
			String apellido1, String apellido2, String bus,
			String tipoHab, int cantidad, boolean pagado, String telefono) {
		super();
		this.id = id;
		this.idPeregrinacion = idPeregrinacion;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.bus = bus;
		this.tipoHab = tipoHab;
		this.cantidad = cantidad;
		this.pagado = pagado;
		this.telefono = telefono;
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
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


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public boolean isPagado() {
		return pagado;
	}


	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}


	@Override
	public String toString() {
		String debe;
		if (isPagado() != true) {
			debe = "NO";
		} else {
			debe = "SI";
		}

		return "" + getId() + ". "  + getNombre() + "  "
				+ getApellido1() + "  " + getApellido2() + ". " + "CANTIDAD: "
				+ getCantidad() + ". " + "PAGADO: " + debe;
	}

}
