package basic_calls;

import java.sql.*;
import java.util.Scanner;

public class Batch_7 {

    public static void main(String[] args) throws Exception {

        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/batch", "root", "Yuvraj@3340");

            PreparedStatement stmt =
                    con.prepareStatement("INSERT INTO Studentt VALUES (?,?,?)");

            Scanner scan = new Scanner(System.in);
        ) {

            con.setAutoCommit(false);

            for (int i = 0; i < 5; i++) {

                System.out.println("Enter ID:");
                int id = scan.nextInt();

                System.out.println("Enter Name:");
                String name = scan.next();

                System.out.println("Enter Email:");
                String email = scan.next();

                stmt.setInt(1, id);
                stmt.setString(2, name);
                stmt.setString(3, email);

                stmt.addBatch();
            }

            int[] arr = stmt.executeBatch();

            for (int i : arr) {
                System.out.println("Rows inserted: " + i);
            }

            con.commit();
        }
    }
}
