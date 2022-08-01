package org.SupportiveCodeClass;

import org.Utilities.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitpractise {
BaseUtility Bu=new BaseUtility ();
	@Test
	public void launch() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		String url="http://localhost:85/login.do";
		driver.get(url);
	WebElement headerlabel=driver.findElement(By.cssSelector("td[class='header']"));
	System.out.println(headerlabel.isDisplayed());
	driver.findElement(By.cssSelector("input[name='username']")).sendKeys("va568");
	driver.findElement(By.cssSelector("input[name='pwd']")).sendKeys("589334");
    driver.findElement(By.cssSelector("#loginButton>div")).click();
	
//By locator=By.xpath("//span[text()='Username or Password is invalid. Please try again.']");
//WebElement msg=Bu.applyFluentWait(driver, locator, 20, 2);
//try {
//	System.out.println("msgdisplay: "+msg.isDisplayed());
//	System.out.println(msg.getText());
//}catch(Exception e) {
//	System.out.println("msg not found");
//}
WebElement errormsg=driver.findElement(By.cssSelector("span[class='errormsg']"));
System.out.println("errormsg"+errormsg.isDisplayed());
//By locator=By.cssSelector("span[class='errormsg']");
//	WebElement errorsg=Bu.applyFluentWait(driver, locator, 20, 2);
//  
//   
//	try{
//		System.out.println("errormsgdisplaye: "+errorsg.isDisplayed());
//		System.out.println("errorsg."+errorsg.getText());
//	}catch(Exception e) {
//		System.out.println("error msg not displayed");
//	}
	}
	
}
