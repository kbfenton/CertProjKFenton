package CommonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {
	public static WebDriver driver;

	public static WebDriver getBrowser() {

		if (Constants.browser.equalsIgnoreCase("chrome")) {

			// Set the properties
			System.setProperty("webdriver.chrome.driver", "..\\Selenium_Nov13_Automation\\drivers\\chromedriver.exe");

			// launch the light browser
			driver = new ChromeDriver();
			
			//Which Browser is invoked
			System.out.println("Which Browser is invoked = "+Constants.browser);

		} else if (Constants.browser.equalsIgnoreCase("firefox")) {

			// Set the properties
			System.setProperty("webdriver.firefox.driver", "..\\Selenium_Nov13_Automation\\drivers\\geckodriver.exe");

			// launch the light browser
			driver = new FirefoxDriver();
			
			//Which Browser is invoked
			System.out.println("Which Browser is invoked = "+Constants.browser);
			

		} else if (Constants.browser.equalsIgnoreCase("Edge")) {

			// Set the properties
			System.setProperty("webdriver.safari.driver", "..\\Selenium_Nov13_Automation\\drivers\\msedgedriver.exe");

			// launch the light browser
			driver = new EdgeDriver();
			
			//Which Browser is invoked
			System.out.println("Which Browser is invoked = "+Constants.browser);
		}

	return driver;
	
	}


}
