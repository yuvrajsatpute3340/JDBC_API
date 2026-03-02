package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Third {

	public static void main(String[] args) throws SQLException {
	
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "Yuvraj@3340");
   ){
			PreparedStatement spmt =con.prepareStatement("select * from book;");
		//PreparedStatement spmt=con.prepareStatement("delete from book where id = 1;");
			
			boolean fl =spmt.execute();
			if(fl==true) {
				ResultSet rs=spmt.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getNString(2));
					System.out.println("*************");
				}
				con.close();
			}
			else {
				System.out.println("Rows Affected :"+spmt.getUpdateCount());
			}
		
		}
		
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			
		}
		
	}
	
}
