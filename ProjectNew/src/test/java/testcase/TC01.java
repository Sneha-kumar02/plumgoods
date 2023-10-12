package testcase;

import java.io.IOException;

import org.testng.annotations.*;

import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import testbase.WebTestBase;
public class TC01 extends WebTestBase {
	MyAccount  myaccount;
	HomePage homePage;
	LoginPage loginPage;
	
	public TC01()
	{
		super();
	}	
	
    @BeforeMethod
    public void beforeMethod(){
    	//will execute prior to each method in test case
        initialisation();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myaccount = new MyAccount();
    }
    @Test(priority=0)
    public void loadurl()
    {
    	homePage.user_click();
    }
    @Test(priority=1)
    public void verifyCookiesHandle() 
    {
         SoftAssert softAssert = new SoftAssert();
         myaccount.getCookiesHandle();
         softAssert.assertAll();
    }  
    @Test(priority=2)
    public void verifyScrollDown()
    {
        SoftAssert softAssert = new SoftAssert();
        myaccount.scrollDownMethod();
        softAssert.assertAll();
    }
    @Test(priority=3)
    public void verifycontactpage()
    {
    	myaccount.contactpage();
    }
    @Test(priority=4)
	public void verifyScrollUp()
    {
    	SoftAssert softAssert = new SoftAssert();
	    myaccount.scrollUpMethod();
    	softAssert.assertAll();
	}
    @Test(priority=5)
    public void verifyGetWindowHandle()
    {
        SoftAssert softAssert = new SoftAssert();
        myaccount.windowHandle();
        softAssert.assertAll();
    }
    @Test(priority=6)
    public void verifyLogin(){
        SoftAssert softAssert = new SoftAssert();
        //WebDriverWait wait = new WebdriverWait(driver,TimeSpan.FormSeconds(30));
        homePage.user_click();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        softAssert.assertAll();
    }

}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //    @Test(priority=7)
//    public void screenshot() throws IOException
//    {
//    	SoftAssert softAssert = new SoftAssert();
//        myaccount.screenshot();
//        softAssert.assertAll();
//    }
//    @Test(priority=6)
//    public void verifySearchBar(){
//        SoftAssert softAssert = new SoftAssert();
//        myaccount.search();
//        softAssert.assertAll();
//    }
    
//    @Test(priority=0)
//    public void verifyMouseHover()
//    {
//        SoftAssert softAssert = new SoftAssert();
//        myaccount.mouseHover();
//        System.out.println("Test Case 2-_*MouseHover*_");
//        softAssert.assertAll();
//	}
//  @AfterMethod
//  public void afterMethod(){
//  	//will execute after each method in test case.
//      driver.close();
//  }

 
