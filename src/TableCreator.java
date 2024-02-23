import java.sql.*;

public class TableCreator {

    public static void tableCreator(){
        try(Connection conn = Database_conn.connect();
        Statement statement = conn.createStatement();){
            String Command = "CREATE TABLE IF NOT EXISTS Expenses" + "(id SERIAL PRIMARY KEY," +
                    "description VARCHAR(255) NOT NULL," +
                    "amount INT," +
                    "cost VARCHAR(255) NOT NULL," +
                    "total VARCHAR(255) NOT NULL," +
                    "time VARCHAR(255) NOT NULL)";

            statement.executeUpdate(Command);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
