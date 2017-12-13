package tests;

import library.CommonUtilities;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestSetUP {
	private static Logger log = Logger.getLogger("TestSetUP.class");
	@BeforeSuite
	@Parameters({"browser", "driverFile", "url", "objectMapFile", "testDataFile", "pageLoadTimeOutInSec", 
		"implicitWaitInSec", "screenshotsFolder"})
	public void setup(String browser, String driverFile, String url, String objectMapFile, 
			String testDataFile, String pageLoadTimeOutInSec, String implicitWaitInSec, String screenshotsFolder){
		log.info("Before suite started, test is being setup");
		CommonUtilities.setTestDataFile(testDataFile);
		log.info("TestData file setup is done.");
		
		CommonUtilities.setObjectMapFile(objectMapFile);	
		log.info("Objectmap file setup is completed");
		
		CommonUtilities.launchBrowser(browser, driverFile);
		log.info("Browser has launched with browser "+browser);
		
		CommonUtilities.setTimeOut(Integer.parseInt(pageLoadTimeOutInSec), Integer.parseInt(implicitWaitInSec));
		
		CommonUtilities.launchURL(url);
		log.info("URL is launched succefully.");
		
		CommonUtilities.setScreenShotFolder(screenshotsFolder);
		log.info("Screenshot folder setup is done");
	}
	
	@BeforeTest
	public void beforeTestSetup() {
		log.info("Before test started.");
		CommonUtilities.gotToBaseURL();
		log.info("Navigated go baseURL");
	}
	
	@AfterSuite
	public void closeBrowser() {
		log.info("After Suite annotation started.");
		CommonUtilities.quiteBrowser();
	}
	
}