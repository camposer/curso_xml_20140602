package parsers.jaxb;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Integer altura;
	private List<Ordenador> ordenadores;
	
	public Persona(Integer id, String nombre, String apellido, Date fechaNacimiento,
			Integer altura, List<Ordenador> ordenadores) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.ordenadores = ordenadores;
	}

	public Persona() { }
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", altura=" + altura + ", ordenadores=" + ordenadores + "]";
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public List<Ordenador> getOrdenadores() {
		return ordenadores;
	}
	@XmlElementWrapper(name="ordenadores")
	@XmlElement(name="ordenador")
	public void setOrdenadores(List<Ordenador> ordenadores) {
		this.ordenadores = ordenadores;
	}
}
