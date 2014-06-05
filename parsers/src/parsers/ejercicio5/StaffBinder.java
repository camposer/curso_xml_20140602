package parsers.ejercicio5;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import parsers.model.Staff;

public class StaffBinder {

	public static void main(String[] args) throws Exception {
		List<Staff> staffing = getStaffing("xml/staff.xml");
		
		for (Staff s : staffing)
			System.out.println(s);
	}

	public static List<Staff> getStaffing(String archivo) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		StaffHandler handler = new StaffHandler();
		saxParser.parse(archivo, handler); // Retorna el control cuando termina de procesar el XML

		return handler.getStaffing();
	}

	private static class StaffHandler extends DefaultHandler {
		private List<Staff> staffing;
		private Staff staff;
		private String elemento;

		public StaffHandler() {
			this.staffing = new ArrayList<Staff>();
		}

		public List<Staff> getStaffing() {
			return staffing;
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {

			elemento = qName;
			
			if (elemento.equals("staff")) {
				staff = new Staff(); 
				staff.setId(
						Integer.parseInt(
								attributes.getValue("id")));
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			
			if (qName.equals("staff"))
				staffing.add(staff);
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {

			String contenido = new String(ch, start, length);
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
