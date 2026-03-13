package basic_calls;

import java.sql.*;

public class Batch_8 {

    public static void main(String[] args) throws Exception {

        Student1[] students = {
            new Student1(1,"Rahul","rahul@gmail.com"),
            new Student1(2,"Amit","amit@gmail.com"),
            new Student1(3,"Sneha","sneha@gmail.com"),
            new Student1(4,"Priya","priya@gmail.com"),
            new Student1(5,"Karan","karan@gmail.com")
        };

        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/book", "root", "Yuvraj@3340");

            PreparedStatement stmt =
                    con.prepareStatement("INSERT INTO Studentt VALUES (?,?,?)");
        ) {

            con.setAutoCommit(false);

            for (Student1 s : students) {

                stmt.setInt(1, s.id);
                stmt.setString(2, s.name);
                stmt.setString(3, s.email);

                stmt.addBatch();
            }

            stmt.executeBatch();
            con.commit();

            System.out.println("Batch Insert Successful");
        }
    }
}

class Student1 {
    int id;
    String name;
    String email;

    Student1(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}