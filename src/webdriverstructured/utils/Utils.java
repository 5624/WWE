package webdriverstructured.utils;

import java.nio.file.Paths;

public class Utils {

	// ============== System Constants ==============
	
	public static final String BASE_PATH = "src";
	public static final String ITEM_CONTENT_PAGE = BASE_PATH + "/items.html";
	
	
	// ============== Test Constants ==============
	
	public static final String itemName3 = "Applesauce, unsweetened";
	public static final String itemName5 = "Juice, Cranberry-apple drink";
	
	
	// ============== Global Functions ==============
	
	public static String getFile(String fileName) {
		return Paths.get(fileName).toUri().toString();
	}
	
}
