/*
 * $Id: Bsp01.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.bsp;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bsp 01
 *
 * @version $Revision: 1579 $
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bsp01 {

	public static void main(final String[] args) throws Exception {
		final Bsp01 bsp = new Bsp01();
		bsp.element = "Element";
		bsp.attribut = "Attribut";

		final Marshaller m = JAXBContext.newInstance(Bsp01.class).createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(bsp, new File("target/bsp01.xml"));
	}

	@XmlAttribute
	String attribut;

	@XmlElement
	String element;
}
