import java.sql.*;

public class s16q2 {

    static Connection connection;
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "123");

            String insertSQL = "INSERT INTO teacher (TNo, TName, Subject) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);

            insertTeacherRecord(101, "Nisha", "Java");
            insertTeacherRecord(102, "Vidya", "C++");
            insertTeacherRecord(103, "Aman", "Java");
            insertTeacherRecord(104, "Vaishali", "Python");
            insertTeacherRecord(105, "Joshu", "Java");

            displayJavaTeachers();

        } catch (SQLException e ) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void insertTeacherRecord(int tNo, String tName, String subject) throws SQLException {
        preparedStatement.setInt(1, tNo);
        preparedStatement.setString(2, tName);
        preparedStatement.setString(3, subject);
        preparedStatement.executeUpdate();
    }

    private static void displayJavaTeachers() throws SQLException {
        String selectSQL = "SELECT * FROM Teacher WHERE Subject = ?";
        preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setString(1, "Java");

        resultSet = preparedStatement.executeQuery();

        System.out.println("Teachers teaching Java:");
        System.out.println("TNo\tTName\tSubject");
        while (resultSet.next()) {
            int tNo = resultSet.getInt("TNo");
            String tName = resultSet.getString("TName");
            String subject = resultSet.getString("Subject");
            System.out.println(tNo + "\t" + tName + "\t" + subject);
        }
    }
}
