package utilities;

import org.openqa.selenium.WebDriver;

public class VerifyPage {
	public static boolean isUrlContains(WebDriver driver,String segment) {
		return driver.getCurrentUrl().contains(segment);
	}
    
    public static boolean isElementNameExist(WebDriver driver,String name) {
		return driver.getPageSource().contains(name);
}
 
    public static boolean isMessageExist(WebDriver driver,String messageSegment) {
		return driver.getPageSource().contains(messageSegment);
}
    
}