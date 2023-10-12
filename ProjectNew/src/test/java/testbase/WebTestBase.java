package testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import java.io.FileInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTestBase {
	public static WebDriver driver;
	public static Properties prop;
	public WebTestBase() 
	{
	try
	{
		FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"//properties//config.properties");
		prop =new Properties();
		prop.load(fileInputStream);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
    public void initialisation() 
    {
    	String browserName=prop.getProperty("browser");
    	if(browserName.equals("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();
    		driver.get(prop.getProperty("url"));
    		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    		driver.manage().deleteAllCookies();
    		
    	}
    }
}

