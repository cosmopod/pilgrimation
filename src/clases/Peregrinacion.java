package clases;

public class Peregrinacion {
	private int id;
	private String lugar;
	private String fecha;

	public Peregrinacion(int id, String lugar, String fecha) {
		super();
		this.id = id;
		this.lugar = lugar;
		this.fecha = fecha;
	}
	
	public Peregrinacion(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
	
		return this.getId()+". Lugar: "+this.lugar+". Fecha: "+this.getFecha();
	}

	
}
