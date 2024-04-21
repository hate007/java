import java.sql.*;

public class s30q2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java","postgres","123");

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SELECT * FROM Teacher");
            System.out.println("Moving to last row and displaying teacher details:");
            if (resultSet.last()) {
                System.out.println("tno: " + resultSet.getInt("tno"));
                System.out.println("TName: " + resultSet.getString("TName"));
                System.out.println("Salary: " + resultSet.getDouble("Salary"));
            }

            System.out.println("\nDisplaying teacher details from first to last:");
            resultSet.beforeFirst(); 
            while (resultSet.next()) {
                System.out.println("tno: " + resultSet.getInt("tno"));
                System.out.println("TName: " + resultSet.getString("TName"));
                System.out.println("Salary: " + resultSet.getDouble("Salary"));
            }

            System.out.println("\nMoving to first row and displaying teacher details:");
            if (resultSet.first()) {
                System.out.println("tno: " + resultSet.getInt("tno"));
                System.out.println("TName: " + resultSet.getString("TName"));
                System.out.println("Salary: " + resultSet.getDouble("Salary"));
            }

            System.out.println("\nDisplaying teacher details from last to first:");
            resultSet.afterLast();
            while (resultSet.previous()) { 
                System.out.println("tno: " + resultSet.getInt("tno"));
                System.out.println("TName: " + resultSet.getString("TName"));
                System.out.println("Salary: " + resultSet.getDouble("Salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
