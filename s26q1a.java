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
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");

            System.out.println("\nUpdated Employee Table:");
            while (resultSet.next()) {
                int eno = resultSet.getInt("ENo");
                String ename = resultSet.getString("EName");
                double salary = resultSet.getDouble("Salary");
                System.out.println("ENo: " + eno + ", EName: " + ename + ", Salary: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
