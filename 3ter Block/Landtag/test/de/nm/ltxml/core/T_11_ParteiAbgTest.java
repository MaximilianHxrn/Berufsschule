/*
 * $Id: T_11_ParteiAbgTest.java 1580 2015-12-17 07:16:38Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import de.nm.ltxml.core.bez.ParteiAbg;

/**
 * Test for {@link ParteiAbg}.
 *
 * @version $Revision: 1580 $
 */
public class T_11_ParteiAbgTest {

   @Test
   public void test_01() {

      final ParteiAbg pabg = new ParteiAbg();
      assertNotNull(pabg);
      assertTrue(pabg.getId() instanceof String);
      assertEquals("??", pabg.getId());
   }

   @SuppressWarnings("deprecation")
   @Test
   public void test_02() {

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

      assertEquals(
               "ParteiAbg: id=pabg_1, "
                        + "abg=Abgeordneter: id=a1, name=Kobold, vorname=Pumukel, titel=??, beruf=??, gebam=null, gebin=??, gesam=null, gesin=??, konf=null, fam=null, "
                        + "partei=Partei: name=CSU, id=p1, bezeichnung=Christlich-Soziale Union in Bayern, "
                        + "von=Wed Feb 02 00:00:00 CET 2000, bis=Sun Apr 04 00:00:00 CEST 2010",
               pabg.toString());

      // in Abgeordneter eingetragen?
      assertEquals(1, abg.getSetParteiAbg().size());
      assertTrue(abg.getSetParteiAbg().contains(pabg));

      // in Partei eingetragen?
      assertEquals(1, partei.getSetParteiAbg().size());
      assertTrue(partei.getSetParteiAbg().contains(pabg));

   }

}
