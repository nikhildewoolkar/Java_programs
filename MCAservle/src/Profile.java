import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Profile() {
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("fname");
        String s2=request.getParameter("lname");
        String s3=request.getParameter("mbno");
        String s4=request.getParameter("email");
        String s5=request.getParameter("password");
        String s6=request.getParameter("date");
        String s7=request.getParameter("gender");
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Entered data is </h1>");
            out.println("your first name:-" + s1+ "</br></br>");
            out.println("your last name:-" + s2 + "</br></br>");
            out.println("your mobile number :-" +  s3 + "</br></br>");
            out.println("your email id:-" + s4 + "</br></br>");
            out.println("your valid password:-" + s5 + "</br></br>");
            out.println("your birthdate:-" + s6 + "</br></br>");
            out.println("your gender:-" + s7 + "</br></br>");
            out.println("</body>");
            out.println("</html>");
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
