package webdriverstructured.utils;

import org.openqa.selenium.By;

public class ItemContentUtil {

	public static By getNameItem3() {		
		return By.xpath("//span[@class='title ng-binding'][3]");
	}
	
	public static By getNameItem5() {		
		return By.xpath("//span[@class='title ng-binding'][5]");
	}
	
	public static By getAllItemNames() {		
		return By.xpath("//span[@class='title ng-binding']");
	}
	
	public static By getAllItemDesc() {		
		return By.xpath("//span[@class='description ng-binding']");
	}
	
}
