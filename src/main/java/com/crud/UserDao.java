package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao{
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","anurag");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	public static int save(User u) {
		int status=0;
		try {
			Connection con=UserDao.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into users(name,password,email,country) values(?,?,?,?)");
			
			pst.setString(1, u.getName());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getCountry());
			
			status = pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int update(User u) {
		int status=0;
		try {
			Connection con=UserDao.getConnection();
			PreparedStatement pst=con.prepareStatement("update users set name=?,password=?,email=?,country=? where id=?");
			pst.setString(1, u.getName());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getCountry());
			pst.setInt(5, u.getId());
			
			status=pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int delete(int id) {
		int status=0;
		try {
			Connection con=UserDao.getConnection();
			PreparedStatement pst=con.prepareStatement("delete from users where id=?");
			pst.setInt(1, id);
			
			status=pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
	}
	public static User getUserById(int id) {
		User u=new User();
		
		try {
			Connection con=UserDao.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from users where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setCountry(rs.getString(5));
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return u;
	}
	
	public static List<User> getAllUsers(){
		List<User> list=new ArrayList<User>();
		
		try {
			Connection con=UserDao.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from users");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setCountry(rs.getString(5));
				list.add(u);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}