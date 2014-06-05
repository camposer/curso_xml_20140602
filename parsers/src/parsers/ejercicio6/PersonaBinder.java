package parsers.ejercicio6;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import parsers.model.Persona;

public class PersonaBinder {

	public static void main(String[] args) throws Exception {
		Persona p = getPersona("xml/persona.xml");
		System.out.println(p);
	}

	public static Persona getPersona(String archivo) throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = xmlInputFactory
        		.createXMLStreamReader(
        				new FileInputStream(archivo));

		return new PersonaHandler(xmlStreamReader).getPersona();
	}

	private static class PersonaHandler {
		private XMLStreamReader xmlStreamReader;
		private Persona persona;
		private String elemento;
		
		public PersonaHandler(XMLStreamReader xmlStreamReader) throws Exception {
			this.xmlStreamReader = xmlStreamReader;
			this.persona = new Persona();

			while (xmlStreamReader.hasNext()) {
				int evento = xmlStreamReader.next();
				
				switch (evento) {
					case XMLStreamConstants.START_ELEMENT:
						startElement();
						break;
					case XMLStreamConstants.CHARACTERS:
						characters();
				}
			}
			
			xmlStreamReader.close(); // Cerrando el fichero!
		}
		
		public Persona getPersona() {
			return persona;
		}
		
		private void startElement() {
			elemento = xmlStreamReader.getLocalName();

			if (elemento.equals("persona"))
				persona.setId(Integer.parseInt(
						xmlStreamReader.getAttributeValue(null, "id")));
		}

		private void characters() {

			String contenido = xmlStreamReader.getText();
			
			if (!contenido.trim().equals("")) {
				if (elemento.equals("nombre")) {
					persona.setNombre(contenido);
				} else if (elemento.equals("apellido")) {
					persona.setApellido(contenido);
				} else if (elemento.equals("fechaNacimiento")) {
					Date fnac = null;
					try {
						fnac = new SimpleDateFormat("yyyy-MM-dd")
								.parse(contenido);
					} catch (ParseException e) { }
					persona.setFechaNacimiento(fnac);
				} else if (elemento.equals("altura")) {
					persona.setAltura(Integer.parseInt(contenido));
				} 
			}
		}
	}
}
