import java.sql.*;

public class s26q1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ENTEER the employee ID to delete.");
            return;
        }

        int employeeId;
        employeeId = Integer.parseInt(args[0]);
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "123");

            String deleteSQL = "DELETE FROM Employee WHERE ENo = ?";
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, employeeId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + employeeId + " was successfully deleted.");
            } else {
                System.out.println("No employee found with ID " + employeeId + ".");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
