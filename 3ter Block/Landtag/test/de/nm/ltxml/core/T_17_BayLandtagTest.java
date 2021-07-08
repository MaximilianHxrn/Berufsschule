/*
 * $Id: T_17_BayLandtagTest.java 1580 2015-12-17 07:16:38Z michael $
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

import de.nm.ltxml.core.bez.KreisAbg;
import de.nm.ltxml.core.bez.OrdenAbg;
import de.nm.ltxml.core.bez.ParFktAbg;
import de.nm.ltxml.core.bez.ParteiAbg;
import de.nm.ltxml.core.bez.StaatAbg;

/**
 * Test for {@link BayLandtag}.
 *
 * @version $Revision: 1580 $
 */
public class T_17_BayLandtagTest {

   @SuppressWarnings("deprecation")
   private static Date d = new Date(960, 5, 13);

   @Test
   public void test_01() {
      final BayLandtag lt = new BayLandtag();
      assertNotNull(lt);
   }

   @SuppressWarnings("deprecation")
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
      abg.setTitel("Dr.");
      abg.setBeruf("Gaukler");
      abg.setGebam(d);
      abg.setGebin("München");
      abg.setGesam(d);
      abg.setGesin("München");

      final BayLandtag lt = new BayLandtag();
      lt.add(fam);
      lt.add(konf);
      lt.add(abg);

      final Orden ord = new Orden("o1", "Bayerischer Verdienstorden");
      lt.add(ord);
      lt.add(new Orden("o2", "Ritterkreuz"));

      final Staatsregierung staat = new Staatsregierung("s1",
               "Ministerpräsident");
      lt.add(staat);
      lt.add(new Staatsregierung("s2", "Finanzminster"));

      final ParFkt parfkt = new ParFkt("f1", "Ältestenrat");
      lt.add(parfkt);
      lt.add(new ParFkt("f2", "Ausschuß für den Staatshaushalt"));

      final Kreis kreis = new Kreis("kr1", "W", "Oberbayern");
      lt.add(kreis);
      lt.add(new Kreis("kr2", "S", "Würzburg-Land"));

      final Partei partei = new Partei("p1", "CSU",
               "Christlich-Soziale Union in Bayern");
      lt.add(partei);
      lt.add(new Partei("p2", "BP", "Bayernpartei"));

      // ------------
      final ParteiAbg pabg = new ParteiAbg("pabg_1");
      pabg.setAbg(abg);
      pabg.setPartei(partei);
      final Date von = new Date(100, 1, 2);
      final Date bis = new Date(110, 3, 4);
      pabg.setVon(von);
      pabg.setBis(bis);
      lt.add(pabg);

      // ------------
      final KreisAbg krbg = new KreisAbg("krbg_1");
      krbg.setAbg(abg);
      krbg.setKreis(kreis);
      krbg.setVon(von);
      krbg.setBis(bis);
      lt.add(krbg);

      // ------------
      final ParFktAbg pfbg = new ParFktAbg("pfbg_1");
      pfbg.setAbg(abg);
      pfbg.setParfkt(parfkt);
      pfbg.setVon(von);
      pfbg.setBis(bis);
      lt.add(pfbg);

      // ------------
      final StaatAbg stbg = new StaatAbg("stbg_1");
      stbg.setAbg(abg);
      stbg.setStaat(staat);
      stbg.setVon(von);
      stbg.setBis(bis);
      lt.add(stbg);

      // ------------
      final OrdenAbg orbg = new OrdenAbg("orbg_1");
      orbg.setAbg(abg);
      orbg.setOrden(ord);
      lt.add(orbg);

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

         // bei allen weiteren Tests werden die Elemente über XPATH ermittelt
         // check ord
         final XPathFactory factory = XPathFactory.instance();
         XPathExpression<Element> xp = factory.compile("/baylandtag/orden/ord",
                  Filters.element());
         final Element orde = xp.evaluateFirst(document);
         assertEquals("o1", orde.getAttributeValue("id"));
         assertEquals("Bayerischer Verdienstorden",
                  orde.getAttributeValue("bezeichnung"));

         final List<Element> ordlist = xp.evaluate(document);
         assertEquals(2, ordlist.size());
         final Element ord2 = ordlist.get(1);
         assertEquals("o2", ord2.getAttributeValue("id"));
         assertEquals("Ritterkreuz", ord2.getAttributeValue("bezeichnung"));

         // check partei
         xp = factory.compile("/baylandtag/partei/pa", Filters.element());
         List<Element> elementList = xp.evaluate(document);
         assertEquals(2, elementList.size());
         assertEquals("p1", elementList.get(0).getAttributeValue("id"));
         assertEquals("CSU", elementList.get(0).getAttributeValue("name"));
         assertEquals("Christlich-Soziale Union in Bayern",
                  elementList.get(0).getAttributeValue("bezeichnung"));
         assertEquals("p2", elementList.get(1).getAttributeValue("id"));
         assertEquals("BP", elementList.get(1).getAttributeValue("name"));
         assertEquals("Bayernpartei",
                  elementList.get(1).getAttributeValue("bezeichnung"));

         // check kreis
         xp = factory.compile("/baylandtag/kreis/kr", Filters.element());
         elementList = xp.evaluate(document);
         assertEquals(2, elementList.size());
         assertEquals("kr1", elementList.get(0).getAttributeValue("id"));
         assertEquals("W", elementList.get(0).getAttributeValue("type"));
         assertEquals("Oberbayern",
                  elementList.get(0).getAttributeValue("bezeichnung"));
         assertEquals("kr2", elementList.get(1).getAttributeValue("id"));
         assertEquals("S", elementList.get(1).getAttributeValue("type"));
         assertEquals("Würzburg-Land",
                  elementList.get(1).getAttributeValue("bezeichnung"));

         // check parfkt
         xp = factory.compile("/baylandtag/parfkt/pf", Filters.element());
         elementList = xp.evaluate(document);
         assertEquals(2, elementList.size());
         assertEquals("f1", elementList.get(0).getAttributeValue("id"));
         assertEquals("Ältestenrat",
                  elementList.get(0).getAttributeValue("bezeichnung"));
         assertEquals("f2", elementList.get(1).getAttributeValue("id"));
         assertEquals("Ausschuß für den Staatshaushalt",
                  elementList.get(1).getAttributeValue("bezeichnung"));

         // check staatsregierung
         xp = factory.compile("/baylandtag/staatsregierung/staat",
                  Filters.element());
         elementList = xp.evaluate(document);
         assertEquals(2, elementList.size());
         assertEquals("s1", elementList.get(0).getAttributeValue("id"));
         assertEquals("Ministerpräsident",
                  elementList.get(0).getAttributeValue("bezeichnung"));
         assertEquals("s2", elementList.get(1).getAttributeValue("id"));
         assertEquals("Finanzminster",
                  elementList.get(1).getAttributeValue("bezeichnung"));

         // check kreis abg
         xp = factory.compile("/baylandtag/kreisabg/krbg", Filters.element());
         elementList = xp.evaluate(document);
         assertEquals(1, elementList.size());
         assertEquals("krbg_1", elementList.get(0).getAttributeValue("id"));

      } catch (final JAXBException | JDOMException | IOException e) {
         System.err.println(e);
         assertTrue(false);
      }

   }

}
