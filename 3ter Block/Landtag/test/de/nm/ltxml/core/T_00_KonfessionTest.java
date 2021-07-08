/*
 * $Id: T_00_KonfessionTest.java 1576 2015-12-14 12:16:43Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for {@link Konfession}.
 *
 * @version $Revision: 1576 $
 */
public class T_00_KonfessionTest {

   @Test
   public void test_01() {
      final Konfession konf = new Konfession();
      assertNotNull(konf);
      assertTrue(konf.getId() instanceof String);
      assertTrue(konf.getBezeichnung() instanceof String);
      assertEquals("??", konf.getId());
      assertEquals("??", konf.getBezeichnung());
   }

   @Test
   public void test_02() {
      final Konfession konf = new Konfession("k1", "römisch-katholisch");
      assertNotNull(konf);
      assertEquals("k1", konf.getId());
      assertEquals("römisch-katholisch", konf.getBezeichnung());
   }

   @Test
   public void test_03() {
      final Konfession konf = new Konfession("k2", "evangelisch");
      assertNotNull(konf);
      assertEquals("k2", konf.getId());
      assertEquals("evangelisch", konf.getBezeichnung());
   }

   @Test
   public void test_toString() {
      final Konfession konf = new Konfession("k2", "evangelisch");
      assertNotNull(konf);
      assertEquals("Konfession: id=k2, bezeichnung=evangelisch",
               konf.toString());
   }

}
