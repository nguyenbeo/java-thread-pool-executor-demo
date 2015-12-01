package se.mikka.demo.threadpoolexecutor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.mikka.demo.threadpoolexecutor.soap.SoapStep1;
import se.mikka.demo.threadpoolexecutor.soap.SoapStep2;

public class InsuranceServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8258424630879697366L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        out.write("Servlet 3 web.xml example configuration");
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		// If partners then execute all steps at the same time
		if ("partners".equals(req.getParameter("from"))) {
			System.out.println("Received request from partner");
			new SoapStep1().getStep1();
			new SoapStep2().getStep2();
		} else { // from customers instead of partners
			System.out.println("Received request from customer");
			new SoapStep1().getStep1();
		}
	}
}
