/*
 * $Id: T_04_OrdenTest.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for {@link Orden}.
 *
 * @version $Revision: 1579 $
 */
public class T_04_OrdenTest {

   @Test
   public void test_01() {
      final Orden ord = new Orden();
      assertNotNull(ord);
      assertTrue(ord.getId() instanceof String);
      assertTrue(ord.getBezeichnung() instanceof String);
      assertEquals("??", ord.getId());
      assertEquals("??", ord.getBezeichnung());
   }

   @Test
   public void test_02() {
      final Orden ord = new Orden("o1", "Bayerischer Verdienstorden");
      assertNotNull(ord);
      assertEquals("o1", ord.getId());
      assertEquals("Bayerischer Verdienstorden", ord.getBezeichnung());
   }

   @Test
   public void test_03() {
      final Orden ord = new Orden("o2", "Ritterkreuz");
      assertNotNull(ord);
      assertEquals("o2", ord.getId());
      assertEquals("Ritterkreuz", ord.getBezeichnung());
   }

   @Test
   public void test_toString() {
      final Orden ord = new Orden("02", "Ritterkreuz");
      assertNotNull(ord);
      assertEquals("Orden: id=02, bezeichnung=Ritterkreuz", ord.toString());
   }

}
