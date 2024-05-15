package CommonClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverCommonLib {
	
public static Actions act;
	
	public static WebDriverCommonLib commLib;

	/**
	 * This is an implicit wait statement method which is used to wait for page to
	 * load.
	 *
	 * This method checks whether the page has been loaded or not in every 500
	 * milliseconds
	 *
	 * This method can also be used just before hitting the url and it will be
	 * applicable on every line in the code.
	 * 
	 * This method also has a waiting limit for 20 seconds after that it will give
	 * NoSuchElementException.
	 *
	 */
	public void waitForPageToload(WebDriver driver) {

		// Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.globalWait));

	}

	/**
	 * Explicit wait statement to wait for an element to become clickable
	 * 
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.globalWait));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to switch between the windows which are opened by
	 * selenium WebDriver
	 * 
	 * @param windowId
	 */
	public void switchWindowTo(WebDriver driver, String windowId) {
		driver.switchTo().window(windowId);
	}

	/**
	 * User need to provide one data and other as null value to use overloaded frame
	 * switching methods
	 * 
	 * @param id_or_name
	 * @param frameAsElement
	 */
	public void switchingToFrame(WebDriver driver, String id_or_name, WebElement frameAsElement) {

		if (id_or_name != null) {

			driver.switchTo().frame(id_or_name);

		} else {
			driver.switchTo().frame(frameAsElement);
		}
	}
	
	/**
	 * With the help of this method you will be able to wait for the webElement to
	 * be located by the xpath which comes from the user itself
	 * 
	 * @param i
	 */
	public void waitForElementPresent(WebDriver driver, int i) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.globalWait));

//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(i)));

	}

	/**
	 * This webDriver wait statement waits for the element to be visible using the
	 * xpath.
	 * 
	 * @param xpath
	 */
	public void waitForXpathPresent(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.globalWait));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public void verifytext(WebDriver driver, String xpath, String expectedValue) {

		waitForPageToload(driver);
		// boolean flag = false; // build concept
		WebElement element = driver.findElement(By.xpath(xpath));
		String actualtext = element.getText();
		Assert.assertEquals(actualtext, expectedValue, "Actual value is not matching with expected Value");
		
		System.out.println("The expected text is matching the Actual Text");

	}

	public static void switchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	public static void switchWindow(WebDriver driver, String windowId) {
		driver.switchTo().window(windowId);
	}

	public static void dragAndDrop(WebDriver driver, String fromXpath, String toXpath) {
		WebElement from = driver.findElement(By.xpath(fromXpath));
		WebElement To = driver.findElement(By.xpath(toXpath));
		// Using Actions class for Drag and Drop
		act = new Actions(driver);
		act.dragAndDrop(from, To).build().perform();

	}

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
