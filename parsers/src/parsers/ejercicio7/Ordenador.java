package parsers.ejercicio7;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ordenador")
public class Ordenador {
	private Integer id;
	private String nombre;
	private String serial;
	private OrdenadorTipo tipo;
	private Persona persona;
	
	@XmlAttribute
	public Integer getId() {
		return id;
	}
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
	public OrdenadorTipo getTipo() {
		return tipo;
	}
	public void setTipo(OrdenadorTipo tipo) {
		this.tipo = tipo;
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
				+ serial + ", tipo=" + tipo + ", persona=" + persona + "]";
	}
}
