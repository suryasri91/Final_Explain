package extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport {
	@Test
	public void report() {
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
		// step 1: create an instance of ExtentSparkReporter
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_report/extentreport_"+timestamp+".html");
		
		// step 2: create an instance of ExtentReports
		ExtentReports extreport = new ExtentReports();
		
		// step 3: attach an instance of ExtentSparkReporter to ExtentReports
		extreport.attachReporter(spark);
		
		// step 4: create an instance of ExtentTest
		ExtentTest test = extreport.createTest("report");
		
		// step 5: call log() to provide status and log message
		test.log(Status.PASS, "log message added into report");
		
		// step 6: call flush() to write messages into destination
		extreport.flush();
	}
}
