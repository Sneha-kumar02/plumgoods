package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import testbase.WebTestBase;

public class Utility extends WebTestBase{
	public static final long PAGE_LOAD_TIMEOUT = 20;
    public static final long IMPLICITLY_WAIT = 20;
    
	public static void waitUntilElementToBeClick(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void mouseHover(WebDriver driver, WebElement element){
        Actions action=new Actions(driver);
        action.moveToElement(element)
                .build()
                .perform();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public static void switchToWindows(WebDriver driver) {
        String parentWindows = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String s : allWindow) {
            if (!parentWindows.contentEquals(s)) {
                driver.switchTo().window(s);
                driver.close();
            }
            driver.switchTo().window(parentWindows);
        }
    }

    public static void scrollDownByElement(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",element);
    }
    
    public static void scrollUp(WebDriver driver, WebElement logoSign){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy(0,800)");
        javascriptExecutor.executeScript("window.scrollBy(0,-800)");
    }
    public static void ScreenShot(WebDriver driver, WebElement screenshot) throws IOException
	{
		TakesScreenshot s=(TakesScreenshot)driver;
		File source=s.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\hp\\Pictures\\HomePage.jpg");
		org.apache.commons.io.FileUtils.copyFile(source,destination);
	}
  
    public static void getCookies(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies){
            System.out.println(c);
        }
    }

}
