/*
 * $Id: T_07_KreisTest.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for {@link Kreis}.
 *
 * @version $Revision: 1579 $
 */
public class T_07_KreisTest {

   @Test
   public void test_01() {
      final Kreis kreis = new Kreis();
      assertNotNull(kreis);
      assertTrue(kreis.getId() instanceof String);
      assertTrue(kreis.getType() instanceof String);
      assertTrue(kreis.getBezeichnung() instanceof String);
      assertEquals("??", kreis.getId());
      assertEquals("?", kreis.getType());
      assertEquals("??", kreis.getBezeichnung());
   }

   @Test
   public void test_02() {
      final Kreis kreis = new Kreis("kr1", "W", "Oberbayern");
      assertNotNull(kreis);
      assertEquals("kr1", kreis.getId());
      assertEquals("W", kreis.getType());
      assertEquals("Oberbayern", kreis.getBezeichnung());
   }

   @Test
   public void test_03() {
      final Kreis kreis = new Kreis("kr2", "S", "Würzburg-Land");
      assertNotNull(kreis);
      assertEquals("kr2", kreis.getId());
      assertEquals("S", kreis.getType());
      assertEquals("Würzburg-Land", kreis.getBezeichnung());
   }

   @Test
   public void test_toString() {
      final Kreis kreis = new Kreis("kr2", "S", "Würzburg-Land");
      assertNotNull(kreis);
      assertEquals("Kreis: type=S, id=kr2, bezeichnung=Würzburg-Land",
               kreis.toString());
   }

}
