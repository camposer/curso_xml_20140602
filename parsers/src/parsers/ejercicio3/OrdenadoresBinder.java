package parsers.ejercicio3;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import parsers.model.Ordenador;
import parsers.model.Persona;

public class OrdenadoresBinder {
	// TODO: Incluir validaciones!
	public static List<Ordenador> getOrdenadores(String archivo)
			throws Exception {
		List<Ordenador> resultado = new ArrayList<Ordenador>();
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document doc = builder.parse(new File(archivo));

		// Nodo raíz
		Element ordenadores = doc.getDocumentElement();
		NodeList ordenadoresHijos = ordenadores.getChildNodes();
		
		for (int i = 0; i < ordenadoresHijos.getLength(); i++) {
			if (ordenadoresHijos.item(i) instanceof Element) {
				Element ordenador = (Element) ordenadoresHijos.item(i);

				String sid = ordenador.getAttribute("id");

				String nombre = ordenador
						.getElementsByTagName("nombre")
						.item(0).getTextContent();

				String serial = ordenador
						.getElementsByTagName("serial")
						.item(0).getTextContent();

				String tipo = ordenador
						.getElementsByTagName("tipo")
						.item(0).getTextContent();

				// Agregando persona
				Element persona = (Element)ordenador
						.getElementsByTagName("persona")
						.item(0);
				
				String sidPersona = persona.getAttribute("id");
				
				String nombrePersona = persona
						.getElementsByTagName("nombre")
						.item(0).getTextContent();
				
				String apellido = persona
						.getElementsByTagName("apellido")
						.item(0).getTextContent();
				
				String sfechaNacimiento = persona
						.getElementsByTagName("fechaNacimiento")
						.item(0).getTextContent();
				Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy")
						.parse(sfechaNacimiento);

				String saltura = persona
						.getElementsByTagName("altura")
						.item(0).getTextContent();
				Integer altura = Integer.parseInt(saltura);

				// Construyendo objeto ordenador para añadir a la lista de resultado
				Ordenador o = new Ordenador();
				o.setId(Integer.parseInt(sid));
				o.setNombre(nombre);
				o.setSerial(serial);
				o.setTipo(tipo);
				o.setPersona(new Persona(
						Integer.parseInt(sidPersona),
						nombrePersona,
						apellido,
						fechaNacimiento,
						altura
					));
				resultado.add(o);
			}
		}
		
		
		return resultado;
	}
	
	public static void main(String[] args) throws Exception {
		for (Ordenador o : getOrdenadores("xml/ordenadores.xml")) {
			System.out.println(o);
		}
	}
}
