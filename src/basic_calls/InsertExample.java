package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class InsertExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school";
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "Yuvraj@3340");

        String insertQuery = "INSERT INTO students (id, name, grade) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, props);
             PreparedStatement pstmt = con.prepareStatement(insertQuery)) {

            
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Rahul");
            pstmt.setString(3, "A");

            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}