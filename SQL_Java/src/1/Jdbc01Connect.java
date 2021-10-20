import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Jdbc01Connect {
   public static void main(final String[] args) {

      System.out.println("JDBC Connection Test");
      System.out.println("====================");

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");

         System.out.println("MySQL JDBC-Treiber geladen!");

         // 2. Öffnen einer Connection zur DB
         Connection connection = Help.getConnection("Beispiel");

         if (connection != null) {
            System.out.println("Connection erfolgreich aufgebaut!");
         } else {
            System.out.println("Connection konnte nicht aufgebaut werden!");
            return;
         }

         // 3. Lesen von Metadaten der DB:
         DatabaseMetaData dbmd = connection.getMetaData();
         System.out.println("Metadaten der Datenbank:");
         System.out.println("DB          : " + dbmd.getDatabaseProductName());
         System.out.println("Version     : " + dbmd.getDatabaseMajorVersion());
         System.out.println("Treiber     : " + dbmd.getDriverName());

         // 4. Schließen der Connection
         if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Connection wurde wieder geschloßen!");
         }

      } catch (ClassNotFoundException e) {
         System.out.println("MySQL JDBC-Treiber nicht gefunden!\n");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("SQL-Fehler");
         e.printStackTrace();
      }
   }
}
