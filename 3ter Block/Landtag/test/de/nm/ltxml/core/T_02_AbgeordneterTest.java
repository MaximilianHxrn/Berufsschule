/*
 * $Id: T_02_AbgeordneterTest.java 1582 2015-12-18 09:53:15Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

/**
 * Test for {@link Abgeordneter}.
 *
 * @version $Revision: 1582 $
 */
public class T_02_AbgeordneterTest {

   @SuppressWarnings("deprecation")
   private static Date d = new Date(1960, 5, 13);

   @Test
   public void test_01() {
      final Abgeordneter abg = new Abgeordneter();
      assertNotNull(abg);
      assertTrue(abg.getId() instanceof String);
      assertTrue(abg.getName() instanceof String);
      assertTrue(abg.getVorname() instanceof String);
      assertEquals("??", abg.getId());
      assertEquals("??", abg.getName());
      assertEquals("??", abg.getVorname());
   }

   @Test
   public void test_02() {
      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      assertNotNull(abg);
      assertTrue(abg.getId() instanceof String);
      assertTrue(abg.getName() instanceof String);
      assertTrue(abg.getVorname() instanceof String);
      assertEquals("a1", abg.getId());
      assertEquals("Kobold", abg.getName());
      assertEquals("Pumukel", abg.getVorname());
   }

   @Test
   public void test_03() {
      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      abg.setTitel("Dr.");
      abg.setBeruf("Gaukler");
      abg.setGebam(d);
      abg.setGebin("München");
      abg.setGesam(d);
      abg.setGesin("München");
      assertNotNull(abg);
      assertTrue(abg.getTitel() instanceof String);
      assertTrue(abg.getBeruf() instanceof String);
      assertTrue(abg.getGebam() instanceof Date);
      assertTrue(abg.getGebin() instanceof String);
      assertTrue(abg.getGesam() instanceof Date);
      assertTrue(abg.getGesin() instanceof String);
      assertEquals("Dr.", abg.getTitel());
      assertEquals("Gaukler", abg.getBeruf());
      assertEquals(d, abg.getGebam());
      assertEquals("München", abg.getGebin());
      assertEquals(d, abg.getGesam());
      assertEquals("München", abg.getGesin());
   }

   @Test
   public void test_toString() {
      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      abg.setTitel("Dr.");
      abg.setBeruf("Gaukler");
      abg.setGebam(d);
      abg.setGebin("München");
      abg.setGesam(d);
      abg.setGesin("München");
      assertNotNull(abg);
      assertEquals(
            "Abgeordneter: id=a1, name=Kobold, vorname=Pumukel, titel=Dr., "
                  + "beruf=Gaukler, gebam=Wed Jun 13 00:00:00 CEST 3860, "
                  + "gebin=München, gesam=Wed Jun 13 00:00:00 CEST 3860, " + "gesin=München, konf=null, fam=null",
            abg.toString());
   }
}
