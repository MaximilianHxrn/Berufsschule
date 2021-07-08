/*
 * $Id: Bsp04.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.bsp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bsp 04
 *
 * @version $Revision: 1579 $
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bsp04 {

	public static void main(final String[] args) throws Exception {
		final Bsp04 bsp = new Bsp04();
		bsp.map.put("A1", "Apfel");
		bsp.map.put("A2", "Birne");
		bsp.map.put("A3", "Banane");

		final Marshaller m = JAXBContext.newInstance(Bsp04.class).createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(bsp, new File("target/bsp04.xml"));
	}

	@XmlElement
	Map<String, String> map = new HashMap<String, String>();
}
