import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String s1=request.getParameter("uid");
        String s2=request.getParameter("pass");
        if(Validate.checkUser(s1, s2))
        {
            RequestDispatcher rs = request.getRequestDispatcher("welcome");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("login.html");
           rs.include(request, response);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.annotation.WebServlet;
//@WebServlet("/Register")
//public class Register extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    public Register() {
//    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}