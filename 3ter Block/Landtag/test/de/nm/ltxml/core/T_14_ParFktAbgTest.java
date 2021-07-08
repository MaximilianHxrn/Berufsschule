/*
 * $Id: T_14_ParFktAbgTest.java 1598 2016-01-01 18:36:14Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import de.nm.ltxml.core.bez.ParFktAbg;

/**
 * Test for {@link ParFktAbg}.
 *
 * @version $Revision: 1598 $
 */
public class T_14_ParFktAbgTest {

	@Test
	public void test_01() {

		final ParFktAbg pfbg = new ParFktAbg();
		assertNotNull(pfbg);
		assertTrue(pfbg.getId() instanceof String);
		assertEquals("??", pfbg.getId());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_02() {

		final ParFktAbg pfbg = new ParFktAbg("pfbg_1");
		assertNotNull(pfbg);

		final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
		final ParFkt parfkt = new ParFkt("f1", "Ältestenrat");

		pfbg.setAbg(abg);
		pfbg.setParfkt(parfkt);
		final Date von = new Date(100, 1, 2);
		final Date bis = new Date(110, 3, 4);
		pfbg.setVon(von);
		pfbg.setBis(bis);

		assertEquals("ParFktAbg: id=pfbg_1, abg=Abgeordneter: id=a1, name=Kobold, vorname=Pumukel, "
				+ "titel=??, beruf=??, gebam=null, gebin=??, gesam=null, gesin=??, "
				+ "konf=null, fam=null, type=null, parfkt=ParFkt: id=f1, "
				+ "bezeichnung=Ältestenrat, von=Wed Feb 02 00:00:00 CET 2000, " + "bis=Sun Apr 04 00:00:00 CEST 2010",
				pfbg.toString());

		// in Abgeordneter eingetragen?
		assertEquals(1, abg.getSetParFktAbg().size());
		assertTrue(abg.getSetParFktAbg().contains(pfbg));

		// in Partei eingetragen?
		assertEquals(1, parfkt.getSetParFktAbg().size());
		assertTrue(parfkt.getSetParFktAbg().contains(pfbg));

	}

}
