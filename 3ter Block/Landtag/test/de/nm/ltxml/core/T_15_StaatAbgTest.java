/*
 * $Id: T_15_StaatAbgTest.java 1627 2016-04-23 07:09:04Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import de.nm.ltxml.core.bez.StaatAbg;

/**
 * Test for {@link StaatAbg}.
 *
 * @version $Revision: 1627 $
 */
public class T_15_StaatAbgTest {

   @Test
   public void test_01() {

      final StaatAbg stbg = new StaatAbg();
      assertNotNull(stbg);
      assertTrue(stbg.getId() instanceof String);
      assertEquals("??", stbg.getId());
   }

   @SuppressWarnings("deprecation")
   @Test
   public void test_02() {

      final StaatAbg stbg = new StaatAbg("stbg_1");
      assertNotNull(stbg);

      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      final Staatsregierung staat = new Staatsregierung("s1", "Ministerpräsident");

      stbg.setAbg(abg);
      stbg.setStaat(staat);
      final Date von = new Date(100, 1, 2);
      final Date bis = new Date(110, 3, 4);
      stbg.setVon(von);
      stbg.setBis(bis);

      assertEquals("StaatAbg: id=stbg_1, abg=Abgeordneter: id=a1, name=Kobold, vorname=Pumukel, "
            + "titel=??, beruf=??, gebam=null, gebin=??, gesam=null, gesin=??, konf=null, "
            + "fam=null, staat=Staatsregierung: id=s1, bezeichnung=Ministerpräsident, "
            + "von=Wed Feb 02 00:00:00 CET 2000, bis=Sun Apr 04 00:00:00 CEST 2010", stbg.toString());

      // in Abgeordneter eingetragen?
      assertEquals(1, abg.getSetStaatAbg().size());
      assertTrue(abg.getSetStaatAbg().contains(stbg));

      // in Partei eingetragen?
      assertEquals(1, staat.getSetStaatAbg().size());
      assertTrue(staat.getSetStaatAbg().contains(stbg));

   }

}
