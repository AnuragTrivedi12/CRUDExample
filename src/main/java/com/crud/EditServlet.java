package com.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<h1>Update User</h1>");
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		User u=UserDao.getUserById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" +u.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" +u.getName()+"'/> </td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='" +u.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+u.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Country:</td><td>");
		out.print("<select name='country' style='width:150px'>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>UK</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
		
	}

	

}
