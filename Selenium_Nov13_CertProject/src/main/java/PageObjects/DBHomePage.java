package PageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.Utils;

import CommonClasses.Constants;
import CommonClasses.Drivers;
import CommonClasses.WebDriverCommonLib;
import io.cucumber.messages.types.Timestamp;

public class DBHomePage {

	public WebDriver driver = Drivers.driver;
	static WebDriverCommonLib wlib = new WebDriverCommonLib();
	static Alert alert;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	/**
	 * @FindBy is used in POM for the Object locators for Home Page elements The
	 *         Object locators for Home Page elements are listed below
	 */

	// Product Store text
	@FindBy(xpath = "//a[contains(text(),'CATEGORIES')]")
	static WebElement categoriesText;

	// Home Link
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	static WebElement homeLink;

	// Contact Link
	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	private static WebElement contactLink;

	// About Us Link
	@FindBy(xpath = "//a[contains(text(),'About us')]")
	private static WebElement aboutUsLink;

	// Cart Link
	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	private static WebElement cartLink;

	// Log in Link
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	private static WebElement logInLink;

	// Sign Up link
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	private static WebElement signUpLink;

	// Close Button
	@FindBy(xpath = "//button(text(),'Close')]")
	private static WebElement closeBtn;
	
// Log into Demo Blaze application
	public void loadDBApplication() {

		// hit the url
		driver.get(Constants.appUrl);

		// maximize the window
		wlib.maximize(driver);

	}

	////////////////////////// Test #1///////////////////////////////////////
	//Validate the menu links on the Demo Blaze Home Page
	public void validateLinks(String menuItem) throws InterruptedException {
		
		System.out.println("-----------------Test 1 --------------");
		System.out.println(menuItem);
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);

		switch (menuItem) {

		// Links Navigates to different window
		case "Home":
			{

			System.out.println("---------Home Link--------");

			WebElement menuElementHome = driver.findElement(By.xpath("//*[contains(text(),'Home')]")); 
			menuElementHome.click();
			System.out.println("Menu Element displayed");
		

			WebElement cat = driver.findElement(By.xpath("//a[contains(text(),'CATEGORIES')]")); 
			String foundText = cat.getText();
			System.out.println("Found Text: " + foundText);
			System.out.println("Home Link is displayed");
			break;
			}
	    

		case "Contact":
		{

			System.out.println("---------Test 1 - Contact--------");

			WebElement menuElementContact2 = driver.findElement(By.xpath("//li/a[contains(text(),'Contact')]")); 
			menuElementContact2.click();
			
				System.out.println("Menu Element displayed: " + menuElementContact2);
			

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // The int here is the maximum time
																					// in seconds the element can wait.
			WebElement contactTitle = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='exampleModalLabel']")));
			
				contactTitle.getText();
				System.out.println("Contact Title has been validated: " + contactTitle);

				WebElement closeButton = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Close']")));
				closeButton.click();

				System.out.println("Close button validated");
				break;
		}
	   

		case "About us":
		{

			System.out.println("---------Test 1 - About us--------");

			WebElement menuElementAboutUs = driver.findElement(By.xpath("//li/a[contains(text(),'About us')]")); 
				System.out.println("About Us found");
			menuElementAboutUs.click();
			System.out.println("Menu Element displayed");
			

			WebDriverWait waitAbout = new WebDriverWait(driver, Duration.ofSeconds(300));
			System.out.println("Wait is working");
			WebElement modalContentAbout = waitAbout
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='videoModal']")));
			System.out.println("Found Modal");
			WebElement aboutTitle = modalContentAbout.findElement(By.xpath("//h5[@id='videoModalLabel']"));
			aboutTitle.getText();
			System.out.println("Contact Title has been validated: " +aboutTitle);

			WebElement closeButtonAbout = waitAbout.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='videoModal']//*[(text()='Close')]")));
			closeButtonAbout.click();

			System.out.println("Close button validated");
			break;
		}
	  

		case "Cart":
		{

			System.out.println("---------Test 1 - Cart--------");
			
			String parent=driver.getWindowHandle();
			System.out.println(parent);

			WebElement menuElementCart4 = driver.findElement(By.xpath("//li/a[contains(text(),'Cart')]")); 
			menuElementCart4.click();
			System.out.println("Menu Element displayed");
									
			Thread.sleep(1000);
			String message4 = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).getText();

				System.out.println("Found Text: " + message4);

//				driver.switchTo().window(parent);
				driver.navigate().back();
				Thread.sleep(500);
				String parentUrl = driver.getCurrentUrl();
				System.out.println(parentUrl);
				
				break;
		}
	    
		
		case "Log in":
		{

			System.out.println("------------Test 1 - Log in--------");

			WebElement menuElementLogIn5 = driver.findElement(By.xpath("//li/a[contains(text(),'Log in')]")); 
			menuElementLogIn5.click();
			System.out.println("Log in Menu Element activated");
			
			WebDriverWait waitLogin = new WebDriverWait(driver, Duration.ofSeconds(60)); // The int here is the maximum
																							// time
			WebElement loginTitle = waitLogin
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='logInModalLabel']"))); 
			loginTitle.getText();
			System.out.println("Login Title has been validated: " + loginTitle);

			WebElement closeBtnLogin = waitLogin
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='logInModal']//*[(text()='Close')]")));
			System.out.println("Close button visible");
			closeBtnLogin.click();

			System.out.println("Close button validated");
			break;
		}

		case "Sign up":
		{

			System.out.println("---------Test 1 - Sign up--------");

			WebElement menuElementSignUp = driver.findElement(By.xpath("//li/a[contains(text(),'Sign up')]")); 
				menuElementSignUp.click();
			System.out.println("Sign up Menu Element activated");
			
				
			WebDriverWait waitSignUp = new WebDriverWait(driver, Duration.ofSeconds(60)); // The int here is the maximum
																							// time
			
			WebElement signUpTitle = waitSignUp
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='signInModalLabel']")));
			
				signUpTitle.getText();
				System.out.println("Sign Up Title has been validated: " + signUpTitle);

				WebElement closeButtonSignup = waitSignUp
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='signInModal']//*[(text()='Close')]")));
				closeButtonSignup.click();

				System.out.println("Close button validated");
				break;
			}
		}
	}

	////////////////////////// Test #2///////////////////////////////////////

	// Page actions = Features of the page - form of methods
	public void getDBHomePageTitle() {
		System.out.println("-------------------- Test 2 ---------------------");

		String actualTitle = driver.getTitle();
		String expectedTitle = "STORE";

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title Matched = " + actualTitle);
		}else {
			System.out.println("Title didn't match");
		}
		
		driver.close();
		System.out.println("Close button validated");

	}
    
}