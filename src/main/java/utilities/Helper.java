package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Random;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Helper {


	public static void scroll_to_element(WebElement element, WebDriver driver) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}




	public static void  captureScreenShot(WebDriver driver, String screenshotname) {

		Path dest = Paths.get("./Screenshots",screenshotname+".png");

		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out =  new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception while getting screenshot" + e.getMessage());
		}
	}


	public static String getScreenShotAsBase64(WebDriver driver) throws IOException {

		File Source =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/image.png";
		FileUtils.copyFile(Source, new File(path));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
		return Base64.getEncoder().encodeToString(imageBytes);
	}
	public static String fakeEmail() {
		String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
		String email = "user"+ userName +"@gmail.com";
		return email;
	}


	public static String fakePassword() 
	{
		int length = 15;
		String symbol = "-/.^&*_!@%=+>)"; 
		String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String small_letter = "abcdefghijklmnopqrstuvwxyz"; 
		String numbers = "0123456789"; 


		String finalString = cap_letter + small_letter + 
				numbers + symbol; 

		Random random = new Random(); 

		char[] password = new char[length]; 

		for (int i = 0; i < length; i++) 
		{ 
			password[i] = 
					finalString.charAt(random.nextInt(finalString.length())); 

		} 
		String fakepassword = String.valueOf(password);
		return fakepassword;
	}


	public static void hoverElement(WebElement element , WebDriver driver) {

		Actions ac = new Actions(driver);
		Helper.scroll_to_element(element, driver);
		ac.moveToElement(element).perform();
	}
}
