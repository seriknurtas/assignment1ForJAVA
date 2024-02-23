import java.sql.*;

public class DeleteClass {

    public void deleteClass(int id) {
        String Command = "DELETE FROM expenses WHERE id = ?";

        try (
                Connection conn = Database_conn.connect();
                PreparedStatement prepstate = conn.prepareStatement(Command)
        ) {
            prepstate.setInt(1, id);

            int affectedRows = prepstate.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Your expense deleted.");
            } else {
                System.out.println("Not found expense \"" + id + "\"!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
