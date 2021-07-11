package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Helper;

public class LoginPage {

	WebDriver driver;
	ExtractorData ex;
	static String registeredemail ;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public void loginToAccount() throws Exception {
		ex = new ExtractorData();
		
		WebElement email = driver.findElement(By.id(ex.Locaters("LoginPage", 3)));
		email.sendKeys(registeredemail);
		WebElement password = driver.findElement(By.id(ex.Locaters("LoginPage", 4)));
		password.sendKeys(AccountCreation.registeredPass);
		WebElement signinBttn = driver.findElement(By.id(ex.Locaters("LoginPage", 5)));
		signinBttn.click();
		
	}
	
	public void createAccount() throws Exception {
		ex = new ExtractorData();
		WebElement newemail = driver.findElement(By.id(ex.Locaters("LoginPage", 1)));
		registeredemail = Helper.fakeEmail();
		newemail.sendKeys(registeredemail);
		WebElement createaccountBttn =  driver.findElement(By.id(ex.Locaters("LoginPage", 2)));
		createaccountBttn.click();

	}
}
