
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriver {

	public static void main(String[] args) {
		
		WebDriver driver = new InternetExplorerDriver();
		//make sure active content is enabled in IE
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		
		driver.get(Paths.get("src/items.html").toUri().toString());
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// A
		System.out.println("===== PartA =====");
		System.out.println(wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title ng-binding'][3]"))).getText());
		System.out.println(driver.findElement(By.xpath("//span[@class='title ng-binding'][5]")).getText());
		
		// B	
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		List<WebElement> foodNames = driver.findElements(By.xpath("//span[@class='title ng-binding']"));
		List<WebElement> foodDescriptions = driver.findElements(By.xpath("//span[@class='description ng-binding']"));
				
		Iterator<WebElement> foodItr = foodNames.iterator();
		Iterator<WebElement> descItr = foodDescriptions.iterator();
		while(foodItr.hasNext() && descItr.hasNext()) {
			map.put(foodItr.next().getText(), descItr.next().getText());
		}
		
		/* if the structure would be like this, where each item is enclosed
		   in a separate div or span, it would be more convenient to iterate:
		<div class=”itemContent”>
		<span class="title ng-binding" ng-bind="food.name">Apple butter</span>
		<span class="description ng-binding" ng-bind="food._servingDesc">1 Tbsp</span>
		</div> 
		<div class=”itemContent”>
		<span class="title ng-binding" ng-bind="food.name">Apple butter</span>
		<span class="description ng-binding" ng-bind="food._servingDesc">1 Tbsp</span>
		</div> */
		
		System.out.println("===== PartB =====");
		for (HashMap.Entry<String, String> entry : map.entrySet()) { 
			System.out.println("FoodName = " + entry.getKey() + ", Decsription = " + entry.getValue()); 
			}
		
		driver.quit();
	}
}
