package parsers.jaxb;

import javax.xml.bind.annotation.XmlAttribute;

public class Ordenador {
	private Integer id;
	private String nombre;
	private String serial;
	
	public Ordenador() {
		
	}
	public Ordenador(Integer id, String nombre, String serial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.serial = serial;
	}
	
	public Integer getId() {
		return id;
	}
	@XmlAttribute
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Ordenador [nombre=" + nombre + ", serial=" + serial + "]";
	}
}
