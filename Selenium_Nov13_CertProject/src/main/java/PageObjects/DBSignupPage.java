package PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonClasses.Constants;
import CommonClasses.Drivers;
import CommonClasses.WebDriverCommonLib;

public class DBSignupPage {

	WebDriver driver = Drivers.driver;
	WebDriverCommonLib commLib = new WebDriverCommonLib();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath = "//input[@id='sign-username']")
	private WebElement newUsername;

	@FindBy(xpath = "//input[@id='sign-password']")
	private WebElement newPassword;

	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement signUpBtn;

	@FindBy(xpath = "///div[@id='signInModal']//*[(text()='Close')]")
	private WebElement closeBtn;

	@FindBy(xpath = "//h5[(text()='Sign up')]")
	private WebElement signUpTitle;

//////////////////////////Test #3///////////////////////////////////////

//////////////////////////Click on Sign Up Link ///////////////////////////////////////

	public void clickSignUpLink() throws InterruptedException {

		System.out.println("-------------------- Test 3 ---------------------");

		WebElement signUpLink = driver.findElement(By.xpath("//li/a[contains(text(),'Sign up')]"));
		{
			signUpLink.click();
			System.out.println("Sign up page opened");

			WebDriverWait waitSignUp = new WebDriverWait(driver, Duration.ofSeconds(60));

			WebElement signUpTitle = waitSignUp
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='signInModalLabel']")));
			{
				signUpTitle.getText();
				System.out.println("Sign Up Title has been validated: " + signUpTitle);

			}
		}
	}

	/////////////////////// Enter Username and Password //////////////////////

	public void enterSignupPage(String Username, String Password) {

		newUsername.sendKeys("TesterLexineTF@gmail.com");
		newPassword.sendKeys("LTF");

	}

/////////////////////// Click on Sign up Button /////////////////////////////////////

	public void clickSignupBtn() {
	
		signUpBtn.click();

		try {
			WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(60));
			waitAlert.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();

			// Getting the text of the alert
			String alertText = alert.getText();
			System.out.println("Sign up Alert text: " + alertText);

			if (alertText.equals("Sign up successful.")) {
				System.out.println("Sign up was successful");

			} else if (alertText.equals("This user already exist.")) {
				System.out.println("User already exist and should go to Log in link");

			} else if (alertText.equals("Please fill out Username and Password.")) {
				System.out.println("No Username and Password was entered");

			} else {
				System.out.println("An Error has occured");
			}

			alert.accept();
		} catch (Exception e) {
			System.out.println("There is no alert");
		}

	}

/////////////////////// Click on Close Button /////////////////////////////////////

	public void clicksCloseBtn() {
		WebDriverWait waitSignUp = new WebDriverWait(driver, Duration.ofSeconds(60)); // The int here is the maximum
		// time

		WebElement closeButtonSignup = waitSignUp.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='signInModal']//*[(text()='Close')]")));
		closeButtonSignup.click();
		System.out.println("Close button was selected and Sign up page was closed");
	}
}