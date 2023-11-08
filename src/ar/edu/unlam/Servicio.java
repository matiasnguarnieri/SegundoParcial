package ar.edu.unlam;

public class Servicio {

	private String id;
	private String nombre;
	private Double precio;
	private String fechaDesde;
	private String fechaHasta;

	public Servicio(String id, String nombre, Double precio, String fechaDesde, String fechaHasta) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	
}
