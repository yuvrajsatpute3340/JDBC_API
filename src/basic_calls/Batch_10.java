package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Batch_10 {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/school";
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "Yuvraj@3340");

        try (Connection con = DriverManager.getConnection(url, props);
             Statement stmt = con.createStatement()) {

            System.out.println("Connection Established: " + con);

           
            String sql = "SELECT id, name, grade FROM students";
            ResultSet rs = stmt.executeQuery(sql);

           
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String grade = rs.getString("grade");

                System.out.println("ID: " + id + ", Name: " + name + ", Grade: " + grade);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
