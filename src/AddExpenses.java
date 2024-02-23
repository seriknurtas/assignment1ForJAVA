import java.sql.*;

public class AddExpenses {

    public void addexpenses(
            String description,
            int amount,
            double cost
    ) {
        String Command =
                "INSERT INTO expenses (description, amount, cost, total, time) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = Database_conn.connect();
                PreparedStatement prepstate = conn.prepareStatement(Command)
        ) {
            prepstate.setString(1, description);
            prepstate.setInt(2, amount);
            prepstate.setString(3, String.valueOf(cost) + " tenge");
            prepstate.setString(4, String.valueOf(amount * cost) + " tenge");
            prepstate.setString(5, addTime());


            prepstate.executeUpdate();
            System.out.println(
                    "Expense " + "\"" + description + "\"" + ""
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String addTime(){
        String Command = "SELECT NOW()";
        try (
                Connection conn = Database_conn.connect();
                Statement statement = conn.createStatement();
                ResultSet resultset = statement.executeQuery(Command)
                ){

            while (resultset.next()) {

                return resultset.getString("now");
            }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
