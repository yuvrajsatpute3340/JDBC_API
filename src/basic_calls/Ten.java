package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Ten {

    public static void main(String[] args) throws SQLException {

        Properties pro = new Properties();
        pro.put("user", "root");
        pro.put("password", "Yuvraj@3340");

        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", pro);
            Scanner scan = new Scanner(System.in);
        ) {

            PreparedStatement stmt = con.prepareStatement("insert into product values(?,?,?)");

            for (int i = 0; i < 2; i++) {

                System.out.println("Enter Product ID:");
                int id = scan.nextInt();

                System.out.println("Enter Product Name:");
                String name = scan.next();

                System.out.println("Enter Product Price:");
                double price = scan.nextDouble();

                stmt.setInt(1, id);
                stmt.setString(2, name);
                stmt.setDouble(3, price);

                System.out.println("Rows inserted: " + stmt.executeUpdate());
            }
        }
    }
}
