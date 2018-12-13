package pages;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReqAppointmentPage extends BasePage {
	public static By locationList	=	By.id("LocationId");
	public static By typeList		=	By.id("Type");
	public static By subjectTxt	=	By.name("Subject");
	public static By messageTxt	=	By.id("Message");
	public static By sendBtn	=	By.id("messageSendNew");
	public static By closeBtn	=	By.xpath("//div[@id='messageSendNewDialog']//span[@aria-hidden='true'][contains(text(),'×')]");
	
	
	
	public static void Location(){
		driver.findElement(locationList).click();
	}
	public static void Type(){
		driver.findElement(typeList).click();
	}
	public static void Subject(){
		driver.findElement(subjectTxt).sendKeys(config.getProperty("Subject"));
	
		
	}
	public static void Message(){
//		driver.findElement(messageTxt);
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.elementSelectionStateToBe(messageTxt, true));
////		(messageTxt));
		driver.findElement(messageTxt).sendKeys(config.getProperty("Message"));
	}
	public static void SendBtn(){
		driver.findElement(sendBtn).click();
	}
	public static void CloseBtn(){
		driver.findElement(closeBtn).click();
	}

}
