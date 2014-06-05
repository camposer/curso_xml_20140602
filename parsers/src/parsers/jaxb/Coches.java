package parsers.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coches {
	private List<Coche> coches;

	public List<Coche> getCoches() {
		return coches;
	}

	@XmlElement(name="coche")
	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}

	public Coches(List<Coche> coches) {
		super();
		this.coches = coches;
	}
	
	public Coches() {}

	@Override
	public String toString() {
		return "Coches [coche=" + coches + "]";
	}
}
