package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogin extends BasePage {

	public AccountLogin(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement msgConfirm;

	public void setEmail(String email) {
		Username.sendKeys(email);
	}

	public void setPassword(String password) {
		Password.sendKeys(password);
	}

	public void Submit() {
		LoginButton.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirm.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}

}
