package testCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountLogin;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountLogin extends BaseClass{
	 
	@Test
	 public void test_account_login() throws InterruptedException { 
		logger.debug("Application Logs....");
		logger.info("starting TC001"); 
		AccountLogin al=new AccountLogin(driver);
		al.setEmail("standard_user");
		logger.info("Entered Username");
		al.setPassword("secret_sauce");
		logger.info("Entered Password");
		al.Submit();
		logger.info("Clicked Login");
		String confirm=al.getConfirmationMsg();
		Assert.assertEquals(confirm,"Swag Labs");
	}

	
}
