package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;
import utilities.readprop;

public class TestBase {

	public static WebDriver driver;
	//ReadProperties read;
	readprop read;

	ExtentReports extent;
	ExtentSparkReporter spark;
	@BeforeSuite
	public void before() throws IOException 
	{
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Report.html");
		final File CONF = new File ("extentconfig.xml");
		spark.loadXMLConfig(CONF);
		extent.attachReporter(spark);
		

		System.out.println("Intitalizing the browser");
		read = new readprop();
		if (read.getPropValues("browserName", "config.properties").equalsIgnoreCase("chrome")) {

			if (read.getPropValues("executionType", "config.properties").equalsIgnoreCase("local")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions capability = new ChromeOptions();
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
				capability.addArguments("--no-sandbox");
				capability.addArguments("--disable-dev-shm-usage");
				driver =  new ChromeDriver(capability);
			}

			else if (read.getPropValues("executionType", "config.properties").equalsIgnoreCase("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver = new ChromeDriver(options);
			}
		}

		else if (read.getPropValues("browserName", "config.properties").equalsIgnoreCase("firefox")) {
			if (read.getPropValues("executionType", "config.properties").equalsIgnoreCase("local")) {
				WebDriverManager.firefoxdriver().setup();
				driver =  new FirefoxDriver();
			}
			else if (read.getPropValues("executionType", "config.properties").equalsIgnoreCase("headless")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver = new FirefoxDriver();
			}
		}

		else if (read.getPropValues("browserName", "config.properties").equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();		
			driver =  new InternetExplorerDriver();
		}

		else if (read.getPropValues("browserName", "config.properties").equalsIgnoreCase("chrome-headless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(read.getPropValues("URL", "config.properties"));

	}

	@AfterSuite
	public void quitBrowser() throws IOException 
	{
		driver.quit();
		extent.flush();
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}

	@AfterMethod
	public void ScreenhotFailure(ITestResult result)
	{
		if (result.getStatus()== ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenShot(driver, result.getName());
		}

	}

}

