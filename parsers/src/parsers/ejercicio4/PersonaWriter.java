package parsers.ejercicio4;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import parsers.model.Persona;

public class PersonaWriter {
	public static void escribirPersona(Persona p, String archivo) throws Exception {
		// Inicialización
		DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
//		factory.setValidating(true);
//		factory.setSchema(schema);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		// Construcción del documento
		Element persona = doc.createElement("persona");
		persona.setAttribute("id", Integer.toString(p.getId()));
		
		Element nombre = doc.createElement("nombre");
		nombre.setTextContent(p.getNombre());
		persona.appendChild(nombre);

		Element apellido = doc.createElement("apellido");
		apellido.setTextContent(p.getApellido());
		persona.appendChild(apellido);
		
		Element fechaNacimiento = doc.createElement("fechaNacimiento");
		String sfechaNacimiento = new SimpleDateFormat("yyyy-MM-dd")
				.format(p.getFechaNacimiento());
		fechaNacimiento.setTextContent(sfechaNacimiento);
		persona.appendChild(fechaNacimiento);
		
		Element altura = doc.createElement("altura");
		altura.setTextContent(Integer.toString(p.getAltura()));
		persona.appendChild(altura);
		
		doc.appendChild(persona);		
		
		// Escribir el documento
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(
				"{http://xml.apache.org/xslt}indent-amount", "4");

		Source s = new DOMSource(doc);
		Result res = new StreamResult(new FileOutputStream(archivo));
		transformer.transform(s, res);
		System.out.println("Ha sido creado el documento XML");
	}

	public static void main(String[] args) throws Exception {
		Persona p = new Persona(
					1,
					"Juan",
					"Pérez",
					new SimpleDateFormat("yyyy-MM-dd").parse("1980-01-03"),
					180
				);
		
		escribirPersona(p, "xml/persona.xml");
	}
}

