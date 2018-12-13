package pages;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage{
	
public static WebDriver driver;
public static  Properties config = null;
	
	
	public static By homeBtn		=	By.xpath("//a[@class='icon-background menu-icon-home']");
	public static By messagesBtn	=	By.xpath("//a[@class='icon-background menu-icon-message']");
	public static By msgInbox		=	By.xpath("//span[contains(text(),'Inbox Messages')]");
	public static By msgSent		=	By.xpath("//span[contains(text(),'Sent Messages')]");
	public static By msgDeleted		=	By.xpath("//a[@href='/PatientPortal/Develop/PP/Messaging/Deleted']");
	public static By healthSummary	=	By.xpath("//a[@class='icon-background menu-icon-health']");
	public static By myDoc			=	By.xpath("//a[@class='icon-background menu-icon-documents']");
	public static By billing		=	By.xpath("//a[@class='icon-background menu-icon-billing']");
	public static By onlineBillPay	=	By.xpath("//span[contains(text(),'Online Bill Pay')]");
	public static By myAccount		=	By.xpath("//a[@class='icon-background menu-icon-account']");
	public static By changePassword	=	By.xpath("//span[contains(text(),'Change Password')]");
	public static By grantAccess	=	By.xpath("//span[contains(text(),'Grant Access')]");
	public static By historyLog		=	By.xpath("//span[contains(text(),'History Log')]");
	public static By logOut			=	By.xpath("//a[@class='icon-background menu-icon-logout']");
	public static By gastroOfficeFtr=	By.xpath("//div[@class='footer-bar boxcolor-background-color hidden-xs hidden-sm']//div[1]");
	public static By helpFtr		=	By.xpath("//button[@type='button'][contains(text(),'close')]");
	public static By mainPageImage  = 	By.xpath("//img[@class='img-responsive big-logo']");
	public static By msgDialogBox 	=	By.xpath("//div[@id='messageSendNewDialog']//div[@class='modal-body']");

	
	public BasePage() {
		 config = new Properties();
		 FileInputStream inp = null;
			try {
				inp = new FileInputStream(System.getProperty("user.dir")+"\\allFiles\\config.properties");
				config.load(inp);
			} catch (Exception e) {
			}
			
	 }

	public static BasePage logOut(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingOverlay")));
		driver.findElement(logOut).click();
//		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageImage));
		return new LoginPage();}
	

 public static void LaunchBrowser() {

	 if(config.getProperty("Browser").equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		if (driver == null) {
		driver = new FirefoxDriver();}
		System.out.println("Fire driver=" +driver);
	}   
	else if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		if (driver == null) {
		driver = new ChromeDriver();
		}
		System.out.println("Chrome driver=" +driver);
	}
	else if (config.getProperty("Browser").equalsIgnoreCase("Edge")) {
		System.setProperty("WebDriver.edge.driver", System.getProperty("user.dir")+"\\drivers\\MicrosoftWebDriver.exe");
		if (driver == null) {
			driver = new InternetExplorerDriver();
		}
		System.out.println("Edge driver=" + driver);
	}
	else if(config.getProperty("Browser").equalsIgnoreCase("IE")) {
		System.setProperty("WebDriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
		if (driver == null) {
			driver = new InternetExplorerDriver();
		}
		System.out.println("IE driver=" + driver);
	}
	 driver.manage().window().maximize();
 }
 
 public static LoginPage launchUrl() {
	 driver.get(config.getProperty("URL"));
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 WebDriverWait wait = new WebDriverWait(driver,30);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageImage)); 
	 System.out.println("Final driver=" + driver);
	 return new LoginPage();
 	}
}
