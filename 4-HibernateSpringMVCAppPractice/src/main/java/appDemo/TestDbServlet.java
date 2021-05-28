package appDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID =1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        //setup connection variables
        String user ="root";
        String pass = "password";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        //get connection to database
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to Database: "+jdbcUrl);

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);

            out.println("connection successful..!");

            connection.close();
        }
        catch (Exception exception){
            exception.printStackTrace();
            throw new ServletException(exception);
        }
    }
}
