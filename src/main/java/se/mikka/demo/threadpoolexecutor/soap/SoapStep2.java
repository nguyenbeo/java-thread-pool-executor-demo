package se.mikka.demo.threadpoolexecutor.soap;

/**
 * Step 2 - simulator class to send request further to SOAP server
 * 
 * @author Nguyenbi
 */
public class SoapStep2 {
	
	public void getStep2() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
