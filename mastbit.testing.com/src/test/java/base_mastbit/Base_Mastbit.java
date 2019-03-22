package base_mastbit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities_mastbit.ScreenShot;

public class Base_Mastbit {

	public WebDriver driver;
	public Properties pr;

	@BeforeMethod
	@Parameters({ "browser" })
	public void setup(String browser) throws IOException {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/ExeDrivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/ExeDrivers/geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/ExeDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		else
			System.out.println("Browser is not correct");

		File f = new File("./mastbit.testing.com/OR.properties");
		// File f =new File("C:\\Users\\Tamanna Sharma\\Desktop\\Jyoti
		// QA\\mastbit.testing.com\\OR.properties");
		FileInputStream fis = new FileInputStream(f);
		pr = new Properties();
		pr.load(fis);
		driver.get(pr.getProperty("url3"));
		driver.get(pr.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@DataProvider(name = "data")
	public Object[][] data() throws BiffException, IOException {

		File f = new File("./mastbit.testing.com/mastbit_data.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sheet = wb.getSheet("Sheet1");

		int row = sheet.getRows();
		int col = sheet.getColumns();
		Object[][] obj = new Object[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Cell c1 = sheet.getCell(j, i);
				obj[i][j] = c1.getContents();
			}
		}
		return obj;
	}

	@AfterMethod
	public void teardown(ITestResult res) {
		if (ITestResult.FAILURE == res.getStatus()) {
			ScreenShot.take_screenshot(driver, res.getName());
		}

		driver.close();
	}

}
