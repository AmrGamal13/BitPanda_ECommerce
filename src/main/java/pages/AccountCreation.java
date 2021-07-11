package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.Helper;
import utilities.readprop;

public class AccountCreation {

	WebDriver driver;
	ExtractorData ex;
	readprop read;
	static String registeredPass;

	public AccountCreation(WebDriver driver) {

		this.driver = driver;
	}


	public void Register() throws Exception {
		read = new readprop();
		ex = new ExtractorData();

		WebElement firstnameField = driver.findElement(By.id(ex.Locaters("CreateAccountPage", 2)));
		firstnameField.sendKeys(read.getPropValues("FirstName", "data.properties"));

		WebElement lastnameField = driver.findElement(By.id(ex.Locaters("CreateAccountPage", 3)));
		lastnameField.sendKeys(read.getPropValues("LastName", "data.properties"));

		WebElement passwordField = driver.findElement(By.id(ex.Locaters("CreateAccountPage", 4)));
		registeredPass = Helper.fakePassword();
		passwordField.sendKeys(registeredPass);

		WebElement addressField = driver.findElement(By.id(ex.Locaters("CreateAccountPage", 5)));
		addressField.sendKeys(read.getPropValues("Address", "data.properties"));

		WebElement cityField = driver.findElement(By.id(ex.Locaters("CreateAccountPage", 6)));
		cityField.sendKeys(read.getPropValues("City", "data.properties"));

		selectState();

		WebElement postcodeField = driver.findElement(By.id(ex.Locaters("CreateAccountPage", 8)));
		postcodeField.sendKeys(read.getPropValues("PostalCode", "data.properties"));

		WebElement mobileField = driver.findElement(By.id(ex.Locaters("CreateAccountPage", 9)));
		mobileField.sendKeys(read.getPropValues("MobilePhone", "data.properties"));

		WebElement registerBttnField = driver.findElement(By.id(ex.Locaters("CreateAccountPage", 11)));
		registerBttnField.click();
	}


	public void selectState () throws Exception {
		ex = new ExtractorData();
		read = new readprop();
		Select sel =  new Select(driver.findElement(By.id(ex.Locaters("CreateAccountPage", 7))));
		sel.selectByVisibleText(read.getPropValues("State", "data.properties"));

	}
	
	public void LogOut() throws Exception {
		ex = new ExtractorData();
		WebElement signoutField = driver.findElement(By.xpath(ex.Locaters("CreateAccountPage", 12)));
		signoutField.click();
		
	}
}