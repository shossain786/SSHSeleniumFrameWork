package test.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ScreenshotWithHighlight {

	WebDriver driver;
	String currentDir=System.getProperty("user.dir");
	String driverPath= currentDir+"\\src\\driver\\IEDriverServer.exe";
	
	@BeforeTest
	public void intitiateTest() {
		System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver();
	}
	@Test
	public void captureScreenShot() {
		driver.get("http://newtours.demoaut.com/");
		WebElement uname = driver.findElement(By.name("userName"));
		sleeptime(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='1px solid red'", uname);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(currentDir+"\\screenshots\\ScreenshotWithBoarder.png"),true);
			System.out.println("Screenshot captured successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sleeptime(long timeToSleep) {
		try {
			Thread.sleep(timeToSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}
}
