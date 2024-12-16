package com.salesforce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.salesforce.base.TestBaseClass;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.LoginPage;
import com.salesforce.util.ScreenShotReader;


public class SFDCLoginTestCases  extends TestBaseClass{
	
	private static final Logger logger = LogManager.getLogger(SFDCLoginTestCases.class);
	LoginPage loginpage;
	HomePage  homepage;
	ScreenShotReader screenshot;
	
	
	public SFDCLoginTestCases() throws IOException {
	
		super();
		/*
		 * logger.info("Setting up the test environment.");
		 * logger.debug("This is a debug message");
		 * logger.info("This is an info message");
		 * logger.warn("This is a warn message");
		 * logger.error("This is an error message");
		 * logger.fatal("This is a fatal message");
		 */
	}

	
	@BeforeMethod
	public void BrowserLaunch() throws IOException {	
	initialization();
	loginpage=new LoginPage();
	
	}
	//
	@Test(priority=1,enabled=true)
	public void PasswordFeildEmptyTest() {
	logger.info("TestCase for password feild empty");
	String ErrMsg=loginpage.InValidlogin(prop.getProperty("username1"), prop.getProperty("password1"));	
	System.out.println("Error message for password feild empty is :"+ErrMsg);
	Assert.assertEquals(ErrMsg,"Please enter your password.","Test Case1-Passed ");	
			
	}
	
	@Test(priority=2,enabled=true)
	public void ValidLoginTest() throws IOException {
	homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
	String title = driver.getTitle();	
	System.out.println("the Page Title is -"+title);
	Assert.assertEquals(title, "Home Page ~ Salesforce - Developer Edition","");
			
	}
	
	@Test(priority=3,enabled=true)
	public void RemberMeChkBoxTest() throws IOException {
		
		String usernameTxtValue=loginpage.RememberMeChkbox();
		Assert.assertEquals(usernameTxtValue,prop.getProperty("username"),"");
			
	}
		
	/*
	 * @Test(priority=4,enabled=false) public void ForgotPwd() throws
	 * InterruptedException { String Message=loginpage.ForgotPassword();
	 * System.out.println(Message); }
	 */
	
    @Test(priority=5,enabled=true)
    public void CheckforIncorrectCrdentials() {
    	String ErrMsg1=loginpage.InValidlogin(prop.getProperty("username2"), prop.getProperty("password2"));	
    	System.out.println("IncorrectCredentials- "+ErrMsg1);
    //	Assert.assertEquals(ErrMsg1,"Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help","Test Case4B-Passed ");	
    	
    }
		
	@AfterMethod
	
	public void tearDown(){
	 
	driver.quit();
		
		
	}

}
