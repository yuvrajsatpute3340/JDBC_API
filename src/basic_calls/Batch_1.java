package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Batch_1 {

	public static void main(String[] args) throws SQLException {

		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch","root","Yuvraj@3340");
				PreparedStatement stmt=con.prepareStatement("insert into Studentt values(?,?,?);");
		Scanner scan=new Scanner(System.in);)
		{	   
			
			con.setAutoCommit(false);
			{
				 for(int i=0;i<5;i++)
				{
					int id=0;
					String name=null;
					String email=null;
					
					System.out.println("enter the id");
					id=scan.nextInt();
					System.out.println("enter the name");
					name=scan.next();	
					System.out.println("enter the email");
					email=scan.next();
					stmt.setInt(i, id);
					stmt.setString(2,name);
					stmt.setString(3, email);
					stmt.addBatch();
					}
				int[]arr=stmt.executeBatch();
				for(int i:arr)
				{
					System.out.println(i);
				}
				con.commit();
				 }
			    }   
	}

}
class Student 
{
	int id;
	String name;
	String email;
}
