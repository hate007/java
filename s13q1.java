import java.sql.*;
public class s13q1 {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java","postgres","123");
            DatabaseMetaData metaData = connection.getMetaData();

            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("JDBC Driver Name: " + metaData.getDriverName());
            System.out.println("JDBC Driver Version: " + metaData.getDriverVersion());

            ResultSet tables = metaData.getTables(null, null, "%", new String[] { "TABLE" });
            System.out.println("\nTables in the database:");
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
