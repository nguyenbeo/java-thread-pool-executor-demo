package se.mikka.demo.threadpoolexecutor.servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
		// Get External threadNumber
		String threadNumber = req.getParameter("threadNumber");
		String threadNumberParam = "threadNumber=" + threadNumber;

		// Send request futher to /insurance
		String insuranceUrl = "http://localhost:8080/java-thread-pool-executor-demo/insurance?from=partners";
		URL obj = new URL(insuranceUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setUseCaches(false);
		con.setDoInput(true);
		con.setDoOutput(true);

		// send post data
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(threadNumberParam);
		out.flush();
		out.close();

		// get response
		InputStream is = con.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		rd.close();

		PrintWriter writer = resp.getWriter();
		writer.write(response.toString());
		writer.close();
		System.out.println("Received response: " + response.toString());
	}
}
