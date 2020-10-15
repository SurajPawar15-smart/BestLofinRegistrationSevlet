package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    
	    String n=request.getParameter("userName");
	    String p=request.getParameter("userPass");
	    
	    if(LDao.validate(n, p)){
	    	RequestDispatcher rd=request.getRequestDispatcher("WelcomePage");
	    	rd.forward(request, response);
	    }
	    else{
	    	out.println("Sorry UserName or Password Error...!!!");
	    	RequestDispatcher rd1=request.getRequestDispatcher("login.html");
	    	rd1.include(request, response);
	    }
	}

}
