package basic_calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class First {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//	Class.forName("com.mysql.cj.jdbc.Driver");
		
		Properties pro=new Properties();
		pro.put("user","root");
		pro.put("password","Yuvraj@3340");
	
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school",pro);
	
	System.out.println(con);
	System.out.println("Conncation Found...");
         
	con.close();
	}

}
