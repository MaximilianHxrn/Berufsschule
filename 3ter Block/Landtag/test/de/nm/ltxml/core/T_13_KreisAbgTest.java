/*
 * $Id: T_13_KreisAbgTest.java 1580 2015-12-17 07:16:38Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import de.nm.ltxml.core.bez.KreisAbg;

/**
 * Test for {@link KreisAbg}.
 *
 * @version $Revision: 1580 $
 */
public class T_13_KreisAbgTest {

   @Test
   public void test_01() {

      final KreisAbg krbg = new KreisAbg();
      assertNotNull(krbg);
      assertTrue(krbg.getId() instanceof String);
      assertEquals("??", krbg.getId());
   }

   @SuppressWarnings("deprecation")
   @Test
   public void test_02() {

      final KreisAbg krbg = new KreisAbg("krbg_1");
      assertNotNull(krbg);

      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      final Kreis kreis = new Kreis("kr1", "W", "Oberbayern");

      krbg.setAbg(abg);
      krbg.setKreis(kreis);
      final Date von = new Date(100, 1, 2);
      final Date bis = new Date(110, 3, 4);
      krbg.setVon(von);
      krbg.setBis(bis);

      assertEquals(
               "KreisAbg: id=krbg_1, abg=Abgeordneter: id=a1, name=Kobold, vorname=Pumukel, "
                        + "titel=??, beruf=??, gebam=null, gebin=??, gesam=null, gesin=??, konf=null, fam=null, "
                        + "kreis=Kreis: type=W, id=kr1, bezeichnung=Oberbayern, von=Wed Feb 02 00:00:00 CET 2000, bis=Sun Apr 04 00:00:00 CEST 2010",
               krbg.toString());

      // in Abgeordneter eingetragen?
      assertEquals(1, abg.getSetKreisAbg().size());
      assertTrue(abg.getSetKreisAbg().contains(krbg));

      // in Partei eingetragen?
      assertEquals(1, kreis.getSetKreisAbg().size());
      assertTrue(kreis.getSetKreisAbg().contains(krbg));

   }

}
