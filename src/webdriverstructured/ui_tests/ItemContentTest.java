package webdriverstructured.ui_tests;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webdriverstructured.utils.ItemContentUtil;
import webdriverstructured.utils.Utils;
import webdriverstructured.utils.WebDriverProvider;


public class ItemContentTest extends WebDriverProvider{

	private static WebDriver driver = null; 
	private WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@BeforeClass
	public static void setUpBeforeClass()  {	
		driver = getDriver();
		driver.get(Utils.getFile(Utils.ITEM_CONTENT_PAGE));
	}
	
	@Test
	public void testprintItemNames3() {
		
		String itemName3 = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		        		ItemContentUtil.getNameItem3())).getText();
		System.out.println(itemName3);
		assertEquals(Utils.itemName3, itemName3);
	}
	
	@Test
	public void testprintItemNames5() {
	
		String itemName5 = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		        		ItemContentUtil.getNameItem5())).getText();
		System.out.println(itemName5);
		assertEquals(Utils.itemName5, itemName5);
	}
	
	@Test
	public void printAllItemsFromMap() {
	
		LinkedHashMap<String, String> map = createMap();
		
		for (HashMap.Entry<String, String> entry : map.entrySet()) { 
			System.out.println("FoodName = " + entry.getKey() + "; Decsription = " + entry.getValue()); 
			}
		assertTrue(true);
	}
	
	
	private static LinkedHashMap<String, String> createMap() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		List<WebElement> foodNames = driver.findElements(ItemContentUtil.getAllItemNames());
		List<WebElement> foodDescriptions = driver.findElements(ItemContentUtil.getAllItemDesc());
				
		Iterator<WebElement> foodItr = foodNames.iterator();
		Iterator<WebElement> descItr = foodDescriptions.iterator();
		while(foodItr.hasNext() && descItr.hasNext()) {
			map.put(foodItr.next().getText(), descItr.next().getText());
		}
		return map;	
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		driver.quit();
	}
}
