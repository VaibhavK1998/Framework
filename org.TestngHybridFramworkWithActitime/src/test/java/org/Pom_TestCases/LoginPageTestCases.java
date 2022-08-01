package org.Pom_TestCases;

import java.io.IOException;
import java.time.Duration;
import org.Pom_pages.LoginPage;
import org.Utilities.BaseUtility;
import org.Utilities.CallITestListners;
import org.Utilities.ConfigReader;
import org.Utilities.DataSupplierUtiity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(org.Utilities.CallITestListners.class) // LinkItestListner class here
public class LoginPageTestCases extends BaseUtility{
private	WebDriver driver;
	String url;
	BaseUtility Bu;
	String browsername; 
	ConfigReader cr;
 //String Uname;
//	 String pwd;
	
	@BeforeSuite
	public void initializeDatas() {
		
		cr=new ConfigReader();
	//Uname=cr.getConfigtestdata("ActiUserName");
	//	pwd=cr.getConfigtestdata("ActiPassword");
		
	}
	@BeforeMethod
	public void initializeBrowser() {
		
		url="http://localhost:85/login.do";
		Bu=new BaseUtility();
		browsername="CH";
		driver=Bu.startup(browsername, url);
		
			}
	@Test(priority=1)
	public void verifypage()  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		LoginPage Lp= new LoginPage(driver);
		Lp.verifyLoginPage();
		
	}
	
	
	@Test(dataProvider="ActitimeLogin",dataProviderClass=DataSupplierUtiity.class)
	public void loginActitime(String Uname,String pwd) throws IOException   {
		
		LoginPage Lp1=new LoginPage(driver);
		Lp1.LoginActitimepage(Uname, pwd);
	
	//Reporter.log("get attribute value username: "+Lp1.UsernameGetvalue().getAttribute("class"));
		
		 By msg=By.cssSelector("span[class='errormsg']");
		boolean ermsg= Bu.waitForElementPresent(driver, 10, msg).isDisplayed();
		System.out.println("error msgverify: "+ermsg);
		Assert.assertEquals(ermsg, false);
			
		}
		
		
	
	

	@AfterMethod
	public void teardown() {
		
		//driver.close();
		
		
	}
	@AfterSuite
	public void closeObject() {
	//	driver.quit();
	}

}
