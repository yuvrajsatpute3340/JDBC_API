
package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Six {

	public static void main(String[] args) throws SQLException {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "Yuvraj@3340");
		
		   con.setAutoCommit(false);
		   Statement stmt=con.createStatement();
		 //  Statement stmt2=con.createStatement();
		   
		   stmt.addBatch("insert into book values(111,'abc@gmail.com'),(444,'abc@gmail.com');");
		   stmt.addBatch("insert into book values(222,'abc@gmail.com');");
		   stmt.addBatch("insert into book values(333,'abc@gmail.com');");
		   
		   int count=1;
	int[] arr=stmt.executeBatch();
	 for(int i:arr)
	 {
		 System.out.println("no.of affected for each query"+i+"Query is:"+count);
		 count++;
	 }
	       con.commit();
			

	       con.close();
	}

}
