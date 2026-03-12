package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Batch_9 {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "Yuvraj@3340";

        String sql = "INSERT INTO Employees (emp_id, emp_name, emp_email) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = con.prepareStatement(sql);
             Scanner scan = new Scanner(System.in)) {

            con.setAutoCommit(false);

            for (int i = 0; i < 5; i++) {
                System.out.println("Enter Employee ID:");
                int id = scan.nextInt();
                System.out.println("Enter Employee Name:");
                String name = scan.next();
                System.out.println("Enter Employee Email:");
                String email = scan.next();

                stmt.setInt(1, id);          
                stmt.setString(2, name);     
                stmt.setString(3, email);    

                stmt.addBatch(); 
            }

            int[] result = stmt.executeBatch(); 
            for (int r : result) {
                System.out.println("Rows affected: " + r);
            }

            con.commit();
            System.out.println("Batch Insert Completed Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


class Employee1 {
    int emp_id;
    String emp_name;
    String emp_email;
}