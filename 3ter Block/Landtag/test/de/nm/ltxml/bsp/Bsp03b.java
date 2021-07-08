/*
 * $Id: Bsp03b.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.bsp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bsp 03b
 *
 * @version $Revision: 1579 $
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bsp03b {

	public static void main(final String[] args) throws Exception {
		final Bsp03b bsp = new Bsp03b();
		bsp.liste.add("Apfel");
		bsp.liste.add("Birne");
		bsp.liste.add("Banane");

		final Marshaller m = JAXBContext.newInstance(Bsp03b.class).createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(bsp, new File("target/bsp03b.xml"));
	}

	@XmlElement(name = "liste")
	@XmlElementWrapper(name = "muesli")
	List<String> liste = new ArrayList<String>();
}
