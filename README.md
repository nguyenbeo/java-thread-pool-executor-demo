# java-thread-pool-executor-demo
An example how to use Java thread pool executor

# Technology
* ThreadPoolExecutor
* Servlet 3.1
* JMeter
* Tomcat 8.0.29
* JConsole

# Scenario
* "Insurance Test.jmx" test plan includes 100 threads to send to /partnerInsurance
* "Customer Insurance Test.jmx" test plan include only 1 thread sending to /insurance

If we run Insurance Test.jmx then wait for some seconds then run Customer Insurance's thread doesn't have a change to execute until 100 threads of "Insurance Test" finish.

The reason is that both cases are using InsuranceServlet which is not asynchronous servlet.

Expected result: We want the thread of Customer Insurance Test to have a chance to run while waiting for Insurance Test.

# Solution
* Enable asynchronous servlet
* Using Thread Pool Executor

# How to test
* Download Tomcat on your computer
* Download JMeter on your computer
* Enable JConsole for Tomcat

* Start Tomcat with this application
* Run Insurance Test.jmx from JMeter
* Wait for some seconds
* Run Customer Insurance Test.jmx from JMeter
