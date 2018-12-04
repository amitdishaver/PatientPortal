package test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;



public class BaseTest{
	

	public BasePage baseObj;
//	baseObj = new BasePage(driver);

	public LoginPage loginObj;

	public static WebDriver driver = null;
	public static Properties config = null;
	public BaseTest() {
		 config = new Properties();
		 FileInputStream inp = null;
			try {
				inp = new FileInputStream(System.getProperty("user.dir")+"\\configurationFiles\\config.properties");
				config.load(inp);
			} catch (Exception e) {
			}
	 }

	
 
@BeforeSuite
 public  void LaunchBrowser() {	
	 if(config.getProperty("Browser").equalsIgnoreCase("Firefox")) {
	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	System.out.println("Fire driver=" + driver);
	}   
	else if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	System.out.println("Chrome driver=" + driver);
	}
	else if (config.getProperty("Browser").equalsIgnoreCase("Edge")) {
	System.setProperty("WebDriver.edge.driver", System.getProperty("user.dir")+"\\drivers\\MicrosoftWebDriver.exe");
	driver = new InternetExplorerDriver();
	System.out.println("Edge driver=" + driver);
	}
	else if(config.getProperty("Browser").equalsIgnoreCase("IE")) {
	System.setProperty("WebDriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	System.out.println("IE driver=" + driver);
	}
	 driver.manage().window().maximize();
	 driver.get(config.getProperty("URL"));
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 WebDriverWait wait = new WebDriverWait(driver,30);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='img-responsive big-logo']"))); 
	System.out.println("Final driver=" + driver);
 }

//@AfterSuite
//public void closeBrowser()
//{
//  driver.close();
//}

}
