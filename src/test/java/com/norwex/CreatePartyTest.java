package com.norwex;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CreatePartyTest extends TestBase1 {
	
	@BeforeTest
    public void beforeTest() throws IOException
    {   
		initialize();
		if (TestUtil.isSkip("CreatePartyTest"))
		{
			throw new SkipException("Skipping test, check run mode");		
		}
		
    }
	@Test 
	public void createParty() throws InterruptedException
	{
		driver.get(CONFIG.getProperty("testSiteName"));
		//login
		TestUtil.doLogin("alexy.dsouza", "testing123");
		//navigate to party
		Thread.sleep(2000L);
		getobject("party_link").click();
		Thread.sleep(2000L);
		getobject("start_party_link").click();
		getobject("partyname_input").sendKeys("Brian's Party");
		getobject("partydate_input").sendKeys("09/30/2015");
		getobject("hostfirstname_input").sendKeys("Brian");
		getobject("hostlastname_input").sendKeys("Menoly");
		getobject("hostemail_input").sendKeys("brian@yahoo.com");
		getobject("hostmobile_input").sendKeys("2128670101");
		getobject("hostadderess_input").sendKeys("2701 Van dr");
		getobject("zipcode_input").sendKeys("73505");
		getobject("zipcode_search_button").click();
		
		//getobject("create_party_button").click();
		//code to **confirm party was created successfully
		WebElement Partyconfirm = getobject("startpartylink");
				if (Partyconfirm !=null){
					//proceed further
				}
		
	}
}
