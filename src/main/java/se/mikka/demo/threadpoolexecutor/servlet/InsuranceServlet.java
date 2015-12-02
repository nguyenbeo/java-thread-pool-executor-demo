package se.mikka.demo.threadpoolexecutor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.mikka.demo.threadpoolexecutor.soap.SoapStep1;
import se.mikka.demo.threadpoolexecutor.soap.SoapStep2;
import se.mikka.demo.threadpoolexecutor.soap.SoapStep3;

public class InsuranceServlet extends HttpServlet {

	private static final long serialVersionUID = -8258424630879697366L;

	private ExecutorService executorService = Executors.newFixedThreadPool(300);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		out.write("Servlet 3 web.xml example configuration");
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		// Initialize async processing.
		final AsyncContext asyncContext = req.startAsync();
		asyncContext.setTimeout(40000);

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					// print request and response outside this thread
					//System.out.println("Request thread: " + req.getParameter("threadNumber"));
					//System.out.println("Response: " + resp);
					
					HttpServletRequest request = (HttpServletRequest) asyncContext.getRequest();
					HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
					PrintWriter printWriter = response.getWriter();
					if ("partners".equals(request.getParameter("from"))) {
						System.out.println("Received request from partner: "
								+ new Date());
						new SoapStep1().getStep1();
						new SoapStep2().getStep2();
						new SoapStep3().process(request, response);
						// Print response
						printWriter.write("Thread number: "
								+ request.getParameter("threadNumber"));
						printWriter.flush();
					} else { // from customers instead of partners
						System.out.println("Received request from customer: "
								+ new Date());
						new SoapStep1().getStep1();
						System.out
								.println("Responsed to customer" + new Date());
					}
					
					// finish asynchronous 
					asyncContext.complete();
					
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});

	}

	public void destroy() {
		executorService.shutdown();
	}
}
