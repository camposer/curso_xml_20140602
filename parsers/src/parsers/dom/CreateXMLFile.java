package parsers.dom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLFile {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element ele = doc.createElement("Movies");

			Element childElement = doc.createElement("Movie");

			childElement.setAttribute("Type", "BollyWood");
			childElement.setAttribute("Name", "Lagaan");
			childElement.setAttribute("Actor", "Aamir Khan");

			// You can also use setTextContent() method to write between nodes

			ele.appendChild(childElement);

			doc.appendChild(ele);

			// Save the Created XML on Local Disc using Transformation APIs as
			// Discussed
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();

			// below 2 line are only for pretty look rendering of XML
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "4");

			Source s = new DOMSource(doc);
			Result res = new StreamResult(new FileOutputStream("xml/ShivaSoft.xml"));
			transformer.transform(s, res);
			System.out.println("XML File Created Succesfully");

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
