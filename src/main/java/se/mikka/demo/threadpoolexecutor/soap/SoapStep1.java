package se.mikka.demo.threadpoolexecutor.soap;

/**
 * Step 1 - simulator class to send request further to SOAP server
 * 
 * @author Nguyenbi
 */
public class SoapStep1 {
	
	@SuppressWarnings("static-access")
	public void getStep1() {
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
