import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class s12q2a {
    static Connection connection;
    static Statement stmt;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Project Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField projectIdField = new JTextField();
        JTextField projectNameField = new JTextField();
        JTextField projectDescriptionField = new JTextField();
        JTextField projectStatusField = new JTextField();

        formPanel.add(new JLabel("Project ID:"));
        formPanel.add(projectIdField);
        formPanel.add(new JLabel("Project Name:"));
        formPanel.add(projectNameField);
        formPanel.add(new JLabel("Project Description:"));
        formPanel.add(projectDescriptionField);
        formPanel.add(new JLabel("Project Status:"));
        formPanel.add(projectStatusField);

        JButton insertButton = new JButton("Insert Project");
        formPanel.add(insertButton);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        frame.setLayout(new BorderLayout());
        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);

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

            // stmt.executeUpdate("INSERT INTO PROJECT (project_id, project_name, project_description, project_status) " +
            //     "VALUES (1, 'Acadify', 'Educational platform', 'Active')");
            // stmt.executeUpdate("INSERT INTO PROJECT (project_id, project_name, project_description, project_status) " +
            //     "VALUES (2, 'Destify', 'Testing framework', 'Completed')");

            insertButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int projectId = Integer.parseInt(projectIdField.getText());
                        String projectName = projectNameField.getText();
                        String projectDescription = projectDescriptionField.getText();
                        String projectStatus = projectStatusField.getText();

                        String insertSQL = "INSERT INTO PROJECT (project_id, project_name, project_description, project_status) " +
                            "VALUES (" + projectId + ", '" + projectName + "', '" + projectDescription + "', '" + projectStatus + "')";
                        stmt.executeUpdate(insertSQL);

                        projectIdField.setText("");
                        projectNameField.setText("");
                        projectDescriptionField.setText("");
                        projectStatusField.setText("");

                        displayProjects(textArea);

                    } catch (SQLException | NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            displayProjects(textArea);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }

    static void displayProjects(JTextArea textArea) {
        try {
            String selectSQL = "SELECT * FROM PROJECT";
            ResultSet rs = stmt.executeQuery(selectSQL);

            textArea.setText("Project ID | Project Name | Project Description | Project Status\n");
            textArea.append("--------------------------------------------------------------\n");

            while (rs.next()) {
                int projectId = rs.getInt("project_id");
                String projectName = rs.getString("project_name");
                String projectDescription = rs.getString("project_description");
                String projectStatus = rs.getString("project_status");

                textArea.append(projectId + " | " + projectName + " | " + projectDescription + " | " + projectStatus + "\n");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
