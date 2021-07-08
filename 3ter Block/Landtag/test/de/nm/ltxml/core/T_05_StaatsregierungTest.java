/*
 * $Id: T_05_StaatsregierungTest.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for {@link Staatsregierung}.
 *
 * @version $Revision: 1579 $
 */
public class T_05_StaatsregierungTest {

   @Test
   public void test_01() {
      final Staatsregierung staat = new Staatsregierung();
      assertNotNull(staat);
      assertTrue(staat.getId() instanceof String);
      assertTrue(staat.getBezeichnung() instanceof String);
      assertEquals("??", staat.getId());
      assertEquals("??", staat.getBezeichnung());
   }

   @Test
   public void test_02() {
      final Staatsregierung staat = new Staatsregierung("s1", "Ministerpräsident");
      assertNotNull(staat);
      assertEquals("s1", staat.getId());
      assertEquals("Ministerpräsident", staat.getBezeichnung());
   }

   @Test
   public void test_03() {
      final Staatsregierung staat = new Staatsregierung("s2", "Finanzminster");
      assertNotNull(staat);
      assertEquals("s2", staat.getId());
      assertEquals("Finanzminster", staat.getBezeichnung());
   }

   @Test
   public void test_toString() {
      final Staatsregierung staat = new Staatsregierung("s2", "Finanzminster");
      assertNotNull(staat);
      assertEquals("Staatsregierung: id=s2, bezeichnung=Finanzminster", staat.toString());
   }

}
