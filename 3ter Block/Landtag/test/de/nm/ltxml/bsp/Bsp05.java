/*
 * $Id: Bsp05.java 1579 2015-12-16 13:53:35Z michael $
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
 * Bsp 05
 *
 * @version $Revision: 1579 $
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bsp05 {

	public static void main(final String[] args) throws Exception {
		final Bsp05 bsp = new Bsp05();
		final Bsp01 b01 = new Bsp01();
		b01.attribut = "A1";
		b01.element = "Apfel";
		bsp.map.put(b01.attribut, b01);
		final Bsp01 b02 = new Bsp01();
		b02.attribut = "A2";
		b02.element = "Birne";
		bsp.map.put(b02.attribut, b02);
		final Bsp01 b03 = new Bsp01();
		b03.attribut = "A3";
		b03.element = "Banane";
		bsp.map.put(b03.attribut, b03);

		final Marshaller m = JAXBContext.newInstance(Bsp05.class).createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(bsp, new File("target/bsp05.xml"));
	}

	@XmlElement
	Map<String, Bsp01> map = new HashMap<String, Bsp01>();
}
