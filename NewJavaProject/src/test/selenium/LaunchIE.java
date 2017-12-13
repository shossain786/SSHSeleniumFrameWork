package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LaunchIE {

	static private WebDriver driver;
	@Test
	public static void launchIE() throws InterruptedException {
		//For Mozila Firefox
		/*System.setProperty("webdriver.gecko.driver", "C:\\SeleniumSoftwares\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		//for Internet Explorer
		System.setProperty("webdriver.ie.driver", "C:\\SeleniumSoftwares\\IEDriverServer1.exe");
		driver= new InternetExplorerDriver();
		
		driver.get("https://www.99acres.com/");
		driver.findElement(By.xpath(".//*[@id='keyword']")).sendKeys("Pune");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[contains(@id,'CITY_19, PREFERENCE')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='submit_query']")).click();
		Thread.sleep(4000);
		
	}
	
	@AfterTest()
	public void closeBrowser() {
		driver.close();
	}
}
