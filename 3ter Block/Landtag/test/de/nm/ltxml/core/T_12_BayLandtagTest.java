/*
 * $Id: T_12_BayLandtagTest.java 1580 2015-12-17 07:16:38Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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

import de.nm.ltxml.core.bez.ParteiAbg;

/**
 * Test for {@link BayLandtag}.
 *
 * @version $Revision: 1580 $
 */
public class T_12_BayLandtagTest {

   @Test
   public void test_01() {
      final BayLandtag lt = new BayLandtag();
      assertNotNull(lt);
   }

   @SuppressWarnings("deprecation")
   @Test
   public void test_abg_01() {

      final ParteiAbg pabg = new ParteiAbg("pabg_1");
      assertNotNull(pabg);

      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      final Partei partei = new Partei("p1", "CSU",
               "Christlich-Soziale Union in Bayern");

      pabg.setAbg(abg);
      pabg.setPartei(partei);
      final Date von = new Date(100, 1, 2);
      final Date bis = new Date(110, 3, 4);
      pabg.setVon(von);
      pabg.setBis(bis);

      final BayLandtag lt = new BayLandtag();
      lt.add(abg);
      lt.add(partei);
      lt.add(pabg);

      // Eintrag 2
      final ParteiAbg pabg2 = new ParteiAbg("pabg_2");
      assertNotNull(pabg2);

      pabg2.setAbg(abg);
      pabg2.setPartei(partei);
      final Date von2 = new Date(90, 1, 2);
      final Date bis2 = new Date(98, 3, 4);
      pabg2.setVon(von2);
      pabg2.setBis(bis2);

      lt.add(pabg2);

      // write to file
      try {
         final JAXBContext context = JAXBContext.newInstance(BayLandtag.class);
         final Marshaller m = context.createMarshaller();
         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
         m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
         final File output = new File(
                  "target/" + this.getClass().getSimpleName() + "_01.xml");
         m.marshal(lt, output);
         assertTrue(true);

         // erzeugte Datei und mit JDOM ... testen
         final SAXBuilder saxBuilder = new SAXBuilder();
         final Document document = saxBuilder.build(output);
         final Element root = document.getRootElement();

         // check root
         assertEquals("baylandtag", root.getName());

         // check partei
         final XPathFactory factory = XPathFactory.instance();
         XPathExpression<Element> xp = factory.compile("/baylandtag/partei/pa",
                  Filters.element());

         List<Element> liste = xp.evaluate(document);
         assertEquals(1, liste.size());
         assertEquals("p1", liste.get(0).getAttributeValue("id"));
         assertEquals("CSU", liste.get(0).getAttributeValue("name"));
         assertEquals("Christlich-Soziale Union in Bayern",
                  liste.get(0).getAttributeValue("bezeichnung"));

         // check partei - pabg
         xp = factory.compile("/baylandtag/partei/pa/parteiabg/pabg",
                  Filters.element());
         liste = xp.evaluate(document);
         assertEquals(2, liste.size());
         assertEquals("pabg_1", liste.get(0).getText());
         assertEquals("pabg_2", liste.get(1).getText());

         // check abgeordnete
         xp = factory.compile("/baylandtag/abgeordnete/abg", Filters.element());
         liste = xp.evaluate(document);
         assertEquals(1, liste.size());
         assertEquals("a1", liste.get(0).getAttributeValue("id"));
         assertEquals("Kobold", liste.get(0).getAttributeValue("name"));
         assertEquals("Pumukel", liste.get(0).getAttributeValue("vorname"));

         // check partei - pabg
         xp = factory.compile("/baylandtag/abgeordnete/abg/parteiabg/pabg",
                  Filters.element());
         liste = xp.evaluate(document);
         assertEquals(2, liste.size());
         assertEquals("pabg_1", liste.get(0).getText());
         assertEquals("pabg_2", liste.get(1).getText());

      } catch (final JAXBException | JDOMException | IOException e) {
         System.err.println(e);
         assertTrue(false);
      }

   }

}
