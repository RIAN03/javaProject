import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		int balance =Integer.parseInt(request.getParameter("balance"));
		PrintWriter out = response.getWriter();
		out.println("<h1>Number " + num + "</h1>");
		out.println("<h1>Name " + name + "</h1>");
		out.println("<h1>Balance " + balance + "</h1>");
		
	}

}