package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.readprop;

public class CartPage {

	WebDriver driver;
	ExtractorData ex;
	readprop read;
	public CartPage (WebDriver driver) {

		this.driver=driver;
	}

	public void DeleteItem (int itemNumber) throws Exception {
		ex = new ExtractorData();
		//String.valueOf(number);		
		String locator = ex.Locaters("CartPage", 1);
		String LocatorwithItemNu = String.format(locator, String.valueOf(itemNumber));
		WebElement el = driver.findElement(By.xpath(LocatorwithItemNu));
		el.click();
		Thread.sleep(5000);
	}
	
	
	public String getProductsQuantity() throws Exception {
		ex = new ExtractorData();
		WebElement productQuantity = driver.findElement(By.xpath(ex.Locaters("CartPage", 3)));
		return productQuantity.getText();
	}
	
	public void clickProceedCheckoutCart() throws Exception{
		ex = new ExtractorData();
		WebElement proceedCheckOut = driver.findElement(By.xpath(ex.Locaters("CartPage", 2)));
		proceedCheckOut.click();
		
	}
}
