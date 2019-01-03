package scripts_mastbit;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_mastbit.Base_Mastbit;
import jxl.read.biff.BiffException;
import pages_mastbit.Mail_Verify;

public class TC2_Login extends Base_Mastbit 
	
      {
	
		@Test(dataProvider="data")
		public void test2(String name,String user,String password) throws InterruptedException, IOException, BiffException
		{
			//driver.findElement(By.xpath(pr.getProperty("crossbtn"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(pr.getProperty("login"))).click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			  driver.findElement(By.xpath(pr.getProperty("loginemail"))).sendKeys(user);
		       
		     
		     driver.findElement(By.xpath(pr.getProperty("password2"))).sendKeys(password);
		     
		     Thread.sleep(120000);
		 	//driver.findElement(By.xpath(pr.getProperty("cap"))).click();
		 	driver.findElement(By.xpath(pr.getProperty("loginBtm"))).click();
		 	Thread.sleep(4000);
		   
		}
		
	
	
	
	

}
