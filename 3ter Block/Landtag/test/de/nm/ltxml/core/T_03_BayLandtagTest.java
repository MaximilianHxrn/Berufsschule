/*
 * $Id: T_03_BayLandtagTest.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

/**
 * Test for {@link BayLandtag}.
 *
 * @version $Revision: 1579 $
 */
public class T_03_BayLandtagTest {

   @Test
   public void test_01() {
      final BayLandtag lt = new BayLandtag();
      assertNotNull(lt);
   }

   @Test
   public void test_abg_01() {

      final Konfession konf = new Konfession("k1", "römisch-katholisch");
      assertNotNull(konf);
      assertEquals("k1", konf.getId());
      assertEquals("römisch-katholisch", konf.getBezeichnung());

      final Familienstand fam = new Familienstand("f1", "ledig");
      assertNotNull(fam);
      assertEquals("f1", fam.getId());
      assertEquals("ledig", fam.getBezeichnung());

      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      abg.setFam(fam);
      abg.setKonf(konf);

      final BayLandtag lt = new BayLandtag();
      lt.add(fam);
      lt.add(konf);
      lt.add(abg);

      // write to file
      try {
         final JAXBContext context = JAXBContext.newInstance(BayLandtag.class);
         final Marshaller m = context.createMarshaller();
         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
         m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
         final File output = new File(
                  System.getProperty("user.dir") + "/" + this.getClass().getSimpleName() + "_01.xml");
         m.marshal(lt, output);
         assertTrue(true);

         // erzeugte Datei und mit JDOM ... testen
         final SAXBuilder saxBuilder = new SAXBuilder();
         final Document document = saxBuilder.build(output);
         final Element root = document.getRootElement();

         // check root
         assertEquals("baylandtag", root.getName());

         // check abg
         final Element abge = root.getChild("abgeordnete").getChild("abg");
         assertEquals("a1", abge.getAttributeValue("id"));
         assertEquals("Kobold", abge.getAttributeValue("name"));

         // check fam
         final Element fame = root.getChild("familie").getChild("fam");
         assertEquals("f1", fame.getAttributeValue("id"));
         assertEquals("ledig", fame.getAttributeValue("bezeichnung"));

         // check konf
         final Element konfe = root.getChild("konfession").getChild("konf");
         assertEquals("k1", konfe.getAttributeValue("id"));
         assertEquals("römisch-katholisch",
                  konfe.getAttributeValue("bezeichnung"));

      } catch (final JAXBException | IOException | JDOMException e) {
         System.err.println(e);
         assertTrue(false);
      }
   }
}
