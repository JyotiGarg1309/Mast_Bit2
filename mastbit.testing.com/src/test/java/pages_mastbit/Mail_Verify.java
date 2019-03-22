package pages_mastbit;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import jxl.read.biff.BiffException;

public class Mail_Verify {

	WebDriver driver;
	Properties pr;

	public Mail_Verify(WebDriver driver, Properties pr) {
		this.driver = driver;
		this.pr = pr;
	}

	public void mail_verify(String name, String user, String password)
			throws InterruptedException, BiffException, IOException {
		driver.get(pr.getProperty("url3"));
		driver.findElement(By.id(pr.getProperty("name"))).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("go"))).click();

		Thread.sleep(2000);
		List<WebElement> allmail = driver.findElements(By.xpath(pr.getProperty("mailinator")));
		System.out.println(allmail.size());

		String MyMailer = "MastBit";

		for (int i = 0; i < allmail.size(); i++) {
			if (allmail.get(i).getText().equals(MyMailer)) {
				System.out.println("Yes we have got mail form " + MyMailer);
				allmail.get(i).click();
				Thread.sleep(4000);

				// Scrolling the window littlebit up

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,100)");

				// switching into iframe to click activation link
				driver.switchTo().frame("msg_body");

				driver.findElement(By.xpath(pr.getProperty("activationLink"))).click();
				break;
			}

		}

		// Entering Mastbit site for login functionality

		Login log = new Login(driver, pr);
		log.login(name, user, password);

	}
}
