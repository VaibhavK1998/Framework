package extentreport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExa2 extends GenerateExtentReports{
	//private BaseUtility Bu;
	private String bname;
	private String url;
	WebDriver driver;
	
@BeforeMethod
public void beforemethod() {
	//Bu=new BaseUtility();
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	bname="chrome";
	url="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	driver.get(url);
}
@Test(dataProvider = "loginhrmData")
public void loginOrangeHrm(String uname,String pwd) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys(uname);
 driver.findElement(By.cssSelector("[name='txtPassword']")).sendKeys(pwd);
 driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
WebElement validatemsg= driver.findElement(By.cssSelector("span[id='spanMessage']"));
 String Actualoutput= validatemsg.getText();
 String ExpectedOutput="Invalid credentials"; 
 
 if(ExpectedOutput.equalsIgnoreCase(Actualoutput)) {
	 System.out.println("loginmethod output:"+Actualoutput);
 }else {
	 System.out.println("loginmethod output : login succesfull");
 }
}
@AfterMethod
public void teardown() {
	driver.quit();
}

@DataProvider(name="loginhrmData")
public String [][] logindataOrangeHrm() {
	
	String[][] data1= {{"Admin","admin123"},{"@45678","admin12"},{"rameshvaramparmeshvaram","admin123"},
			
			{"administrator","78767234"}};
			
	     return data1;
	
}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
