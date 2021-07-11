package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.readprop;

public class PaymentPage {

	WebDriver driver;
	ExtractorData ex;
	readprop read;
	WebDriverWait wait;

	public PaymentPage (WebDriver driver) {

		this.driver=driver;
	}
	
	public void clickPayByCheckAndConfirm() throws Exception{
		wait = new WebDriverWait(driver, 30);
		ex = new ExtractorData();
		
		WebElement paybByCheck = driver.findElement(By.xpath(ex.Locaters("PaymentPage", 1)));
		paybByCheck.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ex.Locaters("PaymentPage", 2))));
		
		WebElement confirmOrderBttn = driver.findElement(By.xpath(ex.Locaters("PaymentPage", 2)));
		confirmOrderBttn.click();
	}
}
