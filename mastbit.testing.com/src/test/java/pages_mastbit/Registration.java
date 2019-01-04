package pages_mastbit;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import jxl.read.biff.BiffException;

public class Registration {
	
	WebDriver driver;
    Properties pr;
	public Registration(WebDriver driver,Properties pr)
		{
			this.driver= driver;
			this.pr =pr;
		}
		
		public void register(String name,String user,String password) throws InterruptedException, BiffException, IOException
		{
		
			
		  List<WebElement> all =driver.findElements( By.xpath(pr.getProperty("reg")));
		  all.get(0).click();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	
	      driver.findElement(By.name(pr.getProperty("fullname"))).sendKeys(name);
	      Thread.sleep(3000);
	     List<WebElement> email = driver.findElements(By.xpath(pr.getProperty("email")));
	       email.get(1).sendKeys(user);
	     
	     driver.findElement(By.name(pr.getProperty("password"))).sendKeys(password);
	     driver.findElement(By.name(pr.getProperty("conpassword"))).sendKeys(password);
	     Thread.sleep(3000);
	     WebElement nationality = driver.findElement(By.name(pr.getProperty("nationality")));
	     Select select =new Select(nationality);
	     select.selectByVisibleText("India");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath(pr.getProperty("check"))).click();
	     Thread.sleep(180000); //long wait set to handle captcha
	     
	     driver.findElement(By.xpath(pr.getProperty("bottomRes"))).click();
	     
	  }




}
