package com.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String driver = "oracle.jdbc.driver.OracleDriver";
		 PrintWriter out = response.getWriter();
		try {
			    Class.forName(driver);
	            System.out.println("Driver is Loaded");

	            String url = "jdbc:oracle:thin:@localhost:1521:xe";
	            String uname = "SRIMANTA";
	            String pwd = "godganesh5";

	            Scanner sc = new Scanner(System.in);

	            Connection con = DriverManager.getConnection(url, uname, pwd);
	            System.out.println("Connection is ready");
	            
	            int num = Integer.parseInt(request.getParameter("num"));
	            String query = "delete from account where num=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, num);
                
                int count = ps.executeUpdate();
                if (count > 0)
                    System.out.println("Deposited");
                else
                    System.out.println("Error : Invalid account num");
		}catch(Exception e) {
			out.println("<h1> Exception :"+e.getMessage()+"</h1>");
		}
	}

}
