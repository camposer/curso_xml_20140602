package parsers.model;

import java.util.Date;
import java.util.List;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Integer altura;
	private List<Ordenador> ordenadores;
	private List<Coche> coches;

	public Persona() {
	}
	
	public Persona(Integer id, String nombre, String apellido, Date fechaNacimiento,
			Integer altura) {
		
		this(id, nombre, apellido, fechaNacimiento, altura, null, null);
	}
	
	public Persona(Integer id, String nombre, String apellido, Date fechaNacimiento,
			Integer altura, List<Ordenador> ordenadores, List<Coche> coches) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.ordenadores = ordenadores;
		this.coches = coches;
	}

	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", altura=" + altura + ", ordenadores=" + ordenadores
				+ ", coches=" + coches + "]";
	}


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
	public void setOrdenadores(List<Ordenador> ordenadores) {
		this.ordenadores = ordenadores;
	}
	public List<Coche> getCoches() {
		return coches;
	}
	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}
	
	
}
