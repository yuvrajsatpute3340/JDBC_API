package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Twetlth {

    public static void main(String[] args) {

        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/book","root","Yuvraj@3340");
            PreparedStatement stmt = con.prepareStatement(
                "update book set name='Advanced Java' where id=1");)
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