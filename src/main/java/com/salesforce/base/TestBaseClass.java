package com.salesforce.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
		
		public static WebDriver driver;
		public static Properties prop;
		public static FileInputStream ip;
		
	public 	TestBaseClass() throws IOException
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("/Users/madhusahu/Eclipse_New/SalesForceTest/src/main/java/com/salesforce/"
				+ "config/config.properties");
		prop.load(ip);
	} 


	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browserName.equals("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

}
}
