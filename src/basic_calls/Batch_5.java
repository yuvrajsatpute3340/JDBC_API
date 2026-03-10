package basic_calls;

import java.sql.*;
import java.util.*;

public class Batch_5 {

    public static void main(String[] args) throws Exception {

        List<Product> list = new ArrayList<>();

        list.add(new Product(101, "Laptop", 65000));
        list.add(new Product(102, "Mobile", 25000));
        list.add(new Product(103, "Headphones", 2000));
        list.add(new Product(104, "Keyboard", 1500));
        list.add(new Product(105, "Mouse", 800));

        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/batch", "root", "password");

            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO Product VALUES(?,?,?)");
        ) {

            con.setAutoCommit(false);

            for (Product p : list) {

                stmt.setInt(1, p.id);
                stmt.setString(2, p.name);
                stmt.setDouble(3, p.price);

                stmt.addBatch();
            }

            int[] result = stmt.executeBatch();

            for (int r : result) {
                System.out.println("Inserted: " + r);
            }

            con.commit();
        }
    }
}

class Product {

    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}