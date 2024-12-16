package com.salesforce.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.salesforce.base.TestBaseClass;


public class LoginPage extends TestBaseClass{
	
	//Initializing the Page Objects:
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}

	//Page Factory - OR:
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginBtn;
	
	@FindBy(id="error")
	WebElement ErrorMessage;
	
	 // Check the "Remember Me" checkbox
	
	@FindBy(id="rememberUn")
    WebElement rememberMechk;
	
	//WebElement of UsrMenu 
   
   @FindBy(xpath="//div[contains(@class, 'menu') or contains(@id, 'userNav')]")
   WebElement usrMenu;
  
   //WebElment for LogoutOption
    @FindBy(xpath="//a[contains(text(),'Logout')]")
    WebElement logoutOption;
    
    //WebElement for Forgot Password
   @FindBy(xpath="//a[contains(text(),'Forgot Your Password?')]")  
   WebElement ForgotPwd;
   
   @FindBy(id="continue")
   WebElement continueBtn;
   
  @FindBy(xpath="\\p[contains(text(),'sent you an email')]")
  WebElement CheckYourEmail;
  
  @FindBy(xpath="//p[@class='senttext mb12']")
  WebElement CheckYourEmailTxt;
  
  @FindBy(id="idcard-identity")
  WebElement Idcard;
  
  @FindBy(id="un")
  WebElement ForgotpwdUsername;
	
	

	
	public String InValidlogin(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		String ErrMsg=ErrorMessage.getText();
		System.out.println(ErrMsg);
		return ErrMsg;
		    	
	}
		
	
	public HomePage login(String un, String pwd) throws IOException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		rememberMechk.click(); 
		loginBtn.click();
	//	String title=driver.getTitle()  ;
	//	System.out.println(title);
		return new HomePage();
	}
	
	 
 	
	public  String RememberMeChkbox() throws IOException {
		login(prop.getProperty("username"), prop.getProperty("password"));
		usrMenu.click();
		logoutOption.click();
		String usernamevalue=Idcard.getText();
		System.out.println("usernamevalue"+usernamevalue);
		return usernamevalue;
		
	}
	
	/*public String ForgotPassword() throws InterruptedException {
		ForgotPwd.click();
		ForgotpwdUsername.sendKeys(prop.getProperty("username"));
		continueBtn.click();
		
		Thread.sleep(5000);
		String pwdResetMsg=getText(CheckYourEmail.getText().contains("Can’t find the email? Try checking your spam folder."));
		System.out.println(pwdResetMsg);
		return pwdResetMsg;
		*/
	}
	

	








