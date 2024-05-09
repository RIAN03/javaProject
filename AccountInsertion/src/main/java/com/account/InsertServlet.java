package com.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		int balance =Integer.parseInt(request.getParameter("balance"));
		PrintWriter out = response.getWriter();
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,"SRIMANTA","godganesh5");
			
			String query="insert into account values(?,?,?)";
			 PreparedStatement ps = con.prepareStatement(query);
			 
			 ps.setInt(1, num);
			 ps.setString(2, name);
			 ps.setInt(3, balance);
			 
			 int count= ps.executeUpdate();
			 
			 if (count>0) {
				 out.println("<h1> Account Inserted </h1>");
			 }
			 else {
				 out.println("<h1> insertion failed </h1>");
			 }
		}catch(Exception e) {
			out.println("<h1> Exception :"+e.getMessage()+"</h1>");
		}
		
//		response.setContentType("text/html");
//		
//		out.println("<h1>Number " + num + "</h1>");
//		out.println("<h1>Name " + name + "</h1>");
//		out.println("<h1>Balance " + balance + "</h1>");
	}

}
