package se.mikka.demo.threadpoolexecutor.servlet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PartnerServlet extends HttpServlet {

	private static final long serialVersionUID = -5694185546956996571L;
	
	private final String USER_AGENT = "Mozilla/5.0";

	/**
	 * Receive post request from Insurance partners
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Send request futher to /insurance
		String insuranceUrl = "http://localhost:8080/java-thread-pool-executor-demo/insurance?from=partners";
		URL obj = new URL(insuranceUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSent 'POST' request to URL : " + insuranceUrl);
		System.out.println("Response Code : " + responseCode);
	}
}
