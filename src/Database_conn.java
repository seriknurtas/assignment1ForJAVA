import java.sql.*;

public class Database_conn {

    private static final String URL = "jdbc:postgresql://localhost/expense_tracker";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}