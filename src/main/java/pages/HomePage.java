package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public static By UpdateInfo		=	By.xpath("//span[contains(text(),'Update your information')]");
	public static By ReqAppointment =	By.xpath("//button[@id='sendApptRequest']");
	public static By PayBill		=	By.xpath("//span[contains(text(),'Pay your bill')]");
	public static By SendMessage	=	By.id("sendNewButton");
	
	public void UpdateInfo(){
		driver.findElement(UpdateInfo).click();
	}
	public void ReqAppointment(){
		driver.findElement(ReqAppointment).click();
	}
	public void PayBill(){
		driver.findElement(PayBill).click();
	}
	public void SendMessage(){
		driver.findElement(SendMessage).click();
	}

}
