/*
 * $Id: T_20_BayLandtagTest.java 1583 2015-12-18 13:18:25Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.junit.Test;

/**
 * Test for {@link BayLandtag}.
 *
 * @version $Revision: 1583 $
 */
public class T_20_BayLandtagTest {

   @Test
   public void test_01() {
      final BayLandtag lt = new BayLandtag();
      assertNotNull(lt);
   }

   @Test
   public void test_abg_01() {

      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      abg.setTitel("Dr.");
      abg.setBeruf("Gaukler");

      final Path path = Paths.get("src/images/555500000096.jpg");

      byte[] b1 = null;
      try {
         b1 = Files.readAllBytes(path);
         abg.setBild(b1);

         assertNotNull(abg.getBild());
         assertTrue(true);
      } catch (final IOException e) {
         System.out.println(e);
         assertTrue(false);
      }

      final BayLandtag lt = new BayLandtag();
      lt.add(abg);

      // write to file
      try {
         final JAXBContext context = JAXBContext.newInstance(BayLandtag.class);
         final Marshaller m = context.createMarshaller();
         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
         m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
         final File output = new File("target/" + this.getClass().getSimpleName() + "_01.xml");
         m.marshal(lt, output);
         assertTrue(true);

         // erzeugte Datei und mit JDOM ... testen
         final SAXBuilder saxBuilder = new SAXBuilder();
         final Document document = saxBuilder.build(output);

         // check ord
         final XPathFactory factory = XPathFactory.instance();
         final XPathExpression<Element> xp = factory.compile("/baylandtag/abgeordnete/abg/bild", Filters.element());
         final Element bild = xp.evaluateFirst(document);

         final byte[] b2 = Base64.getDecoder().decode(bild.getTextNormalize());
         assertEquals(b1.length, b2.length);
         assertArrayEquals(b1, b2);

      } catch (final JAXBException | JDOMException | IOException e) {
         System.err.println(e);
         assertTrue(false);
      }
   }
}
