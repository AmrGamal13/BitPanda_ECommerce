package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Helper;

public class HomePage {

	WebDriver driver;
	ExtractorData ex;

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	
	public void clickOnSign() throws Exception {
		
		ex = new ExtractorData();
		WebElement signin_link= driver.findElement(By.xpath(ex.Locaters("HomePage", 1)));
		signin_link.click();

	}
	
	
	public void clickOnLogo() throws Exception {
		ex = new ExtractorData();
		WebElement logo_link= driver.findElement(By.xpath(ex.Locaters("HomePage", 2)));
		logo_link.click();
		
	}
	
	public void searchForProduct (String itemName) throws Exception {
		ex = new ExtractorData();
		WebElement searchTxt= driver.findElement(By.id(ex.Locaters("HomePage", 3)));
		searchTxt.sendKeys(itemName);
		WebElement searchsubmitBttn= driver.findElement(By.name(ex.Locaters("HomePage", 4)));
		searchsubmitBttn.click();
	}
	
	public void navigateToWomenCasualDress() throws Exception {
		ex = new ExtractorData();
		WebElement womenTab = driver.findElement(By.xpath(ex.Locaters("HomePage", 5)));
		Helper.hoverElement(womenTab, driver);
		WebElement casualdressLnk = driver.findElement(By.xpath(ex.Locaters("HomePage", 6)));
		casualdressLnk.click();

	}
	
	public void clickOnTshirts() throws Exception {
		ex = new ExtractorData();
		WebElement TshirtsLnk = driver.findElement(By.xpath(ex.Locaters("HomePage", 7)));
		TshirtsLnk.click();
	}
}
