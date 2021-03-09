import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String s1=request.getParameter("fname");
        String s2=request.getParameter("lname");
        String s3=request.getParameter("uid");
        String s4=request.getParameter("email");
        String s5=request.getParameter("pass");
        String s6=request.getParameter("rpass");
        try {
        	if (s5.equals(s6))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("dbc:mysql://localhost:3306/mydb", "root", "123456");
                    PreparedStatement ps = con.prepareStatement("insert into STUDENT values(?,?,?,?,?)");
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setString(3, s3);
                    ps.setString(4, s4);
                    ps.setString(5, s5);
                    int x = ps.executeUpdate(); 
                    if (x > 0)
                    {
                    	System.out.println("Data Saved Successfully");
                    	RequestDispatcher rs = request.getRequestDispatcher("login.html");
                    }
                }
                catch (Exception ex)
                {
                    out.println(ex);
                }
            }
            else
            {
            	out.println("Data not Saved");
            }
        }
        finally
        {
        out.close();
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