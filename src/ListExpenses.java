import java.sql.*;

public class ListExpenses { //Method used to show w

    public void listExpenses() {
        String Command = "SELECT * FROM expenses";

        try (
                Connection conn = Database_conn.connect();
                Statement statement = conn.createStatement();
                ResultSet resultset = statement.executeQuery(Command)
        ) {
            while (resultset.next()) {
                System.out.println(
                        "ID: " + resultset.getInt("id") +
                                "\nDescription: " +
                                resultset.getString("description") +
                                "\nAmount: " +
                                resultset.getInt("amount") +
                                "\nCost: " +
                                resultset.getString("cost") +
                                "\nTotal: " +
                                resultset.getString("total") +
                                "\nTime: " +
                                resultset.getString("time")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}