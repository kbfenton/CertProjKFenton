package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import CommonClasses.Drivers;
import CommonClasses.WebDriverCommonLib;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;


public class Hooks {
	public WebDriver driver = Drivers.driver;
	WebDriverCommonLib wlib = new WebDriverCommonLib();

	@Before()
	public void initiateBrowser() {
		Drivers.getBrowser();
	}
	
	@After()
	  public void closeBrowser(){
        try{
        driver.quit();
        } catch(NullPointerException e){
            System.out.println("NullPointerException thrown!");
        }	
	}

}
