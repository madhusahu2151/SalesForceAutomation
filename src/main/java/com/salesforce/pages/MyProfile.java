package com.salesforce.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.base.TestBaseClass;

public class MyProfile extends TestBaseClass{

	public MyProfile() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Edit Profile']")
	WebElement EditProfilelink;
	
	@FindBy(xpath="//*[@id=\"aboutTab\"]/a")
	WebElement AboutTab;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="editContactInfoCancelButton")
	WebElement SaveAll;
	
	@FindBy(id="AboutMe")
	WebElement AboutMe;
	
	@FindBy(xpath="//a[@title='Post']")
	WebElement PostinkElement;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement PostLinkFrame;
	
	@FindBy(xpath="//body[contains(text(),'Share an update, @mention someone...')]")
	WebElement PostMessage;
	
	@FindBy(id="publishersharebutton") 
	WebElement ShareBtn;
	@FindBy(id="publisherAttachContentPost")
	WebElement FileLink;
	
	@FindBy(xpath="//a[@title='Upload a file from your computer']")
	WebElement UploadFromComputerLink;
	
    @FindBy(id="chatterFile")
    WebElement ChooseFileBtn;
    
    @FindBy(id="uploadLink")
    WebElement UploadLink;
    @FindBy(xpath="//iframe[@id='uploadPhotoContentId']")
    WebElement UploadProfilePhotoframe;
   @FindBy(id="j_id0:uploadFileForm:uploadInputFile']")
   WebElement ChooseFilePhoto;
   @FindBy(id="j_id0:uploadFileForm:uploadBtn")
   WebElement SavePhotobtn;
   @FindBy(id="j_id0:j_id7:save")
   WebElement SavePhoto1;

   
 

	
	public void EditProfilelink() {
		EditProfilelink.click();
	}
	
	public void EditProfileFrame() {
		driver.switchTo().frame(EditProfilelink);
		AboutTab.click();
		lastName.clear();
		lastName.sendKeys("Sahu");
		AboutMe.clear();
		AboutMe.sendKeys("My Name is Madhu");
		SaveAll.click();
		driver.switchTo().defaultContent();
		
	}
	
	
	public void PostLink() {
		PostinkElement.click();
		driver.switchTo().frame(PostLinkFrame);
		PostMessage.sendKeys("I Love SalesForce");
		driver.switchTo().defaultContent();
		ShareBtn.click();
		
		
	}
	
	public void FileLink() {
		
		FileLink.click();
		UploadFromComputerLink.click();
		ChooseFileBtn.click();
		ChooseFileBtn.sendKeys("/Users/madhusahu/Desktop/FileInput1"); 
		ShareBtn.click();
	}
	
public void AddPhotoFileLink() {
	UploadLink.click();
	driver.switchTo().frame(UploadProfilePhotoframe);
	ChooseFilePhoto.click();
	ChooseFilePhoto.sendKeys("/Users/madhusahu/Desktop/Madhu_testing.jpeg");	
	SavePhotobtn.click();
	SavePhoto1.click();
		
	}


	

}
