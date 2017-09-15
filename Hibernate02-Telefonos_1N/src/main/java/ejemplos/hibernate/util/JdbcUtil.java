package ejemplos.hibernate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Antonio
 */
public class JdbcUtil {
    
    // ----------------------------------------------------
    // Lo que viene a continuacion son funciones JDBC
    // ----------------------------------------------------
    

    // Database configuration
    //    public static String url = "jdbc:mysql://localhost:3306/tablas_de_prueba";
    //    public static String dbdriver = "com.mysql.jdbc.Driver";
    //    public static String username = "root";
    //    public static String password = "root";
    
    public static String url;
    public static String dbdriver;
    public static String username;
    public static String password;
    
    static Connection conn;
    static Statement st;
    


    public static void createStatement() {
        
        Configuration cfg = new Configuration();
        /* Parametros para la configuracion extraidos del cfg.xml*/
        dbdriver = cfg.configure().getProperty("hibernate.connection.driver_class");
        url = cfg.getProperty("hibernate.connection.url");
        username = cfg.getProperty("hibernate.connection.username");
        password = cfg.getProperty("hibernate.connection.password");
        
        try {
            Class.forName(dbdriver);
            conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();
        } catch (Exception e) {
            System.err.println("--- ERROR: Hay una excepcion");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void ejecutaQuery(String sql) {

        try {
            createStatement();
            ResultSet r = st.executeQuery(sql);
            // Vuelco la info y pongo el nombre de la tabla
            String[] starray = sql.split(" ");
            outputResultSet(r, starray[starray.length - 1]);
        } catch (Exception e) {
            System.err.println("--- ERROR: Hay una excepcion");
            System.err.println(e.getMessage());

        }
    }

    public static void ejecutaUpdate(String sql) {
        try {
            createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println("--- ERROR: Hay una excepcion");
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public static void outputResultSet(ResultSet rs, String texto) throws Exception {
        System.out.println("\n****** Volcado Tabla " + texto + " ******");
        ResultSetMetaData metadata = rs.getMetaData();

        int numcols = metadata.getColumnCount();
        String[] labels = new String[numcols];
        int[] colwidths = new int[numcols];
        int[] colpos = new int[numcols];
        int linewidth;
        linewidth = 1;
        for (int i = 0; i < numcols; i++) {
            colpos[i] = linewidth;
            labels[i] = metadata.getColumnLabel(i + 1); // get its label
            int size = metadata.getColumnDisplaySize(i + 1);
            if (size > 30 || size == -1) {
                size = 30;
            }
            int labelsize = labels[i].length();
            if (labelsize > size) {
                size = labelsize;
            }
            colwidths[i] = size + 1; // save the column the size
            linewidth += colwidths[i] + 2; // increment total size
        }
        StringBuffer divider = new StringBuffer(linewidth);
        StringBuffer blankline = new StringBuffer(linewidth);
        for (int i = 0; i < linewidth; i++) {
            divider.insert(i, '-');
            blankline.insert(i, " ");
        }
        // Put special marks in the divider line at the column positions
        for (int i = 0; i < numcols; i++) {
            divider.setCharAt(colpos[i] - 1, '+');
        }
        divider.setCharAt(linewidth - 1, '+');
        // Begin the table output with a divider line
        System.out.println(divider);
        // The next line of the table contains the column labels.
        // Begin with a blank line, and put the column names and column
        // divider characters "|" into it. overwrite() is defined below.
        StringBuffer line = new StringBuffer(blankline.toString());
        line.setCharAt(0, '|');
        for (int i = 0; i < numcols; i++) {
            int pos = colpos[i] + 1 + (colwidths[i] - labels[i].length()) / 2;
            overwrite(line, pos, labels[i]);
            overwrite(line, colpos[i] + colwidths[i], " |");
        }
        System.out.println(line);
        System.out.println(divider);
        while (rs.next()) {
            line = new StringBuffer(blankline.toString());
            line.setCharAt(0, '|');
            for (int i = 0; i < numcols; i++) {
                Object value = rs.getObject(i + 1);
                if (value != null) {
                    overwrite(line, colpos[i] + 1, value.toString().trim());
                    overwrite(line, colpos[i] + colwidths[i], " |");
                }
            }
            System.out.println(line);
        }
        System.out.println(divider);
    }

    static void overwrite(StringBuffer b, int pos, String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            b.setCharAt(pos + i, s.charAt(i));
        }

    }
    
}
