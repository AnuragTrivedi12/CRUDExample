package com.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id =Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email = request.getParameter("email");
		String country=request.getParameter("country");
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setPassword(password);
		u.setEmail(email);
		u.setCountry(country);
		
		int status=UserDao.update(u);
		
		if(status>0) {
			response.sendRedirect("ViewServlet");
		}
		else {
			out.println("Sorry! unable to update records");
		}
	}

}
