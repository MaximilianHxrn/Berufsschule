/*
 * $Id: T_08_ParteiTest.java 1579 2015-12-16 13:53:35Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for {@link Partei}.
 *
 * @version $Revision: 1579 $
 */
public class T_08_ParteiTest {

   @Test
   public void test_01() {
      final Partei partei = new Partei();
      assertNotNull(partei);
      assertTrue(partei.getId() instanceof String);
      assertTrue(partei.getName() instanceof String);
      assertTrue(partei.getBezeichnung() instanceof String);
      assertEquals("??", partei.getId());
      assertEquals("??", partei.getName());
      assertEquals("??", partei.getBezeichnung());
   }

   @Test
   public void test_02() {
      final Partei partei = new Partei("p1", "CSU", "Christlich-Soziale Union in Bayern");
      assertNotNull(partei);
      assertEquals("p1", partei.getId());
      assertEquals("CSU", partei.getName());
      assertEquals("Christlich-Soziale Union in Bayern", partei.getBezeichnung());
   }

   @Test
   public void test_03() {
      final Partei partei = new Partei("p2", "BP", "Bayernpartei");
      assertNotNull(partei);
      assertEquals("p2", partei.getId());
      assertEquals("BP", partei.getName());
      assertEquals("Bayernpartei", partei.getBezeichnung());
   }

   @Test
   public void test_toString() {
      final Partei partei = new Partei("p2", "BP", "Bayernpartei");
      assertNotNull(partei);
      assertEquals("Partei: name=BP, id=p2, bezeichnung=Bayernpartei", partei.toString());
   }

}
