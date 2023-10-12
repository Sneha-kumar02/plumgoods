package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.WebTestBase;
import utils.Utility;

public class MyAccount extends WebTestBase{
	@FindBy(id = "Capa_1")
    WebElement accountTitle;
	//WebElements are found by @FindBy Annotation 

    @FindBy(xpath = "//*[@id=\"searchfeild\"]")
    WebElement searchTextBox;

    @FindBy(xpath = "//*[@id=\"searchModal\"]/div/div[2]/div[1]/div[2]/div[3]/div[2]/div/div/div/div[2]/a")
    WebElement searchBtn;
    
    @FindBy(className = "title")
    WebElement searchTitle;
    
    @FindBy(xpath="//*[@id=\"slideshow-template--15207864664124__1658484860c65081e1\"]")
    WebElement screenshot;
    
    @FindBy(xpath="//*[@id=\"footer\"]/div[1]/div/div/div/div[2]/div/div[3]/div/ul/li[1]/a/span")
    WebElement contact;
    
    @FindBy(xpath = "//img[@alt='Plum Goodness']")
    WebElement logoSign;
    
    @FindBy(xpath = "//*[@id=\"home-blog-template--15207864664124__4fc71138-69fe-4c8c-9139-8a7c5c79562d\"]/div")
    WebElement view;
    public MyAccount()
    {
        PageFactory.initElements(driver, this);
        
    }
    public void search() {
    	searchTextBox.click();
    	searchTextBox.sendKeys("15% Vitamin C Serum with Mandarin");
    	searchTextBox.sendKeys(Keys.ENTER);
    	searchTextBox.click();
    	searchBtn.click();    		
    }
    
    public void scrollDownMethod() {
        Utility.scrollDownByElement(driver, contact);
    }
    public void contactpage()
    {
    	contact.click();
    }
    
    public void scrollUpMethod() {
        Utility.scrollUp(driver, logoSign);
    }

    public void windowHandle(){
        Utility.scrollDownByElement(driver, view);
        Utility.switchToWindows(driver);
    }
    public void screenshot() throws IOException
	{
		Utility.ScreenShot(driver,screenshot);
		screenshot.click();
	}

    public void getCookiesHandle(){
        Utility.getCookies();
    }
}
