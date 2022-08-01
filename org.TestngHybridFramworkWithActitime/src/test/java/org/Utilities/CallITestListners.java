package org.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CallITestListners  implements ITestListener {
BaseUtility Bu=new BaseUtility();
WebDriver driver;

//public CallITestListners(WebDriver driver) {
//	this.driver=driver;
//}

@Override
public void onTestStart(ITestResult result) {
	
	System.out.println("onTestStart");
}

@Override
public void onTestFailure(ITestResult result) {
	Reporter.log(result.getMethod().getMethodName()+"testcase failed");
}

@Override
public void onTestSuccess(ITestResult result) {
	Reporter.log(result.getMethod().getMethodName()+"test succesfull");
}

@Override
public void onTestSkipped(ITestResult result) {
	System.out.println("skipped");
}

@Override
public void onTestFailedWithTimeout(ITestResult result) {
	System.out.println("failed timeout");
}

@Override
public void onStart(ITestContext context) {
	System.out.println("onstart");
}

@Override
public void onFinish(ITestContext context) {
	System.out.println("onFinish");
}


}

