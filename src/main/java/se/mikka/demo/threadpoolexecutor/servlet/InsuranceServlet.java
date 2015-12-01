package se.mikka.demo.threadpoolexecutor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.mikka.demo.threadpoolexecutor.soap.SoapStep1;
import se.mikka.demo.threadpoolexecutor.soap.SoapStep2;

public class InsuranceServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8258424630879697366L;
	
	//private ExecutorService executorService = Executors.newFixedThreadPool(300);
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        out.write("Servlet 3 web.xml example configuration");
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		
		// If partners then execute all steps at the same time
		/*if ("partners".equals(req.getParameter("from"))) {
			Future<String> future = executorService.submit(new Callable<String>() {
				@Override
				public String call() {
					System.out.println("Received request from partner: " + new Date());
					new SoapStep1().getStep1();
					new SoapStep2().getStep2();
					return "Callable Result";
				}
			});
			try {
				if ("Callable Result".equals(future.get())) {
					return;
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		} else { // from customers instead of partners
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			Future<String> future = executorService.submit(new Callable<String>() {
				@Override
				public String call() {
					System.out.println("Received request from customer: " + new Date());
					new SoapStep1().getStep1();
					System.out.println("Responsed to customer" + new Date());
					return "Callable Result";
				}
			});
			try {
				if ("Callable Result".equals(future.get())) {
					return;
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}*/
		if ("partners".equals(req.getParameter("from"))) {
			System.out.println("Received request from partner: " + new Date());
			new SoapStep1().getStep1();
			new SoapStep2().getStep2();
		} else { // from customers instead of partners
			System.out.println("Received request from customer: " + new Date());
			new SoapStep1().getStep1();
			System.out.println("Responsed to customer" + new Date());
		}
	}
	
	public void destroy() {
		//executorService.shutdown();
	}
}
