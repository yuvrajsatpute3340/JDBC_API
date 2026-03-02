package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Fourth {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","Yuvraj@3340");
			PreparedStatement stmt=con.prepareStatement("select * from book;");)
		{
			boolean rs=stmt.execute();
			System.out.println(stmt.getUpdateCount());
			System.out.println(rs);
		}

catch(Exception ex)
{
	System.out.println(ex.getMessage());
}
}
}
