package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Regsiter")
public class Regsiter extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Regsiter() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    
	    String n=request.getParameter("Name");
	    String p=request.getParameter("Pass");
	    String e=request.getParameter("Email");
	    String city=request.getParameter("City");
	    String add=request.getParameter("Address");
	    String c=request.getParameter("Country");
	    
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    }catch(ClassNotFoundException e1){
	    	e1.printStackTrace();
	    }
	    try{
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/trystudent","root","root");
	    	PreparedStatement pstmt=con.prepareStatement("insert into registeruser values(?,?,?,?,?,?)");
	    	pstmt.setString(1, n);
	    	pstmt.setString(2, p);
	    	pstmt.setString(3, e);
	    	pstmt.setString(4, city);
	    	pstmt.setString(5, add);
	    	pstmt.setString(6, c);
	    	
	    	int i=pstmt.executeUpdate();
	    	if(i>0){
	    		out.println("You are successfully registered");
	    	}
	    
	    }catch(SQLException e2){
	    	
	    	e2.printStackTrace();
	    }
}

	
}
