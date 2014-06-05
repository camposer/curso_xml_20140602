package parsers.ejercicio5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import parsers.model.Persona;

public class PersonaBinder {

	public static void main(String[] args) throws Exception {
		Persona p = getPersona("xml/persona.xml");
		System.out.println(p);
	}

	public static Persona getPersona(String archivo) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		PersonaHandler handler = new PersonaHandler();
		saxParser.parse(archivo, handler); // Retorna el control cuando termina de procesar el XML

		return handler.getPersona();
	}

	private static class PersonaHandler extends DefaultHandler {
		private Persona persona;
		private String elemento;

		public PersonaHandler() {
			this.persona = new Persona();
		}

		public Persona getPersona() {
			return persona;
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {

			elemento = qName;

			if (elemento.equals("persona"))
				persona.setId(Integer.parseInt(attributes.getValue("id")));
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {

			String contenido = new String(ch, start, length);
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
