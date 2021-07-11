package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {
	WebDriver driver;
	ExtractorData ex;
	static String registeredemail ;

	public OrderConfirmationPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getOrderConfirmationMessage() throws Exception{
		
		ex = new ExtractorData();
		WebElement confirmationMessage = driver.findElement(By.xpath(ex.Locaters("OrderConfirmationPage", 1)));
		return confirmationMessage.getText();
	}
}
