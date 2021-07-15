package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pages.AccountCreation;
import pages.AddressPage;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.PaymentPage;
import pages.SearchResultsPage;
import pages.ShippingPage;
import utilities.Helper;
import utilities.readprop;

public class RegisterAnAccountTest extends TestBase {

	LoginPage loginOb;
	HomePage homeObj ; 
	AccountCreation accouObj;
	readprop read;
	SearchResultsPage searchObj;
	CartPage carObj;
	AddressPage addObj;
	ShippingPage shipObj;
	PaymentPage payObj;
	OrderConfirmationPage ordObj;

	@Test (priority = 1)
	public void RegisterAnAccountSuccessfully() throws Exception {
		ExtentTest test = extent.createTest("Register An Account Successfully").
				assignAuthor("Adel").assignCategory("Regression").assignDevice("Chome 91");

		loginOb = new LoginPage(driver);
		homeObj = new HomePage(driver);
		accouObj = new AccountCreation(driver);
		read = new readprop();

		test.log(Status.INFO, "Click on Sign in Button");
		homeObj.clickOnSign();

		test.log(Status.INFO, "Create new Account");
		loginOb.createAccount();

		test.log(Status.INFO, "Register new Account");
		accouObj.Register();

		test.log(Status.INFO, "Log out after resgistering");
		accouObj.LogOut();

		test.log(Status.INFO, "Log in with the new account");
		loginOb.loginToAccount();

		try {
			Assert.assertTrue(driver.getTitle().equals(read.getPropValues("TitleAfterLogging", "config.properties")));
			test.pass("Test Case Passed");

		} catch (AssertionError e) {
			test.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenShotAsBase64(driver)).build());
		}


	}

	@Test(priority = 2)
	public void AddItemFromSearch() throws IOException, Exception {
		ExtentTest test = extent.createTest("Add Item by searching using the search text box").
				assignAuthor("Adel").assignCategory("Regression").assignDevice("Chome 91");
		homeObj = new HomePage(driver);
		searchObj = new SearchResultsPage(driver);
		read = new readprop();
		test.log(Status.INFO, "Click on the logo");
		homeObj.clickOnLogo();

		test.log(Status.INFO, "Search for a product by the name");
		homeObj.searchForProduct(read.getPropValues("SearchItemName", "data.properties"));

		test.log(Status.INFO, "select the item and add it to the cart");
		searchObj.addItem();

		try {
			Assert.assertTrue(searchObj.addingSuccessMessage().isDisplayed());
			test.pass("Test Case Passed");

		} catch (AssertionError e) {
			test.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenShotAsBase64(driver)).build());
		}

		test.log(Status.INFO, "click on continue shopping");
		searchObj.ClickOnContinueShopping();
	}

	@Test(priority = 3)
	public void AddItemFromWomenCategory() throws Exception
	{
		ExtentTest test = extent.createTest("Add Item from women category").
				assignAuthor("Adel").assignCategory("Regression").assignDevice("Chome 91");

		homeObj = new HomePage(driver);
		searchObj = new SearchResultsPage(driver);

		test.log(Status.INFO, "Click on the logo");
		homeObj.clickOnLogo();

		test.log(Status.INFO, "Click on casual dress from women tab");
		homeObj.navigateToWomenCasualDress();

		test.log(Status.INFO, "Select the item and add it to the cart");
		searchObj.addItem();
		try {
			Assert.assertTrue(searchObj.addingSuccessMessage().isDisplayed());
			test.pass("Test Case Passed");

		} catch (AssertionError e) {
			test.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenShotAsBase64(driver)).build());
		}

		test.log(Status.INFO, "click on continue shopping");
		searchObj.ClickOnContinueShopping();

	}  
	@Test(priority = 4)
	public void AddItemFromTshirts() throws Exception
	{
		ExtentTest test = extent.createTest("Add Item from T-Shirts tab").
				assignAuthor("Adel").assignCategory("Regression").assignDevice("Chome 91");
		homeObj = new HomePage(driver);
		searchObj = new SearchResultsPage(driver);
		carObj = new CartPage(driver);

		test.log(Status.INFO, "Click on the logo");
		homeObj.clickOnLogo();
		
		test.log(Status.INFO, "Click on the T-Shirts tab");
		homeObj.clickOnTshirts();
		
		test.log(Status.INFO, "Select the item and add it to the cart");
		searchObj.addItem();
		try {
			Assert.assertTrue(searchObj.addingSuccessMessage().isDisplayed());
			test.pass("Test Case Passed");

		} catch (AssertionError e) {
			test.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenShotAsBase64(driver)).build());
		}
		test.log(Status.INFO, "click on continue shopping");
		searchObj.ClickOnProceedCheckout();

	} 

	@Test(priority = 5)
	public void verifyItemIsDeleted() throws Exception
	{
		ExtentTest test = extent.createTest("Verify the item is deleted successfully").
				assignAuthor("Adel").assignCategory("Regression").assignDevice("Chome 91");
		
		homeObj = new HomePage(driver);
		searchObj = new SearchResultsPage(driver);
		carObj = new CartPage(driver);
		
		test.log(Status.INFO, "Delete the item number 3 from the shopping cart");
		carObj.DeleteItem(3);
		try {
			Assert.assertTrue(carObj.getProductsQuantity().contains("2"));
			test.pass("Test Case Passed");

		} catch (AssertionError e) {
			test.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenShotAsBase64(driver)).build());
		}

	} 
	
	@Test(priority = 6)
	public void verifyUserCanCheckout() throws Exception{
		ExtentTest test = extent.createTest("Verify User can checkout successfully").
				assignAuthor("Adel").assignCategory("Regression").assignDevice("Chome 91");
		
		carObj = new CartPage(driver);
		addObj = new AddressPage(driver);
		shipObj = new ShippingPage(driver);
		payObj = new PaymentPage(driver);
		ordObj = new OrderConfirmationPage(driver);
		
		test.log(Status.INFO, "click on proceed checkout in shopping Cart Page");
		carObj.clickProceedCheckoutCart();
		
		test.log(Status.INFO, "click on proceed checkout in Address Page");
		addObj.clickProceedCheckoutAddress();
		
		test.log(Status.INFO, "click on accept terms in shipping Page");
		shipObj.clickAgreeTerms();
		
		test.log(Status.INFO, "click on proceed checkout in shipping Page");
		shipObj.clickProceedCheckoutShipping();
		
		test.log(Status.INFO, "click on pay by check & cofirm order in payment Page");
		payObj.clickPayByCheckAndConfirm();
		
		try {
			Assert.assertTrue(ordObj.getOrderConfirmationMessage().contains(read.getPropValues("orderConfirmationMessage", "data.properties")));
			test.pass("Test Case Passed");

		} catch (Exception e) {
			test.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.getScreenShotAsBase64(driver)).build());
		}
	}
}
