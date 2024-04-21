import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class s1q2 extends JFrame implements ActionListener {
    JLabel lblEno, lblEName, lblDesignation, lblSalary;
    JTextField txtEno, txtEName, txtDesignation, txtSalary;
    JButton btnSave;

    Connection con;
    PreparedStatement pst;

    public s1q2() {
        setTitle("Employee Details Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        lblEno = new JLabel("Employee No:");
        txtEno = new JTextField();
        lblEName = new JLabel("Employee Name:");
        txtEName = new JTextField();
        lblDesignation = new JLabel("Designation:");
        txtDesignation = new JTextField();
        lblSalary = new JLabel("Salary:");
        txtSalary = new JTextField();
        btnSave = new JButton("Save");

        add(lblEno);
        add(txtEno);
        add(lblEName);
        add(txtEName);
        add(lblDesignation);
        add(txtDesignation);
        add(lblSalary);
        add(txtSalary);
        add(btnSave);

        btnSave.addActionListener(this);

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "123");
            pst = con.prepareStatement("insert into employee1 values(?,?,?,?)");
        } catch (Exception e) {
            System.out.println(e);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSave) {
            try {
                int eno = Integer.parseInt(txtEno.getText());
                String ename = txtEName.getText();
                String designation = txtDesignation.getText();
                int salary = Integer.parseInt(txtSalary.getText());

                pst.setInt(1, eno);
                pst.setString(2, ename);
                pst.setString(3, designation);
                pst.setInt(4, salary);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Added Successfully");
                txtEno.setText("");
                txtEName.setText("");
                txtDesignation.setText("");
                txtSalary.setText("");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        new s1q2();
    }
}