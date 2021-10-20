import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class Help {
    private static String pw = "Max69546463272386954";

    public static Connection getConnection(String db) throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/" + db + "?allowMultipleQueries=true&useSSL=false&serverTimezone=GMT",
            "root",
            "Max69546463272386954"
         );
    }

    public static void formatAsText(ResultSet result_set) throws SQLException {
        ResultSetMetaData meta_data = result_set.getMetaData();
        // Maximum widths of each column.
        int[] max_widths = new int[meta_data.getColumnCount()];
        @SuppressWarnings("unchecked")
        Vector<String>[] data = new Vector[meta_data.getColumnCount()];
        for (int i = 0; i < data.length; ++i) {
            data[i] = new Vector<>();
        }
        int row_count = 0;

        for (int i = 0; i < data.length; ++i) {
            String str = meta_data.getColumnLabel(i + 1);
            max_widths[i] = Math.max(str.length(), max_widths[i]);
        }

        // Read in the data for the result set,
        while (result_set.next()) {
            for (int i = 0; i < data.length; ++i) {
                Object ob = result_set.getObject(i + 1);
                String str = "NULL";
                if (ob != null) {
                    str = ob.toString();
                }
                data[i].addElement(str);
                max_widths[i] = Math.max(str.length(), max_widths[i]);
            }
            ++row_count;
        }

        // Output the data we stored
        String[] line = new String[data.length];

        writeBreak(max_widths);
        for (int n = 0; n < line.length; ++n) {
            line[n] = meta_data.getColumnLabel(n + 1);
        }
        writeRow(max_widths, line);
        writeBreak(max_widths);
        for (int i = 0; i < row_count; ++i) {
            for (int n = 0; n < line.length; ++n) {
                line[n] = (String) data[n].elementAt(i);
            }
            writeRow(max_widths, line);
        }
        writeBreak(max_widths);

    }

    public static void formatAsText(ResultSet result_set, boolean withHeader) throws SQLException {
        if (withHeader) {
            formatAsText(result_set);
            return;
        }
        ResultSetMetaData meta_data = result_set.getMetaData();
        // Maximum widths of each column.
        int[] max_widths = new int[meta_data.getColumnCount()];
        @SuppressWarnings("unchecked")
        Vector<String>[] data = new Vector[meta_data.getColumnCount()];
        for (int i = 0; i < data.length; ++i) {
            data[i] = new Vector<>();
        }
        int row_count = 0;

        for (int i = 0; i < data.length; ++i) {
            String str = meta_data.getColumnLabel(i + 1);
            max_widths[i] = Math.max(str.length(), max_widths[i]);
        }

        // Read in the data for the result set,
        while (result_set.next()) {
            for (int i = 0; i < data.length; ++i) {
                Object ob = result_set.getObject(i + 1);
                String str = "NULL";
                if (ob != null) {
                    str = ob.toString();
                }
                data[i].addElement(str);
                max_widths[i] = Math.max(str.length(), max_widths[i]);
            }
            ++row_count;
        }

        // Output the data we stored
        String[] line = new String[data.length];

        for (int n = 0; n < line.length; ++n) {
            line[n] = meta_data.getColumnLabel(n + 1);
        }
        for (int i = 0; i < row_count; ++i) {
            for (int n = 0; n < line.length; ++n) {
                line[n] = (String) data[n].elementAt(i);
            }
            writeRow(max_widths, line, false);
        }
    }

    /**
     * Writes a break.
     *   eg. "+--------+----------+---------------+"
     */
    private static void writeBreak(int[] widths) {
        System.out.print('+');
        for (int i = 0; i < widths.length; ++i) {
            int wid = widths[i] + 2;
            for (int n = 0; n < wid; ++n) {
                System.out.print('-');
            }
            System.out.print('+');
        }
        System.out.println();
    }

    /**
     * Writes a row of data.
     *   eg. "|1         |Greetings        |Part-54445    |"
     */
    private static void writeRow(int[] widths, String[] cols) {
        System.out.print('|');
        for (int i = 0; i < widths.length; ++i) {
            String str = cols[i];
            System.out.print(' ');
            System.out.print(str);
            // Write padding
            int wid = (widths[i] + 1) - str.length();
            for (int n = 0; n < wid; ++n) {
                System.out.print(' ');
            }
            System.out.print('|');
        }
        System.out.println();
    }

    private static void writeRow(int[] widths, String[] cols, boolean withPipe) {
        if (withPipe) {
            writeRow(widths, cols);
            return;
        }
        for (int i = 0; i < widths.length; ++i) {
            String str = cols[i];
            System.out.print(' ');
            System.out.print(str);
            // Write padding
            int wid = (widths[i] + 1) - str.length();
            for (int n = 0; n < wid; ++n) {
                System.out.print(' ');
            }
        }
        System.out.println();
    }

    public static String getPassword() {
        return pw;
    }
}