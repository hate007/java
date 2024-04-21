import java.sql.*;

public class s29q1 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            
            Class.forName("org.postgresql.Driver"); 
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM DONAR");
            
            ResultSetMetaData metaData = resultSet.getMetaData();
            
            int columnCount = metaData.getColumnCount(); 
            System.out.println("Number of columns in DONAR table: " + columnCount);
            
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("  Name: " + metaData.getColumnName(i)); 
                System.out.println("  Type: " + metaData.getColumnTypeName(i)); 
                System.out.println("  Size: " + metaData.getColumnDisplaySize(i)); 
                System.out.println("  Is Nullable: " + metaData.isNullable(i));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
