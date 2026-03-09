package basic_calls;

import java.sql.*;
import java.util.*;

public class Batch_4 {

    public static void main(String[] args) throws Exception {

        List<Studentt> list = new ArrayList<>();

        list.add(new Studentt(1, "Rahul", "rahul@gmail.com"));
        list.add(new Studentt(2, "Amit", "amit@gmail.com"));
        list.add(new Studentt(3, "Neha", "neha@gmail.com"));
        list.add(new Studentt(4, "Riya", "riya@gmail.com"));
        list.add(new Studentt(5, "Karan", "karan@gmail.com"));

        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/batch", "root", "Yuvraj@3340");

            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO Studentt VALUES(?,?,?)");
        ) {

            con.setAutoCommit(false);

            for (Studentt s : list) {

                stmt.setInt(1, s.id);
                stmt.setString(2, s.name);
                stmt.setString(3, s.email);

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

class Studentt {

    int id;
    String name;
    String email;

    Studentt(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}