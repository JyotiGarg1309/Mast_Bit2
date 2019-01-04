package pages_mastbit;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import jxl.read.biff.BiffException;

public class Login {
	

	WebDriver driver;
    Properties pr;
	public Login(WebDriver driver,Properties pr)
		{
			this.driver= driver;
			this.pr =pr;
		}
		
		public void login(String name,String user,String password) throws InterruptedException, BiffException, IOException
		{
			Thread.sleep(6000);
			driver.findElement(By.xpath(pr.getProperty("crossbtn"))).click();
			Thread.sleep(3000);
			  driver.findElement(By.xpath(pr.getProperty("login"))).click();
			
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			  driver.findElement(By.xpath(pr.getProperty("loginemail"))).sendKeys(user);
		      driver.findElement(By.xpath(pr.getProperty("password2"))).sendKeys(password);
		     
		      Thread.sleep(180000); // long wait set to handle captcha
		     
		 	 //driver.findElement(By.xpath(pr.getProperty("cap"))).click();
		 	  driver.findElement(By.xpath(pr.getProperty("loginBtm"))).click();
		 	 Thread.sleep(4000);
		    //welcome in MastBit
		}
		
	

}
