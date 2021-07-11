package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Helper;
import utilities.readprop;

public class SearchResultsPage {

	WebDriver driver;
	ExtractorData ex;
	readprop read;
	WebDriverWait wait;

	public SearchResultsPage(WebDriver driver) {

		this.driver = driver;
	}

	public void addItem() throws Exception {

		ex = new ExtractorData();
		WebElement productItem = driver.findElement(By.xpath(ex.Locaters("SearchResultsPage", 1)));
		Helper.hoverElement(productItem, driver);

		WebElement addToCartBtn = driver.findElement(By.xpath(ex.Locaters("SearchResultsPage", 2)));
		addToCartBtn.click();

	}

	public WebElement addingSuccessMessage() throws Exception {
		wait = new WebDriverWait(driver, 30);
		ex = new ExtractorData();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ex.Locaters("SearchResultsPage", 3))));
		WebElement message = driver.findElement(By.xpath(ex.Locaters("SearchResultsPage", 3)));
		return message;
	}


	public void ClickOnContinueShopping() throws Exception {
		ex = new ExtractorData();
		WebElement continueBttn = driver.findElement(By.xpath(ex.Locaters("SearchResultsPage",4)));
		continueBttn.click();

	}
	
	public void ClickOnProceedCheckout() throws Exception {
		ex = new ExtractorData();
		WebElement proceedCheckoutBtnn = driver.findElement(By.xpath(ex.Locaters("SearchResultsPage",5)));
		proceedCheckoutBtnn.click();

	}
}
