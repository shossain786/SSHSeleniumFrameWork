package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompareTwoScreenshots {
	WebDriver driver;
	String currentDir=System.getProperty("user.dir");
	String path = currentDir+"\\src\\driver\\chromedriver.exe";
	@BeforeTest
	public void intitiateTest() {
		System.setProperty("webdriver.ie.driver", path);
		driver = new InternetExplorerDriver();
	}
	@Test
	public void captureScreenShot() {
		driver.get("http://newtours.demoaut.com/");
		WebElement uname = driver.findElement(By.name("userName"));
		sleeptime(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='1px solid red'", uname);
		
		String loginScreen = compareScreen(driver);
		
		driver.findElement(By.name("userName")).sendKeys("test");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.name("login")).click();
		sleeptime(3000);
		
		String logOnScreen = compareScreen(driver);
		
		if(loginScreen.equals(logOnScreen))
			System.out.println("Both screens are same");
		else
			System.out.println("Screenshots are not matching");
		
	}
	
	public void sleeptime(long timeToSleep) {
		try {
			Thread.sleep(timeToSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String compareScreen(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	@AfterTest
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}
}
