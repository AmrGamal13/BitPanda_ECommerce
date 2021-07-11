package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.readprop;

public class AddressPage {

	WebDriver driver;
	ExtractorData ex;
	readprop read;
	public AddressPage (WebDriver driver) {

		this.driver=driver;
	}
	
	public void clickProceedCheckoutAddress() throws Exception{
		ex = new ExtractorData();
		WebElement proceedCheckOut = driver.findElement(By.name(ex.Locaters("AddressPage", 1)));
		proceedCheckOut.click();
		
	}
}
