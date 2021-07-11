package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.readprop;

public class ShippingPage {
	WebDriver driver;
	ExtractorData ex;
	readprop read;
	public ShippingPage (WebDriver driver) {

		this.driver=driver;
	}
	
	public void clickAgreeTerms() throws Exception{
		
		ex = new ExtractorData();
		WebElement proceedCheckOut = driver.findElement(By.id(ex.Locaters("ShippingPage", 1)));
		proceedCheckOut.click();
	}
	public void clickProceedCheckoutShipping() throws Exception{
		ex = new ExtractorData();
		WebElement proceedCheckOut = driver.findElement(By.name(ex.Locaters("ShippingPage", 2)));
		proceedCheckOut.click();
		
	}
}
