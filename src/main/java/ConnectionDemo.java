

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/Connection")
public class ConnectionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String jdbcurl="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="system";
		String password="anurag";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection connection=DriverManager.getConnection(jdbcurl, username, password);
			
			if(connection!=null) {
				out.print("Connection Successfull");
			}
			else {
				out.print("Connection Failed");
			}
			
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			out.print("<h3>Oracle JDBC Driver Not Found</h3>");
			e.printStackTrace(out);
		}catch(SQLException e){
			out.print("<h3>Connection Error</h3>");
			e.printStackTrace(out);
		}
	}

	

}
