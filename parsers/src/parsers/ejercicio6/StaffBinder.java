package parsers.ejercicio6;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import parsers.model.Staff;

public class StaffBinder {

	public static void main(String[] args) throws Exception {
		List<Staff> staffing = getStaffing("xml/staff.xml");
		for (Staff s : staffing) 
			System.out.println(s);
	}

	public static List<Staff> getStaffing(String archivo) throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = xmlInputFactory
        		.createXMLStreamReader(
        				new FileInputStream(archivo));

		return new StaffHandler(xmlStreamReader).getStaffing();
	}

	private static class StaffHandler {
		private XMLStreamReader xmlStreamReader;
		private List<Staff> staffing;
		private Staff staff;
		private String elemento;
		
		public StaffHandler(XMLStreamReader xmlStreamReader) throws Exception {
			this.xmlStreamReader = xmlStreamReader;
			this.staffing = new ArrayList<Staff>();

			while (xmlStreamReader.hasNext()) {
				int evento = xmlStreamReader.next();
				
				switch (evento) {
					case XMLStreamConstants.START_ELEMENT:
						startElement();
						break;
					case XMLStreamConstants.CHARACTERS:
						characters();
						break;
					case XMLStreamConstants.END_ELEMENT:
						endElement();
				}
			}
			
			xmlStreamReader.close(); // Cerrando el fichero!
		}
		
		public List<Staff> getStaffing() {
			return staffing;
		}
		
		private void startElement() {
			elemento = xmlStreamReader.getLocalName();

			if (elemento.equals("staff")) {
				staff = new Staff(); 
				staff.setId(
						Integer.parseInt(
								xmlStreamReader.getAttributeValue(null, "id")));
			}
		}

		private void endElement() {
			if (xmlStreamReader.getLocalName().equals("staff"))
				staffing.add(staff);
		}

		private void characters() {

			String contenido = xmlStreamReader.getText();
			
			if (!contenido.trim().equals("")) {
				if (elemento.equals("firstname"))
					staff.setFirstName(contenido);
				else if (elemento.equals("lastname"))
					staff.setLastName(contenido);
				else if (elemento.equals("nickname"))
					staff.setNickName(contenido);
				else if (elemento.equals("salary"))
					staff.setSalary(Float.parseFloat(contenido));
			}
		}
	}
}
