package parsers.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Lector {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		Document doc = builder.parse(new File("xml/personas.xml"));
		Element personas = doc.getDocumentElement(); // Extraigo nodo raíz

		imprimir(personas, "");
	}

	private static void imprimir(Node nodo, String indent) {
		imprimirNodo(nodo, indent);

		NodeList personaNodeList = nodo.getChildNodes();
		indent += "-"; 
		for (int i = 0; i < personaNodeList.getLength(); i++) {
			//if (personaNodeList.item(i) instanceof Element) {
				imprimir(personaNodeList.item(i), indent);
			//}
		}

	}

	private static void imprimirNodo(Node nodo, String indent) {
		String valor = indent + "[nodeName = " + nodo.getNodeName() + 
				", nodeValue = " + nodo.getNodeValue() + 
				", nodeType = " + nodo.getNodeType();
		
		if (nodo.getNodeName().equals("nombre")) 
			valor += ", nodeTextContent = " + nodo.getTextContent();
		
		valor += "]";

		System.out.println(valor);

	}
}