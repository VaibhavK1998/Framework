package extentreport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenerateExtentReports {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	@BeforeSuite
	public void beforesuit() {
		 htmlReporter = new ExtentHtmlReporter("extent.html");
		 extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	@Test
	public void test1() throws IOException {
		 // creates a toggle for the given test, adds all log events under it    
        test = extent.createTest("MyFirstTest", "Sample description for testing");

        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        //log with snapshot
       test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
         //test with snapshot
       // test.addScreenCaptureFromPath("screenshot.png");
	}
	@Test
	public void test2() {
		test = extent.createTest("Second Test", "Sample description for test 2");
test.log(Status.INFO, "test2 shows work ok");
String a="vaibhav";
String b="gaurav";
Assert.assertEquals(a, b);
test.fail("details" );
		
	}
	
	@Test
	public void test3() {
		test = extent.createTest("third Test", "Sample description for test 3");
		System.out.println("test 3 here");
		test.log(Status.INFO, "test 3 here");
		
	}
	@AfterSuite
	public void teardown() {
		extent.flush();
	}
}
