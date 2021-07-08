/*
 * $Id: Bsp02.java 1579 2015-12-16 13:53:35Z michael $
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
 * Bsp 02
 *
 * @version $Revision: 1579 $
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bsp02 {

	public static void main(final String[] args) throws Exception {
		final Bsp02 bsp = new Bsp02();
		bsp.element = "Element";
		bsp.attribut = "Attribut";

		final Marshaller m = JAXBContext.newInstance(Bsp02.class).createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(bsp, new File("target/bsp02.xml"));
	}

	@XmlAttribute(name = "att")
	String attribut;

	@XmlElement(name = "el")
	String element;
}
