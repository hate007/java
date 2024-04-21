import java.sql.*;
import java.util.Scanner;

public class s22q1 {
    Connection connection;

    public s22q1() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertEmployee(Scanner scanner) throws Exception {
        System.out.print("Enter Employee Number: ");
        int eno = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String ename = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        String sql = "INSERT INTO Employee (ENo, EName, Salary) VALUES (?, ?, ?)";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        pstmt.setInt(1, eno);
        pstmt.setString(2, ename);
        pstmt.setDouble(3, salary);
        pstmt.executeUpdate();
        System.out.println("Employee inserted successfully.");
        
    }

    public void updateEmployee(Scanner scanner) throws Exception {
        System.out.print("Enter Employee Number to Update: ");
        int eno = scanner.nextInt();

        System.out.print("Enter new Employee Name: ");
        String ename = scanner.next();

        System.out.print("Enter new Employee Salary: ");
        double salary = scanner.nextDouble();

        String sql = "UPDATE Employee SET EName = ?, Salary = ? WHERE ENo = ?";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        pstmt.setString(1, ename);
        pstmt.setDouble(2, salary);
        pstmt.setInt(3, eno);
        pstmt.executeUpdate();
        System.out.println("Employee updated successfully.");

    }

    public void displayEmployees() throws Exception {

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

        System.out.println("ENo\tEName\tSalary");
        while (rs.next()) {
            int eno = rs.getInt("ENo");
            String ename = rs.getString("EName");
            double salary = rs.getDouble("Salary");
            System.out.printf("%d\t%s\t%.2f%n", eno, ename, salary);
        }
       
    }

    public static void main(String[] args) {
        s22q1 menu = new s22q1();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Menu");
            System.out.println("1. Insert Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            try{
                switch (choice) {
                    case 1:
                        menu.insertEmployee(scanner);
                        break;
                    case 2:
                        menu.updateEmployee(scanner);
                        break;
                    case 3:
                        menu.displayEmployees();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
            catch (Exception e){
                e.printStackTrace();

            }
        }
    }
}
