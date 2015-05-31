package com.norwex;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.events.EventFiringWebDriver;


public class TestUtil extends TestBase1 
{
	
	// check if user is already logged in
	public static void doLogin (String username, String password) throws InterruptedException{
		//if not logged in the proceed to log in
		getobject("signin_link").click();
		getobject("username_Signin_input").sendKeys(username);
		getobject("password_input").sendKeys(password);
		Thread.sleep(2000L);
		getobject("submit_button").click();
		// check if the is login error is present
				
	}		
	
	public static void logout()
	{
			getobject("logout_link").click();
	}
	
	// get skip condition
	public static boolean isSkip(String testName)
	{
		for(int rowNum=2 ; rowNum<=datatable.getRowCount("Test Cases");rowNum++){
			if(testName.equals(datatable.getCellData("Test Cases", "TCID", rowNum))){
				if(datatable.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))
					return false;  //false means -- it is not to be skipped
				else
					return true;   //true means -- it is to be skipped
			}
		}
		return false;
	} 
	
}









