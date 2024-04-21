import java.sql.*;

public class s11q2 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "123");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM DONAR");
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Column Information for DONAR table:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("  Name: " + metaData.getColumnName(i));
                System.out.println("  Type: " + metaData.getColumnTypeName(i));
                System.out.println("  Size: " + metaData.getColumnDisplaySize(i));
                System.out.println("  Nullable: " + (metaData.isNullable(i) == 1 ? "Yes" : "No"));
                System.out.println("  Auto Increment: " + metaData.isAutoIncrement(i));
                System.out.println();
            }
        } catch ( ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
