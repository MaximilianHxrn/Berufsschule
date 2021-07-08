/*
 * $Id: T_16_OrdenAbgTest.java 1580 2015-12-17 07:16:38Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.nm.ltxml.core.bez.OrdenAbg;

/**
 * Test for {@link OrdenAbg}.
 *
 * @version $Revision: 1580 $
 */
public class T_16_OrdenAbgTest {

   @Test
   public void test_01() {

      final OrdenAbg orbg = new OrdenAbg();
      assertNotNull(orbg);
      assertTrue(orbg.getId() instanceof String);
      assertEquals("??", orbg.getId());
   }

   @SuppressWarnings("deprecation")
   @Test
   public void test_02() {

      final OrdenAbg orbg = new OrdenAbg("orbg_1");
      assertNotNull(orbg);

      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      final Orden ord = new Orden("o1", "Bayerischer Verdienstorden");

      orbg.setAbg(abg);
      orbg.setOrden(ord);

      assertEquals(
               "OrdenAbg: id=orbg_1, abg=Abgeordneter: id=a1, name=Kobold, vorname=Pumukel, "
                        + "titel=??, beruf=??, gebam=null, gebin=??, gesam=null, gesin=??, konf=null, "
                        + "fam=null, orden=Orden: id=o1, bezeichnung=Bayerischer Verdienstorden",
               orbg.toString());

      // in Abgeordneter eingetragen?
      assertEquals(1, abg.getSetOrdenAbg().size());
      assertTrue(abg.getSetOrdenAbg().contains(orbg));

      // in Partei eingetragen?
      assertEquals(1, ord.getSetOrdenAbg().size());
      assertTrue(ord.getSetOrdenAbg().contains(orbg));

   }

}
