package com.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<a href='index.html'>Add New Users</a>");
		out.print("<h1>Users List</h1>");
		
		List<User> list=UserDao.getAllUsers();
		
		
		out.print("<table border='1' width='100%'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for(User u:list){
			out.print("<tr><td>" +u.getId()+"</td><td>" +u.getName()+ "</td><td>" +u.getPassword()+"</td><td>"+ u.getEmail()+"</td><td>" 
			+u.getCountry()+"</td><td><a href='EditServlet?id="+u.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+u.getId()+"'>delete</a></td></tr>");
			
		}
		out.print("</table>");
		
		out.close();
	}

}
