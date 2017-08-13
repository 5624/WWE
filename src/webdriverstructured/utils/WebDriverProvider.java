package webdriverstructured.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebDriverProvider {

	/* Here we can specify which driver/ browser we want to use and 
	   if to use local or cloud environment.
       For now we will use just IE driver	*/
	
	public static WebDriver getDriver() {

		//local machine		

		/*switch(Properties.SELENIUM_BROWSER.readValue()){				
		case "chrome": return new ChromeDriver();
		case "firefox" : return new FirefoxDriver(); 
		etc.*/

		// For IE make sure zoom is set to 100% and active content is allowed
		return new InternetExplorerDriver();

	}
}

