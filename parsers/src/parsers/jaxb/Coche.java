package parsers.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Coche {
	private Integer id;
	private String matricula;
	private String marca;
	private List<Persona> personas;
	
	public Coche() {}
	public Coche(Integer id, String matricula, String marca, List<Persona> personas) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.personas = personas;
	}
	public Integer getId() {
		return id;
	}
	@XmlAttribute
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public List<Persona> getPersonas() {
		return personas;
	}
	@XmlElementWrapper(name="personas")
	@XmlElement(name="persona")
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca
				+ ", persona=" + personas + "]";
	}
	
	
}
