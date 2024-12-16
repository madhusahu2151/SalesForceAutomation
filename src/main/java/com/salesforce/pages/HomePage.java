package com.salesforce.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.base.TestBaseClass;

public class HomePage  extends TestBaseClass{
 
	public HomePage ()throws IOException {
		PageFactory.initElements(driver, this);
	}


//OR defining
@FindBy(id="userNavLabel")
WebElement UserDropdownMenu;

@FindBy(xpath = "//a[@title='My Profile']")
private WebElement myProfileLink;

@FindBy(xpath="//iframe[@id='contactInfoContentId']")
WebElement EditProfileFrame;

@FindBy(xpath="//a[@title='My Settings']")
WebElement mySettings;
@FindBy(xpath="//a[@title='Developer Console (New Window)']")
WebElement DeveloperConsole;
@FindBy(id="PersonalInfo_font")
WebElement PersonalLink;
@FindBy(id="LoginHistory_font")
WebElement LoginHistory;

@FindBy(xpath="//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
WebElement DownloadHistoryLink;

@FindBy(id="DisplayAndLayout_font")
WebElement DisplayAndLayout;

@FindBy(id="CustomizeTabs_font")
WebElement CustomizeTabs;
@FindBy(id="p4")
WebElement CustomApp;

@FindBy(xpath="//option[@value='report']")
WebElement Reports;

@FindBy(xpath="//img[@title='Add']")
WebElement Add;


@FindBy(id="EmailSetup")
WebElement EmailSetup;

@FindBy(id="EmailSettings_font")
WebElement EmailSettings;

@FindBy(id="sender_name")
WebElement EmailName;

@FindBy(id="sender_email")
WebElement EmailAddress;

@FindBy(id="auto_bcc1")
WebElement AutoBCC;

@FindBy(xpath="//input[(@name='save' and @title='Save')]")
WebElement SaveEmailSettings;

@FindBy(id="CalendarAndReminders_font")
WebElement CalendarAndReminders;


@FindBy(id="Reminders_font")
WebElement Reminders;

public void UserDropDownMenu() {
	UserDropdownMenu.click();
	
}

public void myProfileLink() {
	myProfileLink.click();
	
}

public void mySettings() {
	mySettings.click();
	PersonalLink.click();
    LoginHistory.click();
    DownloadHistoryLink.click();
    DisplayAndLayout.click();
    CustomizeTabs.click();
    CustomApp.click();
    Select CustomAppDropdown=new Select(CustomApp);
	CustomAppDropdown.selectByVisibleText("Salesforce Chatter");
	Reports.click();
	Add.click();
	EmailSetup.click();
	EmailSettings.click();
	EmailName.clear();
	EmailName.sendKeys("Madhu Panda");
	EmailAddress.sendKeys("madhusahu2151@gmail.com");
	AutoBCC.click();
	SaveEmailSettings.click();
	CalendarAndReminders.click();
	Reminders.click();
	
}

public void DeveloperConsole() {
	DeveloperConsole.click();
}}	