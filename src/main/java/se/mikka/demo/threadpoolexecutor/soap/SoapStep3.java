package se.mikka.demo.threadpoolexecutor.soap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SoapStep3 {
	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.write("Writing something ...");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
