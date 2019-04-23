package UTN.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCConnection {
    //  JDBCConnection driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/Ahorcado?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "";

    //  Singleton
    private static JDBCConnection instance;

    private Connection conn = null;

    public static JDBCConnection getInstance() {
        instance = Optional.ofNullable(instance).orElse(new JDBCConnection());

        return instance;
    }

    private JDBCConnection(){
    }

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySql Driver not installed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to database");
        }
        return conn;
    }
}
