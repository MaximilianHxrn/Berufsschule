

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Beispiel: Jdbc03ExecuteQuery
 * 
 * @author <a href="mailto:mgn.schule@gmx.de">Michael Niedermair</a>
 * @version $Revision: 1117 $
 */
public class Jdbc03ExecuteQuery {

   public static void main(final String[] args) {

      System.out.println("JDBC Execute Query");
      System.out.println("==================");

      Connection connection = null;
      Statement statement = null;

      try {

         // 1. Holen einer Connection
         connection = Help.getConnection("Beispiel");

         // 2. Erzeugen eines Statements
         statement = connection.createStatement();

         // 3. Struktur der Tabelle LIEFERANT anzeigen
         String sql1 = "DESC LIEFERANT";

         Help.formatAsText(statement.executeQuery(sql1));
         connection.close();

      } catch (SQLException e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
   }
}
