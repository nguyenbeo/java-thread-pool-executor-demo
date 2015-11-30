package se.mikka.demo.threadpoolexecutor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsuranceServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8258424630879697366L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        out.write("Servlet 3 web.xml example configuration");
    }
}
