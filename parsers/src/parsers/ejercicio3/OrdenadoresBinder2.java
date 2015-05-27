package parsers.ejercicio3;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import parsers.model.Ordenador;
import parsers.model.Persona;

public abstract class OrdenadoresBinder2 {
	public static List<Ordenador> leer(String rutaXml) throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document doc = builder.parse(new File(rutaXml));

		NodeList ordenadoresList = doc.getDocumentElement().getChildNodes();
		return getOrdenadores(ordenadoresList);
	}
	
	private static List<Ordenador> getOrdenadores(NodeList ordenadoresList) throws Exception {
		List<Ordenador> ordenadores = new ArrayList<Ordenador>();
		
		for (int i = 0; i < ordenadoresList.getLength(); i++) {
			if (ordenadoresList.item(i) instanceof Element) {
				Element ordenadorElement = (Element) ordenadoresList.item(i);
				
				Ordenador ordenador = new Ordenador();
				
				// Extratendo el id
				String sordenadorId = ordenadorElement.getAttributeNode("id").getValue();
				ordenador.setId(Integer.parseInt(sordenadorId));
				
				NodeList ordenadorList = ordenadorElement.getChildNodes();
				for (int j = 0; j < ordenadorList.getLength(); j++) {
					if (ordenadorList.item(j) instanceof Element) {
						Element elemento = (Element) ordenadorList.item(j);
						
						if (elemento.getNodeName().equals("nombre")) 
							ordenador.setNombre(elemento.getTextContent());
						else if (elemento.getNodeName().equals("serial"))
							ordenador.setSerial(elemento.getTextContent());
						else if (elemento.getNodeName().equals("persona")) 
							ordenador.setPersona(getPersona(elemento));						
					}
				}
				
				ordenadores.add(ordenador);
			}
		}
		
		return ordenadores;
	}
	
	private static Persona getPersona(Element personaElement) throws Exception {
		Persona persona = new Persona();
		
		// Extratendo el id
		String sordenadorId = personaElement.getAttributeNode("id").getValue();
		persona.setId(Integer.parseInt(sordenadorId));
		
		NodeList personaList = personaElement.getChildNodes();
		for (int i = 0; i < personaList.getLength(); i++) {
			if (personaList.item(i) instanceof Element) {
				Element elemento = (Element) personaList.item(i);
				
				if (elemento.getNodeName().equals("nombre")) {
					persona.setNombre(elemento.getTextContent());
				} else if (elemento.getNodeName().equals("apellido")) {
					persona.setApellido(elemento.getTextContent());
				} else if (elemento.getNodeName().equals("fechaNacimiento")) {
					String sfechaNacimiento = elemento.getTextContent();
					persona.setFechaNacimiento(new SimpleDateFormat("dd/MM/yyyy").parse(sfechaNacimiento));
				} else if (elemento.getNodeName().equals("altura")) {
					String saltura = elemento.getTextContent();
					persona.setAltura(Integer.parseInt(saltura));
				}
			}
		}
		
		return persona;
	}
	
	public static void main(String[] args) throws Exception {
		for (Ordenador o : leer("xml/ordenadores.xml")) {
			System.out.println(o);
		}
	}

	
}
