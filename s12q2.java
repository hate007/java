import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class s12q2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Project Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); 
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); 
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER); 
        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java","postgres","123");
            stmt = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS PROJECT (" +
                "project_id INT PRIMARY KEY, " +
                "project_name VARCHAR(50), " +
                "project_description TEXT, " +
                "project_status VARCHAR(20))";
            stmt.executeUpdate(createTableSQL);

            stmt.executeUpdate("INSERT INTO PROJECT (project_id, project_name, project_description, project_status) " +
                "VALUES (3, 'Acadify', 'Educational platform', 'Active')");
            stmt.executeUpdate("INSERT INTO PROJECT (project_id, project_name, project_description, project_status) " +
                "VALUES (4, 'Destify', 'Testing framework', 'Completed')");

            String selectSQL = "SELECT * FROM PROJECT";
            ResultSet rs = stmt.executeQuery(selectSQL);

            textArea.append("Project ID | Project Name | Project Description | Project Status\n");
            textArea.append("--------------------------------------------------------------\n");

            while (rs.next()) {
                int projectId = rs.getInt("project_id");
                String projectName = rs.getString("project_name");
                String projectDescription = rs.getString("project_description");
                String projectStatus = rs.getString("project_status");

                textArea.append("    " + projectId + "    " + " | " + projectName + " | " + projectDescription + " | " + projectStatus + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        frame.setVisible(true);
    }
}
