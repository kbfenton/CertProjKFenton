package PageObjects;

import java.time.Duration;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonClasses.Constants;
import CommonClasses.Drivers;
import CommonClasses.MSXcelAutomation;
import CommonClasses.WebDriverCommonLib;
import io.cucumber.datatable.DataTable;

public class DBLoginPage {

	WebDriver driver = Drivers.driver;
	WebDriverCommonLib commLib = new WebDriverCommonLib();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	String username;
	String password;
	Boolean isRequired;

	@FindBy(xpath = "//li/a[contains(text(),'Log in')]")
	private static WebElement loginLink;

	@FindBy(xpath = "//input[@id='loginusername']")
	private static WebElement usernameField;

	@FindBy(xpath = "//input[@id='loginpassword']")
	private static WebElement passwordField;

	@FindBy(xpath = "//button[text()='Log in']")
	private static WebElement loginBtn;

//	@FindBy(xpath = "//button[contains(text(),'Close')]")
	@FindBy(xpath = "//div[@id='logInModal']//div[@class='modal-footer']//button[@class='btn btn-secondary']")
	private WebElement closeBtn;

	@FindBy(xpath = "//a[@id='nameofuser']")
	private WebElement nameofuser;

	@FindBy(xpath = "//li/a[contains(text(),'Log out')]")
	private static WebElement logoutLink;

	public DBLoginPage() {
		PageFactory.initElements(driver, this);
	}

	// And user clicks on Log in link
	public void clicksLogInLink() {

		System.out.println("-------------------- Test 4 ---------------------");

		WebElement menuElementLogIn5 = driver.findElement(By.xpath("//li/a[contains(text(),'Log in')]"));
		menuElementLogIn5.click();
		System.out.println("Log in Menu Element activated");

		WebDriverWait waitLogin = new WebDriverWait(driver, Duration.ofSeconds(60)); // The int here is the maximum
																						// time
		WebElement loginTitle = waitLogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='logInModalLabel']")));
		loginTitle.getText();
		System.out.println("Login Title has been validated: " + loginTitle);

	}

	// Get data from excel for Username and Password
	public void doLogin(String username, String password) {

		usernameField.clear();
		usernameField.sendKeys(username);

		passwordField.clear();
		passwordField.sendKeys(password);

		// To check empty fields , we need to check "required" field is on an attribute
		loginBtn.click();

		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();

			if (alertText.equalsIgnoreCase("User does not exist.")) {
				System.out.println("ALERT Text - User does not exist.");
				alert.accept();
			} else if (alertText.equalsIgnoreCase("Wrong password.")) {
				System.out.println("ALERT Text - Wrong password..");
				alert.accept();
			} else if (alertText.equalsIgnoreCase("Please fill out Username and Password.")) {
				System.out.println("ALERT Text - Please fill out Username and Password.");
				alert.accept();
			}

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
			closeBtn.click();

		} catch (Exception e) {
			String Greeting = nameofuser.getText();
			System.out.println(Greeting);
			logoutLink.click();
			driver.close();
		}

	}

}
