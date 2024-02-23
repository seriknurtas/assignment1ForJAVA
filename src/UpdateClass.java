import java.sql.*;

public class UpdateClass { //Updating songs in library by it's ID;

    public void updateClass(
            int id,
            String description,
            int amount,
            double cost
    ) {
        String Command =
                "UPDATE expenses SET description = ?, amount = ?, cost = ?, total = ? WHERE id = ?";

        try (
                Connection conn = Database_conn.connect();
                PreparedStatement prepstate = conn.prepareStatement(Command)
        ) {
            prepstate.setString(1, description);
            prepstate.setInt(2, amount);
            prepstate.setString(3, String.valueOf(cost) + " tenge");
            prepstate.setString(4, String.valueOf(amount * cost) + " tenge");
            prepstate.setInt(5, id);

            int affectedRows = prepstate.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Your expenses updated.");
            } else {
                System.out.println("Expense with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}