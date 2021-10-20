
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc02ExecuteUpdate {

   public static void main(final String[] args) throws SQLException {

      System.out.println("JDBC Execute Update");
      System.out.println("===================");

      Connection connection = null;
      Statement statement = null;

      try {

         // 1. Holen einer Connection
         connection = Help.getConnection("Beispiel");

         // 2. Erzeugen eines Statements
         statement = connection.createStatement();

         // 3. Tabelle LIEFERANT löschen, wenn diese vorhanden ist
         String sql1 = "drop table if exists Lieferant;";
         statement.executeUpdate(sql1);

         // 4. Tabelle LIEFERANT erstellen

         String sql2 = "CREATE TABLE LIEFERANT (id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, created TIMESTAMP, updated TIMESTAMP DEFAULT {ts '2013-01-01 01:00:00.0'});";
         statement.executeUpdate(sql2);

         // 5: Daten einfügen
         // INSERT INTO LIEFERANT SET name="Niedermair";
         // INSERT INTO LIEFERANT SET name="Müller";
         // INSERT INTO LIEFERANT SET name="Maier";
         statement.addBatch("insert into lieferant set name=\"Niedermair\";");
         statement.addBatch("INSERT INTO LIEFERANT SET name=\"Müller\";");
         statement.addBatch("INSERT INTO LIEFERANT SET name=\"Maier\";");

         statement.executeBatch();
         Help.formatAsText(statement.executeQuery("select * from lieferant;"));
      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      } finally {
         statement.close();
         connection.close();
      }
   }
}
