/*
 * $Id: T_01_FamilienstandTest.java 1576 2015-12-14 12:16:43Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for {@link Familienstand}.
 *
 * @version $Revision: 1576 $
 */
public class T_01_FamilienstandTest {

   @Test
   public void test_01() {
      final Familienstand fam = new Familienstand();
      assertNotNull(fam);
      assertTrue(fam.getId() instanceof String);
      assertTrue(fam.getBezeichnung() instanceof String);
      assertEquals("??", fam.getId());
      assertEquals("??", fam.getBezeichnung());
   }

   @Test
   public void test_02() {
      final Familienstand fam = new Familienstand("f0", "keine Angabe");
      assertNotNull(fam);
      assertEquals("f0", fam.getId());
      assertEquals("keine Angabe", fam.getBezeichnung());
   }

   @Test
   public void test_03() {
      final Familienstand fam = new Familienstand("f1", "ledig");
      assertNotNull(fam);
      assertEquals("f1", fam.getId());
      assertEquals("ledig", fam.getBezeichnung());
   }

   @Test
   public void test_toString() {
      final Familienstand fam = new Familienstand("f1", "ledig");
      assertNotNull(fam);
      assertEquals("Familienstand: id=f1, bezeichnung=ledig", fam.toString());
   }
}
