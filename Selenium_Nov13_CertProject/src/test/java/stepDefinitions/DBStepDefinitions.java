package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.errorprone.annotations.Var;

import CommonClasses.DBExcelReader;
import CommonClasses.Constants;
import CommonClasses.Drivers;
import CommonClasses.MSXcelAutomation;
import CommonClasses.WebDriverCommonLib;
import PageObjects.DBHomePage;
import PageObjects.DBLoginPage;
import PageObjects.DBSignupPage;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DBStepDefinitions {

	public WebDriver driver = Drivers.driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebDriverCommonLib wlib = new WebDriverCommonLib();
	DBHomePage dbHomePg = PageFactory.initElements(driver, DBHomePage.class);
	DBLoginPage dbLoginPg = PageFactory.initElements(driver, DBLoginPage.class);
	DBSignupPage dbSignupPg = PageFactory.initElements(driver, DBSignupPage.class);

	String username;
	String password;
	Boolean isRequired;

	// ----------------BACKGROUND------------------------
	@Given("the user is on the Google web browser")
	public void the_user_is_on_the_google_web_browser() throws InterruptedException {

		System.out.println("WebBrowser was Initiated");

	}

	@When("the user navigates to the demo_blaze website")
	public void the_user_navigates_to_the_demo_blaze_website() {

		dbHomePg.loadDBApplication();

	}

	// ---------------- @test1 ------------------------

	@Then("views the list of {string} links on the site are valid")
	public void viewsTheListOfLinksOnTheSiteAreValid(String element) throws InterruptedException {

		dbHomePg.validateLinks(element);

	}

	// ---------------- @test2 ------------------------

	@Then("validate the Header on the Home Page")
	public void validate_the_title_on_the_home_page() {
		dbHomePg.getDBHomePageTitle();

	}

	// ---------------- @test3 ------------------------

	@And("user clicks on Sign up link")
	public void user_clicks_on_sign_up_link() throws InterruptedException {
		dbSignupPg.clickSignUpLink();

	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		dbSignupPg.enterSignupPage(username, password);
	}

	@And("user clicks on Sign up button")
	public void user_clicks_on_Sign_up_button() {
		dbSignupPg.clickSignupBtn();
	}

	@Then("user clicks Close button")
	public void user_clicks_Close_button() {
		dbSignupPg.clicksCloseBtn();
	}

	// ---------------- @test4 ------------------------

	@And("user clicks on Log in link")
	public void user_clicks_on_log_in_link() {
		dbLoginPg.clicksLogInLink();

	}

	// ---------Enter Sheetname and Rownumber to get Username/Password---------
	@When("The user enters sheetname {string} and {int}")
	public void the_user_enters_sheetname_and(String sheetname, Integer rownumber)
			throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {

		System.out.println("Entered getting Excel - Stage 4");
		DBExcelReader dbexcelReader = new DBExcelReader();

		List<Map<String, String>> testData = dbexcelReader.getData(Constants.testDataSheetPath, sheetname);
		System.out.println(testData);

		username = testData.get(rownumber).get("username");
		password = testData.get(rownumber).get("password");

		dbLoginPg.doLogin(username, password);
		
	}

}
