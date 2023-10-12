package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.WebTestBase;

public class LoginPage extends WebTestBase{
	
	@FindBy(id = "customer_email")
    WebElement emailTextBox;
	//email-id text box
	
	@FindBy(id = "customer_password")
    WebElement passwordTextBox;
	//password text box

    @FindBy(id = "notifyeventsignup")
    WebElement loginbtn;
    //login button

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
//sending the email id and password to login
    public void login(String email, String password){
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginbtn.click();
    }
}

