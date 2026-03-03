package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Five {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","Yuvraj@3340");
		PreparedStatement stmt=con.prepareStatement("insert into book values(1,'sita');");)
			{
			boolean flag=stmt.execute();
			if(flag)
			{
				System.out.println("DQL");
				ResultSet rs=stmt.getResultSet();
				while(rs.next())
				{
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
				}
			}
			else
			{
				System.out.println("DML");
				int i=stmt.getUpdateCount();
				System.out.println("no of rows affected:"+i);
			}
			}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}

}
