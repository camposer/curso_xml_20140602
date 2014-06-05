package parsers.ejercicio7;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ordenadores")
public class Ordenadores {
	private List<Ordenador> ordenadores;

	@XmlElement(name="ordenador")
	public List<Ordenador> getOrdenadores() {
		return ordenadores;
	}

	public void setOrdenadores(List<Ordenador> ordenadores) {
		this.ordenadores = ordenadores;
	}

	@Override
	public String toString() {
		return "Ordenadores [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
