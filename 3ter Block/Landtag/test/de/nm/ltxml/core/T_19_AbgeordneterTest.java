/*
 * $Id: T_19_AbgeordneterTest.java 1583 2015-12-18 13:18:25Z michael $
 */
package de.nm.ltxml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * Test for {@link Abgeordneter}.
 *
 * @version $Revision: 1583 $
 */
public class T_19_AbgeordneterTest {

   @Test
   public void test_01() {
      final Abgeordneter abg = new Abgeordneter();
      assertNotNull(abg);
      assertTrue(abg.getId() instanceof String);
      assertTrue(abg.getName() instanceof String);
      assertTrue(abg.getVorname() instanceof String);
      assertEquals("??", abg.getId());
      assertEquals("??", abg.getName());
      assertEquals("??", abg.getVorname());
   }

   @Test
   public void test_02() {
      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      assertNotNull(abg);
      assertTrue(abg.getId() instanceof String);
      assertTrue(abg.getName() instanceof String);
      assertTrue(abg.getVorname() instanceof String);
      assertEquals("a1", abg.getId());
      assertEquals("Kobold", abg.getName());
      assertEquals("Pumukel", abg.getVorname());
   }

   @Test
   public void test_03() {
      final Abgeordneter abg = new Abgeordneter("a1", "Kobold", "Pumukel");
      assertNotNull(abg);

      try {
         // File input = new File("src/images/555500000096.jpg");

         final Path path = Paths.get("src/images/555500000096.jpg");

         abg.setBild(Files.readAllBytes(path));

         assertNotNull(abg.getBild());
         assertTrue(true);
      } catch (final IOException e) {
         System.out.println(e);
         assertTrue(false);
      }
   }

}
