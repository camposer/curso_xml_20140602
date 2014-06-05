package parsers.ejercicio7;

import javax.xml.bind.annotation.XmlEnumValue;

public enum OrdenadorTipo {
	@XmlEnumValue("PORTATIL")
	LAPTOP,
	@XmlEnumValue("ESTACION_TRABAJO")
	WORKSTATION,
	@XmlEnumValue("SERVIDOR")
	SERVER;
}
