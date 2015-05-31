package com.norwex;


import java.io.FileInputStream;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import datatable.Xls_Reader;

public class TestBase1 {

	// initalizing the property file reading
		public static Properties CONFIG=null;
		public static Properties OR=null;
		public static WebDriver dr=null;
		public static EventFiringWebDriver driver=null;
		public static boolean isLoggedIn=true;
		public static Xls_Reader datatable = null;
		
		public void initialize() throws IOException{
			if (driver==null){
		//	config properties file
				CONFIG = new Properties();
				FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+ "//src//test//java//config//config.properties");
				CONFIG.load(fn);
		//	OR properties
				OR = new Properties();
				fn = new FileInputStream(System.getProperty("user.dir")+ "//src//test//java//config//OR.properties");
				OR.load(fn);
		//	initialize the webdriver
				if (CONFIG.getProperty("browser").equals("Firefox")) {
				dr = new FirefoxDriver();
				}else if (CONFIG.getProperty("browser").equals("Chrome")) {
					System.setProperty("webdriver.chrome.driver", "G://IT//NorwexQA//Workspace//Max//browse//chromedriver.exe");
					 dr = new ChromeDriver();
				}else if (CONFIG.getProperty("browser").equals("IE")) {
					System.setProperty("webdriver.ie.driver", "G://IT//NorwexQA//Workspace//Max//browse//iedriver.exe");
					 dr = new InternetExplorerDriver();
				
				}
		// 	load the suite1 sheet
				datatable = new Xls_Reader(System.getProperty("user.dir")+"//src//test//java//datatable//Suite1.xlsx");
			 	driver= new EventFiringWebDriver(dr);
			 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		}
		
		public static WebElement getobject(String xpathKey){
			try{
				return driver.findElement(By.xpath(OR.getProperty(xpathKey)));
			}catch(Throwable t){
				return null;
			}
		}
		
}


















