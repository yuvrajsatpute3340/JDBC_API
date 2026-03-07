package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Eleventh {

    public static void main(String[] args) {

        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/book","root","Yuvraj@3340");
            PreparedStatement stmt = con.prepareStatement(
                "insert into book values(3,'Java Basics','James')");)
        {
            boolean rs = stmt.execute();

            System.out.println(stmt.getUpdateCount());
            System.out.println(rs);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}