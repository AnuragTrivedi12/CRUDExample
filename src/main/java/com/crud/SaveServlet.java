package com.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		User u=new User();
		u.setName(name);
		u.setPassword(password);
		u.setEmail(email);
		u.setCountry(country);
		
		int status=UserDao.save(u);
		if(status>0) {
			out.print("<p>Record Saved Successfully</p>");
			request.getRequestDispatcher("index.html").include(request,response);
		}
		else {
			out.println("<p>Unable to save records</p>");
		}
		
		out.close();
	}

}
