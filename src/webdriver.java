

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriver {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		//driver.get("file:///../items.html");
		
		// 1	
		System.out.println(driver.findElement(By.xpath("//span[@class='title ng-binding'][3]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[@class='title ng-binding'][5]")).getText());
		
		//2	
		HashMap<String, String> map = new HashMap<String, String>();
		
		List<WebElement> foodNames = driver.findElements(By.xpath("//span[@class='title ng-binding']"));
		List<WebElement> foodDescriptions = driver.findElements(By.xpath("//span[@class='description ng-binding']"));
				
		Iterator<WebElement> foodItr = foodNames.iterator();
		Iterator<WebElement> descItr = foodDescriptions.iterator();
		while(foodItr.hasNext() && descItr.hasNext()) {
			map.put(foodItr.next().getText(), descItr.next().getText());
		}
		
		/* if the structure would be like this, where each item is enclosed in a separate div or span, it would be more convenient to iterate:
		<div class=”itemContent”>
		<span class="title ng-binding" ng-bind="food.name">Apple butter</span>
		<span class="description ng-binding" ng-bind="food._servingDesc">1 Tbsp</span>
		</div> 
		<div class=”itemContent”>
		<span class="title ng-binding" ng-bind="food.name">Apple butter</span>
		<span class="description ng-binding" ng-bind="food._servingDesc">1 Tbsp</span>
		</div> */
		
		for (HashMap.Entry<String, String> entry : map.entrySet()) { 
			System.out.println("FoodName = " + entry.getKey() + ", Decsription = " + entry.getValue()); 
			}
		
		driver.quit();
	}
}
