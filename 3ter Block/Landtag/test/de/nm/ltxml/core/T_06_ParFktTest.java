/*
 * $Id: T_06_ParFktTest.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for {@link ParFkt}.
 *
 * @version $Revision: 1579 $
 */
public class T_06_ParFktTest {

   @Test
   public void test_01() {
      final ParFkt parfkt = new ParFkt();
      assertNotNull(parfkt);
      assertTrue(parfkt.getId() instanceof String);
      assertTrue(parfkt.getBezeichnung() instanceof String);
      assertEquals("??", parfkt.getId());
      assertEquals("??", parfkt.getBezeichnung());
   }

   @Test
   public void test_02() {
      final ParFkt parfkt = new ParFkt("f1", "Ältestenrat");
      assertNotNull(parfkt);
      assertEquals("f1", parfkt.getId());
      assertEquals("Ältestenrat", parfkt.getBezeichnung());
   }

   @Test
   public void test_03() {
      final ParFkt parfkt = new ParFkt("f2", "Ausschuß für den Staatshaushalt");
      assertNotNull(parfkt);
      assertEquals("f2", parfkt.getId());
      assertEquals("Ausschuß für den Staatshaushalt", parfkt.getBezeichnung());
   }

   @Test
   public void test_toString() {
      final ParFkt parfkt = new ParFkt("f2", "Ausschuß für den Staatshaushalt");
      assertNotNull(parfkt);
      assertEquals("ParFkt: id=f2, bezeichnung=Ausschuß für den Staatshaushalt", parfkt.toString());
   }

}
