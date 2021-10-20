

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Beispiel: Jdbc05PreparedStatements
 *
 * @author <a href="mailto:mgn.schule@gmx.de">Michael Niedermair</a>
 * @version $Revision: 1537 $
 */
public class Jdbc05PreparedStatements {

   public static void main(final String[] args) {

      System.out.println("JDBC Prepared Statements");
      System.out.println("========================");

      Connection connection = null;
      PreparedStatement pst = null;

      try {

         // 1. Holen einer Connection
         connection = Help.getConnection("stufe2");

         // 2. Prepared Statement erzeugen
         pst = connection
                  .prepareStatement("SELECT * from SPIELER WHERE Geschlecht=?");

         // 3. Werte zuweisen
         pst.setString(1, "weiblich");

         Help.formatAsText(pst.executeQuery());

         connection.close();

      } catch (SQLException e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
   }
}
