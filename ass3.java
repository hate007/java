import java.sql.*;
import java.util.*;
public class ass3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "123");
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.print("Enter the number of employees: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter name for Employee " + i + ": ");
                String empName = scanner.nextLine();
                System.out.print("Enter Salary " + ": ");
                double salary = scanner.nextInt();
                scanner.nextLine();
                String insertSQL = "INSERT INTO employee (emp_name, salary) VALUES ('" + empName + "', " + salary + ")";
                stmt.executeUpdate(insertSQL);
            }
            String selectSQL = "SELECT emp_no, emp_name, salary FROM employee";
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                int empNo = rs.getInt("emp_no");
                String empName = rs.getString("emp_name");
                double salary = rs.getDouble("salary");
                System.out.print("Emp No: " + empNo);
                System.out.print(", Emp Name: " + empName);
                System.out.println(", Salary: " + salary);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se ) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}