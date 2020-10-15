package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LDao {
	public static boolean validate(String name,String pass){
		boolean status=false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trystudent","root","root");
			PreparedStatement pstmt=con.prepareStatement("select * from registeruser where email=? and password=?");
			pstmt.setString(1,name);
			pstmt.setString(2,pass);
			
			ResultSet rs=pstmt.executeQuery();
			status=rs.next();
		  }
		catch(SQLException e)
		{
			System.out.println(e);
			//e.printStackTrace();
		}
		return status;
		
	}

}

