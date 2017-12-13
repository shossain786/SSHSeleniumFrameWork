package tests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import library.CommonUtilities;

public class FacebookLoginTest extends CommonUtilities{

	final Logger log = Logger.getLogger("FacebookLoginTest.class");
	
	@Test
	public void TC1_LoginWithValidCredentials() {
		log.info("TestCase TC1_LoginWithValidCredentials execution started.");
		ArrayList<String> testData = getTestData("TC1_LoginWithValidCredentials");
		String username = testData.get(0);
		String password = testData.get(1);
		String expectedText = testData.get(2);
		
		//testSteps

		assertion("Login_Forgotten_XPATH", expectedText);
		
		sendKeys("Login_UserName_XPATH", username);
		sendKeys("Login_Password_XPATH", password);
		click("Login_LoginButton_ID");
		sleepTime(3000);
		captureScreenShot("LoginPageScreenShot");
		log.info("End of test case TC1_LoginWithValidCredentials.");
	}
	
	@Test
	public void TC2_LoginWithInvalidCredentials() {
		log.info("TestCase TC2_LoginWithInvalidCredentials execution started.");
		log.info("Title of current page: "+getPageTitle());
		log.info("Current URL :"+getPageURL());
		sleepTime(3000);
	}
}
