/*
 * $Id: Bsp06.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.bsp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Bsp 06
 *
 * @version $Revision: 1579 $
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bsp06 {

	/** MapAdapter */
	public static class MapAdapter extends XmlAdapter<MapElements[], Map<String, String>> {
		public MapAdapter() {
		}

		@Override
		public MapElements[] marshal(final Map<String, String> arg0) throws Exception {
			final MapElements[] mapElements = new MapElements[arg0.size()];
			int i = 0;
			for (final Map.Entry<String, String> entry : arg0.entrySet()) {
				mapElements[i++] = new MapElements(entry.getKey(), entry.getValue());
			}
			return mapElements;
		}

		@Override
		public Map<String, String> unmarshal(final MapElements[] arg0) throws Exception {
			final Map<String, String> r = new HashMap<String, String>();
			for (final MapElements mapelement : arg0) {
				r.put(mapelement.key, mapelement.value);
			}
			return r;
		}
	}

	/** MapElements */
	public static class MapElements {
		@XmlAttribute
		public String key;
		@XmlAttribute
		public String value;

		private MapElements() {
		} // Required by JAXB

		public MapElements(final String key, final String value) {
			this.key = key;
			this.value = value;
		}
	}

	/** main */
	public static void main(final String[] args) throws Exception {
		final Bsp06 bsp = new Bsp06();
		bsp.map.put("A1", "Apfel");
		bsp.map.put("A2", "Birne");
		bsp.map.put("A3", "Banane");

		final Marshaller m = JAXBContext.newInstance(Bsp06.class).createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(bsp, new File("target/bsp06.xml"));
	}

	@XmlJavaTypeAdapter(MapAdapter.class)
	@XmlElement
	Map<String, String> map = new HashMap<String, String>();
}
