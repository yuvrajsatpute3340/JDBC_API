package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Seven {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/batchhh", 
                "root", 
                "Yuvraj@3340");

        con.setAutoCommit(false);

        String sql = "INSERT INTO stud VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        try {

            // First record
            ps.setInt(1, 5);
            ps.setString(2, "5a");
            ps.setString(3, "5ag");
            ps.addBatch();

            ps.setInt(1, 6);
            ps.setString(2, "6a");
            ps.setString(3, "6ag");
            ps.addBatch();

            ps.setInt(1, 7);
            ps.setString(2, "7a");
            ps.setString(3, "7ag");
            ps.addBatch();

            ps.executeBatch();
            con.commit();

            System.out.println("Batch executed successfully!");

        } catch (Exception e) {
            System.out.println("Error occurred, rolling back...");
            con.rollback();
        }

        ps.close();
        con.close();
    }
}