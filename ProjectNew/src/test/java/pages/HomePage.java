package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.WebTestBase;

public class HomePage extends WebTestBase{

	@FindBy(xpath="//*[@id=\"Capa_1\"]")
	WebElement user;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	//clicking on My_Profile
	public void user_click()
	{
		user.click();
	}

}
