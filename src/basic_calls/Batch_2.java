package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_2 {

	public static void main(String[] args) throws SQLException, InterruptedException {
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batchhh", "root", "Yuvraj@3340");
		 Statement stmt=con.createStatement();
		 con.setAutoCommit(false);
		
		 stmt.addBatch("insert into stud values(1,'1a','1ag');");
		 stmt.addBatch("insert into stud values(2,'2a','2ag');");
		 stmt.addBatch("insert into stud values(3,'3a','1ag');");
		 stmt.addBatch("insert into stud values(4,'4a','4ag');");
		  try {
			  
		   stmt.executeBatch();
		   con.commit();
		  }
		  catch(Exception ex)
		  {
			   System.out.println("line Number:"+ex.getStackTrace()[3]);
			   System.out.println("pala re pala....");
			   Thread.sleep(1000);
			   System.out.println("Intiating roll back..");
			   con.rollback();
		  }
		  
	}

}
