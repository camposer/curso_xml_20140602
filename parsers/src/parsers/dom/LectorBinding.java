package parsers.dom;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import parsers.model.Ordenador;
import parsers.model.Persona;

public class LectorBinding {

	public static void main(String[] args) throws Exception {
		List<Persona> personas = new LectorBinding().obtenerPersonas();
		for (Persona p : personas)
			System.out.println(p);
	}
	
	public List<Persona> obtenerPersonas() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		Document doc = builder.parse(new File("xml/personas.xml"));

		return obtenerPersonas(doc.getDocumentElement());
	}

	private List<Persona> obtenerPersonas(Node elementoRaiz) throws Exception {
		List<Persona> personas = new ArrayList<Persona>();
		
		NodeList ps = elementoRaiz.getChildNodes();
		
		// Iterando sobre personas
		for (int i = 0; i < ps.getLength(); i++) { 
			if (ps.item(i) instanceof Element) {
				Element e = (Element) ps.item(i); // Es persona el primer elemento!
				String sid = e.getAttribute("id");
				
				String nombre, apellido, sfechaNacimiento, saltura;
				nombre = apellido = sfechaNacimiento = saltura = null;
				List<Ordenador> ordenadores = null; 
				
				
				NodeList personaHijos = e.getChildNodes();
				// Iterando sobre persona
				for (int j = 0; j < personaHijos.getLength(); j++) {
					if (personaHijos.item(j) instanceof Element) {
						if (personaHijos.item(j)
								.getNodeName().equals("nombre"))
							nombre = personaHijos.item(j).getTextContent();
						else if (personaHijos.item(j)
								.getNodeName().equals("apellido"))
							apellido = personaHijos.item(j).getTextContent();
						else if (personaHijos.item(j)
								.getNodeName().equals("fechaNacimiento"))
							sfechaNacimiento = personaHijos.item(j).getTextContent();
						else if (personaHijos.item(j)
								.getNodeName().equals("altura"))
							saltura = personaHijos.item(j).getTextContent();
						else if (personaHijos.item(j)
								.getNodeName().equals("ordenadores")) {
							
							ordenadores = new ArrayList<Ordenador>();
							NodeList os = personaHijos.item(j).getChildNodes(); // ordenadores
							String onombre = null, serial = null;
							
							for (int z = 0; z < os.getLength(); z++) {
								if (os.item(z) instanceof Element) {
									NodeList oHijos = os.item(z).getChildNodes(); // ordenador
									
									for (int w = 0; w < oHijos.getLength(); w++) {
										if (oHijos.item(w) instanceof Element) {
											if (oHijos.item(w)
													.getNodeName().equals("nombre"))
												onombre = oHijos.item(w).getTextContent();
											else if (oHijos.item(w)
													.getNodeName().equals("serial"))
												serial = oHijos.item(w).getTextContent();
										}
									}
									
									Ordenador o = new Ordenador(onombre, serial);
									ordenadores.add(o);
								}

							}
						}
					}
				}
				
				// Convirtiendo sfechaNacimiento a Date
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date fnac = sdf.parse(sfechaNacimiento);
				
				// Convirtiendo sid y saltura a Integer 
				Integer id = Integer.parseInt(sid);
				Integer altura = Integer.parseInt(saltura);
				
				Persona p = new Persona(id, nombre, apellido, fnac, altura, ordenadores, null);
				personas.add(p);
			}
		}
		
		return personas;
	}

}
