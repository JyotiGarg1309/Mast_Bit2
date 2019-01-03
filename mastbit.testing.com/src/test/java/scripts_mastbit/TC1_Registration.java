package scripts_mastbit;

import java.io.IOException;

import org.testng.annotations.Test;

import base_mastbit.Base_Mastbit;
import jxl.read.biff.BiffException;
import pages_mastbit.Mail_Verify;
import pages_mastbit.Registration;

public class TC1_Registration extends Base_Mastbit {
	
	@Test(dataProvider="data")
	public void test1(String name,String user,String password) throws InterruptedException, IOException, BiffException
	{
		Thread.sleep(5000);
		Registration reg =new Registration(driver ,pr);
		
	     reg.register(name,user,password);
	     Thread.sleep(3000);
	     
	     Mail_Verify mailvfy =new Mail_Verify(driver,pr);
	     mailvfy.mail_verify(name,user,password);
	   
	   
	}
	

}
