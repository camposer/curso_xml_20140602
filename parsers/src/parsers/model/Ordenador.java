package parsers.model;

public class Ordenador {
	private Integer id;
	private String nombre;
	private String serial;
	private Persona persona;
	
	public Ordenador() {
		
	}
	
	public Ordenador(String nombre, String serial) {
		this(null, nombre, serial, null);
	}
	
	public Ordenador(Integer id, String nombre, String serial, Persona persona) {
		this.id = id;
		this.nombre = nombre;
		this.serial = serial;
		this.persona = persona;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Ordenador [id=" + id + ", nombre=" + nombre + ", serial="
				+ serial + ", persona=" + persona + "]";
	}
}
