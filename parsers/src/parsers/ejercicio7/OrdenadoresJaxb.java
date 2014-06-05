package parsers.ejercicio7;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class OrdenadoresJaxb {
	public static void main(String[] args) throws Exception {
		File file = new File("xml/ordenadores.xml");
		JAXBContext jaxbContext = JAXBContext
				.newInstance(Ordenadores.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Ordenadores ordenadores = (Ordenadores) jaxbUnmarshaller.unmarshal(file);
		for (Ordenador o : ordenadores.getOrdenadores()) {
			System.out.println(o);
		}
		
	}
}
