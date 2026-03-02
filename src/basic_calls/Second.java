package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) throws SQLException {
		
		Properties pro=new Properties();
		pro.put("user","root");
		pro.put("password","Yuvraj@3340");
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school",pro);
				Scanner scan=new Scanner(System.in);)
		{

		PreparedStatement stmt=con.prepareStatement("insert into employee value(?,?,?);");
				for (int i=0;i<5;i++)
				{
					System.out.println("please enter the ID");
					int id =scan.nextInt();
					System.out.println("please enter the name");
					String name=scan.next();
					System.out.println("please enter the salary");
					double sal=scan.nextDouble();
					stmt.setInt(1, id);
					stmt.setString(2, name);
					stmt.setDouble(3, sal);
					System.out.println("rows:"+stmt.executeUpdate());
					
				}
	}
	}
}
