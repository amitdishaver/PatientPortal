package pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import static driverFactory.DriverFactory.driver;


public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	public static Properties config = null;
	public BasePage() {
		 config = new Properties();
		 FileInputStream inp = null;
			try {
				inp = new FileInputStream(System.getProperty("user.dir")+"\\configurationFiles\\config.properties");
				config.load(inp);
			} catch (Exception e) {
			}
	 }
//	static WebDriver driver;
	
	public  By HomeBtn			=	By.xpath("//a[@class='icon-background menu-icon-home']");
	public  By MessagesBtn		=	By.xpath("//a[@class='icon-background menu-icon-message']");
	public  By MsgInbox			=	By.xpath("//span[contains(text(),'Inbox Messages')]");
	public  By MsgSent			=	By.xpath("//span[contains(text(),'Sent Messages')]");
	public  By MsgDeleted		=	By.xpath("//a[@href='/PatientPortal/Develop/PP/Messaging/Deleted']");
	public  By HealthSummary	=	By.xpath("//a[@class='icon-background menu-icon-health']");
	public  By MyDoc			=	By.xpath("//a[@class='icon-background menu-icon-documents']");
	public  By Billing			=	By.xpath("//a[@class='icon-background menu-icon-billing']");
	public  By OnlineBillPay	=	By.xpath("//span[contains(text(),'Online Bill Pay')]");
	public  By MyAccount		=	By.xpath("//a[@class='icon-background menu-icon-account']");
	public  By ChangePassword	=	By.xpath("//span[contains(text(),'Change Password')]");
	public  By GrantAccess		=	By.xpath("//span[contains(text(),'Grant Access')]");
	public  By HistoryLog		=	By.xpath("//span[contains(text(),'History Log')]");
	public  By LogOut			=	By.xpath("//a[@class='icon-background menu-icon-logout']");
	public  By GastroOfficeFtr	=	By.xpath("//div[@class='footer-bar boxcolor-background-color hidden-xs hidden-sm']//div[1]");
	public  By HelpFtr			=	By.xpath("//button[@type='button'][contains(text(),'close')]");
	
	public void logOut(){
		driver.findElement(LogOut).click();
	}
	

}
