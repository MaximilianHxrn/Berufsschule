import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC06FinalTask {
    public static void main(final String[] args) {
        try {
            Connection connection = null;
            connection = Help.getConnection("stufe2");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("show tables;");
            while (rs.next()) {
                Statement temp_stmt = connection.createStatement();
                System.out.println("Table " + rs.getString(1) + ":");
                Help.formatAsText(temp_stmt.executeQuery("desc " + rs.getString(1) + ";"));
                System.out.println("");
            }
            rs = stmt.executeQuery("show tables;");
            while (rs.next()) {
                Statement temp_stmt = connection.createStatement();
                System.out.println("Show Create Table " + rs.getString(1) + ":");
                Help.formatAsText(temp_stmt.executeQuery("show create table " + rs.getString(1) + ";"), false);
                System.out.println("");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}