package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Eight {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/batchhh", 
                "root", 
                "Yuvraj@3340");

        Statement stmt = con.createStatement();
        con.setAutoCommit(false);

        try {

            stmt.addBatch("UPDATE stud SET name='Updated1' WHERE id=1");
            stmt.addBatch("UPDATE stud SET name='Updated2' WHERE id=2");
            stmt.addBatch("DELETE FROM stud WHERE id=7");

            stmt.executeBatch();
            con.commit();

            System.out.println("Batch update/delete successful!");

        } catch (Exception e) {

            System.out.println("Exception occurred...");
            con.rollback();
        }

        stmt.close();
        con.close();
    }
}