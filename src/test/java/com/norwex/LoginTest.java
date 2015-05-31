package com.norwex;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class LoginTest extends TestBase1 {
	
	@BeforeTest
    public void beforeTest() throws IOException 
	{   
		initialize();
		if (TestUtil.isSkip("LoginTest"))
		{
			throw new SkipException("Skipping test, check run mode");		
		}
		
    }
     
	@Test
	public void loginTest() throws InterruptedException
	{
	
				
		driver.get(CONFIG.getProperty("testSiteName"));
		TestUtil.doLogin("alexy.dsouza", "testing123");
		
	}
	
	
}

