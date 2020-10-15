package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomePage")
public class WelcomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public WelcomePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    
	    String n=request.getParameter("userName");
	    out.println("Welcome "+n);
	    out.close();
	}

}
